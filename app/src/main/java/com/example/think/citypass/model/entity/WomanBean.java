package com.example.think.citypass.model.entity;

import java.util.List;

/**
 * Created by think on 2017/6/2.
 */
//女人缘
public class WomanBean {

    /**
     * MessageList : {"code":1000,"message":"Success"}
     * ServerInfo : {"CoverXinShangInfoListTop3":{"CoverXinShangInfoListTop3":[{"Number":1,"UserID":15625208,"nick":"雷锋","userface":"http://r9.pccoo.cn/weixin/20170516/2017051618493781722346_960_1280_150x150(s).jpg","positionName":"职业不明","address":"延庆县孟庄村大队部一号","Age":"38","LikeTotal":"1"},{"Number":2,"UserID":16431661,"nick":"够狠才男人","userface":"http://r3.pccoo.cn/weixin/20151112/2015111217274239508554_150x150(s).jpg","positionName":"职业不明","address":"北京延庆八达岭","Age":"28","LikeTotal":"1"},{"Number":3,"UserID":21258296,"nick":"恩智","userface":"http://r9.pccoo.cn/weixin/20161025/2016102501344245870054_638_640_150x150(s).jpg","positionName":"职业不明","address":"西龙湾","Age":"27","LikeTotal":"1"}],"Count":3},"CoverXinShangInfoList":{"CoverXinShangInfoList":[{"Number":4,"UserID":24447405,"nick":"魂魂","userface":"http://wx.qlogo.cn/mmopen/omtgJqX5wNnsq2VZ3c1pnSk6Zp4HWia5Ald4GGetToHmoYSbuAdCeWftLCtS5XTS6mGTPokbllmxB1Ft2CIBklacRtZaicvy7s/0","positionName":"消防","address":"北京延庆县","Age":"3","LikeTotal":"1"},{"Number":5,"UserID":28768361,"nick":"泽生","userface":"http://r9.pccoo.cn/webapp/20170513/2017051311131941730706_720_960_150x150(s).jpg","positionName":"职业不明","address":"啦啦","Age":"38","LikeTotal":"1"},{"Number":6,"UserID":28809809,"nick":"现实太美，美不过虚伪","userface":"http://q.qlogo.cn/qqapp/1102147502/F27A97F61DE24FF454EDABEE04DECBF8/100","positionName":"职业不明","address":"北京吉利大学","Age":"38","LikeTotal":"1"},{"Number":7,"UserID":28833985,"nick":"忘记了拥抱","userface":"http://r9.pccoo.cn/app_avatar/20170509/2017050911243455585437_780_780_150x150(s).jpg","positionName":"职业不明","address":"北京吉利大学","Age":"25","LikeTotal":"1"}],"Count":7},"CurrMyRankStr":""}
     * Extend : null
     * Count : 0
     * GxNum : 0
     * PageNum : 0
     * retime : 0.0839844
     */

    private MessageListBean MessageList;
    private ServerInfoBean ServerInfo;
    private Object Extend;
    private int Count;
    private int GxNum;
    private int PageNum;
    private double retime;

    public MessageListBean getMessageList() {
        return MessageList;
    }

    public void setMessageList(MessageListBean MessageList) {
        this.MessageList = MessageList;
    }

    public ServerInfoBean getServerInfo() {
        return ServerInfo;
    }

    public void setServerInfo(ServerInfoBean ServerInfo) {
        this.ServerInfo = ServerInfo;
    }

    public Object getExtend() {
        return Extend;
    }

    public void setExtend(Object Extend) {
        this.Extend = Extend;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int Count) {
        this.Count = Count;
    }

    public int getGxNum() {
        return GxNum;
    }

    public void setGxNum(int GxNum) {
        this.GxNum = GxNum;
    }

    public int getPageNum() {
        return PageNum;
    }

    public void setPageNum(int PageNum) {
        this.PageNum = PageNum;
    }

    public double getRetime() {
        return retime;
    }

    public void setRetime(double retime) {
        this.retime = retime;
    }

    public static class MessageListBean {
        /**
         * code : 1000
         * message : Success
         */

