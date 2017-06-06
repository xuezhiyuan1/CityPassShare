package com.example.think.citypass.model.entity;

import java.util.List;

/**
 * Created by think on 2017/6/6.
 */

public class NvBean {

    /**
     * MessageList : {"code":1000,"message":"Success"}
     * ServerInfo : {"NewTCoverInfoList":{"NewTCoverInfoList":[{"Id":"693338","UserID":"11756215","Photo":"http://r9.pccoo.cn/weixin/20161116/2016111614440800273211_952_1280_500x300(w).jpg","MapName":"新双路","tName":"","nick":"??玉??","positionName":"38岁","CreateTime":"2017-6-5 14:32:31","LikeTotal":"8","isDZ":0}],"Count":1},"TotalPage":103,"UpdateCount":0}
     * Extend : null
     * Count : 0
     * GxNum : 0
     * PageNum : 0
     * retime : 0.099603
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
         * NewTCoverInfoList : {"NewTCoverInfoList":[{"Id":"693338","UserID":"11756215","Photo":"http://r9.pccoo.cn/weixin/20161116/2016111614440800273211_952_1280_500x300(w).jpg","MapName":"新双路","tName":"","nick":"??玉??","positionName":"38岁","CreateTime":"2017-6-5 14:32:31","LikeTotal":"8","isDZ":0}],"Count":1}
         * TotalPage : 103
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
             * NewTCoverInfoList : [{"Id":"693338","UserID":"11756215","Photo":"http://r9.pccoo.cn/weixin/20161116/2016111614440800273211_952_1280_500x300(w).jpg","MapName":"新双路","tName":"","nick":"??玉??","positionName":"38岁","CreateTime":"2017-6-5 14:32:31","LikeTotal":"8","isDZ":0}]
             * Count : 1
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
                 * Id : 693338
                 * UserID : 11756215
                 * Photo : http://r9.pccoo.cn/weixin/20161116/2016111614440800273211_952_1280_500x300(w).jpg
                 * MapName : 新双路
                 * tName :
                 * nick : ??玉??
                 * positionName : 38岁
                 * CreateTime : 2017-6-5 14:32:31
                 * LikeTotal : 8
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
