package com.example.think.citypass.activity.zxm;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.think.citypass.R;
import com.example.think.citypass.common.base.BaseActivity;
import com.example.think.citypass.model.bean.ZBDataBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 张萌 on 2017/6/5.
 */

public class MyLevel  extends BaseActivity {
    ImageView  imagev;
    List<ZBDataBean> mlist;
    LevelAdapter  adapter;
    ListView  listview;
    @Override
    protected int layoutId() {
        return R.layout.shouye_level;
    }

    @Override
    protected void initView() {
        imagev= (ImageView) findViewById(R.id.level_image);
        listview= (ListView) findViewById(R.id.level_listview);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences  share=getSharedPreferences("data",MODE_PRIVATE);
        String image = share.getString("image", "");
        Glide.with(MyLevel.this).load(image).into(imagev);
    }

    @Override
    protected void initData() {
     mlist=new ArrayList<>();
        for(int  i=1;i<=10;i++){
            ZBDataBean  zb=new ZBDataBean("新居民",0,i*100+"","lv"+i);
            mlist.add(zb);
        }
        for(int  i=10;i<=20;i++){
            ZBDataBean  zb1=new ZBDataBean("小区楼长",0,i*500+"","lv"+i);
            mlist.add(zb1);
        }
        for(int  i=20;i<=30;i++){
            ZBDataBean  zb2=new ZBDataBean("街道主任",0,i*500+"","lv"+i);
            mlist.add(zb2);
        }
        adapter=new LevelAdapter(MyLevel.this,mlist);
        listview.setAdapter(adapter);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void loadData() {

    }



    class LevelAdapter  extends BaseAdapter{
        Context  context;
        List<ZBDataBean>  list;

        public LevelAdapter(Context context, List<ZBDataBean> list) {
            this.context = context;
            this.list = list;
        }

        @Override
        public int getCount() {
            return list.size();
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
                convertView= LayoutInflater.from(context).inflate(R.layout.level_item,null);
                holder.level= (TextView) convertView.findViewById(R.id.levelitem_level);
                holder.chengzhang= (TextView) convertView.findViewById(R.id.levelitem_chengzhang);
                holder.touxian= (TextView) convertView.findViewById(R.id.levelitem_touxian);
                convertView.setTag(holder);
            }else{
                holder= (Holder) convertView.getTag();
            }

            ZBDataBean  zb=mlist.get(position);
            holder.touxian.setText(zb.getTitle());
            holder.chengzhang.setText(zb.getCoin1());
            holder.level.setText(zb.getCoin2());
            return convertView;
        }

        class Holder  {
            TextView  level,touxian,chengzhang;
        }
    }
}
