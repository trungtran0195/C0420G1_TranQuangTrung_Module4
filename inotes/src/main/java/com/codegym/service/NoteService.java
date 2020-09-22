package com.codegym.service;

import com.codegym.model.Note;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NoteService {
    void save (Note note);

    Note findById(int id);

    Page<Note> findAll(Pageable pageable);

    Page<Note>findAllByTitle(String title,String noteType,Pageable pageable);

    void remove(int id);
}
