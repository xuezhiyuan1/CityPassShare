package com.example.think.citypass.model.bean;

/**
 * Created by 张萌 on 2017/5/31.
 */

public class LoginBean {

    /**
     * MessageList : {"code":1000,"message":"Success"}
     * ServerInfo : {"UserID":29673064,"UserName":"sid090950350418930","RoleName":"无中生有","RoleImg":"http://p9.pccoo.cn/app_avatar/20170525/2017052509073885460592_520_520.jpg","uSiteID":2422,"ouSiteID":2422}
     * Extend : null
     * Count : 0
     * GxNum : 0
     * PageNum : 0
     * retime : 0.0820313
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
         * UserID : 29673064
         * UserName : sid090950350418930
         * RoleName : 无中生有
         * RoleImg : http://p9.pccoo.cn/app_avatar/20170525/2017052509073885460592_520_520.jpg
         * uSiteID : 2422
         * ouSiteID : 2422
         */

        private int UserID;
        private String UserName;
        private String RoleName;
        private String RoleImg;
        private int uSiteID;
        private int ouSiteID;

        public int getUserID() {
            return UserID;
        }

        public void setUserID(int UserID) {
            this.UserID = UserID;
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

        public int getUSiteID() {
            return uSiteID;
        }

        public void setUSiteID(int uSiteID) {
            this.uSiteID = uSiteID;
        }

        public int getOuSiteID() {
            return ouSiteID;
        }

        public void setOuSiteID(int ouSiteID) {
            this.ouSiteID = ouSiteID;
        }
    }
}
