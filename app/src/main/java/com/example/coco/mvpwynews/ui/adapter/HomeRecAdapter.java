package com.example.coco.mvpwynews.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.coco.mvpwynews.R;

import java.util.List;

/**
 * Created by coco on 2017/8/14.
 */

public class HomeRecAdapter extends RecyclerView.Adapter<HomeRecAdapter.MyHolder>{
    private Context context;
    private List<String>list;
    private LayoutInflater inflater;


    public HomeRecAdapter(Context context,List<String> list){
        this.context=context;
        this.list=list;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public HomeRecAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyHolder(inflater.inflate(R.layout.home_item,null,false));
    }

    @Override
    public void onBindViewHolder(HomeRecAdapter.MyHolder holder, int position) {
        holder.title.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        if (list!=null){
            return list.size();
        }
        return 0;
    }


    public class MyHolder extends RecyclerView.ViewHolder{
        TextView title;

        public MyHolder(View itemView) {
            super(itemView);
            title= (TextView) itemView.findViewById(R.id.title);
        }
    }
}

