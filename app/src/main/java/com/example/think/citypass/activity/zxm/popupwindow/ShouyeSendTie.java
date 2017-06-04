package com.example.think.citypass.activity.zxm.popupwindow;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.bumptech.glide.Glide;
import com.example.think.citypass.App;
import com.example.think.citypass.R;
import com.example.think.citypass.activity.zxm.baidumap.LocationService;
import com.example.think.citypass.activity.zxm.upphoto.logic.ImgFileListActivity;
import com.example.think.citypass.activity.zxm.upphoto.logic.ImgsActivity;
import com.example.think.citypass.common.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 张萌 on 2017/5/24.
 */

public class ShouyeSendTie   extends BaseActivity {
    private LocationService locationService;
    ListView listView;
    ArrayList<String> listfile=new ArrayList<String>();
GridviewAdapter  adapter;
    ImageView  photoimage;
    TextView  textViewloc;
    String addrStr;
    ArrayList<String> alistfile=new ArrayList<String>();
    //选择图片后返回的数据结果集
    GridView   gridView;


    @Override
    protected int layoutId() {
        return com.example.think.citypass.R.layout.shouye_fatie;
    }

    @Override
    protected void initView() {
        photoimage= (ImageView) findViewById(com.example.think.citypass.R.id.tiezi_photo);
        textViewloc= (TextView) findViewById(com.example.think.citypass.R.id.text_location);
    }

    @Override
    protected void initData() {
        gridView=(GridView) findViewById(com.example.think.citypass.R.id.after_listview);
        Bundle bundle= getIntent().getExtras();
        if (bundle!=null) {
            if (bundle.getStringArrayList("files")!=null) {
                alistfile= bundle.getStringArrayList("files");
                gridView.setVisibility(View.VISIBLE);
//                ImgsActivity  imgsActivity=new ImgsActivity();
//                List<ImageView> imageview = imgsActivity.getImageview();
                adapter=new GridviewAdapter(alistfile,ShouyeSendTie.this);
                gridView.setAdapter(adapter);
            }
        }


    }

    @Override
    protected void initListener() {
    photoimage.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(ShouyeSendTie.this,ImgFileListActivity.class);
            startActivity(intent);
        }
    });
    }

    @Override
    protected void loadData() {
      textViewloc.setText(addrStr);
    }
    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        // -----------location config ------------
        locationService = ((App) getApplication()).locationService;
        //获取locationservice实例，建议应用中只初始化1个location实例，然后使用，可以参考其他示例的activity，都是通过此种方式获取locationservice实例的
        locationService.registerListener(mListener);
        //注册监听
        int type = getIntent().getIntExtra("from", 0);
        if (type == 0) {
            locationService.setLocationOption(locationService.getDefaultLocationClientOption());
        } else if (type == 1) {
            locationService.setLocationOption(locationService.getOption());
        }

        locationService.start();// 定位SDK

    }


    /***
     * Stop location service
     */
    @Override
    protected void onStop() {
        // TODO Auto-generated method stub
        locationService.unregisterListener(mListener); //注销掉监听
        locationService.stop(); //停止定位服务
        super.onStop();
    }

    /*****
     *
     * 定位结果回调，重写onReceiveLocation方法，可以直接拷贝如下代码到自己工程中修改
     *
     */
    private BDLocationListener mListener = new BDLocationListener() {

        @Override
        public void onReceiveLocation(BDLocation location) {
            // TODO Auto-generated method stub
            if (null != location && location.getLocType() != BDLocation.TypeServerError) {
                addrStr = location.getAddrStr();
                textViewloc.setText(addrStr);
                Toast.makeText(ShouyeSendTie.this, location.getAddrStr(), Toast.LENGTH_SHORT).show();
            }
        }

        public void onConnectHotSpotMessage(String s, int i){
        }
    };


    class GridviewAdapter  extends BaseAdapter {
        List<String> mlist;
        Context context;

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
            Holder holder=null;
            if(convertView==null){
                holder=new Holder();
                convertView= LayoutInflater.from(context).inflate(R.layout.shouye_fatie_photoitem,null);
                holder.imageView= (ImageView) convertView.findViewById(R.id.shouye_photo_item);
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
