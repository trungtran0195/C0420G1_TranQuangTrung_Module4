package com.codegym.repository;

import com.codegym.model.Note;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note,Integer> {
    Page<Note> findAll(Pageable pageable);
    Page<Note> findAllByTitleContainingOrNoteType_TypeContaining(String title,String noteTypeTitle,Pageable pageable);
}
