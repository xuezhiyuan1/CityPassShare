package com.example.think.citypass.fragment.zzh.community.banqu;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.think.citypass.App;
import com.example.think.citypass.R;

/**
 * Created by ASUS on 2017/5/22.
 */

public class BanquAdapter extends BaseAdapter {

    private int count;

    public BanquAdapter(int count){
        this.count = count;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = View.inflate(App.activity, R.layout.list_item, null);
        }
        return convertView;
    }
}
