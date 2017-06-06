package com.example.think.citypass.model.entity;

import java.util.List;

/**
 * Created by think on 2017/6/6.
 */

public class ZuiXinBean {

    /**
     * MessageList : {"code":1000,"message":"Success"}
     * ServerInfo : {"NewTCoverInfoList":{"NewTCoverInfoList":[{"Id":"742652","UserID":"25250139","Photo":"http://r9.pccoo.cn/weixin/20170211/2017021110152550141341_720_1280_500x300(w).jpg","MapName":"来自金星","tName":"","nick":"那年╮莪笑靥如花","positionName":"28岁","CreateTime":"2017-6-2 22:33:57","LikeTotal":"3","isDZ":0},{"Id":"799747","UserID":"28818056","Photo":"http://r9.pccoo.cn/weixin/20170508/2017050822335769712069_960_1280_500x300(w).jpg","MapName":"来自金星","tName":"","nick":"奶糖嘟嘟 (☆_☆)","positionName":"28岁","CreateTime":"2017-6-2 22:31:53","LikeTotal":"1","isDZ":0},{"Id":"815109","UserID":"29946738","Photo":"http://r9.pccoo.cn/weixin/20170531/2017053107044197831198_960_1280_500x300(w).jpg","MapName":"朝阳区,湖光中街辅路","tName":"","nick":"花开花落","positionName":"38岁","CreateTime":"2017-5-31 7:05:05","LikeTotal":"0","isDZ":0},{"Id":"742658","UserID":"20139576","Photo":"http://r9.pccoo.cn/weixin/20170211/2017021110455114945597_721_1280_500x300(w).jpg","MapName":"来自金星","tName":"","nick":"司大仙","positionName":"28岁","CreateTime":"2017-5-30 21:46:01","LikeTotal":"2","isDZ":0},{"Id":"768515","UserID":"22052933","Photo":"http://r9.pccoo.cn/weixin/20170324/2017032400590412394911_720_1280_500x300(w).jpg","MapName":"来自金星","tName":"","nick":"。阿娇  。","positionName":"28岁","CreateTime":"2017-5-29 7:52:05","LikeTotal":"2","isDZ":0},{"Id":"811921","UserID":"24746951","Photo":"http://r9.pccoo.cn/weixin/20170525/2017052515103423305603_708_1052_500x300(w).jpg","MapName":"来自金星","tName":"","nick":"宝贝我爱你","positionName":"28岁","CreateTime":"2017-5-25 15:10:29","LikeTotal":"0","isDZ":0},{"Id":"805409","UserID":"13046209","Photo":"http://r9.pccoo.cn/weixin/20170516/2017051622404734414192_960_1280_500x300(w).jpg","MapName":"来自金星","tName":"","nick":"呼噜路","positionName":"28岁","CreateTime":"2017-5-25 8:45:54","LikeTotal":"1","isDZ":0},{"Id":"803813","UserID":"23405297","Photo":"http://r9.pccoo.cn/weixin/20170514/2017051418131398337546_950_1280_500x300(w).jpg","MapName":"来自金星","tName":"","nick":"灵😘","positionName":"28岁","CreateTime":"2017-5-25 8:45:53","LikeTotal":"2","isDZ":0},{"Id":"805408","UserID":"29196868","Photo":"http://r9.pccoo.cn/weixin/20170516/2017051622353557868373_960_1280_500x300(w).jpg","MapName":"来自金星","tName":"","nick":"呼噜路","positionName":"28岁","CreateTime":"2017-5-25 8:44:00","LikeTotal":"2","isDZ":0},{"Id":"806415","UserID":"29284658","Photo":"http://r9.pccoo.cn/weixin/20170518/2017051809011096371372_960_1280_500x300(w).jpg","MapName":"来自金星","tName":"","nick":"萍儿","positionName":"28岁","CreateTime":"2017-5-25 8:41:29","LikeTotal":"1","isDZ":0}],"Count":10},"TotalPage":11,"UpdateCount":0}
     * Extend : null
     * Count : 0
     * GxNum : 0
     * PageNum : 0
     * retime : 0.4853516
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
         * NewTCoverInfoList : {"NewTCoverInfoList":[{"Id":"742652","UserID":"25250139","Photo":"http://r9.pccoo.cn/weixin/20170211/2017021110152550141341_720_1280_500x300(w).jpg","MapName":"来自金星","tName":"","nick":"那年╮莪笑靥如花","positionName":"28岁","CreateTime":"2017-6-2 22:33:57","LikeTotal":"3","isDZ":0},{"Id":"799747","UserID":"28818056","Photo":"http://r9.pccoo.cn/weixin/20170508/2017050822335769712069_960_1280_500x300(w).jpg","MapName":"来自金星","tName":"","nick":"奶糖嘟嘟 (☆_☆)","positionName":"28岁","CreateTime":"2017-6-2 22:31:53","LikeTotal":"1","isDZ":0},{"Id":"815109","UserID":"29946738","Photo":"http://r9.pccoo.cn/weixin/20170531/2017053107044197831198_960_1280_500x300(w).jpg","MapName":"朝阳区,湖光中街辅路","tName":"","nick":"花开花落","positionName":"38岁","CreateTime":"2017-5-31 7:05:05","LikeTotal":"0","isDZ":0},{"Id":"742658","UserID":"20139576","Photo":"http://r9.pccoo.cn/weixin/20170211/2017021110455114945597_721_1280_500x300(w).jpg","MapName":"来自金星","tName":"","nick":"司大仙","positionName":"28岁","CreateTime":"2017-5-30 21:46:01","LikeTotal":"2","isDZ":0},{"Id":"768515","UserID":"22052933","Photo":"http://r9.pccoo.cn/weixin/20170324/2017032400590412394911_720_1280_500x300(w).jpg","MapName":"来自金星","tName":"","nick":"。阿娇  。","positionName":"28岁","CreateTime":"2017-5-29 7:52:05","LikeTotal":"2","isDZ":0},{"Id":"811921","UserID":"24746951","Photo":"http://r9.pccoo.cn/weixin/20170525/2017052515103423305603_708_1052_500x300(w).jpg","MapName":"来自金星","tName":"","nick":"宝贝我爱你","positionName":"28岁","CreateTime":"2017-5-25 15:10:29","LikeTotal":"0","isDZ":0},{"Id":"805409","UserID":"13046209","Photo":"http://r9.pccoo.cn/weixin/20170516/2017051622404734414192_960_1280_500x300(w).jpg","MapName":"来自金星","tName":"","nick":"呼噜路","positionName":"28岁","CreateTime":"2017-5-25 8:45:54","LikeTotal":"1","isDZ":0},{"Id":"803813","UserID":"23405297","Photo":"http://r9.pccoo.cn/weixin/20170514/2017051418131398337546_950_1280_500x300(w).jpg","MapName":"来自金星","tName":"","nick":"灵😘","positionName":"28岁","CreateTime":"2017-5-25 8:45:53","LikeTotal":"2","isDZ":0},{"Id":"805408","UserID":"29196868","Photo":"http://r9.pccoo.cn/weixin/20170516/2017051622353557868373_960_1280_500x300(w).jpg","MapName":"来自金星","tName":"","nick":"呼噜路","positionName":"28岁","CreateTime":"2017-5-25 8:44:00","LikeTotal":"2","isDZ":0},{"Id":"806415","UserID":"29284658","Photo":"http://r9.pccoo.cn/weixin/20170518/2017051809011096371372_960_1280_500x300(w).jpg","MapName":"来自金星","tName":"","nick":"萍儿","positionName":"28岁","CreateTime":"2017-5-25 8:41:29","LikeTotal":"1","isDZ":0}],"Count":10}
         * TotalPage : 11
         * UpdateCount : 0
         */

