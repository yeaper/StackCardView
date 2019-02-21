package com.yyp.example.bean;

import java.io.Serializable;

/**
 * 新闻数据类
 *
 * Created by yyp on 2019/2/18
 */
public class NewsBean implements Serializable {

    private String imageUrl;
    private String title;
    private String content;
    private String column;
    private int readCount;

    public NewsBean(String imageUrl, String title, String content, String column, int readCount) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.content = content;
        this.column = column;
        this.readCount = readCount;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public int getReadCount() {
        return readCount;
    }

    public void setReadCount(int readCount) {
        this.readCount = readCount;
    }
}
