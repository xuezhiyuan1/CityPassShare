package com.example.think.citypass.activity.zzh;

import android.os.Handler;
import android.os.Message;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.think.citypass.App;
import com.example.think.citypass.R;
import com.example.think.citypass.activity.zzh.adapter.PostInfoAdapter;
import com.example.think.citypass.common.base.BaseActivity;
import com.example.think.citypass.common.config.Urls;
import com.example.think.citypass.model.enitity.PostDetailBean;
import com.example.think.citypass.model.http.callback.ResaultCallBack;
import com.example.think.citypass.myview.GifRfreshHeader;
import com.example.think.citypass.myview.MRecyclerView;
import com.example.think.citypass.myview.MyProgressDialog;
import com.example.think.citypass.myview.SquareItemImageView;
import com.example.think.citypass.utils.LinuxUtils;
import com.example.think.citypass.utils.retrofitutils.RetrofitUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by ASUS on 2017/6/2.
 */

public class PostDetailActivity extends BaseActivity {

    private MyProgressDialog dialog;
    private Button backBtn, fatieBtn, shareBtn;
    private LinearLayout loadLL, failureLL, messageLL;
    private MRecyclerView mRecyclerView;
    private ImageView zanIv, otherIv, biaoqingIv, photoIv, aiteIv;
    private EditText ReplyEt;
    private TextView typeTv, numTv, submitTv;

