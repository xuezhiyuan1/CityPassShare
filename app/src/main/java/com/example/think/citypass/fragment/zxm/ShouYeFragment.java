package com.example.think.citypass.fragment.zxm;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.think.citypass.App;
import com.example.think.citypass.R;
import com.example.think.citypass.activity.HomeActivity;
import com.example.think.citypass.activity.zxm.FindhouseActivity;
import com.example.think.citypass.activity.zxm.LoginActivity;
import com.example.think.citypass.activity.zxm.ShouyeFenleiLife;
import com.example.think.citypass.activity.zxm.ShouyeHaoli;
import com.example.think.citypass.activity.zxm.ShouyeHuabi;
import com.example.think.citypass.activity.zxm.ShouyeZBActivity;
import com.example.think.citypass.activity.zxm.WebView_Activity;
import com.example.think.citypass.activity.zxm.Workdetail;
import com.example.think.citypass.catchexception.LogUtils;
import com.example.think.citypass.common.base.BaseFragment;
import com.example.think.citypass.model.bean.LoginBean;
import com.example.think.citypass.model.bean.ShouyeDataEntity;
import com.example.think.citypass.model.bean.ShouyeModelBean;
import com.example.think.citypass.utils.sharepreferencesutil.SharedPreferencesUtils;
import com.google.gson.Gson;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.jude.rollviewpager.hintview.ColorPointHintView;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
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

import static com.example.think.citypass.R.id.top_name;

/**
zhangxiaomeng
 * 重首页点击  加载 Fragment  用来完成首页业务
 */

public class ShouYeFragment extends BaseFragment {
    LinearLayout findwork_lay,findhouse_lay,fenlei,tongchengh;
    LinearLayout haoli,zhuanbi,choujiang,huabi,loginline,top_redlay;
    TextView  logintext1,loginqiandao;
    private Boolean isLoadMore = false;
    private int pageSize = 10;
    private ArrayList<ShouyeDataEntity.ServerInfoBean.HeadTInfoListBean>   mll = new ArrayList<>();
    private View inflate;
    TextView  login_after_name,coin_textview;
    private View footView;
    private int  page = 1 ;
    private MyAdapter myAdapter;
    TextView  logintext;
    TextView  denglu_textview,tag_textview;
    TextView  top_name;
    LinearLayout layout1,layout2,layout3,layout4;
    private ArrayList<ShouyeModelBean>  datalist=new ArrayList<>();
    private ArrayList<ShouyeDataEntity.ServerInfoBean.HeadTInfoListBean>  dataList=new ArrayList<>();
    private RelativeLayout layout;



    // 移动因子, 是一个百分比, 比如手指移动了100px, 那么View就只移动50px 目的是达到一个延迟的效果
    private static final float MOVE_FACTOR = 0.5f;

