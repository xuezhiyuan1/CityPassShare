package com.example.think.citypass.activity.zxm.popupwindow;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.think.citypass.R;
import com.example.think.citypass.activity.zxm.upphoto.logic.ImgsActivity;
import com.example.think.citypass.common.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import static com.example.think.citypass.R.id.imageView;

/**
 * Created by 张萌 on 2017/6/2.
 */

public class ShouyeSendPhoto  extends BaseActivity {
    TextView  fabu;
    GridviewAdapter  adapter;
    GridView  gridView;
    List<String>  alistfile=new ArrayList<>();
    List<ImageView>  mlist=new ArrayList<>();
    @Override
    protected int layoutId() {
        return R.layout.popup_photo;
    }

    @Override
    protected void initView() {
  gridView= (GridView) findViewById(R.id.photo_gridView);

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void loadData() {
        Bundle bundle= getIntent().getExtras();
        if (bundle!=null) {
            if (bundle.getStringArrayList("files")!=null) {
                alistfile= bundle.getStringArrayList("files");
                adapter=new GridviewAdapter(alistfile,ShouyeSendPhoto.this);
                gridView.setAdapter(adapter);
            }
        }

    }


    class GridviewAdapter  extends BaseAdapter{
        List<String>  mlist;
        Context  context;

        public GridviewAdapter(List<String> mlist, Context context) {
            this.mlist = mlist;
            this.context = context;
        }

        @Override
        public int getCount() {
            return mlist.size();
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
            Holder  holder=null;
            if(convertView==null){
                holder=new Holder();
                convertView= LayoutInflater.from(context).inflate(R.layout.popup_gridviewitem,null);
                holder.imageView= (ImageView) convertView.findViewById(R.id.grid_item);
                convertView.setTag(holder);
            }else{
                holder= (Holder) convertView.getTag();
            }
            String  imageView1=mlist.get(position);
            Glide.with(context).load(imageView1).into(holder.imageView);
            return convertView;
        }

        class Holder  {
            ImageView  imageView;
        }
    }
}
