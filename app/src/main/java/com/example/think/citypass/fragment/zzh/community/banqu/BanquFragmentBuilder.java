package com.example.think.citypass.fragment.zzh.community.banqu;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.think.citypass.App;
import com.example.think.citypass.R;
import com.example.think.citypass.common.base.BaseActivity;
import com.example.think.citypass.common.base.BaseFragment;

import static com.example.think.citypass.App.banquFragment;


public class BanquFragmentBuilder {

    private static BanquFragmentBuilder fragmentBuilder;

    private FragmentManager fragmentManager;

    private BaseFragment baseFragment;

    private FragmentTransaction transaction;


    private BanquFragmentBuilder() {
        init(App.activity);
    }

    public synchronized static BanquFragmentBuilder getInstance() {
        if (fragmentBuilder == null)
            fragmentBuilder = new BanquFragmentBuilder();
        return fragmentBuilder;
    }

    private void init(BaseActivity activity) {
        fragmentManager = activity.getSupportFragmentManager();
    }

    public static void clean() {
        fragmentBuilder = null;
    }

    public BanquFragmentBuilder show(Class<? extends BaseFragment> aClass) {
        transaction = fragmentManager.beginTransaction();
        String simpleName = aClass.getSimpleName();

        baseFragment = (BaseFragment) fragmentManager.findFragmentByTag(simpleName);

        if (baseFragment == null) {
            try {
                baseFragment = aClass.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            transaction.add(R.id.banqu_frame, baseFragment, simpleName);
        }

        if (banquFragment != null) {
            transaction.hide(banquFragment);
        }

        transaction.show(baseFragment);

        transaction.addToBackStack(null);

        return this;
    }

    public BaseFragment builder() {
        banquFragment = baseFragment;
        transaction.commit();
        return baseFragment;
    }

}
