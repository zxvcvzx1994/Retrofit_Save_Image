package com.cvcompany.vo.myapplication.View.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cvcompany.vo.myapplication.Module.Picture;
import com.cvcompany.vo.myapplication.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.ContentValues.TAG;

/**
 * Created by vinh on 8/23/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<Picture> list;
    private Context context;

    public MyAdapter(Context context, List<Picture> list){
        this.context = context;
        this.list = list;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Picture picture = list.get(position);
        holder.txtTitle.setText(""+picture.getTitle());
        String [] img = list.get(0).getImage().split("/");
        Log.i(TAG, "onViewCreated: "+img[img.length-1]);
        Glide.with(context).load("http://192.168.1.12/index/image/"+img[img.length-1]).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return (list==null)?0:list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txtTitle)
        TextView txtTitle;
        @BindView(R.id.img)
        ImageView  img;
        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
