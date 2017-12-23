package com.seowoo2017.mystore;

/**
 * Created by alfo06-21 on 2017-10-31.
 */

public class News {

    String[] imgUrl;
    String title;
    String date;
    String[] desc;

    public News(String[] imgUrl, String title, String date, String[] desc) {
        this.imgUrl = imgUrl;
        this.title = title;
        this.date = date;
        this.desc = desc;
    }

    public String[] getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String[] imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String[] getDesc() {
        return desc;
    }

    public void setDesc(String[] desc) {
        this.desc = desc;
    }
}