    // 松开手指后, 界面回到正常位置需要的动画时间
    private static final int ANIM_TIME = 300;
    private SlidingUpPanelLayout slidingUpPanelLayout;
    private RollPagerView rollPagerView;
    private ListView listView;
    //  private Banner_Adapter banner_adapter;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    String str = (String) msg.obj;
                    Gson gson = new Gson();
                    ShouyeDataEntity NewsBean = gson.fromJson(str, ShouyeDataEntity.class);
                    headTInfoList = NewsBean.getServerInfo().getHeadTInfoList();
                    mll.addAll(headTInfoList);
                    int i = headTInfoList.get(0).getTheirID();
                    Log.d("ShouYeFragment", "i:" + i);
                    myAdapter.notifyDataSetChanged();
                    break;
            }
        }
    };
    private List<ShouyeDataEntity.ServerInfoBean.HeadTInfoListBean> headTInfoList;


    @Override
    protected int layoutId() {
        return R.layout.head_activity;
    }

    /**
     * 找控件 Id
     *
     * @param view
     */
    @Override
    public void initView(View view) {


        tag_textview= (TextView) view.findViewById(R.id.tag_textview);
        coin_textview= (TextView) view.findViewById(R.id.coin_textview);
        slidingUpPanelLayout = (SlidingUpPanelLayout) view.findViewById(R.id.SlidingUpaneHead);
        int height = (int) ((App.activity.getWindowManager().getDefaultDisplay().getHeight()) * 0.45);
        slidingUpPanelLayout.setPanelHeight(height);
        zhuanbi= (LinearLayout) view.findViewById(R.id.zhuanbi_layout);
        huabi= (LinearLayout) view.findViewById(R.id.huabi_layout);
        haoli= (LinearLayout) view.findViewById(R.id.haoli_layout);
        choujiang= (LinearLayout) view.findViewById(R.id.choujiang_layout);
        listView = (ListView) view.findViewById(R.id.mListView);
        View view1 = LayoutInflater.from(getActivity().getApplicationContext()).inflate(R.layout.head_two_activity, null);
        logintext= (TextView) view1.findViewById(R.id.denglu_textview);

        findwork_lay= (LinearLayout) view1.findViewById(R.id.findwork_layout);
        findhouse_lay= (LinearLayout) view1.findViewById(R.id.findhouse_layout);
        fenlei= (LinearLayout) view1.findViewById(R.id.fenleilife_layout);
        tongchengh= (LinearLayout) view1.findViewById(R.id.tongcheng_layout);
        rollPagerView = (RollPagerView) view1.findViewById(R.id.RollPagerView);
        loginline= (LinearLayout) view.findViewById(R.id.login_linelayout);
        loginqiandao= (TextView) view.findViewById(R.id.login_qiandao);
        logintext= (TextView) view.findViewById(R.id.login_text);
        denglu_textview= (TextView) view1.findViewById(R.id.denglu_textview);

        top_redlay= (LinearLayout) view.findViewById(R.id.top_redlay);
        myAdapter = new MyAdapter(getActivity(),mll);
        listView.setAdapter(myAdapter);
        getPhoto();
        //添加头部
       listView.addHeaderView(view1);
        //更换布局
         layout1 = (LinearLayout) view.findViewById(R.id.top_begin);
        layout2 = (LinearLayout) view.findViewById(R.id.top_after);
        View  v=LayoutInflater.from(getContext()).inflate(R.layout.head_two_activity,null);
        layout3= (LinearLayout) view.findViewById(R.id.head_one);
        layout4= (LinearLayout) view.findViewById(R.id.head_two);
        login_after_name= (TextView) view.findViewById(R.id.login_after_name);
        top_name= (TextView) view.findViewById(R.id.top_name);
    }

    SharedPreferences share;
    SharedPreferences.Editor  editor;

    @Override
    protected void initData() {



    }

    @Override
    public void onResume() {
        super.onResume();
        layout1.setVisibility(View.VISIBLE);
        layout2.setVisibility(View.GONE);
        layout3.setVisibility(View.VISIBLE);
        layout4.setVisibility(View.GONE);
        share=getContext().getSharedPreferences("data",Context.MODE_PRIVATE);
        editor=share.edit();
//        System.out.print("3333333333333333333333333333333333333333333333333333333333333");
        boolean login = share.getBoolean("login", false);
        if(login){
            String name = share.getString("rolename", "未得到名字");
            String image = share.getString("roleimg", "未得到图片");
            login_after_name.setText(name);
            top_name.setText(name);
            layout2.setVisibility(View.VISIBLE);
            layout1.setVisibility(View.GONE);
            layout4.setVisibility(View.VISIBLE);
            layout3.setVisibility(View.GONE);
        }

        coin_textview.setText("财富:  "+share.getInt("coin",1)+""+"城市币");
        tag_textview.setText(share.getString("honoename",""));


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //        注销
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void initListener() {
        loginline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent=new Intent(getContext(),LoginActivity.class);
                startActivity(intent);
            }
        });

        logintext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent=new Intent(getContext(),LoginActivity.class);
                startActivity(intent);
            }
        });

        loginqiandao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent=new Intent(getContext(),LoginActivity.class);
                startActivity(intent);
            }
        });

        slidingUpPanelLayout.addPanelSlideListener(new SlidingUpPanelLayout.PanelSlideListener() {
            @Override
            public void onPanelSlide(View panel, float slideOffset) {
            }
            @Override
            public void onPanelStateChanged(View panel, SlidingUpPanelLayout.PanelState previousState, SlidingUpPanelLayout.PanelState newState) {
            }
        });

        slidingUpPanelLayout.setFadeOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                slidingUpPanelLayout.setPanelState(com.sothree.slidinguppanel.SlidingUpPanelLayout.PanelState.COLLAPSED);
            }
        });


        /**8
         * z找工作
         */
        findwork_lay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "找工作", Toast.LENGTH_SHORT).show();
                Intent  intent=new Intent(getContext(), Workdetail.class);
                startActivity(intent);
            }
        });


        /**
         * 找房子
         */
        findhouse_lay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "找房子", Toast.LENGTH_SHORT).show();
                Intent  intent=new Intent(getContext(), FindhouseActivity.class);
                startActivity(intent);
            }
        });
