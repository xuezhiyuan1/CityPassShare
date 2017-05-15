package com.example.think.citypass.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.example.think.citypass.R;

/**
 * Created by 张萌 on 2017/5/14.
 */

public class FistActivity  extends Activity {

    private XCSlideMenu xcSlideMenu;
    private TextView btnSwitch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.firstcehuamenu);
        xcSlideMenu = (XCSlideMenu) findViewById(R.id.slideMenu);
        btnSwitch = (TextView)findViewById(R.id.btnSwitch);
        btnSwitch.setClickable(true);
        btnSwitch.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                xcSlideMenu.switchMenu();

            }
        });

    }

}
