package com.seowoo2017.mystore;

/**
 * Created by alfo06-21 on 2017-10-31.
 */

public class Enter {

    String imgUrl;
    String title;
    float rating;
    String desc;
    int price;

    public Enter(String imgUrl, String title, float rating, String desc, int price) {
        this.imgUrl = imgUrl;
        this.title = title;
        this.rating = rating;
        this.desc = desc;
        this.price = price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
