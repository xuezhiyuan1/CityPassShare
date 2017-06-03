package com.example.think.citypass.model.enitity;

import java.util.List;

/**
 * Created by ASUS on 2017/6/2.
 */

public class PostDetailBean {


    /**
     * MessageList : {"code":1000,"message":"Success"}
     * ServerInfo : {"TopicInfo":{"Title":"王泉营的水还能喝么？","Role":"A.             ??","RoleImg":"http://r9.pccoo.cn/weixin/20170213/2017021313024311167659_640_640_150x150(s).jpg","Level":0,"Addtime":"2017-5-18 21:21:53","Hits":1448,"Reply":4,"Tbody":"事件发生时间:2017-05-18事件发生地点:王泉营村事件描述:王泉营的水变成了这样，里面全都是密密麻麻黑色的东西，给大家带来了极其的不便，饭做不了，衣服洗不了，用布包住水龙头，布上面全是东西[img]http://r9.pccoo.cn/weixin/20170518/2017051808334945582541_1280_960_500x300(w).jpg[/img][img]http://r9.pccoo.cn/weixin/20170518/2017051808335294901183_960_1280_500x300(w).jpg[/img][img]http://r9.pccoo.cn/weixin/20170518/2017051808335426810812_960_1280_500x300(w).jpg[/img]","Images":"","Videos":"","BoardID":"122029","BoardName":"同城爆料","IsHide":0,"IsNMReply":0},"VoteList":[],"PropLog":[],"ReplyList":[{"ReplyID":42213,"Rtitle":"沙发","UserName":"WXID16366771","RoleName":"大咖","RoleImg":"http://r3.pccoo.cn/weixin/20151107/2015110717545092984488_150x150(s).jpg","Level":2,"AddTime":"2017-5-27 8:34:31","ReplyMemo":"净化不过关","Clild":null,"ClildReplyList":null},{"ReplyID":42234,"Rtitle":"板凳","UserName":"WXIDXNFRIF248191","RoleName":"_喵喵喵","RoleImg":"http://r9.pccoo.cn/weixin/20170527/2017052709395121686862_430_430_150x150(s).jpg","Level":0,"AddTime":"2017-5-27 9:40:07","ReplyMemo":"这是哪里来的水","Clild":null,"ClildReplyList":null},{"ReplyID":42330,"Rtitle":"马扎","UserName":"sid232419523978639","RoleName":"宪宪","RoleImg":"http://r9.pccoo.cn/APPIMAGE/20170526/2017052623233630508556_80_80_150x150(s).jpg","Level":0,"AddTime":"2017-5-27 11:44:31","ReplyMemo":"怎么能这样","Clild":null,"ClildReplyList":null},{"ReplyID":45598,"Rtitle":"4楼","UserName":"WXID14501361","RoleName":"仁义礼智信","RoleImg":"http://r9.pccoo.cn/weixin/20170519/2017051911190185349088_640_1136_150x150(s).jpg","Level":2,"AddTime":"2017-6-2 3:45:04","ReplyMemo":"早就该管管  由于加压水管多处破裂 经常坏  现在又因为加压年久失修   经常出现大量杂质  还让人活吗？","Clild":null,"ClildReplyList":null}]}
     * Extend : null
     * Count : 0
     * GxNum : 0
     * PageNum : 0
     * retime : 0.3056758
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
         * TopicInfo : {"Title":"王泉营的水还能喝么？","Role":"A.             ??","RoleImg":"http://r9.pccoo.cn/weixin/20170213/2017021313024311167659_640_640_150x150(s).jpg","Level":0,"Addtime":"2017-5-18 21:21:53","Hits":1448,"Reply":4,"Tbody":"事件发生时间:2017-05-18事件发生地点:王泉营村事件描述:王泉营的水变成了这样，里面全都是密密麻麻黑色的东西，给大家带来了极其的不便，饭做不了，衣服洗不了，用布包住水龙头，布上面全是东西[img]http://r9.pccoo.cn/weixin/20170518/2017051808334945582541_1280_960_500x300(w).jpg[/img][img]http://r9.pccoo.cn/weixin/20170518/2017051808335294901183_960_1280_500x300(w).jpg[/img][img]http://r9.pccoo.cn/weixin/20170518/2017051808335426810812_960_1280_500x300(w).jpg[/img]","Images":"","Videos":"","BoardID":"122029","BoardName":"同城爆料","IsHide":0,"IsNMReply":0}
         * VoteList : []
         * PropLog : []
         * ReplyList : [{"ReplyID":42213,"Rtitle":"沙发","UserName":"WXID16366771","RoleName":"大咖","RoleImg":"http://r3.pccoo.cn/weixin/20151107/2015110717545092984488_150x150(s).jpg","Level":2,"AddTime":"2017-5-27 8:34:31","ReplyMemo":"净化不过关","Clild":null,"ClildReplyList":null},{"ReplyID":42234,"Rtitle":"板凳","UserName":"WXIDXNFRIF248191","RoleName":"_喵喵喵","RoleImg":"http://r9.pccoo.cn/weixin/20170527/2017052709395121686862_430_430_150x150(s).jpg","Level":0,"AddTime":"2017-5-27 9:40:07","ReplyMemo":"这是哪里来的水","Clild":null,"ClildReplyList":null},{"ReplyID":42330,"Rtitle":"马扎","UserName":"sid232419523978639","RoleName":"宪宪","RoleImg":"http://r9.pccoo.cn/APPIMAGE/20170526/2017052623233630508556_80_80_150x150(s).jpg","Level":0,"AddTime":"2017-5-27 11:44:31","ReplyMemo":"怎么能这样","Clild":null,"ClildReplyList":null},{"ReplyID":45598,"Rtitle":"4楼","UserName":"WXID14501361","RoleName":"仁义礼智信","RoleImg":"http://r9.pccoo.cn/weixin/20170519/2017051911190185349088_640_1136_150x150(s).jpg","Level":2,"AddTime":"2017-6-2 3:45:04","ReplyMemo":"早就该管管  由于加压水管多处破裂 经常坏  现在又因为加压年久失修   经常出现大量杂质  还让人活吗？","Clild":null,"ClildReplyList":null}]
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
             * Title : 王泉营的水还能喝么？
             * Role : A.             ??
             * RoleImg : http://r9.pccoo.cn/weixin/20170213/2017021313024311167659_640_640_150x150(s).jpg
             * Level : 0
             * Addtime : 2017-5-18 21:21:53
             * Hits : 1448
             * Reply : 4
             * Tbody : 事件发生时间:2017-05-18事件发生地点:王泉营村事件描述:王泉营的水变成了这样，里面全都是密密麻麻黑色的东西，给大家带来了极其的不便，饭做不了，衣服洗不了，用布包住水龙头，布上面全是东西[img]http://r9.pccoo.cn/weixin/20170518/2017051808334945582541_1280_960_500x300(w).jpg[/img][img]http://r9.pccoo.cn/weixin/20170518/2017051808335294901183_960_1280_500x300(w).jpg[/img][img]http://r9.pccoo.cn/weixin/20170518/2017051808335426810812_960_1280_500x300(w).jpg[/img]
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
             * ReplyID : 42213
             * Rtitle : 沙发
             * UserName : WXID16366771
             * RoleName : 大咖
             * RoleImg : http://r3.pccoo.cn/weixin/20151107/2015110717545092984488_150x150(s).jpg
             * Level : 2
             * AddTime : 2017-5-27 8:34:31
             * ReplyMemo : 净化不过关
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
