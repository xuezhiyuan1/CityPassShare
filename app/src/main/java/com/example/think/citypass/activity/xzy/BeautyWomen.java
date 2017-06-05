package com.example.think.citypass.activity.xzy;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.think.citypass.R;
import com.example.think.citypass.common.base.BaseActivity;
import com.example.think.citypass.common.base.BaseFragment;
import com.example.think.citypass.fragment.xzy.beauty.XinShangFragment;
import com.example.think.citypass.fragment.zzh.community.TushuoFragment;
import com.example.think.citypass.fragment.zzh.naonao.WangyouFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by think on 2017/6/1.
 */
//美女秀
public class BeautyWomen  extends BaseActivity implements View.OnClickListener {

    TabLayout tabLayout;
    ViewPager viewPager;
    List<String> stringList;
    List<BaseFragment>  fragmentList;
    BeautyWomen.ViewpagerAdapter adapter;
    ImageView imageView;
    TextView textView;
    ImageView imageView5;
    @Override
    protected int layoutId() {
        return R.layout.find_activity;
    }

    @Override
    protected void initView() {
        imageView5 = (ImageView) findViewById(R.id.imageView5);
        tabLayout= (TabLayout) findViewById(R.id.findcitything_tablayout);
        viewPager= (ViewPager) findViewById(R.id.findcitything_viewpager);
        imageView = (ImageView) findViewById(R.id.image_citything);
        textView = (TextView) findViewById(R.id.title_Dongtan);
    }

    @Override
    protected void initData() {
        textView.setText("美女");
        imageView5.setImageDrawable(getResources().getDrawable(R.drawable.mall_camera3));
        stringList=new ArrayList<>();
        fragmentList=new ArrayList<>();
        stringList.add("土豪榜");
        stringList.add("欣赏榜");
        stringList.add("魅力榜");
        stringList.add("最新");
        stringList.add("封面女郎");
        stringList.add("新人秀");
        stringList.add("性感");
        stringList.add("冷艳");
        stringList.add("气质");
        stringList.add("萌妹子");
        stringList.add("女汉子");
        for (int i = 0; i < stringList.size(); i++) {
            if(i==1){
                XinShangFragment xinShangFragment = new XinShangFragment();
                fragmentList.add(xinShangFragment);
            }else if(i==3) {
                TushuoFragment tushuoFragment = new TushuoFragment();
                fragmentList.add(tushuoFragment);
            }else{
                WangyouFragment wangyouFragment = new WangyouFragment();
                fragmentList.add(wangyouFragment);
            }
        }

        adapter= new BeautyWomen.ViewpagerAdapter(getSupportFragmentManager(),stringList,fragmentList);
        viewPager.setAdapter(adapter);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setupWithViewPager(viewPager);
        adapter.notifyDataSetChanged();

    }

    @Override
    protected void initListener()  {
        imageView.setOnClickListener(this);
    }

    @Override
    protected void loadData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.image_citything:
                finish();
                break;
        }
    }


    class  ViewpagerAdapter extends FragmentPagerAdapter {
        List<String>  stringList;
        List<BaseFragment>  fragmentList;
        public ViewpagerAdapter(FragmentManager fm, List<String>  stringList, List<BaseFragment>  fragmentList) {
            super(fm);
            this.stringList=stringList;
            this.fragmentList=fragmentList;
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return stringList.get(position);
        }
    }


}
