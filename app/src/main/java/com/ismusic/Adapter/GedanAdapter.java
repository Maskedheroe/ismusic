package com.ismusic.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ismusic.R;

import java.util.ArrayList;
import java.util.List;

public class GedanAdapter extends RecyclerView.Adapter<GedanAdapter.ViewHolder> {

    private List<Integer> mList;

    public GedanAdapter(List list){
        this.mList=list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view =LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_gedan,viewGroup,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        viewHolder.image.setImageResource(R.drawable.coman);
        viewHolder.title.setText(i+"");
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView title;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image =itemView.findViewById(R.id.img_gedan);
            title = itemView.findViewById(R.id.title_gedan);
        }
    }
}
