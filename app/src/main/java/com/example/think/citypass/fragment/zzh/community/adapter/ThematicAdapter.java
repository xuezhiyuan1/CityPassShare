package com.example.think.citypass.fragment.zzh.community.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.think.citypass.App;
import com.example.think.citypass.R;

import java.util.List;

/**
 * Created by ASUS on 2017/5/18.
 */

public class ThematicAdapter extends RecyclerView.Adapter<ThematicAdapter.ViewHolder> {
    private List<String> data;

    public ThematicAdapter(List<String> data) {
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder holder = new ViewHolder(View.inflate(App.activity, R.layout.thematic_activities_item, null));
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.iv.setText("已有1203人感兴趣");
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView iv;

        public ViewHolder(View itemView) {
            super(itemView);
            iv = (TextView) itemView.findViewById(R.id.activity_count);
        }
    }
}
