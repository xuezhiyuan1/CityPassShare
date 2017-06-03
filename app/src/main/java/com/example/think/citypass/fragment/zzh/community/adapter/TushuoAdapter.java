package com.example.think.citypass.fragment.zzh.community.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.think.citypass.App;
import com.example.think.citypass.R;
import com.example.think.citypass.model.enitity.TushuoBean;

import java.util.List;

/**
 * Created by ASUS on 2017/5/18.
 */

public class TushuoAdapter extends RecyclerView.Adapter<TushuoAdapter.ViewHolder> {
    private List<TushuoBean.ServerInfoBean> data;


    public TushuoAdapter(List<TushuoBean.ServerInfoBean> data) {
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder holder = new ViewHolder(View.inflate(App.activity, R.layout.shaitu_item, null));
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.detailTv.setVisibility(View.INVISIBLE);
        Glide.with(App.activity)
                .load(data.get(position).getImages().split("\\|")[0])
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.shape_image_zhanwei)
                .into(holder.imageView);
        holder.nameTv.setText(data.get(position).getRole());
        holder.timeTv.setText(data.get(position).getReplyTime().substring(5));
        holder.zanTv.setText(String.valueOf(data.get(position).getReply()));
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView detailTv, zanTv, nameTv, timeTv;
        private ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.shaitu_image);
            detailTv = (TextView) itemView.findViewById(R.id.shaitu_details);
            zanTv = (TextView) itemView.findViewById(R.id.shaitu_zan_count);
            nameTv = (TextView) itemView.findViewById(R.id.shaitu_name);
            timeTv = (TextView) itemView.findViewById(R.id.shaitu_time);
        }
    }
}
