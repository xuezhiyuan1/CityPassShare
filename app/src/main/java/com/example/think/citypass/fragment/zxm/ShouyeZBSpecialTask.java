package com.example.think.citypass.fragment.zxm;

import android.content.Context;
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
import com.example.think.citypass.common.base.BaseFragment;
import com.example.think.citypass.model.bean.ZBDataBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 张萌 on 2017/5/18.
 */

public class ShouyeZBSpecialTask   extends BaseFragment {
    ListView  listView;
    Adapter  adapter;
    List<ZBDataBean>  list;

    @Override
    protected int layoutId() {
        return R.layout.shouye_zb_specialtask;
    }

    @Override
    protected void initView(View view) {
       listView= (ListView) view.findViewById(R.id.shouye_sb_listview);
    }

    @Override
    protected void initData() {
        list=new ArrayList<>();
     ZBDataBean zb1=new ZBDataBean("设置头像",R.drawable.zfz_dianpu,"50","100");
        list.add(zb1);
        ZBDataBean zb2=new ZBDataBean("完善基本信息",R.drawable.zfz_chushou,"50","50");
        list.add(zb2);
        ZBDataBean zb3=new ZBDataBean("完善联系信息",R.drawable.zfz_qiugou,"50","50");
        list.add(zb3);
        ZBDataBean zb4=new ZBDataBean("手机认证",R.drawable.zfz_zhongjie,"50","100");
        list.add(zb4);
        ZBDataBean zb5=new ZBDataBean("搭讪与结识",R.drawable.zfz_xinloupan,"150","100");
        list.add(zb5);
        ZBDataBean zb6=new ZBDataBean("狂点赞",R.drawable.wodetiezi,"150","100");
        list.add(zb6);
        ZBDataBean zb7=new ZBDataBean("我爱评论",R.drawable.rose,"150","100");
        list.add(zb7);
        ZBDataBean zb8=new ZBDataBean("我爱抢楼",R.drawable.daoju,"150","200");
        list.add(zb8);
        ZBDataBean zb9=new ZBDataBean("我爱疯抢",R.drawable.task_money2,"150","200");
        list.add(zb9);

        adapter=new Adapter(list,getContext());
        listView.setAdapter(adapter);

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void loadData() {

    }


    class   Adapter  extends BaseAdapter{
        List<ZBDataBean>  mlist;
        Context  context;

        public Adapter(List<ZBDataBean> mlist, Context context) {
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
                convertView= LayoutInflater.from(context).inflate(R.layout.shouye_sblistview_item,null);
                holder.coin1= (TextView) convertView.findViewById(R.id.coin_one);
                holder.coin2= (TextView) convertView.findViewById(R.id.coin_two);
                holder.title= (TextView) convertView.findViewById(R.id.small_title);
                holder.imageView= (ImageView) convertView.findViewById(R.id.shouye_zb_item_image);
                convertView.setTag(holder);
            }else{
                holder= (Holder) convertView.getTag();
            }
            ZBDataBean  zbDataBean=mlist.get(position);
            holder.coin1.setText(zbDataBean.getCoin1());
            holder.coin2.setText(zbDataBean.getCoin2());
            holder.title.setText(zbDataBean.getTitle());
            Glide.with(context).load(zbDataBean.getImage()).into(holder.imageView);
            return convertView;
        }

        class Holder{
            private ImageView   imageView;
            private TextView  title,coin1,coin2;
        }
    }
}
