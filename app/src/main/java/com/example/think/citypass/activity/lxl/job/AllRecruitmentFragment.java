package com.example.think.citypass.activity.lxl.job;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.think.citypass.App;
import com.example.think.citypass.R;
import com.example.think.citypass.activity.lxl.job.bean.LifeBean;
import com.example.think.citypass.activity.lxl.job.demo.GridViewAdapter;
import com.example.think.citypass.activity.lxl.job.demo.Model;
import com.example.think.citypass.activity.lxl.job.demo.ViewPagerAdapter;
import com.example.think.citypass.activity.zxm.FindworkActivity;
import com.example.think.citypass.common.base.BaseFragment;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 * Created by d on 2017/5/16.
 * 这是我的“生活”模块
 * 李祥磊
 */

public class AllRecruitmentFragment extends BaseFragment {
    private String[] titles = {"全职招聘", "二手房", "新楼盘", "二手交易", "车辆买卖", "生活服务",
            "同城交友", "宠物服务"};
    private ViewPager mPager;
    private List<View> mPagerList;
    private List<Model> mDatas;
    private LinearLayout mLlDot;
    private LayoutInflater inflater;
    /**
     * 总的页数
     */
    private int pageCount;
    /**
     * 每一页显示的个数
     */
    private int pageSize = 4;
    /**
     * 当前显示的是第几页
     */
    private int curIndex = 0;
    private TextView QuanZhi,JianZhi,JianLiKu,twohouse,newhouse;
    private RelativeLayout layout ,layoutHouse;
    //无网络加载试图
    LinearLayout linearLayout;
//    private int pageSize = 4;
    private int  page = 1 ;
    @Override
    protected int layoutId() {
        return R.layout.all_life_all;
    }

