package com.example.think.citypass.fragment.xzy.beauty.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.think.citypass.App;
import com.example.think.citypass.R;
import com.example.think.citypass.model.entity.ZuiXinBean;

import java.util.List;

/**
 * Created by think on 2017/6/6.
 */

public class ZuiXinAdapter extends RecyclerView.Adapter<ZuiXinAdapter.ViewHolder> {

    private List<ZuiXinBean.ServerInfoBean.NewTCoverInfoListBeanX.NewTCoverInfoListBean> data;

    public ZuiXinAdapter(List<ZuiXinBean.ServerInfoBean.NewTCoverInfoListBeanX.NewTCoverInfoListBean> data) {
        this.data = data;
    }

    @Override
    public ZuiXinAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ZuiXinAdapter.ViewHolder holder = new ZuiXinAdapter.ViewHolder(View.inflate(App.activity, R.layout.zuixin_item, null));
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(App.activity)
                .load(data.get(position).getPhoto().split("\\|")[0])
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.shape_image_zhanwei)
                .into(holder.imageView);
        holder.nameTv.setText(data.get(position).getNick());
        holder.timeTv.setText(data.get(position).getCreateTime().substring(5));
        holder.zanTv.setText(String.valueOf(data.get(position).getLikeTotal()));
        holder.ageTv.setText(data.get(position).getPositionName());
        holder.foundTv.setText(data.get(position).getMapName());
    }


    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView zanTv, nameTv, timeTv ,ageTv ,foundTv;
        private ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageview);
            zanTv = (TextView) itemView.findViewById(R.id.ding);
            nameTv = (TextView) itemView.findViewById(R.id.name_text);
            timeTv = (TextView) itemView.findViewById(R.id.date_text);
            ageTv = (TextView) itemView.findViewById(R.id.position_text);
            foundTv = (TextView) itemView.findViewById(R.id.address_text);
        }
    }
}
