package com.example.think.citypass.activity.zzh.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.think.citypass.App;
import com.example.think.citypass.R;
import com.example.think.citypass.model.enitity.PostDetailBean;

import java.util.List;

/**
 * Created by ASUS on 2017/6/4.
 */

public class PostInfoAdapter extends RecyclerView.Adapter<PostInfoAdapter.ViewHolder> {

    private List<PostDetailBean.ServerInfoBean.ReplyListBean> data;

    public PostInfoAdapter(List<PostDetailBean.ServerInfoBean.ReplyListBean> data) {
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder viewHolder = new ViewHolder(View.inflate(App.activity, R.layout.post_list_item, null));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(App.activity)
                .load(data.get(position).getRoleImg())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.shape_image_zhanwei)
                .into(holder.itemIv);
        if (data.get(position).getRtitle().contains("楼")) {
            holder.loucentIv.setVisibility(View.GONE);
        } else {
            holder.loucentIv.setVisibility(View.VISIBLE);
            switch (data.get(position).getRtitle()) {
                case "沙发":
                    holder.loucentIv.setImageResource(R.drawable.news_discuss_image1);
                    break;
                case "板凳":
                    holder.loucentIv.setImageResource(R.drawable.news_discuss_image2);
                    break;
                case "马扎":
                    holder.loucentIv.setImageResource(R.drawable.news_discuss_image3);
                    break;
            }
        }
        holder.nameTv.setText(data.get(position).getRoleName());
        holder.dengjiTv.setText("Lv." + data.get(position).getLevel());
        holder.timeTv.setText(data.get(position).getAddTime().substring(5));
        holder.loucengTv.setText(data.get(position).getRtitle());
        holder.contentTv.setText(data.get(position).getReplyMemo());
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView itemIv, loucentIv;
        private TextView nameTv, dengjiTv, louzhuTv, timeTv, loucengTv, contentTv;

        public ViewHolder(View itemView) {
            super(itemView);
            itemIv = (ImageView) itemView.findViewById(R.id.post_item_imageview);
            loucentIv = (ImageView) itemView.findViewById(R.id.loucheng_imageview);
            nameTv = (TextView) itemView.findViewById(R.id.post_item_name);
            dengjiTv = (TextView) itemView.findViewById(R.id.post_item_dengji);
            louzhuTv = (TextView) itemView.findViewById(R.id.post_item_louzhu);
            timeTv = (TextView) itemView.findViewById(R.id.time_textview);
            loucengTv = (TextView) itemView.findViewById(R.id.post_item_louceng);
            contentTv = (TextView) itemView.findViewById(R.id.post_item_content);
        }
    }
}