        private NewTCoverInfoListBeanX NewTCoverInfoList;
        private int TotalPage;
        private int UpdateCount;

        public NewTCoverInfoListBeanX getNewTCoverInfoList() {
            return NewTCoverInfoList;
        }

        public void setNewTCoverInfoList(NewTCoverInfoListBeanX NewTCoverInfoList) {
            this.NewTCoverInfoList = NewTCoverInfoList;
        }

        public int getTotalPage() {
            return TotalPage;
        }

        public void setTotalPage(int TotalPage) {
            this.TotalPage = TotalPage;
        }

        public int getUpdateCount() {
            return UpdateCount;
        }

        public void setUpdateCount(int UpdateCount) {
            this.UpdateCount = UpdateCount;
        }

        public static class NewTCoverInfoListBeanX {
            /**
             * NewTCoverInfoList : [{"Id":"742652","UserID":"25250139","Photo":"http://r9.pccoo.cn/weixin/20170211/2017021110152550141341_720_1280_500x300(w).jpg","MapName":"来自金星","tName":"","nick":"那年╮莪笑靥如花","positionName":"28岁","CreateTime":"2017-6-2 22:33:57","LikeTotal":"3","isDZ":0},{"Id":"799747","UserID":"28818056","Photo":"http://r9.pccoo.cn/weixin/20170508/2017050822335769712069_960_1280_500x300(w).jpg","MapName":"来自金星","tName":"","nick":"奶糖嘟嘟 (☆_☆)","positionName":"28岁","CreateTime":"2017-6-2 22:31:53","LikeTotal":"1","isDZ":0},{"Id":"815109","UserID":"29946738","Photo":"http://r9.pccoo.cn/weixin/20170531/2017053107044197831198_960_1280_500x300(w).jpg","MapName":"朝阳区,湖光中街辅路","tName":"","nick":"花开花落","positionName":"38岁","CreateTime":"2017-5-31 7:05:05","LikeTotal":"0","isDZ":0},{"Id":"742658","UserID":"20139576","Photo":"http://r9.pccoo.cn/weixin/20170211/2017021110455114945597_721_1280_500x300(w).jpg","MapName":"来自金星","tName":"","nick":"司大仙","positionName":"28岁","CreateTime":"2017-5-30 21:46:01","LikeTotal":"2","isDZ":0},{"Id":"768515","UserID":"22052933","Photo":"http://r9.pccoo.cn/weixin/20170324/2017032400590412394911_720_1280_500x300(w).jpg","MapName":"来自金星","tName":"","nick":"。阿娇  。","positionName":"28岁","CreateTime":"2017-5-29 7:52:05","LikeTotal":"2","isDZ":0},{"Id":"811921","UserID":"24746951","Photo":"http://r9.pccoo.cn/weixin/20170525/2017052515103423305603_708_1052_500x300(w).jpg","MapName":"来自金星","tName":"","nick":"宝贝我爱你","positionName":"28岁","CreateTime":"2017-5-25 15:10:29","LikeTotal":"0","isDZ":0},{"Id":"805409","UserID":"13046209","Photo":"http://r9.pccoo.cn/weixin/20170516/2017051622404734414192_960_1280_500x300(w).jpg","MapName":"来自金星","tName":"","nick":"呼噜路","positionName":"28岁","CreateTime":"2017-5-25 8:45:54","LikeTotal":"1","isDZ":0},{"Id":"803813","UserID":"23405297","Photo":"http://r9.pccoo.cn/weixin/20170514/2017051418131398337546_950_1280_500x300(w).jpg","MapName":"来自金星","tName":"","nick":"灵😘","positionName":"28岁","CreateTime":"2017-5-25 8:45:53","LikeTotal":"2","isDZ":0},{"Id":"805408","UserID":"29196868","Photo":"http://r9.pccoo.cn/weixin/20170516/2017051622353557868373_960_1280_500x300(w).jpg","MapName":"来自金星","tName":"","nick":"呼噜路","positionName":"28岁","CreateTime":"2017-5-25 8:44:00","LikeTotal":"2","isDZ":0},{"Id":"806415","UserID":"29284658","Photo":"http://r9.pccoo.cn/weixin/20170518/2017051809011096371372_960_1280_500x300(w).jpg","MapName":"来自金星","tName":"","nick":"萍儿","positionName":"28岁","CreateTime":"2017-5-25 8:41:29","LikeTotal":"1","isDZ":0}]
             * Count : 10
             */

