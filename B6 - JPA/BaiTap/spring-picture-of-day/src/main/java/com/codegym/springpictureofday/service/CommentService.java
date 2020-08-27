package com.codegym.springpictureofday.service;


import com.codegym.springpictureofday.model.Comment;

import java.util.List;

public interface CommentService {
    void save(Comment comment);

    List<Comment> getAll();

    Comment findById(Long id);
}
