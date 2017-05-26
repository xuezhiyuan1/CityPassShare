package com.example.think.citypass.model.bean;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by think on 2017/5/26.
 */

public class TitleBean {


    /**
     * MessageList : {"code":1000,"message":"Success"}
     * ServerInfo : [{"Id":1,"Class":0,"Name":"有态度","Buju":1},{"Id":2,"Class":0,"Name":"打酱油","Buju":2},{"Id":3,"Class":0,"Name":"爱潜水","Buju":3},{"Id":0,"Class":1,"Name":"最新","Buju":0},{"Id":1,"Class":1,"Name":"社会","Buju":1},{"Id":2,"Class":1,"Name":"正事","Buju":1},{"Id":3,"Class":1,"Name":"生活","Buju":1},{"Id":4,"Class":1,"Name":"娱乐","Buju":1}]
     * Extend : null
     * Count : 8
     * GxNum : 0
     * PageNum : 0
     * retime : 0.0263672
     */

    private MessageListBean MessageList;
    private Object Extend;
    private int Count;
    private int GxNum;
    private int PageNum;
    private double retime;
    private List<ServerInfoBean> ServerInfo;

    public MessageListBean getMessageList() {
        return MessageList;
    }

    public void setMessageList(MessageListBean MessageList) {
        this.MessageList = MessageList;
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

    public List<ServerInfoBean> getServerInfo() {
        return ServerInfo;
    }

    public void setServerInfo(List<ServerInfoBean> ServerInfo) {
        this.ServerInfo = ServerInfo;
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
         * Id : 1
         * Class : 0
         * Name : 有态度
         * Buju : 1
         */

        private int Id;

        public int getClasss() {
            return Classs;
        }

        public void setClasss(int classs) {
            Classs = classs;
        }

        @SerializedName("Class")
        private int Classs;
        private String Name;
        private int Buju;

        public int getId() {
            return Id;
        }

        public void setId(int Id) {
            this.Id = Id;
        }


        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public int getBuju() {
            return Buju;
        }

        public void setBuju(int Buju) {
            this.Buju = Buju;
        }
    }
}
