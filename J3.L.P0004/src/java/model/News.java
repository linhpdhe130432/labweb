/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author DuongDT
 */
public class News {
    private int id;
    private String title;
    private String shortDes;
    private String content;
    private String author;
    private String imageDes;
    private String createdAt;

    public News(int id, String title, String shortDes, String content, String author, String imageDes, String createdAt) {
        this.id = id;
        this.title = title;
        this.shortDes = shortDes;
        this.content = content;
        this.author = author;
        this.imageDes = imageDes;
        this.createdAt = createdAt;
    }

    public News(int id, String title, String shortDes) {
        this.id = id;
        this.title = title;
        this.shortDes = shortDes;
    }

    public News(int id, String title, String shortDes, String imageDes) {
        this.id = id;
        this.title = title;
        this.shortDes = shortDes;
        this.imageDes = imageDes;
    }

    
    
    
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getShortDes() {
        return shortDes;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public String getImageDes() {
        return imageDes;
    }

    public String getCreatedAt() {
        return createdAt;
    }
    
    
}
