package com.codegym.controller;

import com.codegym.model.Note;
import com.codegym.model.NoteType;
import com.codegym.service.NoteService;
import com.codegym.service.NoteTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class NoteController {

    @Autowired
    private NoteService noteService;

    @Autowired
    private NoteTypeService noteTypeService;

    @GetMapping("/note")
    public ModelAndView listNote(@PageableDefault(2) Pageable pageable, @RequestParam(value = "search",defaultValue = "")String search,
                                  @RequestParam(value = "by", defaultValue = "all") String by) {
        Page<Note> notes = noteService.findAllByTitle(search,by,pageable);
        List<NoteType> noteTypeList = noteTypeService.findAll();
        if (notes.isEmpty()) {
            return new ModelAndView("list", "message", "Không tìm thấy note trong DB");
        } else {
            ModelAndView modelAndView = new ModelAndView("list");
            modelAndView.addObject("notes", notes);
            modelAndView.addObject("categories",noteTypeList);
            modelAndView.addObject("search", search);
            return modelAndView;
        }
    }

    @GetMapping("/detail-note/{id}")
    public ModelAndView showNote(@PathVariable Integer id){
        Note note = noteService.findById(id);
        if(note != null) {
            ModelAndView modelAndView = new ModelAndView("detail");
            modelAndView.addObject("note", note);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @GetMapping("/create-note")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("note",new Note());
        modelAndView.addObject("categories",noteTypeService.findAll());
        return modelAndView;
    }

    @PostMapping("/create-note")
    public ModelAndView createNote(@ModelAttribute("note") Note note){
        noteService.save(note);
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("note", new Note());
        modelAndView.addObject("message", "New note created successfully");
        return modelAndView;
    }

    @GetMapping("/edit-note/{id}")
    public ModelAndView showEditForm(@PathVariable Integer id){
        Note note = noteService.findById(id);
        if(note != null) {
            ModelAndView modelAndView = new ModelAndView("edit");
            modelAndView.addObject("note", note);
            modelAndView.addObject("categories",noteTypeService.findAll());
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-note")
    public ModelAndView updateNote(@ModelAttribute("note") Note note){
        noteService.save(note);
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("note", note);
        modelAndView.addObject("message", "note updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-note/{id}")
    public ModelAndView showDeleteForm(@PathVariable Integer id){
        Note note = noteService.findById(id);
        if(note != null) {
            ModelAndView modelAndView = new ModelAndView("delete");
            modelAndView.addObject("note", note);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-note")
    public String deleteCustomer(@ModelAttribute("note") Note note){
        noteService.remove(note.getId());
        return "redirect:";
    }

}
