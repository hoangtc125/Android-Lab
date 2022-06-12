package com.example.email;

public class mailModel {
    private String avatar;
    private String title;
    private String content;
    private String date;

    public mailModel(String avatar, String title, String content, String date) {
        this.avatar = avatar;
        this.title = title;
        this.content = content;
        this.date = date;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
