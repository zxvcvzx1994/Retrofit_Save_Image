package com.cvcompany.vo.myapplication.View.Fragment;


import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.cvcompany.vo.myapplication.MainActivity;
import com.cvcompany.vo.myapplication.Module.Picture;
import com.cvcompany.vo.myapplication.Module.Retrofit.ApiClient;
import com.cvcompany.vo.myapplication.Module.Retrofit.ApiInterface;
import com.cvcompany.vo.myapplication.R;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.internal.Utils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class InputImage extends Fragment {
    private static final int IMAGE_CAPTURE =300 ;
    @BindView(R.id.btnSend)
    Button btnSend;
    @BindView(R.id.img)
    ImageView img;
    @BindView(R.id.etTitle)
    EditText etTitle;
    private Bitmap bitmap;

    public InputImage() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_input_image, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
//        Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.effect_button);
//        btnSend.setAnimation(animation);

    }

    @OnClick(R.id.btnSend)
    public void btnSend(){
        if(bitmap!=null && etTitle.length()>0)
            setPicture( etTitle.getText().toString().trim(),getStringBitMap(bitmap));
    }

    @OnClick(R.id.img)
    public void img(){
        intentImage();
    }

    private void setPicture(String title, String image){
//        Log.i(TAG, "setPicture: "+image);
        ApiInterface apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);
        Call<Picture> call  = apiInterface.getPicture(title, image);
        call.enqueue(new Callback<Picture>() {
            @Override
            public void onResponse(Call<Picture> call, Response<Picture> response) {
                Picture picture= response.body();
//                Log.i(TAG, "onResponse: "+picture.getResponse());

                Log.i(TAG, "onResponse: 11111111111111111111");
                Log.i(TAG, "onResponse: "+ picture.getResponse());
            }

            @Override
            public void onFailure(Call<Picture> call, Throwable t) {
                Log.i(TAG, "onResponse: 222222222222222222222222222   "+t.getMessage());
            }
        });
    }

    public void intentImage(){
        Intent intent  = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, IMAGE_CAPTURE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==IMAGE_CAPTURE && resultCode== getActivity().RESULT_OK && data!=null){
            Uri uri = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(),uri);
                img.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public String getStringBitMap(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] data = byteArrayOutputStream.toByteArray();
        return Base64.encodeToString(data,  Base64.DEFAULT);
    }
}
