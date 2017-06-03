package com.example.think.citypass.fragment.zzh.community;

import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.think.citypass.App;
import com.example.think.citypass.R;
import com.example.think.citypass.common.base.BaseFragment;
import com.example.think.citypass.common.config.Urls;
import com.example.think.citypass.model.enitity.BanquBean;
import com.example.think.citypass.model.enitity.BanquGuanBean;
import com.example.think.citypass.model.http.callback.ResaultCallBack;
import com.example.think.citypass.myview.MyProgressDialog;
import com.example.think.citypass.myview.RoundAngleImageView;
import com.example.think.citypass.utils.LinuxUtils;
import com.example.think.citypass.utils.retrofitutils.RetrofitUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BanquFragment extends BaseFragment {

    private MyProgressDialog dialog;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                dialog.dismiss();
            }
        }
    };

    private LinearLayout leftLayout, noLoginLayout;

    private ListView mainListview;

    private int weizhi = -1;

    private List<BanquBean.ServerInfoBean> data;
    private Map<Integer,BanquBean.ServerInfoBean> guanList;
    private List<BanquBean.ServerInfoBean> MyfollowList;
    private List<BanquBean.ServerInfoBean> oneList;
    private List<BanquBean.ServerInfoBean> twoList;
    private List<BanquBean.ServerInfoBean> threeList;
    private List<BanquBean.ServerInfoBean> fourList;
    private List<BanquBean.ServerInfoBean> fiveList;


    private BanquAdapter adapter;

    @Override
    protected int layoutId() {
        return R.layout.banqu_fragment;
    }

    @Override
    protected void initView(View view) {
        leftLayout = (LinearLayout) view.findViewById(R.id.banqu_daohang);
        mainListview = (ListView) view.findViewById(R.id.banqu_listview);
        noLoginLayout = (LinearLayout) view.findViewById(R.id.noLoginLayout);
    }

    @Override
    protected void initData() {
        data = new ArrayList<>();
        guanList = new HashMap<>();
        MyfollowList = new ArrayList<>();
        oneList = new ArrayList<>();
        twoList = new ArrayList<>();
        threeList = new ArrayList<>();
        fourList = new ArrayList<>();
        fiveList = new ArrayList<>();
        init();
        set();
    }

    private void init() {
        dialog = new MyProgressDialog(App.activity);
    }

    @Override
    protected void initListener() {


    }

    @Override
    protected void loadData() {
    }

    private void set() {
        for (int i = 0; i < 6; i++) {
            final int position = i;
            View view = LayoutInflater.from(getActivity()).inflate(
                    R.layout.banqu_left_item, null);
            view.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (position == 0) {
                        setDaohangState(position);
                    } else if (position == 4) {
                        setDaohangState(position);
                    } else {
                        setDaohangState(position);
                    }
                }
            });
            TextView title = (TextView) view.findViewById(R.id.title);
            switch (i) {
                case 0:
                    title.setText("我的关注");
                    break;
                case 1:
                    title.setText("百姓事");
                    break;
                case 2:
                    title.setText("兴趣圈");
                    break;
                case 3:
                    title.setText("生活馆");
                    break;
                case 4:
                    title.setText("问事帮");
                    break;
                case 5:
                    title.setText("找客服");
                    break;
                default:
                    break;
            }
            leftLayout.addView(view);
        }
        setDaohangState(0);
        adapter = new BanquAdapter();
        mainListview.setAdapter(adapter);
    }

    private void setDaohangState(int position) {
        weizhi = position;
        for (int i = 0; i < leftLayout.getChildCount(); i++) {
            View view = leftLayout.getChildAt(i);
            TextView title = (TextView) view.findViewById(R.id.title);
            LinearLayout layout = (LinearLayout) view.findViewById(R.id.layout);
            TextView line1 = (TextView) view.findViewById(R.id.oneline);
            TextView line2 = (TextView) view.findViewById(R.id.twoline);
            TextView line3 = (TextView) view.findViewById(R.id.threeline);

            if (i == position) {
                title.setTextSize(17);
                title.setTextColor(getResources().getColor(R.color.red_text));
                line1.setVisibility(View.VISIBLE);
                line2.setVisibility(View.GONE);
                line3.setVisibility(View.GONE);
                layout.setBackgroundColor(getResources()
                        .getColor(R.color.white));
            } else {
                title.setTextSize(16);
                title.setTextColor(getResources().getColor(R.color.color_999));
                line1.setVisibility(View.GONE);
                line2.setVisibility(View.VISIBLE);
                line3.setVisibility(View.VISIBLE);
                layout.setBackgroundColor(getResources().getColor(
                        R.color.color_f0));
            }
        }

        showNotLoginView(position);

        switch (position) {
            case 0:
                if (oneList.size() == 0) {
                    RetrofitUtil.getInstance().postRetrofitTwo(creatParamsLike(), new MyGuanzhuCallback(), BanquBean.class);
                } else {
                    data.clear();
                    data.addAll(MyfollowList);
                    adapter.notifyDataSetChanged();
                }
                break;
            case 1:
                if (oneList.size() == 0) {
                    dialog.show();
                    RetrofitUtil.getInstance().postRetrofitTwo(creatParams(1), new ResaultCallBack() {
                        @Override
                        public void onSuccess(Object obj) {
                            dialog.dismiss();
                            BanquBean guanzhuBean = (BanquBean) obj;
                            List<BanquBean.ServerInfoBean> serverInfo = guanzhuBean.getServerInfo();

                            if (!(serverInfo == null && serverInfo.size() == 0)) {
                                oneList.clear();
                                oneList.addAll(serverInfo);
                            }
                            data.clear();
                            data.addAll(oneList);
                            adapter.notifyDataSetChanged();
                        }

                        @Override
                        public void onError(String errorMsg) {
                            Toast.makeText(App.activity, errorMsg, Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void notNet(String netData) {
                            Toast.makeText(App.activity, netData, Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onErrorParams(String errorParams) {
                            Toast.makeText(App.activity, errorParams, Toast.LENGTH_SHORT).show();
                        }
                    }, BanquBean.class);
                } else {
                    data.clear();
                    data.addAll(oneList);
                    adapter.notifyDataSetChanged();
                }
                break;
            case 2:
                if (twoList.size() == 0) {
                    dialog.show();
                    RetrofitUtil.getInstance().postRetrofitTwo(creatParams(2), new ResaultCallBack() {
                        @Override
                        public void onSuccess(Object obj) {
                            dialog.dismiss();
                            BanquBean guanzhuBean = (BanquBean) obj;
                            List<BanquBean.ServerInfoBean> serverInfo = guanzhuBean.getServerInfo();

                            if (!(serverInfo == null && serverInfo.size() == 0)) {
                                twoList.clear();
                                twoList.addAll(serverInfo);
                            }
                            data.clear();
                            data.addAll(twoList);
                            adapter.notifyDataSetChanged();
                        }

                        @Override
                        public void onError(String errorMsg) {
                            Toast.makeText(App.activity, errorMsg, Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void notNet(String netData) {
                            Toast.makeText(App.activity, netData, Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onErrorParams(String errorParams) {
                            Toast.makeText(App.activity, errorParams, Toast.LENGTH_SHORT).show();
                        }
                    }, BanquBean.class);
                } else {
                    data.clear();
                    data.addAll(twoList);
                    adapter.notifyDataSetChanged();
                }
                break;
            case 3:
                if (threeList.size() == 0) {
                    dialog.show();
                    RetrofitUtil.getInstance().postRetrofitTwo(creatParams(3), new ResaultCallBack() {
                        @Override
                        public void onSuccess(Object obj) {
                            dialog.dismiss();
                            BanquBean guanzhuBean = (BanquBean) obj;
                            List<BanquBean.ServerInfoBean> serverInfo = guanzhuBean.getServerInfo();

                            if (!(serverInfo == null && serverInfo.size() == 0)) {
                                threeList.clear();
                                threeList.addAll(serverInfo);
                            }
                            data.clear();
                            data.addAll(threeList);
                            adapter.notifyDataSetChanged();
                        }

                        @Override
                        public void onError(String errorMsg) {
                            Toast.makeText(App.activity, errorMsg, Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void notNet(String netData) {
                            Toast.makeText(App.activity, netData, Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onErrorParams(String errorParams) {
                            Toast.makeText(App.activity, errorParams, Toast.LENGTH_SHORT).show();
                        }
                    }, BanquBean.class);
                } else {
                    data.clear();
                    data.addAll(threeList);
                    adapter.notifyDataSetChanged();
                }
                break;
            case 4:
                if (fourList.size() == 0) {
                    dialog.show();
                    RetrofitUtil.getInstance().postRetrofitTwo(creatParams(4), new ResaultCallBack() {
                        @Override
                        public void onSuccess(Object obj) {
                            dialog.dismiss();
                            BanquBean guanzhuBean = (BanquBean) obj;
                            List<BanquBean.ServerInfoBean> serverInfo = guanzhuBean.getServerInfo();

                            if (!(serverInfo == null && serverInfo.size() == 0)) {
                                fourList.clear();
                                fourList.addAll(serverInfo);
                            }
                            data.clear();
                            data.addAll(fourList);
                            adapter.notifyDataSetChanged();
                        }

                        @Override
                        public void onError(String errorMsg) {
                            Toast.makeText(App.activity, errorMsg, Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void notNet(String netData) {
                            Toast.makeText(App.activity, netData, Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onErrorParams(String errorParams) {
                            Toast.makeText(App.activity, errorParams, Toast.LENGTH_SHORT).show();
                        }
                    }, BanquBean.class);
                } else {
                    data.clear();
                    data.addAll(fourList);
                    adapter.notifyDataSetChanged();
                }
                break;
            case 5:
                if (fiveList.size() == 0) {
                    dialog.show();
                    RetrofitUtil.getInstance().postRetrofitTwo(creatParams(5), new ResaultCallBack() {
                        @Override
                        public void onSuccess(Object obj) {
                            dialog.dismiss();
                            BanquBean guanzhuBean = (BanquBean) obj;
                            List<BanquBean.ServerInfoBean> serverInfo = guanzhuBean.getServerInfo();

                            if (!(serverInfo == null && serverInfo.size() == 0)) {
                                fiveList.clear();
                                fiveList.addAll(serverInfo);
                            }
                            data.clear();
                            data.addAll(fiveList);
                            adapter.notifyDataSetChanged();
                        }

                        @Override
                        public void onError(String errorMsg) {
                            Toast.makeText(App.activity, errorMsg, Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void notNet(String netData) {
                            Toast.makeText(App.activity, netData, Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onErrorParams(String errorParams) {
                            Toast.makeText(App.activity, errorParams, Toast.LENGTH_SHORT).show();
                        }
                    }, BanquBean.class);
                } else {
                    data.clear();
                    data.addAll(fiveList);
                    adapter.notifyDataSetChanged();
                }
                break;
        }


    }

    private void showNotLoginView(int type) {
        if (type == 0) {
            noLoginLayout.setVisibility(View.VISIBLE);
        } else {
            noLoginLayout.setVisibility(View.GONE);
            mainListview.setVisibility(View.VISIBLE);
        }
    }


    private class MyGuanzhuCallback implements ResaultCallBack {

        @Override
        public void onSuccess(Object obj) {
            BanquBean guanzhuBean = (BanquBean) obj;
            List<BanquBean.ServerInfoBean> serverInfo = guanzhuBean.getServerInfo();

            if (!(serverInfo == null && serverInfo.size() == 0)) {
                MyfollowList.clear();
                MyfollowList.addAll(serverInfo);
            }
            data.clear();
            data.addAll(MyfollowList);
            adapter.notifyDataSetChanged();
        }

        @Override
        public void onError(String errorMsg) {
            Toast.makeText(App.activity, errorMsg, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void notNet(String netData) {
            Toast.makeText(App.activity, netData, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onErrorParams(String errorParams) {
            Toast.makeText(App.activity, errorParams, Toast.LENGTH_SHORT).show();
        }
    }

    private class BanquAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return data == null ? 0 : data.size();
        }

        @Override
        public Object getItem(int position) {
            return data.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, final ViewGroup parent) {
            if (convertView == null) {
                convertView = View.inflate(App.activity, R.layout.list_item, null);
            }

            LinearLayout topLayout = (LinearLayout) convertView.findViewById(R.id.top_layout);
            TextView typeTv = (TextView) convertView.findViewById(R.id.type_textview);
            RoundAngleImageView imageView = (RoundAngleImageView) convertView.findViewById(R.id.banqu_imageview);
            TextView titleTv = (TextView) convertView.findViewById(R.id.title_textview);
            final TextView numTv = (TextView) convertView.findViewById(R.id.num_textview);
            final TextView submitTv = (TextView) convertView.findViewById(R.id.submit_textview);

            final BanquBean.ServerInfoBean info = data.get(position);

            if (weizhi == 0) {
                if (position == 0) {
                    topLayout.setVisibility(View.VISIBLE);
                    typeTv.setText("推荐版块");
                } else
                    topLayout.setVisibility(View.GONE);

            } else if (!"".equals(info.getParentName())) {
                if (position == 0) {
                    topLayout.setVisibility(View.VISIBLE);
                } else {
                    if (info.getParentName().equals(
                            data.get(position - 1).getParentName())) {
                        topLayout.setVisibility(View.GONE);
                    } else {
                        topLayout.setVisibility(View.VISIBLE);
                    }
                }
                typeTv.setText(info.getParentName());
            } else {
                topLayout.setVisibility(View.GONE);
            }

            // 是否关注设置
            boolean isGuan = false;

            Set<Integer> keySet = guanList.keySet();

            for (int key : keySet) {
                BanquBean.ServerInfoBean serverInfoBean = guanList.get(key);
                if(String.valueOf(serverInfoBean.getBoardId()).equals(String.valueOf(info.getBoardId()))){
                    isGuan = true;
                }
            }

            if (isGuan) {
                if (weizhi == 2) {
                    submitTv.setText("已加入");
                } else {
                    submitTv.setText("已关注");
                }
                submitTv.setBackgroundResource(R.drawable.banqu_guanzhu_after);
            } else {
                if (weizhi == 2) {
                    submitTv.setText("加入");
                } else {
                    submitTv.setText("关注");
                }
                submitTv.setBackgroundResource(R.drawable.banqu_guanzhu_befor);
            }

            submitTv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.show();
                    RetrofitUtil.getInstance().postRetrofitTwo(creatParamsGuan(info.getBoardId()), new ResaultCallBack() {
                        @Override
                        public void onSuccess(Object obj) {
                            BanquGuanBean guanBean = (BanquGuanBean) obj;
                            int code = guanBean.getMessageList().getCode();

                            if (code == 1000) {
                                if (weizhi == 2) {
                                    Toast.makeText(App.activity, "已加入本圈~", Toast.LENGTH_SHORT).show();
                                    submitTv.setText("已加入");
                                } else {
                                    Toast.makeText(App.activity, "已关注~", Toast.LENGTH_SHORT).show();
                                    submitTv.setText("已关注");
                                }
                                data.get(position).setFollowNum(data.get(position).getFollowNum() + 1);
                                guanList.put(position, data.get(position));
                                submitTv.setBackgroundResource(R.drawable.banqu_guanzhu_after);
                            } else if (code == 1001) {
                                if (weizhi == 2) {
                                    Toast.makeText(App.activity, "已退出本圈~", Toast.LENGTH_SHORT).show();
                                    submitTv.setText("加入");
                                } else {
                                    Toast.makeText(App.activity, "已取消关注~", Toast.LENGTH_SHORT).show();
                                    submitTv.setText("关注");
                                }
                                guanList.remove(position);
                                data.get(position).setFollowNum(data.get(position).getFollowNum() - 1);
                                submitTv.setBackgroundResource(R.drawable.banqu_guanzhu_befor);
                            }
                            numTv.setText("关注：" + data.get(position).getFollowNum());
                            dialog.dismiss();
                        }

                        @Override
                        public void onError(String errorMsg) {
                            Toast.makeText(App.activity, errorMsg, Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void notNet(String netData) {
                            Toast.makeText(App.activity, netData, Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onErrorParams(String errorParams) {
                            Toast.makeText(App.activity, errorParams, Toast.LENGTH_SHORT).show();

                        }
                    }, BanquGuanBean.class);
                }
            });


            titleTv.setText(info.getBoardName());
            Glide.with(App.activity)
                    .load(info.getIcon())
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(R.drawable.shape_image_zhanwei)
                    .into(imageView);
            numTv.setText("关注：" + info.getFollowNum());

            return convertView;
        }
    }


    private String creatParamsLike() {
        JSONObject jo = new JSONObject();
        try {
            jo.put("siteID", 2422);
            jo.put("userName", "");
            jo.put("pageIndex", 1);
            jo.put("pageSize", 10);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        final String params = LinuxUtils.createnewsParam(
                Urls.BANQUGUESS, jo);
        return params;
    }

    private String creatParams(int type) {
        JSONObject jo = new JSONObject();
        try {
            jo.put("siteId", 2422);
            jo.put("type", type);
            jo.put("pageIndex", 1);
            jo.put("pageSize", 50);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String params = LinuxUtils.createnewsParam(
                Urls.BANQUALL, jo);
        return params;
    }

    private String creatParamsGuan(int ID) {
        JSONObject jo = new JSONObject();
        try {
            jo.put("siteID", 2422);
            jo.put("usiteID", 2422);
            jo.put("userName", "sid090950350418930");
            jo.put("boardID", ID);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String params = LinuxUtils.createnewsParam(
                Urls.BANQUGUAN, jo);
        return params;
    }
}
