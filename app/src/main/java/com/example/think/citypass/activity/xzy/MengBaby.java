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
import com.example.think.citypass.fragment.zzh.naonao.WangyouFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by think on 2017/6/1.
 */
//萌宝秀
public class MengBaby  extends BaseActivity implements View.OnClickListener  {

    TabLayout tabLayout;
    ViewPager viewPager;
    List<String> stringList;
    List<BaseFragment>  fragmentList;
    MengBaby.ViewpagerAdapter adapter;
    TextView textView;
    ImageView imageView;
    private ImageView imageView5;

    @Override
    protected int layoutId() {
        return R.layout.find_activity;
    }

    @Override
    protected void initView() {
        imageView5 = (ImageView) findViewById(R.id.imageView5);
        textView = (TextView) findViewById(R.id.title_Dongtan);
        tabLayout= (TabLayout) findViewById(R.id.findcitything_tablayout);
        viewPager= (ViewPager) findViewById(R.id.findcitything_viewpager);
        imageView = (ImageView) findViewById(R.id.image_citything);
    }

    @Override
    protected void initData() {
        imageView5.setImageDrawable(getResources().getDrawable(R.drawable.mall_camera3));
        textView.setText("萌宝");
        stringList=new ArrayList<>();
        fragmentList=new ArrayList<>();
        stringList.add("最强亲友团");
        stringList.add("慷慨粉");
        stringList.add("有爱粉");
        stringList.add("最新");
        stringList.add("封面宝宝");
        stringList.add("新宝宝");
        stringList.add("潮娃");
        stringList.add("吃货");
        stringList.add("表情帝");
        stringList.add("萌娃");
        stringList.add("睡姿秀");
        for (int i = 0; i < stringList.size(); i++) {
            WangyouFragment wangyouFragment = new WangyouFragment();
            fragmentList.add(wangyouFragment);
        }

        adapter= new MengBaby.ViewpagerAdapter(getSupportFragmentManager(),stringList,fragmentList);
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
