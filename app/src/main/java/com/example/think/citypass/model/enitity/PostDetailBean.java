package com.example.think.citypass.model.enitity;

import java.util.List;

/**
 * Created by ASUS on 2017/6/2.
 */

public class PostDetailBean {

    /**
     * MessageList : {"code":1000,"message":"Success"}
     * ServerInfo : {"TopicInfo":{"Title":"生活区怎么会成垃圾区，没人管吗？","Role":"清晨","RoleImg":"http://r3.pccoo.cn/weixin/20150731/2015073113504990907999_150x150(s).jpg","Level":2,"Addtime":"2017-5-24 8:55:39","Hits":3751,"Reply":5,"Tbody":"事件发生时间:2017-05-23事件发生地点:延庆区香营乡孟官屯村事件描述:请看照片，告诉您，这片垃圾区已经形成一年多了，开始是觉得居民方便，乡里管环境的很快就会请走。可是现在我觉得不是这样的，一方面困扰居民的休闲娱乐，一方面，已进入夏季，垃圾成堆，很容易产生空气污染，病菌很容易传播。况且这是居民生活区，不是垃圾区，这样已成习惯，每个家庭有建筑垃圾就往这空旷的地方倒，希望有关领导和部门重视和关注。在创城进行时，我们居民也希望得到最美的生活空间和呼吸最新鲜的空气！给您带来不便请见谅！[img]http://r9.pccoo.cn/weixin/20170523/2017052314220572677028_960_1280_500x300(w).jpg[/img][img]http://r9.pccoo.cn/weixin/20170523/2017052314220918967262_960_1280_500x300(w).jpg[/img][img]http://r9.pccoo.cn/weixin/20170523/2017052314221376825504_960_1280_500x300(w).jpg[/img][img]http://r9.pccoo.cn/weixin/20170523/2017052314221684620121_960_1280_500x300(w).jpg[/img]","Images":"","Videos":"","BoardID":"122029","BoardName":"同城爆料","IsHide":0,"IsNMReply":0},"VoteList":[],"PropLog":[],"ReplyList":[{"ReplyID":41930,"Rtitle":"沙发","UserName":"WXID16366771","RoleName":"大咖","RoleImg":"http://r3.pccoo.cn/weixin/20151107/2015110717545092984488_150x150(s).jpg","Level":2,"AddTime":"2017-5-26 20:20:11","ReplyMemo":"乱倒渣土垃圾有违公德","Clild":null,"ClildReplyList":null},{"ReplyID":41932,"Rtitle":"板凳","UserName":"WXID16366771","RoleName":"大咖","RoleImg":"http://r3.pccoo.cn/weixin/20151107/2015110717545092984488_150x150(s).jpg","Level":2,"AddTime":"2017-5-26 20:20:58","ReplyMemo":"乱倒垃圾缺德","Clild":null,"ClildReplyList":null},{"ReplyID":41959,"Rtitle":"马扎","UserName":"WXIDpNiTjbOc3588","RoleName":"延庆板爷","RoleImg":"http://r9.pccoo.cn/APPIMAGE/20170526/2017052620361616875598_80_80_150x150(s).jpg","Level":0,"AddTime":"2017-5-26 20:41:45","ReplyMemo":"表示各个村里都存在此类现象","Clild":null,"ClildReplyList":null},{"ReplyID":42729,"Rtitle":"4楼","UserName":"WXIDoZ7Wmju3-akz","RoleName":"、   ?  ????","RoleImg":"http://r5.pccoo.cn/weixin/20160804/2016080405352539783476_150x150(s).jpg","Level":2,"AddTime":"2017-5-28 6:15:59","ReplyMemo":"怎么没人管呀","Clild":null,"ClildReplyList":null},{"ReplyID":46179,"Rtitle":"5楼","UserName":"QQID97632FB31721","RoleName":"　无梦而安。","RoleImg":"http://r9.pccoo.cn/app_avatar/20170602/2017060219052392866754_780_780_150x150(s).jpg","Level":0,"AddTime":"2017-6-2 19:24:53","ReplyMemo":"这些事压根没人管","Clild":null,"ClildReplyList":null}]}
     * Extend : null
     * Count : 0
     * GxNum : 0
     * PageNum : 0
     * retime : 0.346693
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
         * TopicInfo : {"Title":"生活区怎么会成垃圾区，没人管吗？","Role":"清晨","RoleImg":"http://r3.pccoo.cn/weixin/20150731/2015073113504990907999_150x150(s).jpg","Level":2,"Addtime":"2017-5-24 8:55:39","Hits":3751,"Reply":5,"Tbody":"事件发生时间:2017-05-23事件发生地点:延庆区香营乡孟官屯村事件描述:请看照片，告诉您，这片垃圾区已经形成一年多了，开始是觉得居民方便，乡里管环境的很快就会请走。可是现在我觉得不是这样的，一方面困扰居民的休闲娱乐，一方面，已进入夏季，垃圾成堆，很容易产生空气污染，病菌很容易传播。况且这是居民生活区，不是垃圾区，这样已成习惯，每个家庭有建筑垃圾就往这空旷的地方倒，希望有关领导和部门重视和关注。在创城进行时，我们居民也希望得到最美的生活空间和呼吸最新鲜的空气！给您带来不便请见谅！[img]http://r9.pccoo.cn/weixin/20170523/2017052314220572677028_960_1280_500x300(w).jpg[/img][img]http://r9.pccoo.cn/weixin/20170523/2017052314220918967262_960_1280_500x300(w).jpg[/img][img]http://r9.pccoo.cn/weixin/20170523/2017052314221376825504_960_1280_500x300(w).jpg[/img][img]http://r9.pccoo.cn/weixin/20170523/2017052314221684620121_960_1280_500x300(w).jpg[/img]","Images":"","Videos":"","BoardID":"122029","BoardName":"同城爆料","IsHide":0,"IsNMReply":0}
         * VoteList : []
         * PropLog : []
         * ReplyList : [{"ReplyID":41930,"Rtitle":"沙发","UserName":"WXID16366771","RoleName":"大咖","RoleImg":"http://r3.pccoo.cn/weixin/20151107/2015110717545092984488_150x150(s).jpg","Level":2,"AddTime":"2017-5-26 20:20:11","ReplyMemo":"乱倒渣土垃圾有违公德","Clild":null,"ClildReplyList":null},{"ReplyID":41932,"Rtitle":"板凳","UserName":"WXID16366771","RoleName":"大咖","RoleImg":"http://r3.pccoo.cn/weixin/20151107/2015110717545092984488_150x150(s).jpg","Level":2,"AddTime":"2017-5-26 20:20:58","ReplyMemo":"乱倒垃圾缺德","Clild":null,"ClildReplyList":null},{"ReplyID":41959,"Rtitle":"马扎","UserName":"WXIDpNiTjbOc3588","RoleName":"延庆板爷","RoleImg":"http://r9.pccoo.cn/APPIMAGE/20170526/2017052620361616875598_80_80_150x150(s).jpg","Level":0,"AddTime":"2017-5-26 20:41:45","ReplyMemo":"表示各个村里都存在此类现象","Clild":null,"ClildReplyList":null},{"ReplyID":42729,"Rtitle":"4楼","UserName":"WXIDoZ7Wmju3-akz","RoleName":"、   ?  ????","RoleImg":"http://r5.pccoo.cn/weixin/20160804/2016080405352539783476_150x150(s).jpg","Level":2,"AddTime":"2017-5-28 6:15:59","ReplyMemo":"怎么没人管呀","Clild":null,"ClildReplyList":null},{"ReplyID":46179,"Rtitle":"5楼","UserName":"QQID97632FB31721","RoleName":"　无梦而安。","RoleImg":"http://r9.pccoo.cn/app_avatar/20170602/2017060219052392866754_780_780_150x150(s).jpg","Level":0,"AddTime":"2017-6-2 19:24:53","ReplyMemo":"这些事压根没人管","Clild":null,"ClildReplyList":null}]
         */

