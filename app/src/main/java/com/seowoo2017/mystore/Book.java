package com.seowoo2017.mystore;

/**
 * Created by alfo06-21 on 2017-10-31.
 */

public class Book {

    String imgUrl;
    String title;
    int price;
    String desc;
    float rating;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    String author;

    public Book(String imgUrl, String title, int price, String desc, float rating, String author) {
        this.imgUrl = imgUrl;
        this.title = title;
        this.price = price;
        this.desc = desc;
        this.rating = rating;
        this.author = author;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
