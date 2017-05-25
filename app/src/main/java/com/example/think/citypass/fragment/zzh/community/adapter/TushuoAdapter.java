package com.example.think.citypass.fragment.zzh.community.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.think.citypass.App;
import com.example.think.citypass.R;

import java.util.List;

/**
 * Created by ASUS on 2017/5/18.
 */

public class TushuoAdapter extends RecyclerView.Adapter<TushuoAdapter.ViewHolder> {
    private List<String> data;

    private int[] images = {R.drawable.login_bg, R.drawable.my_main_advice1, R.drawable.main_theall_bg, R.drawable.none_sj2, R.drawable.task_center_top, R.drawable.tieba_top_bg1, R.drawable.bike_city};

    public TushuoAdapter(List<String> data) {
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder holder = new ViewHolder(View.inflate(App.activity, R.layout.shaitu_item, null));
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.iv.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView iv;

        public ViewHolder(View itemView) {
            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.shaitu_image);
        }
    }
}