        private TopicInfoBean TopicInfo;
        private List<?> VoteList;
        private List<?> PropLog;
        private List<ReplyListBean> ReplyList;

        public TopicInfoBean getTopicInfo() {
            return TopicInfo;
        }

        public void setTopicInfo(TopicInfoBean TopicInfo) {
            this.TopicInfo = TopicInfo;
        }

        public List<?> getVoteList() {
            return VoteList;
        }

        public void setVoteList(List<?> VoteList) {
            this.VoteList = VoteList;
        }

        public List<?> getPropLog() {
            return PropLog;
        }

        public void setPropLog(List<?> PropLog) {
            this.PropLog = PropLog;
        }

        public List<ReplyListBean> getReplyList() {
            return ReplyList;
        }

        public void setReplyList(List<ReplyListBean> ReplyList) {
            this.ReplyList = ReplyList;
        }

        public static class TopicInfoBean {
            /**
             * Title : 生活区怎么会成垃圾区，没人管吗？
             * Role : 清晨
             * RoleImg : http://r3.pccoo.cn/weixin/20150731/2015073113504990907999_150x150(s).jpg
             * Level : 2
             * Addtime : 2017-5-24 8:55:39
             * Hits : 3751
             * Reply : 5
             * Tbody : 事件发生时间:2017-05-23事件发生地点:延庆区香营乡孟官屯村事件描述:请看照片，告诉您，这片垃圾区已经形成一年多了，开始是觉得居民方便，乡里管环境的很快就会请走。可是现在我觉得不是这样的，一方面困扰居民的休闲娱乐，一方面，已进入夏季，垃圾成堆，很容易产生空气污染，病菌很容易传播。况且这是居民生活区，不是垃圾区，这样已成习惯，每个家庭有建筑垃圾就往这空旷的地方倒，希望有关领导和部门重视和关注。在创城进行时，我们居民也希望得到最美的生活空间和呼吸最新鲜的空气！给您带来不便请见谅！[img]http://r9.pccoo.cn/weixin/20170523/2017052314220572677028_960_1280_500x300(w).jpg[/img][img]http://r9.pccoo.cn/weixin/20170523/2017052314220918967262_960_1280_500x300(w).jpg[/img][img]http://r9.pccoo.cn/weixin/20170523/2017052314221376825504_960_1280_500x300(w).jpg[/img][img]http://r9.pccoo.cn/weixin/20170523/2017052314221684620121_960_1280_500x300(w).jpg[/img]
             * Images :
             * Videos :
             * BoardID : 122029
             * BoardName : 同城爆料
             * IsHide : 0
             * IsNMReply : 0
             */

