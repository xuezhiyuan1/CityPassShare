package com.example.think.citypass.activity.zxm;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.think.citypass.App;
import com.example.think.citypass.R;
import com.example.think.citypass.common.base.BaseActivity;
import com.example.think.citypass.model.bean.CityBean;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 张萌 on 2017/5/25.
 */

public class CityListActivity  extends BaseActivity {
    ListView  listView;
    List<String>  mlist;
    EditText  editText;
    Button  button;
    MyAdapter  adapter;
    @Override
    protected int layoutId() {
        return R.layout.city_listview;
    }

    @Override
    protected void initView() {
     listView= (ListView) findViewById(R.id.city_listview);
        editText= (EditText) findViewById(R.id.city_search);
        button= (Button) findViewById(R.id.city_button);
    }

    @Override
    protected void initData() {
   mlist=new ArrayList<>();
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void loadData() {
        OkHttpClient  okHttpClient=new OkHttpClient.Builder().build();
        final Request  request=new Request.Builder().url("http://m67.ccoo.cn/webconfig/webconfig.txt").build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                      final String  string=response.body().string();
                Log.i("----string--",string);
                App.activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Gson  gson=new Gson();
                        CityBean cityBean = gson.fromJson(string, CityBean.class);
                        List<CityBean.ServerInfoBean> serverInfo = cityBean.getServerInfo();
                        for(int i=0;i<serverInfo.size();i++){
                            String wapSiteName = serverInfo.get(i).getWapSiteName();
                            mlist.add(wapSiteName);
                            adapter=new MyAdapter(mlist,CityListActivity.this);
                            listView.setAdapter(adapter);
                            adapter.notifyDataSetChanged();

                        }
                    }
                });
            }
        });
    }


    /***
     * listview的适配器
     */
    class  MyAdapter  extends BaseAdapter{
        List<String>  mlist;
        Context  context;

        public MyAdapter(List<String> mlist, Context context) {
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
            ViewHolder  holder=null;
            if(convertView==null){
                holder=new ViewHolder();
                convertView= LayoutInflater.from(context).inflate(R.layout.citychoice_textview,null);
                holder.textView= (TextView) convertView.findViewById(R.id.choiceitem_text);
                convertView.setTag(holder);
            }
            else{
                holder= (ViewHolder) convertView.getTag();
            }

            String  str=mlist.get(position);
            holder.textView.setText(str);
            return convertView;
        }

        class ViewHolder{
            TextView  textView;
        }

    }


}
