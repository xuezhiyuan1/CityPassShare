package com.example.think.citypass.model.bean;

/**
 * Created by 张萌 on 2017/6/5.
 */

public class ZBDataBean {
    private  String  title;
    private  int  image;
    private String  coin1;
    private String  coin2;

    public ZBDataBean(String title, int image, String coin1, String coin2) {

        this.title = title;
        this.image = image;
        this.coin1 = coin1;
        this.coin2 = coin2;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getCoin1() {
        return coin1;
    }

    public void setCoin1(String coin1) {
        this.coin1 = coin1;
    }

    public String getCoin2() {
        return coin2;
    }

    public void setCoin2(String coin2) {
        this.coin2 = coin2;
    }
}
