package com.codegym.controller;

import com.codegym.Model.HotelService;
import com.codegym.Service.HotelServiceRentTypeService;
import com.codegym.Service.HotelServiceService;
import com.codegym.Service.HotelServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class HotelServiceController {
    @Autowired
    private HotelServiceService hotelServiceService;

    @Autowired
    private HotelServiceTypeService hotelServiceTypeService;

    @Autowired
    private HotelServiceRentTypeService hotelServiceRentTypeService;

    @GetMapping("/serviceList")
    public ModelAndView listService(@PageableDefault(2) Pageable pageable) {
        Page<HotelService> hotelServices = hotelServiceService.findAll(pageable);
        if (hotelServices.isEmpty()) {
            return new ModelAndView("hotelService/listService", "message", "Không tìm thấy danh sách dịch vụ trong DB");
        } else {
            ModelAndView modelAndView = new ModelAndView("hotelService/listService");
            modelAndView.addObject("hotelServices", hotelServices);
            return modelAndView;
        }
    }

    @GetMapping("/addService")
    public ModelAndView serviceInputForm() {
        ModelAndView modelAndView = new ModelAndView("hotelService/addService");
        modelAndView.addObject("service",new HotelService());
        modelAndView.addObject("hotelServiceType",hotelServiceTypeService.findAll());
        modelAndView.addObject("hotelServiceTypeRent",hotelServiceRentTypeService.findAll());
        return modelAndView;
    }

    @PostMapping("/addService")
    public ModelAndView addService(@Valid @ModelAttribute("hotelService") HotelService hotelService, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("hotelService/addService");
            return modelAndView;
        }else {
            hotelServiceService.save(hotelService);
            ModelAndView modelAndView = new ModelAndView("hotelService/addService");
            modelAndView.addObject("service",new HotelService());
            modelAndView.addObject("message", "New service added successfully");
            return modelAndView;
        }
    }

    @GetMapping("/edit-service/{id}")
    public ModelAndView showEditForm(@PathVariable String id){
        HotelService hotelService = hotelServiceService.findById(id);
        if(hotelService != null) {
            ModelAndView modelAndView = new ModelAndView("hotelService/edit");
            modelAndView.addObject("hotelService", hotelService);
            modelAndView.addObject("hotelServiceType",hotelServiceTypeService.findAll());
            modelAndView.addObject("hotelServiceTypeRent",hotelServiceRentTypeService.findAll());
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-service")
    public ModelAndView updateHotelService(@ModelAttribute("hotelService") HotelService hotelService){
        hotelServiceService.save(hotelService);
        ModelAndView modelAndView = new ModelAndView("customer/edit");
        modelAndView.addObject("hotelService", hotelService);
        modelAndView.addObject("message", "hotelService updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-service/{id}")
    public String deleteHotelService(@ModelAttribute("hotelService") HotelService hotelService){
        hotelServiceService.remove(hotelService.getId());
        return "redirect:/serviceList";
    }

}
