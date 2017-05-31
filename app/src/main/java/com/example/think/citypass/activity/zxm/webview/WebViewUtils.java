package com.example.think.citypass.activity.zxm.webview;

import android.content.Context;
import android.content.Intent;



/**
 * Created by 韩志军 on 2017/5/22.
 */
/*公用的跳转 webview 工具类*/
public class WebViewUtils {

    private static Intent intent;

    public static Intent urlMethod(Context context, String turnUrl, String title) {
        String url = "http://m.yanqing.ccoo.cn/";
//         intent = new Intent(context, WebViewActivity.class);
        intent.putExtra("title", title);
        if (turnUrl.contains("http")) {
            intent.putExtra("url", turnUrl);
        } else {
            if (turnUrl.startsWith("/")) {
                intent.putExtra("url", url + turnUrl);
            } else {
                intent.putExtra("url", url + "/" + turnUrl);
            }
        }
        if (turnUrl.equals("")) {
            intent = null;
        }
        return intent;
    }

    //目前楼盘用到了
    public static void turnUrl(Context context, String turnUrl, String title) {
         intent = urlMethod(context, turnUrl, title);
        if (intent != null) {
            context.startActivity(intent);

        }
    }


    /**
     * @param channelInfo channelInfo
     * @param type        1为原生 2位网页
     * @param channelUrl  跳转网址
     * @param title       webActivity的title
     * @param context     上下文对象
     */
    public static void getTiaoZ(String channelInfo, int type, String channelUrl, String title, Context context) {

        /*当type ==2 的时候 是在做查询的操作*/
        if (type == 2) {
            String url = "";
            if (channelUrl.contains("http")) {
                url = channelUrl;
            } else {
                if (channelUrl.endsWith("/")) {
                    url = "http://m.yanqing.ccoo.cn/" + channelUrl;
                } else {
                    url = "http://m.yanqing.ccoo.cn/" + channelUrl + "/";
                }
            }

//            intent = new Intent(context, WebViewActivity.class);
            intent.putExtra("url", url);
            intent.putExtra("title", title);
//            LogUtils.e("WebViewUtils", url);
            context.startActivity(intent);

        } else {
        /*channelInfo 类型 "3,2,0,0" 把它进行分裂 判断他的每一个数字*/
        int oneID = -1;
            int twoID = 0;
            int threeID = 0;
            if(channelInfo.contains(",")){
                String[] sum = channelInfo.split(",");
                oneID = Integer.parseInt(sum[0]);/*第一个数字*/
                twoID = Integer.parseInt(sum[1]);/*第二个数字*/
                threeID =Integer.parseInt(sum[2]);/*第三个数字*/
            }


            switch (oneID) {
                case 0:

                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
//                intent = new Intent(context, MeiNvXiuChangActivity.class);
                    intent.putExtra("title", title);
                    intent.putExtra("itemClass", "0");
                    intent.putExtra("itemID", "5");
                    break;
                case 5:/*发现分类信息*/
//                    intent = new Intent(context, WebViewActivity.class);
                    intent.putExtra("title", title);
                    String url = "http://m.yanqing.ccoo.cn";
                    switch (twoID) {
                        case 0://分类首页
                            break;
                        case 1://全职招聘
                            if (threeID == 0) {
                                intent.putExtra("url", url + "/post/job/");
                            } else {

                                intent.putExtra("url", url + "/post/job/jobshow.aspx?id=" + threeID);
                            }
                            break;
                        case 2://兼职招聘
                            if (threeID == 0) {
                                intent.putExtra("url", url + "/post/jianzhi/");
                            } else {
                                intent.putExtra("url", url + "/post/jianzhi/jzshow.aspx?id=" + threeID);
                            }
                            break;
                        case 3://房屋出售
                            if (threeID == 0) {
                                intent.putExtra("url", url+  "/post/fangwu/fc_chushou.aspx");
                            } else {
                                intent.putExtra("url", url + "/post/fangwu/fc_chushou.aspx?id=" + threeID);
                            }
                            break;
                        case 4://房屋出租
                            if (threeID == 0) {
                                intent.putExtra("url", url + "/post/fangwu/fc_chuzu.aspx");
                            } else {
                                intent.putExtra("url", url + "/post/fangwu/fw_showcz.aspx?id=" + threeID);
                            }
                            break;
                        case 5:// 房屋求购
                            if (threeID == 0) {
                                intent.putExtra("url", url + "/post/fangwu/fc_qiugou.aspx");
                            } else {
                                intent.putExtra("url", url + "/post/fangwu/fw_showqg.aspx?id=" + threeID);
                            }
                            break;
                        case 6:// 房屋求租
                            if (threeID == 0) {
                                intent.putExtra("url", url + "/post/fangwu/fc_qiuzu.aspx");
                            } else {
                                intent.putExtra("url", url + "/post/fangwu/fw_showqz.aspx?id=" + threeID);
                            }
                            break;
                        case 7:// 店铺转让
                            if (threeID == 0) {
                                intent.putExtra("url", url + "/post/fangwu/chudui/");
                            } else {
                                intent.putExtra("url", url + "/post/fangwu/chudui/shop_detail.aspx?id=" + threeID);
                            }
                            break;
                        case 8:/*发现二手交易*/
                            if (threeID == 0) {
                                intent.putExtra("url", url + "/post/ershou/ershou_search.aspx");
                            } else {
                                intent.putExtra("url", url + "/post/ershou/ershou_show.aspx?id=" + threeID);
                            }
                            break;
                        case 9:/*发现车辆买卖*/
                            if (threeID == 0) {
                                intent.putExtra("url", url + "/post/cheliang/cheliang_search.aspx");
                            } else {
                                intent.putExtra("url", url + "/post/cheliang/clshow.aspx?id=" + threeID);
                            }
                            break;
                        case 10:/*发现生活服务*/
                            if (threeID == 0) {
                                intent.putExtra("url", url + "/post/shenghuo/live_search.aspx");
                            } else {
                                intent.putExtra("url", url + "/post/shenghuo/shshow.aspx?id=" + threeID);
                            }
                            break;
                        case 11:// 商业机会
                            if (threeID == 0) {
                                intent.putExtra("url", url + "/post/shenghuo/?kindid=10");
                            } else {
                                intent.putExtra("url", url + "/post/shenghuo/shshow.aspx?id=" + threeID);
                            }
                            break;
                        case 12:// 教育培训
                            if (threeID == 0) {
                                intent.putExtra("url", url + "/yp/yp_list.aspx?Leibie=30#1");
                            } else {
                                intent.putExtra("url", url + "/yp/yp_show.aspx?id=" + threeID);
                            }
                            break;
                        case 13:/*发现同城交友*/
                            if (threeID == 0) {
                                intent.putExtra("url", url + "/post/jiaoyou/");
                            } else {
                                intent.putExtra("url", url + "/post/jiaoyou/jyshow.aspx?id=" + threeID);
                            }
                            break;
                        case 14:/*宠物服务*/
                            if (threeID == 0) {
                                intent.putExtra("url", url + "/post/pet/");
                            } else {
                                intent.putExtra("url", url + "/post/pet/cwshow.aspx?id=" + threeID);
                            }
                            break;
                        case 15:/*发现新楼盘*/
                            if (threeID == 0) {
                                intent.putExtra("url", url + "/post/xinloupan/");
                            } else {
                                intent.putExtra("url", url + "/post/xinloupan/lpnew.aspx?id=" + threeID);
                            }
                            break;
                        case 16:/*发现找房子*/
                            intent.putExtra("url", url + "/post/fangwu/");
                            break;
                        case 17:// 分类信息发布页

                            break;
                        case 18:/*发现找工作  招聘*/
                            intent.putExtra("url", url + "/post/zhaopin/#andriod_redirect");
                            break;
                        case 26:// 看房团
                            intent.putExtra("url", url + "/post/xinloupan/kanfangtuan.aspx?id=" + threeID);
                            break;
                        case 30:
                            intent.putExtra("url", url + "/post/qiuzhi/");
                            break;
                        case 35:// 房屋出售详情
                            intent.putExtra("url", url + "/post/fangwu/fw_showcs.aspx?id=" + threeID);
                            break;
                    }
                    break;

                case 6:/*热门推荐  城市币抽奖*/
//                intent.putExtra("url","http://m.yanqing.ccoo.cn/login/?reurl=/yp/user.aspx#andriod_redirect");
                    break;
                case 7:/*发现生活导购*/
//                    intent = new Intent(context, WebViewActivity.class);
                    intent.putExtra("title", title);
                    String urlone = "http://m.yanqing.ccoo.cn";
                    switch (twoID) {
                        case 2:/*家居*/
                            intent.putExtra("url", urlone + "/store/shop/store_list.aspx?Sort=2");
                            break;
                        case 3:/*婚庆*/
                            intent.putExtra("url", urlone + "/store/shop/store_list.aspx?Sort=1");
                            break;
                        case 4:/*汽车*/
                            intent.putExtra("url", urlone + "/store/shop/store_list.aspx?Sort=5");
                            break;
                        case 7:/*亲子*/
                            intent.putExtra("url", urlone + "/store/shop/store_list.aspx?Sort=6");
                            break;
                    }
                    break;
                case 11:/*实用查询*/ /*查电话*/
//                    intent = new Intent(context, WebViewActivity.class);
                    intent.putExtra("title", title);
                    String urltwo = "http://m.yanqing.ccoo.cn";
                    intent.putExtra("url", urltwo + "/tel/");
                    break;
                case 12:/*实用查询*/ /*查黄历*/
//                    intent = new Intent(context, WebViewActivity.class);
                    intent.putExtra("title", title);
                    String urlthree = "http://m.yanqing.ccoo.cn";
                    intent.putExtra("url", urlthree + "/yp/");
                    break;
                default:
                    urlMethod(context,channelUrl,title);
                    break;
            }
            if (intent == null)
                return;
            context.startActivity(intent);
        }
    }

}
