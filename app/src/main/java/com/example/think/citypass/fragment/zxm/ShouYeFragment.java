package com.example.think.citypass.fragment.zxm;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.think.citypass.R;
import com.example.think.citypass.activity.zxm.CityChoiceActivity;
import com.example.think.citypass.activity.zxm.FindhouseActivity;
import com.example.think.citypass.activity.zxm.FindworkActivity;
import com.example.think.citypass.activity.zxm.ShouyeFenleiLife;
import com.example.think.citypass.activity.zxm.ShouyeHaoli;
import com.example.think.citypass.activity.zxm.ShouyeHuabi;
import com.example.think.citypass.activity.zxm.ShouyeNotice;
import com.example.think.citypass.activity.zxm.ShouyeZBActivity;
import com.example.think.citypass.common.base.BaseFragment;
import com.example.think.citypass.model.bean.ModelOneBean;
import com.example.think.citypass.model.bean.ShouyeDataEntity;
import com.example.think.citypass.model.bean.ShouyeModelBean;
import com.example.think.citypass.myview.MyAnimalUtils;
import com.example.think.citypass.myview.MyGradeView;
import com.example.think.citypass.model.http.callback.OkhttpCallback;
import com.example.think.citypass.utils.http.HttpCallBack;
import com.example.think.citypass.utils.http.RetrofitImpl;
import com.example.think.citypass.utils.retrofitutils.OkhttpUtils;
import com.google.gson.Gson;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.jude.rollviewpager.hintview.ColorPointHintView;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
zhangxiaomeng
 * 重首页点击  加载 Fragment  用来完成首页业务
 */

public class ShouYeFragment extends BaseFragment implements AbsListView.OnScrollListener{
   ImageButton imageButton1,imageButton2;
    ImageView im3;
    Button findwork_lay,findhouse_lay,fenlei,tongchengh;
    LinearLayout haoli,zhuanbi,choujiang,huabi;
    private ArrayList<ModelOneBean> mList = new ArrayList<>();
    private MyAdapter myAdapter;

    private MyGradeView linkPageGridview;
    private PopupWindow popupWindow;
    private View view;
    private GVAdapter gvAdapter;
    private List<String> mlist;
    private List<Integer> mDList;
    private ArrayList<ShouyeModelBean>  datalist=new ArrayList<>();
    private ArrayList<ShouyeDataEntity.ServerInfoBean.HeadTInfoListBean>  dataList=new ArrayList<>();
    private RelativeLayout layout;
    private Handler handler = new Handler();
    private int visibleLastIndex = 0;   //最后的可视项索引
    private int visibleItemCount;       // 当前窗口可见项总数
    private int datasize = 38;          //模拟数据集的条数
    private View loadMoreView;
    private Button loadMoreButton;

    // 移动因子, 是一个百分比, 比如手指移动了100px, 那么View就只移动50px 目的是达到一个延迟的效果
    private static final float MOVE_FACTOR = 0.5f;

    // 松开手指后, 界面回到正常位置需要的动画时间
    private static final int ANIM_TIME = 300;
  private SlidingUpPanelLayout slidingUpPanelLayout;
    private RollPagerView rollPagerView;
    private ListView listView;
  //  private Banner_Adapter banner_adapter;



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
        slidingUpPanelLayout = (SlidingUpPanelLayout) view.findViewById(R.id.SlidingUpaneHead);
        zhuanbi= (LinearLayout) view.findViewById(R.id.zhuanbi_layout);
        huabi= (LinearLayout) view.findViewById(R.id.huabi_layout);
        haoli= (LinearLayout) view.findViewById(R.id.haoli_layout);
        choujiang= (LinearLayout) view.findViewById(R.id.choujiang_layout);
        listView = (ListView) view.findViewById(R.id.mListView);
        View view1 = LayoutInflater.from(getActivity().getApplicationContext()).inflate(R.layout.head_two_activity, null);
        findwork_lay= (Button) view1.findViewById(R.id.findwork_layout);
        findhouse_lay= (Button) view1.findViewById(R.id.findhouse_layout);
        fenlei= (Button) view1.findViewById(R.id.fenleilife_layout);
        tongchengh= (Button) view1.findViewById(R.id.tongcheng_layout);
        imageButton1= (ImageButton) view1.findViewById(R.id.title_choose1);
        imageButton2= (ImageButton) view1.findViewById(R.id.title_choose2);
        im3= (ImageView) view1.findViewById(R.id.title_choose3);
        rollPagerView = (RollPagerView) view1.findViewById(R.id.RollPagerView);


