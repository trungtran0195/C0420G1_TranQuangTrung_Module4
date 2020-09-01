package com.codegym.springpictureofday.service;


import com.codegym.springpictureofday.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CommentService {
    void save(Comment comment);

    Page<Comment> getAll(Pageable pageable);

    Comment findById(Long id);
}