//
        /**
         * 赚币
         */

        zhuanbi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent=new Intent(getContext(), ShouyeZBActivity.class);
                startActivity(intent);
            }
        });
//
/**
 * 花币
 */
        huabi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent=new Intent(getContext(), ShouyeHuabi.class);
                startActivity(intent);
//                ghgghghghgh
                ///dsadsadsadsadsas
            }
        });
        /**
         * 好礼
         */
        haoli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent=new Intent(getContext(), ShouyeHaoli.class);
                startActivity(intent);
            }
        });
//

        /**8
         * 分类内容
         */
        fenlei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), ShouyeFenleiLife.class);
                startActivity(intent);
            }
        });

        /***
         * 登录或者注册
         */

        logintext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent=new Intent(getContext(), LoginActivity.class);
                startActivity(intent);
            }
        });

        /***8
         * listview分页加载监听事件
         */
        listener();

        denglu_textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent=new Intent(getContext(), LoginActivity.class);
                startActivity(intent);
            }
        });

    }


    @Override
    protected void loadData() {
        /***
         * 执行网络请求,加载网络数据
         */
        loadDataNet();
    }


    /**
     * 对SlidingUpPanelLayout进行监听   你懂得   实现
     * <p>
     * 首页的那个效果，反正就是那个效果。
     */

       private void  getPhoto(){
        //设置播放时间间隔
        rollPagerView.setPlayDelay(2000);
        //设置透明度
        rollPagerView.setAnimationDurtion(500);
        //设置适配器
        rollPagerView.setAdapter(new Banner_Adapter());
        //设置指示器（顺序依次）
        //自定义指示器图片
        //设置圆点指示器颜色
        //设置文字指示器
        //隐藏指示器
        //mRollViewPager.setHintView(new IconHintView(this, R.drawable.point_focus, R.drawable.point_normal));
        rollPagerView.setHintView(new ColorPointHintView(getActivity(), Color.YELLOW, Color.WHITE));
        //mRollViewPager.setHintView(new TextHintView(this));
        //mRollViewPager.setHintView(null);
    }


    /***
     * 轮播图的适配器
     */
    class Banner_Adapter extends StaticPagerAdapter {


        private int[] imgs ={
                R.drawable.my_main_advice1,
                R.drawable.my_main_advice2,
                R.drawable.my_main_advice3,
                R.drawable.my_main_advice4,

        };
        @Override
        public View getView(ViewGroup container, int position) {
            ImageView view = new ImageView(container.getContext());
            view.setImageResource(imgs[position]);
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            return view;
        }

        @Override
        public int getCount() {
            return imgs.length;
        }
    }
    /***
     * listview的适配器
     */
    class MyAdapter extends BaseAdapter {
        private Context mContext;
        private ArrayList<ShouyeDataEntity.ServerInfoBean.HeadTInfoListBean> mList;

        public MyAdapter(Context mContext, ArrayList<ShouyeDataEntity.ServerInfoBean.HeadTInfoListBean> mList) {
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
            Hodler hodler = null;
            if (convertView == null) {
                hodler = new Hodler();
                convertView = LayoutInflater.from(mContext).inflate(R.layout.shouyelistview_item, null);
                hodler.mText_Name = (TextView) convertView.findViewById(R.id.modelone_item_title);
                hodler.mText_Address = (TextView) convertView.findViewById(R.id.modelone_item_author);
                hodler.textView= (TextView) convertView.findViewById(R.id.modelone_itemcount);
                hodler.imageView= (ImageView) convertView.findViewById(R.id.modelone_image);
                convertView.setTag(hodler);
            } else {
                hodler = (Hodler) convertView.getTag();
            }
            ShouyeDataEntity.ServerInfoBean.HeadTInfoListBean stu = mList.get(position);
            hodler.mText_Name.setText(stu.getData().get(0).getTitle()+ "");
            hodler.mText_Address.setText(stu.getData().get(0).getVariable8()+ "");
            hodler.textView.setText(stu.getData().get(0).getVariable1()+"");
            if (stu.getData().get(0).getImage()==null){
                Glide.with(getContext()).load(R.drawable.city).into(hodler.imageView);
            }
            Glide.with(getContext()).load(stu.getData().get(0).getImage()).into(hodler.imageView);
            return convertView;

        }

        class Hodler {
            private TextView mText_Name, mText_Address,textView;
            ImageView  imageView;
        }
    }
    /**8
     * 加载网络数据,
     */
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
            pp.put("customerKey", "6A2861840C7B1164C1C48876EAEEFF37");
            pp.put("Method", "PHSocket_GetHeadlinesInfoO");
            pp.put("Statis", createTongji());
            pp.put("customerID", 8001);
            pp.put("version", "4.6");


        } catch (JSONException e) {
            e.printStackTrace();
        }
        String str = pp.toString();
        Log.d("ShouYeFragment", str);

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
        //        Toast.makeText(getContext(), "加载失败，请重新加载。。。", Toast.LENGTH_SHORT).show();
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
            pp.put("PhoneId", "866622010080020");
            pp.put("System_VersionNo", "Android " + android.os.Build.VERSION.RELEASE);
            pp.put("UserId", "0");
            pp.put("PhoneNum", "");
            pp.put("SystemNo", 2);
            pp.put("PhoneNo", "android.os.Build.MODEL");
            pp.put("SiteId", "2422");


        } catch (Exception e) {
            e.printStackTrace();
        }
        return pp;
    }


    /**
     * 对SlidingUpPanelLayout进行监听   你懂得   实现
     * <p>
     * 首页的那个效果，反正就是那个效果。
     */
    protected void listener() {

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(),WebView_Activity.class);
                intent.putExtra("id",mll.get(position-1).getTheirID());
                startActivity(intent);

//                Toast.makeText(getContext(), "暂无详情", Toast.LENGTH_SHORT).show();
            }
        });


        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (scrollState == SCROLL_STATE_IDLE && isLoadMore) {
                    Toast.makeText(getContext(), "loading...", Toast.LENGTH_SHORT).show();
                    Log.e("TAG", "ListView开始分页加载");
                    listView.addFooterView(inflate);
                    loadData();
                    listView.removeFooterView(inflate);
                    myAdapter.notifyDataSetChanged();
                    isLoadMore = false;
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (firstVisibleItem + visibleItemCount == totalItemCount) {
                    isLoadMore = true;


                }
            }
        });

    }






}
