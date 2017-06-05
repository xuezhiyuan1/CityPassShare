package com.example.think.citypass.fragment.cityadapter;

import android.content.Context;
import com.example.think.citypass.R;
import com.example.think.citypass.common.base.CommonAdapter;
import com.example.think.citypass.common.base.ViewHolder;
import com.example.think.citypass.model.entity.CityBean;

import java.util.List;

/**
 * Created by think on 2017/5/31.
 */

public class QianWaterAdapter extends CommonAdapter<CityBean.ServerInfoBean> {

    private Context context;
    private List<CityBean.ServerInfoBean> datas;

    public QianWaterAdapter(Context context, List<CityBean.ServerInfoBean> datas) {
        super(context, datas, R.layout.loveqianwater);
        this.context = context;
        this.datas = datas;
    }

    @Override
    public void display(ViewHolder holder, CityBean.ServerInfoBean serverInfoBean) {
            String address = serverInfoBean.getAddress();
            int level = serverInfoBean.getLevel();
            String sum = serverInfoBean.getSum();
            String nickName = serverInfoBean.getNickName();
            String userFace = serverInfoBean.getUserFace();
            holder.setText(R.id.naonaodiCount_water,level+"");
            holder.setImage(R.id.userImage_water,userFace);
            holder.setText(R.id.userNameText_water,nickName);
            holder.setText(R.id.location_text_water,address);
            holder.setText(R.id.repliesCount_water,sum);
    }
}