    private int topicId, boardId;
    private String BName, Title;
    private View view;
    private String mapName;
    private List<PostDetailBean.ServerInfoBean.ReplyListBean> data;
    private List<PostDetailBean.ServerInfoBean.ReplyListBean> list;
    private PostInfoAdapter adapter;
    private boolean daoxu = true;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                list.clear();
                list.addAll(data);
                adapter.notifyDataSetChanged();
                dialog.dismiss();
            }
        }
    };

    @Override
    protected int layoutId() {
        return R.layout.post_detail;
    }

    @Override
    protected void initView() {
        backBtn = (Button) findViewById(R.id.post_btn_back);
        fatieBtn = (Button) findViewById(R.id.post_btn_fatie);
        shareBtn = (Button) findViewById(R.id.post_btn_share);
        loadLL = (LinearLayout) findViewById(R.id.ll_loading);
        failureLL = (LinearLayout) findViewById(R.id.failure_layout);
        mRecyclerView = (MRecyclerView) findViewById(R.id.post_list);
        zanIv = (ImageView) findViewById(R.id.post_bottom_zan_imageview);
        otherIv = (ImageView) findViewById(R.id.post_bottom_other_imageview);
        ReplyEt = (EditText) findViewById(R.id.post_bottom_edittext);
        messageLL = (LinearLayout) findViewById(R.id.post_message_layout);
        typeTv = (TextView) findViewById(R.id.post_type_textview);
        numTv = (TextView) findViewById(R.id.post_num_textview);
        submitTv = (TextView) findViewById(R.id.post_bottom_submit);
        biaoqingIv = (ImageView) findViewById(R.id.post_biaoqing_imageview);
        photoIv = (ImageView) findViewById(R.id.post_photo_imageview);
        aiteIv = (ImageView) findViewById(R.id.post_aite_imageview);

    }

    private TextView title, boardName, huitie, name, dengji, time,
            content, addressTv, scan1Tv, daoxuTv, scan1lineTv, scan2Tv, scan2lineTv, scan3Tv, scan3lineTv;
    private ImageView touIv, dashangIv, headZanIv, shareIv;
    private LinearLayout imagesLL, addressLL;

    @Override
    protected void initData() {
        dialog = new MyProgressDialog(App.activity);
        data = new ArrayList<>();
        list = new ArrayList<>();
        topicId = getIntent().getIntExtra("TopicID", 0);
        boardId = getIntent().getIntExtra("BoardID", 0);
        BName = getIntent().getStringExtra("BName");
        Title = getIntent().getStringExtra("Title");
        mapName = getIntent().getStringExtra("MapName");
        view = View.inflate(App.activity, R.layout.post_top_item, null);

        title = (TextView) view.findViewById(R.id.title);
        boardName = (TextView) view.findViewById(R.id.boardname);
        huitie = (TextView) view.findViewById(R.id.huitie);
        touIv = (ImageView) view.findViewById(R.id.image_tou);
        name = (TextView) view.findViewById(R.id.name);
        dengji = (TextView) view.findViewById(R.id.dengji);
        time = (TextView) view.findViewById(R.id.time);
        content = (TextView) view.findViewById(R.id.content);
        imagesLL = (LinearLayout) view.findViewById(R.id.post_images_layout);
        addressLL = (LinearLayout) view.findViewById(R.id.lay_address);
        addressTv = (TextView) view.findViewById(R.id.text_address);
        dashangIv = (ImageView) view.findViewById(R.id.dashang_imageview1);
        headZanIv = (ImageView) view.findViewById(R.id.zan_imageview1);
        shareIv = (ImageView) view.findViewById(R.id.share_imageview1);
        scan1Tv = (TextView) view.findViewById(R.id.scan1_textview);
        daoxuTv = (TextView) view.findViewById(R.id.zuixin_daoxu_tv);
        scan1lineTv = (TextView) view.findViewById(R.id.scan1_line);
        scan2Tv = (TextView) view.findViewById(R.id.scan2_textview);
        scan2lineTv = (TextView) view.findViewById(R.id.scan2_line);
        scan3Tv = (TextView) view.findViewById(R.id.scan3_textview);
        scan3lineTv = (TextView) view.findViewById(R.id.scan3_line);
        GifRfreshHeader gifRfreshHeader = new GifRfreshHeader(App.activity);
        gifRfreshHeader.setVisibility();
        mRecyclerView.setRefreshHeader(gifRfreshHeader);
        mRecyclerView.addHeaderView(view);
        adapter = new PostInfoAdapter(data);
        setAdapter(1, adapter);
    }


    @Override
    protected void initListener() {
        mRecyclerView.setLoadingListener(new MRecyclerView.LoadingListener() {

            @Override
            public void onRvScrolled(int dx, int dy) {
            }

            @Override
            public void onRefresh() {
                mRecyclerView.refreshCompleteTwo();
            }

            @Override
            public void onLoadMore() {
            }
        });
        failureLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                failureLL.setVisibility(View.GONE);
                loadLL.setVisibility(View.VISIBLE);
                RetrofitUtil.getInstance().postRetrofitTwo(createParams(), callBack, PostDetailBean.class);
            }
        });
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        scan1Tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (data.size() == 0) {
                    if (list.size() == 0) {
                        mRecyclerView.setFootViewText("", "没有任何回帖 回复抢沙发~");
                    } else {
                        data.addAll(list);
                        adapter.notifyDataSetChanged();
                        mRecyclerView.setFootViewText("", "没有更多内容啦~");
                    }
                    mRecyclerView.setNoMore(true);
                    scan1Tv.setTextColor(ContextCompat.getColor(App.activity, R.color.red_text));
                    scan2Tv.setTextColor(ContextCompat.getColor(App.activity, R.color.color_333));
                    scan3Tv.setTextColor(ContextCompat.getColor(App.activity, R.color.color_333));
                    scan1lineTv.setBackgroundResource(R.color.red_text);
                    scan2lineTv.setBackgroundResource(R.color.transparent);
                    scan3lineTv.setBackgroundResource(R.color.transparent);
                }
            }
        });
        scan2Tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.clear();
                adapter.notifyDataSetChanged();
                scan2Tv.setTextColor(ContextCompat.getColor(App.activity, R.color.red_text));
                scan1Tv.setTextColor(ContextCompat.getColor(App.activity, R.color.color_333));
                scan3Tv.setTextColor(ContextCompat.getColor(App.activity, R.color.color_333));
                scan2lineTv.setBackgroundResource(R.color.red_text);
                scan1lineTv.setBackgroundResource(R.color.transparent);
                scan3lineTv.setBackgroundResource(R.color.transparent);
                mRecyclerView.setFootViewText("", "还没有大咖参与回复~");
                mRecyclerView.setNoMore(true);
            }
        });
        scan3Tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.clear();
                adapter.notifyDataSetChanged();
                scan3Tv.setTextColor(ContextCompat.getColor(App.activity, R.color.red_text));
                scan1Tv.setTextColor(ContextCompat.getColor(App.activity, R.color.color_333));
                scan2Tv.setTextColor(ContextCompat.getColor(App.activity, R.color.color_333));
                scan3lineTv.setBackgroundResource(R.color.red_text);
                scan1lineTv.setBackgroundResource(R.color.transparent);
                scan2lineTv.setBackgroundResource(R.color.transparent);
                mRecyclerView.setFootViewText("", "暂未收到任何打赏~");
                mRecyclerView.setNoMore(true);
            }
        });
        daoxuTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (data.size() > 0) {
                    if (daoxu) {
                        daoxuTv.setBackgroundResource(R.drawable.ccoo_icon_daoxu_press);
                        daoxu = false;
                    } else {
                        daoxuTv.setBackgroundResource(R.drawable.ccoo_icon_daoxut_noral);
                        daoxu = true;
                    }
                    dialog.show();
                    Collections.reverse(data);
                    handler.sendEmptyMessageDelayed(1, 1000);
                }
            }
        });
        ReplyEt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messageLL.setVisibility(View.GONE);
            }
        });
    }

    @Override
    protected void loadData() {
        mRecyclerView.setNoMore(true);
        RetrofitUtil.getInstance().postRetrofitTwo(createParams(), callBack, PostDetailBean.class);
    }

    public void showNormal() {
        failureLL.setVisibility(View.GONE);
        loadLL.setVisibility(View.GONE);
    }

    public void setAdapter(int type, RecyclerView.Adapter adapter) {
        adapter.setHasStableIds(true);
        mRecyclerView.setHasFixedSize(true);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(type, StaggeredGridLayoutManager.VERTICAL);
        staggeredGridLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        mRecyclerView.setLayoutManager(staggeredGridLayoutManager);
        mRecyclerView.setAdapter(adapter);
    }


    private ResaultCallBack callBack = new ResaultCallBack() {
        @Override
        public void onSuccess(Object obj) {
            showNormal();
            title.setText(Title);
            boardName.setText(BName);
            if ("".equals(mapName)) {
                addressLL.setVisibility(View.GONE);
            } else {
                addressTv.setText(mapName);
            }
            PostDetailBean postDetailBean = (PostDetailBean) obj;
            PostDetailBean.ServerInfoBean serverInfo = postDetailBean.getServerInfo();
            if (serverInfo != null) {
                PostDetailBean.ServerInfoBean.TopicInfoBean topicInfo = serverInfo.getTopicInfo();
                huitie.setText(String.valueOf(topicInfo.getHits()));
                Glide.with(App.activity)
                        .load(topicInfo.getRoleImg())
                        .placeholder(R.drawable.shape_image_zhanwei)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(touIv);
                name.setText(topicInfo.getRole());
                dengji.setText("Lv." + topicInfo.getLevel());
                time.setText(topicInfo.getAddtime().substring(5));
                String contentText = getContent(topicInfo.getTbody());
                content.setText(contentText);
                String image = getImages(topicInfo.getTbody());
                if ("".equals(image)) {
                    imagesLL.setVisibility(View.GONE);
                } else {
                    imagesLL.setVisibility(View.VISIBLE);
                    String[] images = image.split(",");
                    for (int i = 0; i < images.length; i++) {
                        View view = View.inflate(App.activity, R.layout.post_detail_image, null);
                        SquareItemImageView imageView = (SquareItemImageView) view.findViewById(R.id.post_image);
                        Glide.with(App.activity)
                                .load(images[i])
                                .diskCacheStrategy(DiskCacheStrategy.ALL)
                                .into(imageView);
                        imageView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(PostDetailActivity.this, "点击图片", Toast.LENGTH_SHORT).show();
                            }
                        });
                        imagesLL.addView(view);
                    }
                }
                List<PostDetailBean.ServerInfoBean.ReplyListBean> replyList = serverInfo.getReplyList();
                if (replyList != null && replyList.size() > 0) {
                    list.addAll(replyList);
                    data.addAll(replyList);
                    adapter.notifyDataSetChanged();
                    mRecyclerView.setFootViewText("", "没有更多内容啦~");
                } else {
                    mRecyclerView.setFootViewText("", "没有任何回帖 回复抢沙发");
                }
                mRecyclerView.setNoMore(true);
                switch (data.size()) {
                    case 0:
                        typeTv.setText("抢沙发");
                        numTv.setText(String.valueOf(data.size()));
                        break;
                    case 1:
                        typeTv.setText("抢板凳");
                        numTv.setText(String.valueOf(data.size()));
                        break;
                    case 2:
                        typeTv.setText("抢马扎");
                        numTv.setText(String.valueOf(data.size()));
                        break;
                    default:
                        if (data.size() > 2) {
                            typeTv.setText("抢回复");
                            numTv.setText(String.valueOf(data.size()));
                        }

                        break;
                }
            }
        }

        @Override
        public void onError(String errorMsg) {
            Toast.makeText(PostDetailActivity.this, errorMsg, Toast.LENGTH_SHORT).show();
            loadLL.setVisibility(View.GONE);
            failureLL.setVisibility(View.VISIBLE);
        }

        @Override
        public void notNet(String netData) {
            Toast.makeText(PostDetailActivity.this, netData, Toast.LENGTH_SHORT).show();
            loadLL.setVisibility(View.GONE);
            failureLL.setVisibility(View.VISIBLE);
        }

        @Override
        public void onErrorParams(String errorParams) {
            Toast.makeText(PostDetailActivity.this, errorParams, Toast.LENGTH_SHORT).show();
            loadLL.setVisibility(View.GONE);
            failureLL.setVisibility(View.VISIBLE);
        }
    };

    private String createParams() {
        JSONObject jo = new JSONObject();

        try {
            jo.put("siteID", 2422);
            jo.put("topicID", topicId);
            jo.put("userName", "");
            jo.put("sourceType", 0);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String params = LinuxUtils.createnewsParam(Urls.POSTINFO, jo);
        return params;
    }

    private String getImages(String content) {
        String[] ss = content.split("\\[img\\]");
        if (ss.length > 1) {
            String ssss = "";
            for (int i = 1; i < ss.length; i++) {
                ssss = ssss + ss[i].split("\\[/img\\]")[0] + ",";
            }
            return ssss;
        } else {
            return "";
        }
    }

    private String getContent(String content) {
        String[] ss1 = content.split("\\[img\\]");
        String[] ss = ss1[0].split(":");
        if (ss.length > 1) {
            String s1 = ss[1];
            String s2 = ss[2];
            String time = ss[0] + ":" + s1.substring(0, s1.indexOf("事"));
            String address = s1.substring(s1.indexOf("事")) + ":"
                    + s2.substring(0, s2.indexOf("事"));
            String detail = s2.substring(s2.indexOf("事")) + ":";
            String s4 = "";
            if (ss.length > 4) {
                for (int i = 3; i < ss.length; i++) {
                    s4 = s4 + (ss[i] + ":");
                    if (i == ss.length - 1) {
                        s4 = s4 + ss[i];
                    }
                }
            } else {
                s4 = ss[3];
            }
            String content1 = time + "\r\n" + address + "\r\n" + detail + "\r\n" + s4;
            return content1;
        } else {
            return ss[0];
        }
    }

}
