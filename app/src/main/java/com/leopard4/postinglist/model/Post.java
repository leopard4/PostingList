package com.leopard4.postinglist.model;

import java.io.Serializable;

public class Post implements Serializable {
    public int id;
    public int userId;
    public String title;
    public String body;

    public Post() {
    }

    public Post(String title, String body) {
        this.userId = -1; // 임의로 -1로 설정 // 설정을 안하면 디폴트로 0으로 됨.
        this.id = -1;
        this.title = title;
        this.body = body;
    }

    public Post(int id, int userId, String title, String body) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.body = body;
    }
}
