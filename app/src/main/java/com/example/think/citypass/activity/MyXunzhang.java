package com.example.think.citypass.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

public class MyXunzhang  extends BaseActivity {
    ListView listView;
    XunzhangAdapter  adapter;
    List<ZBDataBean>  mlist;
    TextView  dotask;
    LinearLayout  shouyehuabi_close;

    @Override
    protected int layoutId() {
        return R.layout.xunzhang;
    }

    @Override
    protected void initView() {
        shouyehuabi_close= (LinearLayout) findViewById(R.id.shouyehuabi_close);
        dotask= (TextView) findViewById(R.id.xunzhang_dotask);
        listView= (ListView) findViewById(R.id.xunzhang_listview);

    }

    @Override
    protected void initData() {
        mlist=new ArrayList<>();
        for(int  i=1;i<=10;i++){
            ZBDataBean  zb=new ZBDataBean("交友族",R.drawable.baby_home_gift5,i*100+"","lv"+i);
            mlist.add(zb);
        }
        for(int  i=10;i<=20;i++){
            ZBDataBean  zb1=new ZBDataBean("红人",R.drawable.baby_home_gift2,i*500+"","lv"+i);
            mlist.add(zb1);
        }
        for(int  i=20;i<=30;i++){
            ZBDataBean  zb2=new ZBDataBean("打赏族",R.drawable.baby_home_gift1,i*500+"","lv"+i);
            mlist.add(zb2);
        }
        adapter=new XunzhangAdapter(MyXunzhang.this,mlist);
        listView.setAdapter(adapter);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void loadData() {

    }

    class XunzhangAdapter  extends BaseAdapter {
        Context context;
        List<ZBDataBean>  list;

        public XunzhangAdapter(Context context, List<ZBDataBean> list) {
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
                convertView= LayoutInflater.from(context).inflate(R.layout.xunzhang_item,null);
                holder.name= (TextView) convertView.findViewById(R.id.xunzhang_name);
                holder.image= (ImageView) convertView.findViewById(R.id.xunzhang_image);
                convertView.setTag(holder);
            }else{
                holder= (Holder) convertView.getTag();
            }

            ZBDataBean  zb=mlist.get(position);
            holder.name.setText(zb.getTitle());
            Glide.with(context).load(zb.getImage()).into(holder.image);
            return convertView;
        }

        class Holder  {
            TextView  name;
            ImageView  image;
        }
    }
}
