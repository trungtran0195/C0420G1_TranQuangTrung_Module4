package com.codegym.service;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlogService {
    Page<Blog> findAll(Pageable pageable);
    Blog findById(int id);
    void save (Blog blog);
    void remove(int id);
    Page<Blog> findAllBlogBySearch(String search,Pageable pageable);
}
