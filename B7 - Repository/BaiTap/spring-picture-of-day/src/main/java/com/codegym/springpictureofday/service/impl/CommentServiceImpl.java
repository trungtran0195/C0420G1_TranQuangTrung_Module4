package com.codegym.springpictureofday.service.impl;

import com.codegym.springpictureofday.model.Comment;
import com.codegym.springpictureofday.repository.CommentRepository;
import com.codegym.springpictureofday.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public Page<Comment> getAll(Pageable pageable) {
        return commentRepository.findAll(pageable);
    }


    @Override
    public Comment findById(Long id) {
        return commentRepository.findById(id).orElse(null);
    }
}
