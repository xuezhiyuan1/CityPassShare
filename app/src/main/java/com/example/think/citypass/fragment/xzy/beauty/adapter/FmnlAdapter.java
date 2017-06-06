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
import com.example.think.citypass.model.entity.FmnlBean;

import java.util.List;

/**
 * Created by think on 2017/6/6.
 */

public class FmnlAdapter extends RecyclerView.Adapter<FmnlAdapter.ViewHolder> {

    private List<FmnlBean.ServerInfoBean.FigureTCoverInfoListBeanX.FigureTCoverInfoListBean> data;

    public FmnlAdapter(List<FmnlBean.ServerInfoBean.FigureTCoverInfoListBeanX.FigureTCoverInfoListBean> data) {
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder holder = new ViewHolder(View.inflate(App.activity, R.layout.item_fengmian, null));
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(App.activity)
                .load(data.get(position).getPhoto())  //.split("\\|")[0]
              //  .diskCacheStrategy(DiskCacheStrategy.ALL)
              //  .placeholder(R.drawable.shape_image_zhanwei)
                .into(holder.imageView);

        holder.text_age.setText(data.get(position).getAge());
        holder.text_found.setText(data.get(position).getMapName());
//      holder.text_message.setText(data.get(position).getLikeTotal());
        holder.text_name.setText(data.get(position).getNick());
        holder.text_work.setText(data.get(position).getPositionName());
        holder.text_star.setText(data.get(position).getUXinZuo());
    }

    @Override
    public int getItemCount() {
          return data.size();
     //   return data == null ? 0 : data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView text_found , text_message ,text_name ,text_age ,text_star ,text_work;
        private ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            text_name = (TextView) itemView.findViewById(R.id.name_text);
            text_age = (TextView) itemView.findViewById(R.id.age_text);
            text_star = (TextView) itemView.findViewById(R.id.star_text);
            text_found = (TextView) itemView.findViewById(R.id.address_text);
            text_work = (TextView) itemView.findViewById(R.id.position_text);
            text_message = (TextView) itemView.findViewById(R.id.discuss_text);
            imageView = (ImageView) itemView.findViewById(R.id.image);

        }
    }
}

