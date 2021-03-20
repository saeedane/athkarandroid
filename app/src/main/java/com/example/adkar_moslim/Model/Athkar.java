package com.example.adkar_moslim.Model;

public class Athkar {
private String title;
private int image ;
private String desc;

    public Athkar(String title, int image) {
        this.title = title;
        this.image = image;
    }

    public Athkar(String title, int image, String desc) {
        this.title = title;
        this.image = image;
        this.desc = desc;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
