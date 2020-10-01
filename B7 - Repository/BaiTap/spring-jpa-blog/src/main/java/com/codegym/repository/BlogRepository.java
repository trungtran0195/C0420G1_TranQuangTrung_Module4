package com.codegym.repository;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Integer> {
    Page<Blog> findAll(Pageable pageable);
    Page<Blog> findAllByBlogNameContainingOrCategory_Name(String blogTitle, String category,Pageable pageable);
    Page<Blog> findAllByBlogNameContaining(String blogTitle,Pageable pageable);
    Page<Blog> findAllByCategory_Name(String category,Pageable pageable);
}