       View  vi=LayoutInflater.from(getContext()).inflate(R.layout.ppmb,null);
//        View  vv=LayoutInflater.from(getContext()).inflate(R.layout.ppmb,null);
        linkPageGridview = (MyGradeView) vi.findViewById(R.id.link_page_gridview);

        layout= (RelativeLayout) vi.findViewById(R.id.layout);
        myAdapter = new MyAdapter(getActivity(),dataList);
        listView.setAdapter(myAdapter);
        getPhoto();
        //添加头部
       listView.addHeaderView(view1);

    }

    @Override
    protected void initData() {
        /**8
         * 给GridView添加数据
          */
        adddata();
        getPopup();
        }

        private void adddata(){
            mlist=new ArrayList<>();
            mlist.add("发帖子");
            mlist.add("发照片");
            mlist.add("小视频");
            mlist.add("有奖爆料");
            mlist.add("分类信息");
            mlist.add("二维码");
            mDList=new ArrayList<>();
            mDList.add(R.drawable.ico_quanbu);
            mDList.add(R.drawable.baby_camera);
            mDList.add(R.drawable.ico_meishi);
            mDList.add(R.drawable.ico_qinzi);
            mDList.add(R.drawable.ic_jianli_icon);
            mDList.add(R.drawable.ic_liulan);

        }

    @Override
    protected void initListener() {
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

        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "选择城市", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getContext(), CityChoiceActivity.class);
                startActivity(intent);
            }
        });

        findwork_lay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "找工作", Toast.LENGTH_SHORT).show();
                Intent  intent=new Intent(getContext(), FindworkActivity.class);
                startActivity(intent);
            }
        });


        findhouse_lay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "找房子", Toast.LENGTH_SHORT).show();
                Intent  intent=new Intent(getContext(), FindhouseActivity.class);
                startActivity(intent);
            }
        });


        zhuanbi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent=new Intent(getContext(), ShouyeZBActivity.class);
                startActivity(intent);
            }
        });


        huabi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent=new Intent(getContext(), ShouyeHuabi.class);
                startActivity(intent);
            }
        });


        haoli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent=new Intent(getContext(), ShouyeHaoli.class);
                startActivity(intent);
            }
        });


        im3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "点击加号", Toast.LENGTH_SHORT).show();
               onViewClicke();

            }
        });

        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), ShouyeNotice.class);
                startActivity(intent);
            }
        });


        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent=new Intent(getContext(),CityChoiceActivity.class);
                startActivity(intent);
            }
        });

        fenlei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), ShouyeFenleiLife.class);
                startActivity(intent);
            }
        });



    }

    public void onViewClicke() {
        /*首先执行 加号的动画*/
        MyAnimalUtils.pictureAnimal(im3,getContext());
        popupWindow.showAtLocation(layout, Gravity.BOTTOM, 0, 0);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                    /*执行popupwindow 出现的动画*/
                MyAnimalUtils.getGVDHB(linkPageGridview, getContext(), false);
            }
        }, 400);
    }

    private void getPopup() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.ppmb, null);
        view.getBackground().setAlpha(200);
        RelativeLayout layout = (RelativeLayout) view.findViewById(R.id.layout);
        popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(null);
        linkPageGridview = (MyGradeView) view.findViewById(R.id.link_page_gridview);
        GVAdapter  gvAdapter = new GVAdapter(mDList, mlist, getContext());
        linkPageGridview.setAdapter(gvAdapter);
        popupWindow.setAnimationStyle(R.style.Animation);

        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*让每一个item先消失*/
                MyAnimalUtils.getGVDHB(linkPageGridview, getContext(), true);
                /*得到一共有几个item 然后乘以每个item 消失的时间*/
                /*获得item 消失一共用了多长时间*/
                long i = (linkPageGridview.getChildCount() + 1) * 160;
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        /*在item 消失点后让popupWindow消失*/
                        popupWindow.dismiss();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                /*在PopupWindow消失后 让加号执行逆时针动作*/
                                MyAnimalUtils.pictureAnimala(im3, getContext());
                            }
                        }, 100);
                    }
                }, i);
            }
        });
    }

    @Override
    protected void loadData() {
//        shouyeData();
        // 几何参数
//        for (int i = 0; i < 30; i++) {
//            ModelOneBean stu = new ModelOneBean("今夜阳光明媚,今夜多云转晴...","28331","亚索");
//            ModelOneBean stu1 = new ModelOneBean("来试试我的‘运气’和三代鬼彻的‘诅咒’……哪一个比较强！如果我输了，就表示我的运气真的很差...","822135","尾田荣一郎");
//            mList.add(stu);
//            mList.add(stu1);
//        }

        Map<String, String> params = new HashMap<>();
        params.put("param", "{\"appName\":\"CcooCity\",\"Param\":{\"pageSize\":20,\"page\":1,\"siteID\":2422},\"requestTime\":\"2017-05-09 18:43:22\",\"customerKey\":\"6A2861840C7B1164C1C48876EAEEFF37\",\"Method\":\"PHSocket_GetHeadlinesInfoO\",\"Statis\":{\"PhoneId\":\"866622010080020\",\"System_VersionNo\":\"Android 4.4.2\",\"UserId\":0,\"PhoneNum\":\"\",\"SystemNo\":2,\"PhoneNo\":\"Lenovo Z90-3\",\"SiteId\":2422},\"customerID\":8001,\"version\":\"4.6\"}");
//        params.put("param", "{\"appName\":\"CcooCity\",\"Param\":{\"pageSize\":20,\"page\":1,\"siteID\":2422},\"requestTime\":\"2017-05-09 18:43:22\",\"customerKey\":\"6A2861840C7B1164C1C48876EAEEFF37\",\"Method\":\"PHSocket_GetHeadlinesInfoO\",\"Statis\":{\"PhoneId\":\"866622010080020\",\"System_VersionNo\":\"Android 4.4.2\",\"UserId\":0,\"PhoneNum\":\"\",\"SystemNo\":2,\"PhoneNo\":\"Lenovo Z90-3\",\"SiteId\":2422},\"customerID\":8001,\"version\":\"4.6\"}");
                RetrofitImpl.getInstance().Post(ShouyeDataEntity.class, "http://appnew.ccoo.cn/appserverapi.ashx", params, new HttpCallBack() {
            @Override
            public void onSuccessful(Object success) {

                ShouyeDataEntity newsbean = (ShouyeDataEntity) success;
                List<ShouyeDataEntity.ServerInfoBean.HeadTInfoListBean> headTInfoList = newsbean.getServerInfo().getHeadTInfoList();
                dataList.addAll(headTInfoList);
                Log.d("ShouYeFragment", "mList.size():" + dataList.size());
                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void onError(String errorMessage) {
                Log.e("--error",errorMessage);
            }
        });

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

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

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
            Glide.with(getContext()).load(stu.getData().get(0).getImage()).into(hodler.imageView);
            return convertView;

        }

        class Hodler {
            private TextView mText_Name, mText_Address,textView;
            ImageView  imageView;
        }
    }

    /**
     * 张晓萌
     * gridview的适配器
     */

    class GVAdapter extends BaseAdapter{

        private List<Integer> mDList;
        private List<String> mlist;
        private Context context;
        private  TextView textView;

        public GVAdapter(List<Integer> mDList, List<String> mlist, Context context) {
            this.mDList = mDList;
            this.mlist = mlist;
            this.context = context;
        }

        @Override
        public int getCount() {
            return mlist.size();
        }

        @Override
        public Object getItem(int position) {
            return mlist.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Holder h=new Holder();
            convertView= LayoutInflater.from(context).inflate(R.layout.gv_item,null);
            h.textView= (TextView) convertView.findViewById(R.id.textA);
            h.imageView= (ImageView) convertView.findViewById(R.id.imageA);
            h.textView.setText(mlist.get(position));
            h.imageView.setImageResource(mDList.get(position));
            convertView.setVisibility(View.INVISIBLE);
            return convertView;
        }
         class Holder{
            private TextView textView;
            private ImageView imageView;
        }
    }










    class popupMoban {
        public  void getPopup(final Context context, PopupWindow popupWindow, RelativeLayout layout, GridView linkPageGridview, final ImageView imageView, BaseAdapter adapter, final Handler handler, List<Integer> mDList, List<String> mlist) {
            View view = LayoutInflater.from(context).inflate(R.layout.ppmb, null);
            view.getBackground().setAlpha(200);
            layout= (RelativeLayout) view.findViewById(R.id.layout);
            popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            popupWindow.setOutsideTouchable(true);
            popupWindow.setBackgroundDrawable(null);
            linkPageGridview = (MyGradeView) view.findViewById(R.id.link_page_gridview);
            adapter = new GVAdapter(mDList,mlist, context);
            linkPageGridview.setAdapter(adapter);
            popupWindow.setAnimationStyle(R.style.Animation);

            final GridView finalLinkPageGridview = linkPageGridview;
            final PopupWindow finalPopupWindow = popupWindow;
            layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                /*让每一个item先消失*/
                    MyAnimalUtils.getGVDHB(finalLinkPageGridview,context,true);
                /*得到一共有几个item 然后乘以每个item 消失的时间*/
                /*获得item 消失一共用了多长时间*/
                    long i = finalLinkPageGridview.getChildCount() * 160;
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                        /*在item 消失点后让popupWindow消失*/
                            finalPopupWindow.dismiss();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                /*在PopupWindow消失后 让加号执行逆时针动作*/
                                    MyAnimalUtils.pictureAnimala(imageView,context);
                                }
                            }, 100);
                        }
                    },i);
                }
            });
        }

        public  void getPopupa(final Context context, final ImageView imageView, List<Integer> mDList, List<String> mlist) {
            final Handler handler=new Handler();
            View view = LayoutInflater.from(context).inflate(R.layout.ppmb, null);
            view.getBackground().setAlpha(200);
            RelativeLayout layout= (RelativeLayout) view.findViewById(R.id.layout);
            PopupWindow popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            popupWindow.setOutsideTouchable(true);
            popupWindow.setBackgroundDrawable(null);
            GridView linkPageGridview = (MyGradeView) view.findViewById(R.id.link_page_gridview);
            GVAdapter adapter = new GVAdapter(mDList,mlist, context);
            linkPageGridview.setAdapter(adapter);
            popupWindow.setAnimationStyle(R.style.Animation);

            final GridView finalLinkPageGridview = linkPageGridview;
            final PopupWindow finalPopupWindow = popupWindow;
            layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                /*让每一个item先消失*/
                    MyAnimalUtils.getGVDHB(finalLinkPageGridview,context,true);
                /*得到一共有几个item 然后乘以每个item 消失的时间*/
                /*获得item 消失一共用了多长时间*/
                    long i = finalLinkPageGridview.getChildCount() * 160;
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                        /*在item 消失点后让popupWindow消失*/
                            finalPopupWindow.dismiss();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                /*在PopupWindow消失后 让加号执行逆时针动作*/
                                    MyAnimalUtils.pictureAnimala(imageView,context);
                                }
                            }, 100);
                        }
                    },i);
                }
            });
        }
    }




}
