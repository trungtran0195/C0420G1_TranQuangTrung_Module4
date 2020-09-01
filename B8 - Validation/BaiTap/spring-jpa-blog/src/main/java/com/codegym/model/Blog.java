package com.codegym.model;

import javax.persistence.*;

@Entity
public class Blog {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "blog_name")
    private String blogName;

    @Column(name = "blog_detail")
    private String blogDetail;

    public Blog() {
    }

    public Blog(int id, String blogName, String blogDetail) {
        this.id = id;
        this.blogName = blogName;
        this.blogDetail = blogDetail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName;
    }

    public String getBlogDetail() {
        return blogDetail;
    }

    public void setBlogDetail(String blogDetail) {
        this.blogDetail = blogDetail;
    }
}
