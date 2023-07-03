package com.example.demo.model;


import javax.persistence.*;

@Entity
@Table (name = "blogs")
public class BLog {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @Column(columnDefinition = "LongText")
    private String content;
    private String author;
    private String date;

    private boolean checkStatus;
    @ManyToOne
    @JoinColumn (name = "type_blog_id", nullable = false)
    private TypeBlog typeBlog;



    public BLog(String title, String content, String author, String date, boolean checkStatus, TypeBlog typeBlog) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.date = date;
        this.checkStatus = checkStatus;
        this.typeBlog = typeBlog;
    }

    public BLog(int id, String title, String content, String author, String date, boolean checkStatus) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.date = date;
        this.checkStatus = checkStatus;
    }

    public boolean getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(boolean checkStatus) {
        this.checkStatus = checkStatus;
    }

    public BLog(String title, String content, String author, String date, boolean checkStatus) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.date = date;
        this.checkStatus = checkStatus;
    }

    public BLog() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public TypeBlog getTypeBlog() {
        return typeBlog;
    }

    public void setTypeBlog(TypeBlog typeBlog) {
        this.typeBlog = typeBlog;
    }
}