        private int code;
        private String message;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    public static class ServerInfoBean {
        /**
         * CoverXinShangInfoListTop3 : {"CoverXinShangInfoListTop3":[{"Number":1,"UserID":15625208,"nick":"雷锋","userface":"http://r9.pccoo.cn/weixin/20170516/2017051618493781722346_960_1280_150x150(s).jpg","positionName":"职业不明","address":"延庆县孟庄村大队部一号","Age":"38","LikeTotal":"1"},{"Number":2,"UserID":16431661,"nick":"够狠才男人","userface":"http://r3.pccoo.cn/weixin/20151112/2015111217274239508554_150x150(s).jpg","positionName":"职业不明","address":"北京延庆八达岭","Age":"28","LikeTotal":"1"},{"Number":3,"UserID":21258296,"nick":"恩智","userface":"http://r9.pccoo.cn/weixin/20161025/2016102501344245870054_638_640_150x150(s).jpg","positionName":"职业不明","address":"西龙湾","Age":"27","LikeTotal":"1"}],"Count":3}
         * CoverXinShangInfoList : {"CoverXinShangInfoList":[{"Number":4,"UserID":24447405,"nick":"魂魂","userface":"http://wx.qlogo.cn/mmopen/omtgJqX5wNnsq2VZ3c1pnSk6Zp4HWia5Ald4GGetToHmoYSbuAdCeWftLCtS5XTS6mGTPokbllmxB1Ft2CIBklacRtZaicvy7s/0","positionName":"消防","address":"北京延庆县","Age":"3","LikeTotal":"1"},{"Number":5,"UserID":28768361,"nick":"泽生","userface":"http://r9.pccoo.cn/webapp/20170513/2017051311131941730706_720_960_150x150(s).jpg","positionName":"职业不明","address":"啦啦","Age":"38","LikeTotal":"1"},{"Number":6,"UserID":28809809,"nick":"现实太美，美不过虚伪","userface":"http://q.qlogo.cn/qqapp/1102147502/F27A97F61DE24FF454EDABEE04DECBF8/100","positionName":"职业不明","address":"北京吉利大学","Age":"38","LikeTotal":"1"},{"Number":7,"UserID":28833985,"nick":"忘记了拥抱","userface":"http://r9.pccoo.cn/app_avatar/20170509/2017050911243455585437_780_780_150x150(s).jpg","positionName":"职业不明","address":"北京吉利大学","Age":"25","LikeTotal":"1"}],"Count":7}
         * CurrMyRankStr :
         */

        private CoverXinShangInfoListTop3BeanX CoverXinShangInfoListTop3;
        private CoverXinShangInfoListBeanX CoverXinShangInfoList;
        private String CurrMyRankStr;

        public CoverXinShangInfoListTop3BeanX getCoverXinShangInfoListTop3() {
            return CoverXinShangInfoListTop3;
        }

        public void setCoverXinShangInfoListTop3(CoverXinShangInfoListTop3BeanX CoverXinShangInfoListTop3) {
            this.CoverXinShangInfoListTop3 = CoverXinShangInfoListTop3;
        }

        public CoverXinShangInfoListBeanX getCoverXinShangInfoList() {
            return CoverXinShangInfoList;
        }

        public void setCoverXinShangInfoList(CoverXinShangInfoListBeanX CoverXinShangInfoList) {
            this.CoverXinShangInfoList = CoverXinShangInfoList;
        }

        public String getCurrMyRankStr() {
            return CurrMyRankStr;
        }

        public void setCurrMyRankStr(String CurrMyRankStr) {
            this.CurrMyRankStr = CurrMyRankStr;
        }

        public static class CoverXinShangInfoListTop3BeanX {
            /**
             * CoverXinShangInfoListTop3 : [{"Number":1,"UserID":15625208,"nick":"雷锋","userface":"http://r9.pccoo.cn/weixin/20170516/2017051618493781722346_960_1280_150x150(s).jpg","positionName":"职业不明","address":"延庆县孟庄村大队部一号","Age":"38","LikeTotal":"1"},{"Number":2,"UserID":16431661,"nick":"够狠才男人","userface":"http://r3.pccoo.cn/weixin/20151112/2015111217274239508554_150x150(s).jpg","positionName":"职业不明","address":"北京延庆八达岭","Age":"28","LikeTotal":"1"},{"Number":3,"UserID":21258296,"nick":"恩智","userface":"http://r9.pccoo.cn/weixin/20161025/2016102501344245870054_638_640_150x150(s).jpg","positionName":"职业不明","address":"西龙湾","Age":"27","LikeTotal":"1"}]
             * Count : 3
             */

            private int Count;
            private List<CoverXinShangInfoListTop3Bean> CoverXinShangInfoListTop3;

            public int getCount() {
                return Count;
            }

            public void setCount(int Count) {
                this.Count = Count;
            }

            public List<CoverXinShangInfoListTop3Bean> getCoverXinShangInfoListTop3() {
                return CoverXinShangInfoListTop3;
            }

            public void setCoverXinShangInfoListTop3(List<CoverXinShangInfoListTop3Bean> CoverXinShangInfoListTop3) {
                this.CoverXinShangInfoListTop3 = CoverXinShangInfoListTop3;
            }

            public static class CoverXinShangInfoListTop3Bean {
                /**
                 * Number : 1
                 * UserID : 15625208
                 * nick : 雷锋
                 * userface : http://r9.pccoo.cn/weixin/20170516/2017051618493781722346_960_1280_150x150(s).jpg
                 * positionName : 职业不明
                 * address : 延庆县孟庄村大队部一号
                 * Age : 38
                 * LikeTotal : 1
                 */

                private int Number;
                private int UserID;
                private String nick;
                private String userface;
                private String positionName;
                private String address;
                private String Age;
                private String LikeTotal;

                public int getNumber() {
                    return Number;
                }

                public void setNumber(int Number) {
                    this.Number = Number;
                }

                public int getUserID() {
                    return UserID;
                }

                public void setUserID(int UserID) {
                    this.UserID = UserID;
                }

                public String getNick() {
                    return nick;
                }

                public void setNick(String nick) {
                    this.nick = nick;
                }

                public String getUserface() {
                    return userface;
                }

                public void setUserface(String userface) {
                    this.userface = userface;
                }

                public String getPositionName() {
                    return positionName;
                }

                public void setPositionName(String positionName) {
                    this.positionName = positionName;
                }

                public String getAddress() {
                    return address;
                }

                public void setAddress(String address) {
                    this.address = address;
                }

                public String getAge() {
                    return Age;
                }

                public void setAge(String Age) {
                    this.Age = Age;
                }

                public String getLikeTotal() {
                    return LikeTotal;
                }

                public void setLikeTotal(String LikeTotal) {
                    this.LikeTotal = LikeTotal;
                }
            }
        }

        public static class CoverXinShangInfoListBeanX {
            /**
             * CoverXinShangInfoList : [{"Number":4,"UserID":24447405,"nick":"魂魂","userface":"http://wx.qlogo.cn/mmopen/omtgJqX5wNnsq2VZ3c1pnSk6Zp4HWia5Ald4GGetToHmoYSbuAdCeWftLCtS5XTS6mGTPokbllmxB1Ft2CIBklacRtZaicvy7s/0","positionName":"消防","address":"北京延庆县","Age":"3","LikeTotal":"1"},{"Number":5,"UserID":28768361,"nick":"泽生","userface":"http://r9.pccoo.cn/webapp/20170513/2017051311131941730706_720_960_150x150(s).jpg","positionName":"职业不明","address":"啦啦","Age":"38","LikeTotal":"1"},{"Number":6,"UserID":28809809,"nick":"现实太美，美不过虚伪","userface":"http://q.qlogo.cn/qqapp/1102147502/F27A97F61DE24FF454EDABEE04DECBF8/100","positionName":"职业不明","address":"北京吉利大学","Age":"38","LikeTotal":"1"},{"Number":7,"UserID":28833985,"nick":"忘记了拥抱","userface":"http://r9.pccoo.cn/app_avatar/20170509/2017050911243455585437_780_780_150x150(s).jpg","positionName":"职业不明","address":"北京吉利大学","Age":"25","LikeTotal":"1"}]
             * Count : 7
             */

            private int Count;
            private List<CoverXinShangInfoListBean> CoverXinShangInfoList;

            public int getCount() {
                return Count;
            }

            public void setCount(int Count) {
                this.Count = Count;
            }

            public List<CoverXinShangInfoListBean> getCoverXinShangInfoList() {
                return CoverXinShangInfoList;
            }

            public void setCoverXinShangInfoList(List<CoverXinShangInfoListBean> CoverXinShangInfoList) {
                this.CoverXinShangInfoList = CoverXinShangInfoList;
            }

            public static class CoverXinShangInfoListBean {
                /**
                 * Number : 4
                 * UserID : 24447405
                 * nick : 魂魂
                 * userface : http://wx.qlogo.cn/mmopen/omtgJqX5wNnsq2VZ3c1pnSk6Zp4HWia5Ald4GGetToHmoYSbuAdCeWftLCtS5XTS6mGTPokbllmxB1Ft2CIBklacRtZaicvy7s/0
                 * positionName : 消防
                 * address : 北京延庆县
                 * Age : 3
                 * LikeTotal : 1
                 */

                private int Number;
                private int UserID;
                private String nick;
                private String userface;
                private String positionName;
                private String address;
                private String Age;
                private String LikeTotal;

                public int getNumber() {
                    return Number;
                }

                public void setNumber(int Number) {
                    this.Number = Number;
                }

                public int getUserID() {
                    return UserID;
                }

                public void setUserID(int UserID) {
                    this.UserID = UserID;
                }

                public String getNick() {
                    return nick;
                }

                public void setNick(String nick) {
                    this.nick = nick;
                }

                public String getUserface() {
                    return userface;
                }

                public void setUserface(String userface) {
                    this.userface = userface;
                }

                public String getPositionName() {
                    return positionName;
                }

                public void setPositionName(String positionName) {
                    this.positionName = positionName;
                }

                public String getAddress() {
                    return address;
                }

                public void setAddress(String address) {
                    this.address = address;
                }

                public String getAge() {
                    return Age;
                }

                public void setAge(String Age) {
                    this.Age = Age;
                }

                public String getLikeTotal() {
                    return LikeTotal;
                }

                public void setLikeTotal(String LikeTotal) {
                    this.LikeTotal = LikeTotal;
                }
            }
        }
    }
}
