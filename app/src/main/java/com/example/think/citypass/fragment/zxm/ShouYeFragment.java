package com.example.think.citypass.fragment.zxm;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.think.citypass.R;
import com.example.think.citypass.activity.zxm.CityChoiceActivity;
import com.example.think.citypass.activity.zxm.FindhouseActivity;
import com.example.think.citypass.activity.zxm.FindworkActivity;
import com.example.think.citypass.activity.zxm.ShouyeHuabi;
import com.example.think.citypass.activity.zxm.ShouyeZBActivity;
import com.example.think.citypass.common.base.BaseFragment;
import com.example.think.citypass.model.bean.ModelOneBean;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.jude.rollviewpager.hintview.ColorPointHintView;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import java.util.ArrayList;

/**
zhangxiaomeng
 * 重首页点击  加载 Fragment  用来完成首页业务
 */

public class ShouYeFragment extends BaseFragment {
   ImageButton  imageButton1,imageButton2,imageButton3;
    Button findwork_lay,findhouse_lay,fenlei,tongchengh;
LinearLayout  haoli,zhuanbi,choujiang,huabi;
    private ArrayList<ModelOneBean> mList = new ArrayList<>();
    private MyAdapter myAdapter;


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
        View  view2=LayoutInflater.from(getActivity()).inflate(R.layout.include_titlebar,null);
        imageButton1= (ImageButton) view2.findViewById(R.id.title_choose1);
        rollPagerView = (RollPagerView) view1.findViewById(R.id.RollPagerView);

        myAdapter = new MyAdapter(getActivity(),mList);
        listView.setAdapter(myAdapter);
        getPhoto();
        //添加头部
       listView.addHeaderView(view1);



    }

    @Override
    protected void initData() {

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
                Intent  intent=new Intent(getContext(), CityChoiceActivity.class);
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



    }




    @Override
    protected void loadData() {
        // 几何参数
        for (int i = 0; i < 30; i++) {
            ModelOneBean stu = new ModelOneBean("今夜阳光明媚,今夜多云转晴...","28331","亚索");
            ModelOneBean stu1 = new ModelOneBean("来试试我的‘运气’和三代鬼彻的‘诅咒’……哪一个比较强！如果我输了，就表示我的运气真的很差...","822135","尾田荣一郎");
            mList.add(stu);
            mList.add(stu1);
        }



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
        private ArrayList<ModelOneBean> mList;

        public MyAdapter(Context mContext, ArrayList<ModelOneBean> mList) {
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
                convertView = LayoutInflater.from(mContext).inflate(R.layout.modelone_item, null);
                hodler.mText_Name = (TextView) convertView.findViewById(R.id.modelone_item_title);
                hodler.mText_Address = (TextView) convertView.findViewById(R.id.modelone_item_author);
                hodler.textView= (TextView) convertView.findViewById(R.id.modelone_itemcount);
                convertView.setTag(hodler);
            } else {
                hodler = (Hodler) convertView.getTag();
            }
            ModelOneBean stu = mList.get(position);
            hodler.mText_Name.setText(stu.getTitle() + "");
            hodler.mText_Address.setText(stu.getAuthor() + "");
            hodler.textView.setText(stu.getCount());
            return convertView;

        }

        class Hodler {
            private TextView mText_Name, mText_Address,textView;
        }
    }


}