            private String Title;
            private String Role;
            private String RoleImg;
            private int Level;
            private String Addtime;
            private int Hits;
            private int Reply;
            private String Tbody;
            private String Images;
            private String Videos;
            private String BoardID;
            private String BoardName;
            private int IsHide;
            private int IsNMReply;

            public String getTitle() {
                return Title;
            }

            public void setTitle(String Title) {
                this.Title = Title;
            }

            public String getRole() {
                return Role;
            }

            public void setRole(String Role) {
                this.Role = Role;
            }

            public String getRoleImg() {
                return RoleImg;
            }

            public void setRoleImg(String RoleImg) {
                this.RoleImg = RoleImg;
            }

            public int getLevel() {
                return Level;
            }

            public void setLevel(int Level) {
                this.Level = Level;
            }

            public String getAddtime() {
                return Addtime;
            }

            public void setAddtime(String Addtime) {
                this.Addtime = Addtime;
            }

            public int getHits() {
                return Hits;
            }

            public void setHits(int Hits) {
                this.Hits = Hits;
            }

            public int getReply() {
                return Reply;
            }

            public void setReply(int Reply) {
                this.Reply = Reply;
            }

            public String getTbody() {
                return Tbody;
            }

            public void setTbody(String Tbody) {
                this.Tbody = Tbody;
            }

            public String getImages() {
                return Images;
            }

            public void setImages(String Images) {
                this.Images = Images;
            }

            public String getVideos() {
                return Videos;
            }

            public void setVideos(String Videos) {
                this.Videos = Videos;
            }

            public String getBoardID() {
                return BoardID;
            }

            public void setBoardID(String BoardID) {
                this.BoardID = BoardID;
            }

            public String getBoardName() {
                return BoardName;
            }

            public void setBoardName(String BoardName) {
                this.BoardName = BoardName;
            }

            public int getIsHide() {
                return IsHide;
            }

            public void setIsHide(int IsHide) {
                this.IsHide = IsHide;
            }

            public int getIsNMReply() {
                return IsNMReply;
            }

            public void setIsNMReply(int IsNMReply) {
                this.IsNMReply = IsNMReply;
            }
        }

        public static class ReplyListBean {
            /**
             * ReplyID : 41930
             * Rtitle : 沙发
             * UserName : WXID16366771
             * RoleName : 大咖
             * RoleImg : http://r3.pccoo.cn/weixin/20151107/2015110717545092984488_150x150(s).jpg
             * Level : 2
             * AddTime : 2017-5-26 20:20:11
             * ReplyMemo : 乱倒渣土垃圾有违公德
             * Clild : null
             * ClildReplyList : null
             */

            private int ReplyID;
            private String Rtitle;
            private String UserName;
            private String RoleName;
            private String RoleImg;
            private int Level;
            private String AddTime;
            private String ReplyMemo;
            private Object Clild;
            private Object ClildReplyList;

            public int getReplyID() {
                return ReplyID;
            }

            public void setReplyID(int ReplyID) {
                this.ReplyID = ReplyID;
            }

            public String getRtitle() {
                return Rtitle;
            }

            public void setRtitle(String Rtitle) {
                this.Rtitle = Rtitle;
            }

            public String getUserName() {
                return UserName;
            }

            public void setUserName(String UserName) {
                this.UserName = UserName;
            }

            public String getRoleName() {
                return RoleName;
            }

            public void setRoleName(String RoleName) {
                this.RoleName = RoleName;
            }

            public String getRoleImg() {
                return RoleImg;
            }

            public void setRoleImg(String RoleImg) {
                this.RoleImg = RoleImg;
            }

            public int getLevel() {
                return Level;
            }

            public void setLevel(int Level) {
                this.Level = Level;
            }

            public String getAddTime() {
                return AddTime;
            }

            public void setAddTime(String AddTime) {
                this.AddTime = AddTime;
            }

            public String getReplyMemo() {
                return ReplyMemo;
            }

            public void setReplyMemo(String ReplyMemo) {
                this.ReplyMemo = ReplyMemo;
            }

            public Object getClild() {
                return Clild;
            }

            public void setClild(Object Clild) {
                this.Clild = Clild;
            }

            public Object getClildReplyList() {
                return ClildReplyList;
            }

            public void setClildReplyList(Object ClildReplyList) {
                this.ClildReplyList = ClildReplyList;
            }
        }
    }
}
