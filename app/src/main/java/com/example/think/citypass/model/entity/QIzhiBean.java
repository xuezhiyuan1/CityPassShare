package com.example.think.citypass.model.entity;

import java.util.List;

/**
 * Created by think on 2017/6/6.
 */

public class QIzhiBean {

    /**
     * MessageList : {"code":1000,"message":"Success"}
     * ServerInfo : {"NewTCoverInfoList":{"NewTCoverInfoList":[{"Id":"724437","UserID":"23240613","Photo":"http://r9.pccoo.cn/weixin/20170103/2017010300022275955979_960_960_500x300(w).jpg","MapName":"四海","tName":"","nick":"Bright sunshine ?","positionName":"28岁","CreateTime":"2017-6-5 14:37:31","LikeTotal":"4","isDZ":0},{"Id":"322557","UserID":"16431230","Photo":"http://p3.pccoo.cn/PHBBS/20151212/2015121211222672809810m.jpg","MapName":"来自金星","tName":"萌妹子","nick":"A.ヾ─╄ Cy ","positionName":"26岁","CreateTime":"2017-6-5 14:32:35","LikeTotal":"4","isDZ":0},{"Id":"693338","UserID":"11756215","Photo":"http://r9.pccoo.cn/weixin/20161116/2016111614440800273211_952_1280_500x300(w).jpg","MapName":"新双路","tName":"","nick":"??玉??","positionName":"38岁","CreateTime":"2017-6-5 14:32:31","LikeTotal":"8","isDZ":0},{"Id":"196481","UserID":"16419526","Photo":"http://p3.pccoo.cn/PHBBS/20151111/2015111120201865778907m.jpg","MapName":"来自金星","tName":"","nick":"本草女人香15910228873","positionName":"28岁","CreateTime":"2017-6-4 20:55:47","LikeTotal":"4","isDZ":0},{"Id":"258642","UserID":"16808370","Photo":"http://p3.pccoo.cn/PHBBS/20151211/2015121113531429559558m.jpeg","MapName":"来自金星","tName":"","nick":"我很卡门","positionName":"28岁","CreateTime":"2017-6-3 12:08:15","LikeTotal":"1","isDZ":0},{"Id":"190638","UserID":"16879465","Photo":"http://p3.pccoo.cn/PHBBS/20151216/2015121620362897287396m.jpg","MapName":"来自金星","tName":"","nick":"七分毒","positionName":"31岁","CreateTime":"2017-6-3 11:17:00","LikeTotal":"4","isDZ":0},{"Id":"728898","UserID":"24431650","Photo":"http://r9.pccoo.cn/weixin/20170110/2017011019193662855920_612_816_500x300(w).jpg","MapName":"来自金星","tName":"","nick":"?dissappear??Aurevoir","positionName":"28岁","CreateTime":"2017-6-3 11:16:50","LikeTotal":"3","isDZ":0},{"Id":"195642","UserID":"16419043","Photo":"http://p3.pccoo.cn/PHBBS/20151111/2015111119560632882287m.jpg","MapName":"来自金星","tName":"","nick":"A??張尕琪 ?","positionName":"28岁","CreateTime":"2017-6-2 22:41:24","LikeTotal":"6","isDZ":0},{"Id":"706525","UserID":"22344356","Photo":"http://r9.pccoo.cn/weixin/20161207/2016120719002629257663_722_1280_500x300(w).jpg","MapName":"来自金星","tName":"","nick":"小五??","positionName":"28岁","CreateTime":"2017-6-2 22:39:10","LikeTotal":"3","isDZ":0},{"Id":"524863","UserID":"14193432","Photo":"http://p3.pccoo.cn/PHBBS/20160221/2016022116092251134894m.jpg","MapName":"来自金星","tName":"","nick":"芳","positionName":"28岁","CreateTime":"2017-6-2 22:36:53","LikeTotal":"2","isDZ":0}],"Count":10},"TotalPage":11,"UpdateCount":0}
     * Extend : null
     * Count : 0
     * GxNum : 0
     * PageNum : 0
     * retime : 0.3525526
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
         * NewTCoverInfoList : {"NewTCoverInfoList":[{"Id":"724437","UserID":"23240613","Photo":"http://r9.pccoo.cn/weixin/20170103/2017010300022275955979_960_960_500x300(w).jpg","MapName":"四海","tName":"","nick":"Bright sunshine ?","positionName":"28岁","CreateTime":"2017-6-5 14:37:31","LikeTotal":"4","isDZ":0},{"Id":"322557","UserID":"16431230","Photo":"http://p3.pccoo.cn/PHBBS/20151212/2015121211222672809810m.jpg","MapName":"来自金星","tName":"萌妹子","nick":"A.ヾ─╄ Cy ","positionName":"26岁","CreateTime":"2017-6-5 14:32:35","LikeTotal":"4","isDZ":0},{"Id":"693338","UserID":"11756215","Photo":"http://r9.pccoo.cn/weixin/20161116/2016111614440800273211_952_1280_500x300(w).jpg","MapName":"新双路","tName":"","nick":"??玉??","positionName":"38岁","CreateTime":"2017-6-5 14:32:31","LikeTotal":"8","isDZ":0},{"Id":"196481","UserID":"16419526","Photo":"http://p3.pccoo.cn/PHBBS/20151111/2015111120201865778907m.jpg","MapName":"来自金星","tName":"","nick":"本草女人香15910228873","positionName":"28岁","CreateTime":"2017-6-4 20:55:47","LikeTotal":"4","isDZ":0},{"Id":"258642","UserID":"16808370","Photo":"http://p3.pccoo.cn/PHBBS/20151211/2015121113531429559558m.jpeg","MapName":"来自金星","tName":"","nick":"我很卡门","positionName":"28岁","CreateTime":"2017-6-3 12:08:15","LikeTotal":"1","isDZ":0},{"Id":"190638","UserID":"16879465","Photo":"http://p3.pccoo.cn/PHBBS/20151216/2015121620362897287396m.jpg","MapName":"来自金星","tName":"","nick":"七分毒","positionName":"31岁","CreateTime":"2017-6-3 11:17:00","LikeTotal":"4","isDZ":0},{"Id":"728898","UserID":"24431650","Photo":"http://r9.pccoo.cn/weixin/20170110/2017011019193662855920_612_816_500x300(w).jpg","MapName":"来自金星","tName":"","nick":"?dissappear??Aurevoir","positionName":"28岁","CreateTime":"2017-6-3 11:16:50","LikeTotal":"3","isDZ":0},{"Id":"195642","UserID":"16419043","Photo":"http://p3.pccoo.cn/PHBBS/20151111/2015111119560632882287m.jpg","MapName":"来自金星","tName":"","nick":"A??張尕琪 ?","positionName":"28岁","CreateTime":"2017-6-2 22:41:24","LikeTotal":"6","isDZ":0},{"Id":"706525","UserID":"22344356","Photo":"http://r9.pccoo.cn/weixin/20161207/2016120719002629257663_722_1280_500x300(w).jpg","MapName":"来自金星","tName":"","nick":"小五??","positionName":"28岁","CreateTime":"2017-6-2 22:39:10","LikeTotal":"3","isDZ":0},{"Id":"524863","UserID":"14193432","Photo":"http://p3.pccoo.cn/PHBBS/20160221/2016022116092251134894m.jpg","MapName":"来自金星","tName":"","nick":"芳","positionName":"28岁","CreateTime":"2017-6-2 22:36:53","LikeTotal":"2","isDZ":0}],"Count":10}
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
             * NewTCoverInfoList : [{"Id":"724437","UserID":"23240613","Photo":"http://r9.pccoo.cn/weixin/20170103/2017010300022275955979_960_960_500x300(w).jpg","MapName":"四海","tName":"","nick":"Bright sunshine ?","positionName":"28岁","CreateTime":"2017-6-5 14:37:31","LikeTotal":"4","isDZ":0},{"Id":"322557","UserID":"16431230","Photo":"http://p3.pccoo.cn/PHBBS/20151212/2015121211222672809810m.jpg","MapName":"来自金星","tName":"萌妹子","nick":"A.ヾ─╄ Cy ","positionName":"26岁","CreateTime":"2017-6-5 14:32:35","LikeTotal":"4","isDZ":0},{"Id":"693338","UserID":"11756215","Photo":"http://r9.pccoo.cn/weixin/20161116/2016111614440800273211_952_1280_500x300(w).jpg","MapName":"新双路","tName":"","nick":"??玉??","positionName":"38岁","CreateTime":"2017-6-5 14:32:31","LikeTotal":"8","isDZ":0},{"Id":"196481","UserID":"16419526","Photo":"http://p3.pccoo.cn/PHBBS/20151111/2015111120201865778907m.jpg","MapName":"来自金星","tName":"","nick":"本草女人香15910228873","positionName":"28岁","CreateTime":"2017-6-4 20:55:47","LikeTotal":"4","isDZ":0},{"Id":"258642","UserID":"16808370","Photo":"http://p3.pccoo.cn/PHBBS/20151211/2015121113531429559558m.jpeg","MapName":"来自金星","tName":"","nick":"我很卡门","positionName":"28岁","CreateTime":"2017-6-3 12:08:15","LikeTotal":"1","isDZ":0},{"Id":"190638","UserID":"16879465","Photo":"http://p3.pccoo.cn/PHBBS/20151216/2015121620362897287396m.jpg","MapName":"来自金星","tName":"","nick":"七分毒","positionName":"31岁","CreateTime":"2017-6-3 11:17:00","LikeTotal":"4","isDZ":0},{"Id":"728898","UserID":"24431650","Photo":"http://r9.pccoo.cn/weixin/20170110/2017011019193662855920_612_816_500x300(w).jpg","MapName":"来自金星","tName":"","nick":"?dissappear??Aurevoir","positionName":"28岁","CreateTime":"2017-6-3 11:16:50","LikeTotal":"3","isDZ":0},{"Id":"195642","UserID":"16419043","Photo":"http://p3.pccoo.cn/PHBBS/20151111/2015111119560632882287m.jpg","MapName":"来自金星","tName":"","nick":"A??張尕琪 ?","positionName":"28岁","CreateTime":"2017-6-2 22:41:24","LikeTotal":"6","isDZ":0},{"Id":"706525","UserID":"22344356","Photo":"http://r9.pccoo.cn/weixin/20161207/2016120719002629257663_722_1280_500x300(w).jpg","MapName":"来自金星","tName":"","nick":"小五??","positionName":"28岁","CreateTime":"2017-6-2 22:39:10","LikeTotal":"3","isDZ":0},{"Id":"524863","UserID":"14193432","Photo":"http://p3.pccoo.cn/PHBBS/20160221/2016022116092251134894m.jpg","MapName":"来自金星","tName":"","nick":"芳","positionName":"28岁","CreateTime":"2017-6-2 22:36:53","LikeTotal":"2","isDZ":0}]
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
                 * Id : 724437
                 * UserID : 23240613
                 * Photo : http://r9.pccoo.cn/weixin/20170103/2017010300022275955979_960_960_500x300(w).jpg
                 * MapName : 四海
                 * tName :
                 * nick : Bright sunshine ?
                 * positionName : 28岁
                 * CreateTime : 2017-6-5 14:37:31
                 * LikeTotal : 4
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
