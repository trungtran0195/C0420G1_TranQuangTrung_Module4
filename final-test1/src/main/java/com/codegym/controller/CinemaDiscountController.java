package com.codegym.controller;

import com.codegym.model.CinemaDiscount;
import com.codegym.service.CinemaDiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CinemaDiscountController {
    @Autowired
    private CinemaDiscountService cinemaDiscountService;

    @GetMapping("/discount")
    public ModelAndView listDiscounts(@PageableDefault(2) Pageable pageable, @RequestParam(value = "search",defaultValue = "")String search, @RequestParam(value = "by",defaultValue = "")String by) {
        Page<CinemaDiscount> cinemaDiscounts = cinemaDiscountService.findAllCinemaDiscountBySearch(search,by,pageable);
        if (cinemaDiscounts.isEmpty()) {
            return new ModelAndView("error", "message", "Không tìm thấy dữ liệu trong DB");
        } else {
            ModelAndView modelAndView = new ModelAndView("list");
            modelAndView.addObject("cinemaDiscounts", cinemaDiscounts);
            modelAndView.addObject("search", search);
            return modelAndView;
        }
    }

    @GetMapping("/create-discount")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("cinemaDiscounts",new CinemaDiscount());
        return modelAndView;
    }

    @PostMapping("/create-discount")
    public ModelAndView createDiscount(@Validated  @ModelAttribute("cinemaDiscounts") CinemaDiscount cinemaDiscounts, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("create");
            return modelAndView;
        }else {
            cinemaDiscountService.save(cinemaDiscounts);
            ModelAndView modelAndView = new ModelAndView("create");
            modelAndView.addObject("cinemaDiscounts", new CinemaDiscount());
            modelAndView.addObject("message", "New discount created successfully");
            return modelAndView;
        }
    }

    @GetMapping("/edit-discount/{id}")
    public ModelAndView showEditForm(@PathVariable Integer id){
        CinemaDiscount cinemaDiscounts = cinemaDiscountService.findById(id);
        if(cinemaDiscounts != null) {
            ModelAndView modelAndView = new ModelAndView("edit");
            modelAndView.addObject("cinemaDiscounts", cinemaDiscounts);
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("edit");
            return new ModelAndView("edit", "message", "Không tìm thấy dữ liệu trong DB");
        }
    }

    @PostMapping("/edit-discount")
    public ModelAndView editDiscount(@ModelAttribute("cinemaDiscounts") CinemaDiscount cinemaDiscounts){
        cinemaDiscountService.save(cinemaDiscounts);
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("cinemaDiscounts", cinemaDiscounts);
        modelAndView.addObject("message", "discount updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-discount/{id}")
    public String deleteDiscount(@ModelAttribute("cinemaDiscounts") CinemaDiscount cinemaDiscounts){
        cinemaDiscountService.remove(cinemaDiscounts.getId());
        return "redirect:/discount";
    }
}
