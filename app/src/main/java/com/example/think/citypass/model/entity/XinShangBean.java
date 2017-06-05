package com.example.think.citypass.model.entity;

import java.util.List;

/**
 * Created by think on 2017/6/5.
 */

public class XinShangBean {

    /**
     * MessageList : {"code":1000,"message":"Success"}
     * ServerInfo : {"CoverXinShangInfoListTop3":{"CoverXinShangInfoListTop3":[{"Number":"1","UserID":"28998068","LikeTotal":"9","nick":"︶ㄣ冷煙～潕","Age":"38","positionName":"职业不明","address":"北京吉利大学","userface":"http://q.qlogo.cn/qqapp/1102147502/4FF2E8600C0C7566A3BC3F43147362BF/100","Sex":"男"},{"Number":"2","UserID":"30095931","LikeTotal":"9","nick":"电灯泡","Age":"28","positionName":"销售","address":"石河营东社区","userface":"http://r5.pccoo.cn/weixin/20170602/2017060215564589996060_150x150(s).jpg","Sex":"男"},{"Number":"3","UserID":"28779185","LikeTotal":"2","nick":"【陪你看星星】。。。","Age":"38","positionName":"职业不明","address":"北京昌平","userface":"http://q.qlogo.cn/qqapp/1102147502/53542B1EB4DC01DB456B9B7C25D27EF4/100","Sex":"男"}],"Count":3},"CoverXinShangInfoList":{"CoverXinShangInfoList":[{"Number":4,"UserID":"28809809","LikeTotal":"2","nick":"现实太美，美不过虚伪","Age":"38","positionName":"职业不明","address":"北京吉利大学","userface":"http://q.qlogo.cn/qqapp/1102147502/F27A97F61DE24FF454EDABEE04DECBF8/100","Sex":"男"},{"Number":5,"UserID":"21968055","LikeTotal":"1","nick":"思念","Age":"29","positionName":"职业不明","address":"石河营","userface":"http://r5.pccoo.cn/weixin/20161129/2016112921583186611349_150x150(s).jpg","Sex":"女"},{"Number":6,"UserID":"28833985","LikeTotal":"1","nick":"忘记了拥抱","Age":"25","positionName":"职业不明","address":"北京吉利大学","userface":"http://r9.pccoo.cn/app_avatar/20170509/2017050911243455585437_780_780_150x150(s).jpg","Sex":"男"},{"Number":7,"UserID":"28834015","LikeTotal":"1","nick":"。。","Age":"38","positionName":"职业不明","address":"北京吉利大学","userface":"http://q.qlogo.cn/qqapp/1102147502/DB073E985AB7863527137A64611FEDD8/100","Sex":"男"},{"Number":8,"UserID":"29874489","LikeTotal":"1","nick":"小伟","Age":"31","positionName":"职业不明","address":"新兴西社区","userface":"http://r5.pccoo.cn/weixin/20170529/2017052907381727330621_150x150(s).jpg","Sex":"男"}],"Count":8},"CurrMyRankStr":""}
     * Extend : null
     * Count : 0
     * GxNum : 0
     * PageNum : 0
     * retime : 0.4150391
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
         * CoverXinShangInfoListTop3 : {"CoverXinShangInfoListTop3":[{"Number":"1","UserID":"28998068","LikeTotal":"9","nick":"︶ㄣ冷煙～潕","Age":"38","positionName":"职业不明","address":"北京吉利大学","userface":"http://q.qlogo.cn/qqapp/1102147502/4FF2E8600C0C7566A3BC3F43147362BF/100","Sex":"男"},{"Number":"2","UserID":"30095931","LikeTotal":"9","nick":"电灯泡","Age":"28","positionName":"销售","address":"石河营东社区","userface":"http://r5.pccoo.cn/weixin/20170602/2017060215564589996060_150x150(s).jpg","Sex":"男"},{"Number":"3","UserID":"28779185","LikeTotal":"2","nick":"【陪你看星星】。。。","Age":"38","positionName":"职业不明","address":"北京昌平","userface":"http://q.qlogo.cn/qqapp/1102147502/53542B1EB4DC01DB456B9B7C25D27EF4/100","Sex":"男"}],"Count":3}
         * CoverXinShangInfoList : {"CoverXinShangInfoList":[{"Number":4,"UserID":"28809809","LikeTotal":"2","nick":"现实太美，美不过虚伪","Age":"38","positionName":"职业不明","address":"北京吉利大学","userface":"http://q.qlogo.cn/qqapp/1102147502/F27A97F61DE24FF454EDABEE04DECBF8/100","Sex":"男"},{"Number":5,"UserID":"21968055","LikeTotal":"1","nick":"思念","Age":"29","positionName":"职业不明","address":"石河营","userface":"http://r5.pccoo.cn/weixin/20161129/2016112921583186611349_150x150(s).jpg","Sex":"女"},{"Number":6,"UserID":"28833985","LikeTotal":"1","nick":"忘记了拥抱","Age":"25","positionName":"职业不明","address":"北京吉利大学","userface":"http://r9.pccoo.cn/app_avatar/20170509/2017050911243455585437_780_780_150x150(s).jpg","Sex":"男"},{"Number":7,"UserID":"28834015","LikeTotal":"1","nick":"。。","Age":"38","positionName":"职业不明","address":"北京吉利大学","userface":"http://q.qlogo.cn/qqapp/1102147502/DB073E985AB7863527137A64611FEDD8/100","Sex":"男"},{"Number":8,"UserID":"29874489","LikeTotal":"1","nick":"小伟","Age":"31","positionName":"职业不明","address":"新兴西社区","userface":"http://r5.pccoo.cn/weixin/20170529/2017052907381727330621_150x150(s).jpg","Sex":"男"}],"Count":8}
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
             * CoverXinShangInfoListTop3 : [{"Number":"1","UserID":"28998068","LikeTotal":"9","nick":"︶ㄣ冷煙～潕","Age":"38","positionName":"职业不明","address":"北京吉利大学","userface":"http://q.qlogo.cn/qqapp/1102147502/4FF2E8600C0C7566A3BC3F43147362BF/100","Sex":"男"},{"Number":"2","UserID":"30095931","LikeTotal":"9","nick":"电灯泡","Age":"28","positionName":"销售","address":"石河营东社区","userface":"http://r5.pccoo.cn/weixin/20170602/2017060215564589996060_150x150(s).jpg","Sex":"男"},{"Number":"3","UserID":"28779185","LikeTotal":"2","nick":"【陪你看星星】。。。","Age":"38","positionName":"职业不明","address":"北京昌平","userface":"http://q.qlogo.cn/qqapp/1102147502/53542B1EB4DC01DB456B9B7C25D27EF4/100","Sex":"男"}]
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
                 * UserID : 28998068
                 * LikeTotal : 9
                 * nick : ︶ㄣ冷煙～潕
                 * Age : 38
                 * positionName : 职业不明
                 * address : 北京吉利大学
                 * userface : http://q.qlogo.cn/qqapp/1102147502/4FF2E8600C0C7566A3BC3F43147362BF/100
                 * Sex : 男
                 */

