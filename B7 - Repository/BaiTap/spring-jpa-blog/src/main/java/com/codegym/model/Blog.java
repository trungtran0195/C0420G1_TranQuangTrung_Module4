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

    @ManyToOne
    @JoinColumn (name = "id_category")
    private Category category;

    public Blog() {
    }

    public Blog(int id, String blogName, String blogDetail, Category category) {
        this.id = id;
        this.blogName = blogName;
        this.blogDetail = blogDetail;
        this.category = category;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
