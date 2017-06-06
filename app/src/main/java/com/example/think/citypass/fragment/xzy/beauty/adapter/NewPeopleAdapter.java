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
import com.example.think.citypass.model.bean.NewPeopleBean;
import com.example.think.citypass.model.entity.FmnlBean;

import java.util.List;

/**
 * Created by think on 2017/6/6.
 */

public class NewPeopleAdapter extends RecyclerView.Adapter<NewPeopleAdapter.ViewHolder> {

    private List<NewPeopleBean.ServerInfoBean.FigureTCoverInfoListBeanX.FigureTCoverInfoListBean> data;

    public NewPeopleAdapter(List<NewPeopleBean.ServerInfoBean.FigureTCoverInfoListBeanX.FigureTCoverInfoListBean> data) {
        this.data = data;
    }

    @Override
    public NewPeopleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        NewPeopleAdapter.ViewHolder holder = new NewPeopleAdapter.ViewHolder(View.inflate(App.activity, R.layout.item_xin_ren_xiu, null));
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(App.activity)
                .load(data.get(position).getPicUrls().split("\\,")[0])  //.split("\\|")[0]
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                //.placeholder(R.drawable.shape_image_zhanwei)
                .into(holder.imageView1);
        Glide.with(App.activity)
                .load(data.get(position).getPicUrls().split("\\,")[1])  //.split("\\|")[0]
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                //.placeholder(R.drawable.shape_image_zhanwei)
                .into(holder.imageView2);
        Glide.with(App.activity)
                .load(data.get(position).getPicUrls().split("\\,")[2])  //.split("\\|")[0]
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                //.placeholder(R.drawable.shape_image_zhanwei)
                .into(holder.imageView3);
        Glide.with(App.activity)
                .load(data.get(position).getPhoto())  //.split("\\|")[0]
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                //.placeholder(R.drawable.shape_image_zhanwei)
                .into(holder.imageView_head);

        holder.text_age.setText(data.get(position).getAge());
        holder.text_address.setText(data.get(position).getMapName());
        holder.text_name.setText(data.get(position).getNick());
        holder.text_work.setText(data.get(position).getPositionName());
        holder.text_time.setText(data.get(position).getCreateTime());
    }


    @Override
    public int getItemCount() {
        return data.size();
        //   return data == null ? 0 : data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView text_address ,text_name ,text_age ,text_time ,text_work;
        ImageView imageView_head,imageView1,imageView2,imageView3;

        public ViewHolder(View itemView) {
            super(itemView);
            text_name = (TextView) itemView.findViewById(R.id.name_text);
            text_address = (TextView) itemView.findViewById(R.id.address_text);
            text_work = (TextView) itemView.findViewById(R.id.position_text);
            text_age = (TextView) itemView.findViewById(R.id.age_text);
            text_time = (TextView) itemView.findViewById(R.id.date_text);

            imageView_head = (ImageView) itemView.findViewById(R.id.head_image);
            imageView1 = (ImageView) itemView.findViewById(R.id.image1);
            imageView2 = (ImageView) itemView.findViewById(R.id.image2);
            imageView3 = (ImageView) itemView.findViewById(R.id.image3);
        }
    }
}