                private String Number;
                private String UserID;
                private String LikeTotal;
                private String nick;
                private String Age;
                private String positionName;
                private String address;
                private String userface;
                private String Sex;

                public String getNumber() {
                    return Number;
                }

                public void setNumber(String Number) {
                    this.Number = Number;
                }

                public String getUserID() {
                    return UserID;
                }

                public void setUserID(String UserID) {
                    this.UserID = UserID;
                }

                public String getLikeTotal() {
                    return LikeTotal;
                }

                public void setLikeTotal(String LikeTotal) {
                    this.LikeTotal = LikeTotal;
                }

                public String getNick() {
                    return nick;
                }

                public void setNick(String nick) {
                    this.nick = nick;
                }

                public String getAge() {
                    return Age;
                }

                public void setAge(String Age) {
                    this.Age = Age;
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

                public String getUserface() {
                    return userface;
                }

                public void setUserface(String userface) {
                    this.userface = userface;
                }

                public String getSex() {
                    return Sex;
                }

                public void setSex(String Sex) {
                    this.Sex = Sex;
                }
            }
        }

        public static class CoverXinShangInfoListBeanX {
            /**
             * CoverXinShangInfoList : [{"Number":4,"UserID":"28809809","LikeTotal":"2","nick":"现实太美，美不过虚伪","Age":"38","positionName":"职业不明","address":"北京吉利大学","userface":"http://q.qlogo.cn/qqapp/1102147502/F27A97F61DE24FF454EDABEE04DECBF8/100","Sex":"男"},{"Number":5,"UserID":"21968055","LikeTotal":"1","nick":"思念","Age":"29","positionName":"职业不明","address":"石河营","userface":"http://r5.pccoo.cn/weixin/20161129/2016112921583186611349_150x150(s).jpg","Sex":"女"},{"Number":6,"UserID":"28833985","LikeTotal":"1","nick":"忘记了拥抱","Age":"25","positionName":"职业不明","address":"北京吉利大学","userface":"http://r9.pccoo.cn/app_avatar/20170509/2017050911243455585437_780_780_150x150(s).jpg","Sex":"男"},{"Number":7,"UserID":"28834015","LikeTotal":"1","nick":"。。","Age":"38","positionName":"职业不明","address":"北京吉利大学","userface":"http://q.qlogo.cn/qqapp/1102147502/DB073E985AB7863527137A64611FEDD8/100","Sex":"男"},{"Number":8,"UserID":"29874489","LikeTotal":"1","nick":"小伟","Age":"31","positionName":"职业不明","address":"新兴西社区","userface":"http://r5.pccoo.cn/weixin/20170529/2017052907381727330621_150x150(s).jpg","Sex":"男"}]
             * Count : 8
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
                 * UserID : 28809809
                 * LikeTotal : 2
                 * nick : 现实太美，美不过虚伪
                 * Age : 38
                 * positionName : 职业不明
                 * address : 北京吉利大学
                 * userface : http://q.qlogo.cn/qqapp/1102147502/F27A97F61DE24FF454EDABEE04DECBF8/100
                 * Sex : 男
                 */

                private int Number;
                private String UserID;
                private String LikeTotal;
                private String nick;
                private String Age;
                private String positionName;
                private String address;
                private String userface;
                private String Sex;

                public int getNumber() {
                    return Number;
                }

                public void setNumber(int Number) {
                    this.Number = Number;
                }

                public String getUserID() {
                    return UserID;
                }

                public void setUserID(String UserID) {
                    this.UserID = UserID;
                }

                public String getLikeTotal() {
                    return LikeTotal;
                }

                public void setLikeTotal(String LikeTotal) {
                    this.LikeTotal = LikeTotal;
                }

                public String getNick() {
                    return nick;
                }

                public void setNick(String nick) {
                    this.nick = nick;
                }

                public String getAge() {
                    return Age;
                }

                public void setAge(String Age) {
                    this.Age = Age;
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

                public String getUserface() {
                    return userface;
                }

                public void setUserface(String userface) {
                    this.userface = userface;
                }

                public String getSex() {
                    return Sex;
                }

                public void setSex(String Sex) {
                    this.Sex = Sex;
                }
            }
        }
    }
}
