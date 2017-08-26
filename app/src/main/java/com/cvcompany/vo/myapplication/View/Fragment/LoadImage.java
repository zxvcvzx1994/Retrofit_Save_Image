package com.cvcompany.vo.myapplication.View.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cvcompany.vo.myapplication.Module.Picture;
import com.cvcompany.vo.myapplication.Module.Retrofit.ApiClient;
import com.cvcompany.vo.myapplication.Module.Retrofit.ApiInterface;
import com.cvcompany.vo.myapplication.R;
import com.cvcompany.vo.myapplication.View.Adapter.MyAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoadImage extends Fragment {
    @BindView(R.id.recyclerView1)
    RecyclerView recyclerView;
    private MyAdapter adapter;

    public LoadImage() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_load_image, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        ApiInterface apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);
        Call<List<Picture>> call  = apiInterface.createArrayList();
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);
        call.enqueue(new Callback<List<Picture>>() {
            @Override
            public void onResponse(Call<List<Picture>> call, Response<List<Picture>> response) {
                MyAdapter adapter = new MyAdapter(getActivity(), response.body());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Picture>> call, Throwable t) {

            }
        });
    }
}
