package com.test.iptv.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.test.iptv.materialdesignone.R;
import com.test.iptv.materialdesignone.categoryDetail;

import java.util.Collections;
import java.util.List;

/**
 * Developed by rubayet on 3/29/16.
 */

public class listRecyclerAdapter extends RecyclerView.Adapter<listRecyclerAdapter.myViewHolder> {

    private LayoutInflater inflater;
    List<categoryDetail> data = Collections.emptyList();
    private Context context;


    public listRecyclerAdapter(Context context , List<categoryDetail> data){
        inflater = LayoutInflater.from(context);
        this.data = data;
        this.context = context;
    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View customRootView = inflater.inflate(R.layout.custom_row,parent,false);
        myViewHolder viewHolder = new myViewHolder(customRootView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(myViewHolder holder, int position) {
        categoryDetail current = data.get(position);
        holder.title.setText(current.categoryName);
        holder.icon.setImageResource(current.icon);
    }

    @Override
    public int getItemCount() {

        if (data != null){
            return data.size();
        }
        return 0;
    }



    class myViewHolder extends RecyclerView.ViewHolder{

        TextView title;
        ImageView icon;

        public myViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.customRowtitle);
            icon = (ImageView) itemView.findViewById(R.id.customRowImage);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "item clicked", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
