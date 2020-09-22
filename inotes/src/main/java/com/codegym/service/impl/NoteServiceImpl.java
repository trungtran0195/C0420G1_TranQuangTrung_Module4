package com.codegym.service.impl;

import com.codegym.model.Note;
import com.codegym.repository.NoteRepository;
import com.codegym.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteRepository noteRepository;

    @Override
    public void save(Note note) {
        noteRepository.save(note);
    }

    @Override
    public Note findById(int id) {
        return noteRepository.getOne(id);
    }

    @Override
    public Page<Note> findAll(Pageable pageable) {
        return noteRepository.findAll(pageable);
    }

    @Override
    public Page<Note> findAllByTitle(String title,String noteType ,Pageable pageable) {
        return noteRepository.findAllByTitleContainingOrNoteType_TypeContaining(title,noteType, pageable);
    }

    @Override
    public void remove(int id) {
        noteRepository.deleteById(id);
    }
}
