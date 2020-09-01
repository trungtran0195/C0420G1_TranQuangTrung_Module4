package com.codegym.springpictureofday.model;

import javax.persistence.*;


@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int mark;

    private String author;

    private String feedback;

    private Long totalLike;

    public Comment() {
    }

    public Comment(Long id, int mark, String author, String feedback, Long totalLike) {
        this.id = id;
        this.mark = mark;
        this.author = author;
        this.feedback = feedback;
        this.totalLike = totalLike;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Long getTotalLike() {
        return totalLike;
    }

    public void setTotalLike(Long totalLike) {
        this.totalLike = totalLike;
    }
}