    @Override
    protected void initView(View view) {
        mPager = (ViewPager)view.findViewById(R.id.viewpager);
        mLlDot = (LinearLayout)view.findViewById(R.id.ll_dot);
        layoutHouse= (RelativeLayout) view.findViewById(R.id.house_relay);
        layout= (RelativeLayout) view.findViewById(R.id.job_relay);
        QuanZhi= (TextView) view.findViewById(R.id.QuanZhizhaopin_text1);
        JianZhi= (TextView) view.findViewById(R.id.JianZhizhaopin_text2);
        JianLiKu= (TextView) view.findViewById(R.id.JianLiKuzhaopin_text3);
        twohouse= (TextView) view.findViewById(R.id.Two_House);
        newhouse= (TextView) view.findViewById(R.id.New_House2);
        //无网络加载试图
        linearLayout = (LinearLayout) view.findViewById(R.id.ll_loading);
    }
    @Override
    protected void initData() {
        initDatas();
        inflater = LayoutInflater.from(getContext());
        //总的页数=总数/每页数量，并取整
        pageCount = (int) Math.ceil(mDatas.size() * 1.0 / pageSize);
        mPagerList = new ArrayList<View>();
        for (int i = 0; i < pageCount; i++) {
            //每个页面都是inflate出一个新实例
            GridView gridView = (GridView) inflater.inflate(R.layout.gridview, mPager, false);
            gridView.setAdapter(new GridViewAdapter(App.activity, mDatas, i, pageSize));
            mPagerList.add(gridView);

            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    int pos = position + curIndex * pageSize;
                    Toast.makeText(getContext(), mDatas.get(pos).getName(), Toast.LENGTH_SHORT).show();
                }
            });
        }
        //设置适配器
        mPager.setAdapter(new ViewPagerAdapter(mPagerList));
        //设置圆点
        setOvalLayout();
    }
    private void initDatas() {
        mDatas = new ArrayList<Model>();
        for (int i = 0; i < titles.length; i++) {
            //动态获取资源ID，第一个参数是资源名，第二个参数是资源类型例如drawable，string等，第三个参数包名
            int imageId = getResources().getIdentifier("ic_category_" + i, "mipmap", null);
            mDatas.add(new Model(titles[i], imageId));
        }
    }
    /**
     * 设置圆点
     */
    public void setOvalLayout() {
        for (int i = 0; i < pageCount; i++) {
            mLlDot.addView(inflater.inflate(R.layout.dot, null));
        }
        // 默认显示第一页
        mLlDot.getChildAt(0).findViewById(R.id.v_dot)
                .setBackgroundResource(R.drawable.dot_selected);
        mPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageSelected(int position) {
                // 取消圆点选中
                mLlDot.getChildAt(curIndex)
                        .findViewById(R.id.v_dot)
                        .setBackgroundResource(R.drawable.dot_normal);
                // 圆点选中
                mLlDot.getChildAt(position)
                        .findViewById(R.id.v_dot)
                        .setBackgroundResource(R.drawable.dot_selected);
                curIndex = position;
            }

            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            public void onPageScrollStateChanged(int arg0) {
            }
        });
    }


    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            if(msg.what == 200){
                linearLayout.setVisibility(View.GONE);
                Toast.makeText(getContext(), "加载成功", Toast.LENGTH_SHORT).show();
            }
            return true;
        }
    });
    @Override
    protected void initListener() {
           QuanZhi.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent intent=new Intent(App.activity,Recuitment_QuanZhiActivity.class);
                  startActivity(intent);
               }
           });
        JianZhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(getContext(),Recruitment_JianZhiActivity.class);
                startActivity(in);
            }
        });
        JianLiKu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(getContext(),JianLiKuActivity.class);
                startActivity(intent1);
            }
        });
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(getContext(), FindworkActivity.class);
                startActivity(intent2);
            }
        });

        layoutHouse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3=new Intent(getContext(), FingSouseActivity.class);
                startActivity(intent3);
            }
        });
        newhouse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5=new Intent(getContext(),NewHouseActivity.class);
                startActivity(intent5);
            }
        });
        twohouse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4=new Intent(getContext(),TwoHouseActivity.class);
                startActivity(intent4);
            }
        });
    }

    @Override
    protected void loadData() {
        loadDataNet();
        handler.sendEmptyMessageDelayed(200,2000);
    }

    class Holder extends BaseAdapter {
        private Context mContext;
        private ArrayList<LifeBean> mList;

        public Holder(Context mContext, ArrayList<LifeBean> mList) {
            this.mContext = mContext;
            this.mList = mList;
        }

        @Override
        public int getCount() {
            return mList.isEmpty() ? 0 : mList.size();
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
            HolderView holderView = null;
            if (convertView == null) {
                holderView = new HolderView();
                convertView = LayoutInflater.from(mContext).inflate(R.layout.alllife_activity, null);
                holderView.mText = (TextView) convertView.findViewById(R.id.ZhiWei);
                holderView.mText_info = (TextView) convertView.findViewById(R.id.GongZuo);
                convertView.setTag(holderView);
            } else {
                holderView = (HolderView) convertView.getTag();
            }
            LifeBean lifeBean = mList.get(position);
            holderView.mText.setText(lifeBean.getTitle() + "");
            holderView.mText.setText(lifeBean.getName() + "");
            return convertView;
        }

        class HolderView {
            private TextView mText, mText_info;

        }

    }
        protected void loadDataNet() {
            JSONObject jo = new JSONObject();
            try {
                jo.put("siteID", 2422);
                jo.put("pageSize", pageSize );
                jo.put("page",page++);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String time = df.format(new Date().getTime());
            JSONObject pp = new JSONObject();
            try {
                pp.put("appName", "CcooCity");
                pp.put("Param", jo);
                pp.put("requestTime", time);
                pp.put("customerKey", "FBE2174C1F7544BEC0BD13029CB6CA32");
                pp.put("Method", "PHSocket_GetNewPostLiveInfoTwo");
                pp.put("Statis", createTongji());
                pp.put("customerID", 8001);
                pp.put("version", "1.0");


            } catch (JSONException e) {
                e.printStackTrace();
            }
            String str = pp.toString();
            Log.d("All", str);

            OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
            FormBody.Builder formBody = new FormBody.Builder();
            Map<String, String> param = new HashMap<>();
            param.put("param", str);
            if (param != null && param.size() > 0) {
                Set<String> set = param.keySet();
                for (String key : set) {
                    String value = param.get(key);
                    formBody.add(key, value);
                }
            }
            Request request = new Request.Builder()
                    .url("http://appnew.ccoo.cn/appserverapi.ashx")
                    .post(formBody.build())
                    .build();
            Call call = okHttpClient.newCall(request);
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    Toast.makeText(getContext(), "加载失败，请重新加载。。。", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String string = response.body().string();
                    Message msg = new Message();
                    msg.obj = string;
                    msg.what = 1;
                    handler.sendMessage(msg);


                }
            });


        }

        public static JSONObject createTongji() {
            JSONObject pp = new JSONObject();
            try {
                pp.put("PhoneId", "864349855812273");
                pp.put("System_VersionNo", "Android " + android.os.Build.VERSION.RELEASE);
                pp.put("UserId", "0");
                pp.put("PhoneNum", "+8617620157651");
                pp.put("SystemNo", 2);
                pp.put("PhoneNo", "N8010");
                pp.put("SiteId", "2422");


            } catch (Exception e) {
                e.printStackTrace();
            }
            return pp;
        }
    }