            private int Count;
            private List<NewTCoverInfoListBean> NewTCoverInfoList;

            public int getCount() {
                return Count;
            }

            public void setCount(int Count) {
                this.Count = Count;
            }

            public List<NewTCoverInfoListBean> getNewTCoverInfoList() {
                return NewTCoverInfoList;
            }

            public void setNewTCoverInfoList(List<NewTCoverInfoListBean> NewTCoverInfoList) {
                this.NewTCoverInfoList = NewTCoverInfoList;
            }

            public static class NewTCoverInfoListBean {
                /**
                 * Id : 742652
                 * UserID : 25250139
                 * Photo : http://r9.pccoo.cn/weixin/20170211/2017021110152550141341_720_1280_500x300(w).jpg
                 * MapName : 来自金星
                 * tName :
                 * nick : 那年╮莪笑靥如花
                 * positionName : 28岁
                 * CreateTime : 2017-6-2 22:33:57
                 * LikeTotal : 3
                 * isDZ : 0
                 */

                private String Id;
                private String UserID;
                private String Photo;
                private String MapName;
                private String tName;
                private String nick;
                private String positionName;
                private String CreateTime;
                private String LikeTotal;
                private int isDZ;

                public String getId() {
                    return Id;
                }

                public void setId(String Id) {
                    this.Id = Id;
                }

                public String getUserID() {
                    return UserID;
                }

                public void setUserID(String UserID) {
                    this.UserID = UserID;
                }

                public String getPhoto() {
                    return Photo;
                }

                public void setPhoto(String Photo) {
                    this.Photo = Photo;
                }

                public String getMapName() {
                    return MapName;
                }

                public void setMapName(String MapName) {
                    this.MapName = MapName;
                }

                public String getTName() {
                    return tName;
                }

                public void setTName(String tName) {
                    this.tName = tName;
                }

                public String getNick() {
                    return nick;
                }

                public void setNick(String nick) {
                    this.nick = nick;
                }

                public String getPositionName() {
                    return positionName;
                }

                public void setPositionName(String positionName) {
                    this.positionName = positionName;
                }

                public String getCreateTime() {
                    return CreateTime;
                }

                public void setCreateTime(String CreateTime) {
                    this.CreateTime = CreateTime;
                }

                public String getLikeTotal() {
                    return LikeTotal;
                }

                public void setLikeTotal(String LikeTotal) {
                    this.LikeTotal = LikeTotal;
                }

                public int getIsDZ() {
                    return isDZ;
                }

                public void setIsDZ(int isDZ) {
                    this.isDZ = isDZ;
                }
            }
        }
    }
}
