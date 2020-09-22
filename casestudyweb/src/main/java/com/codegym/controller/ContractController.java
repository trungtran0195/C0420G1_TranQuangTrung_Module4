package com.codegym.controller;

import com.codegym.Model.Contract;
import com.codegym.Model.ContractDetail;
import com.codegym.Service.ContractService;
import com.codegym.Service.CustomerService;
import com.codegym.Service.HotelServiceService;
import com.codegym.Service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@SessionAttributes("deleteList")
public class ContractController {
    @Autowired
    private ContractService contractService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private HotelServiceService hotelServiceService;

    @Autowired
    private StaffService staffService;

    @GetMapping("/contractList")
    public ModelAndView listContract(@CookieValue(name="username",defaultValue = "") String username,@PageableDefault(2) Pageable pageable) {
        Page<Contract> contracts = contractService.findAll(pageable);
        if (contracts.isEmpty()) {
            return new ModelAndView("Contract/contractList", "message", "Không tìm thấy danh sách hợp đồng trong DB");
        } else {
            ModelAndView modelAndView = new ModelAndView("Contract/contractList");
            modelAndView.addObject("username",username);
            modelAndView.addObject("contracts", contracts);
            return modelAndView;
        }
    }

    @GetMapping("/customerContractList")
    public ModelAndView listServiceUseByCustomer(@PageableDefault(2) Pageable pageable) {
        Page<Contract> contracts = contractService.findAll(pageable);
        if (contracts.isEmpty()) {
            return new ModelAndView("Contract/customerList", "message", "Không tìm thấy danh sách hợp đồng trong DB");
        } else {
            ModelAndView modelAndView = new ModelAndView("Contract/customerList");
            modelAndView.addObject("contracts", contracts);
            return modelAndView;
        }
    }

    @GetMapping("/addContract")
    public ModelAndView contractInputForm() {
        ModelAndView modelAndView = new ModelAndView("Contract/addContract");
        modelAndView.addObject("contract",new Contract());
        modelAndView.addObject("customerList",customerService.findAll());
        modelAndView.addObject("hotelServiceList",hotelServiceService.findAll());
        modelAndView.addObject("staffList",staffService.findAll());
        modelAndView.addObject("contractDetailList",contractService.findAllContractDetail());
        return modelAndView;
    }

    @PostMapping("/addContract")
    public ModelAndView addContract(@Valid @ModelAttribute("contract") Contract contract, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("Contract/addContract");
            return modelAndView;
        }else {
            contractService.save(contract);
            ModelAndView modelAndView = new ModelAndView("Contract/addContract");
            modelAndView.addObject("message", "New contract added successfully");
            return modelAndView;
        }
    }

    @GetMapping("/addContractDetail")
    public ModelAndView contractDetailInputForm() {
        ModelAndView modelAndView = new ModelAndView("Contract/addContractDetail");
        modelAndView.addObject("contractDetail",new ContractDetail());
        modelAndView.addObject("extraServiceList",contractService.findAllExtraService());
        return modelAndView;
    }

    @PostMapping("/addContractDetail")
    public ModelAndView addContractExtraService(@Valid @ModelAttribute("contractDetail") ContractDetail contractDetail, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("Contract/addContractDetail");
            return modelAndView;
        }else {
            contractService.saveContractDetail(contractDetail);
            ModelAndView modelAndView = new ModelAndView("Contract/addContractDetail");
            modelAndView.addObject("extraServiceList",contractService.findAllExtraService());
            modelAndView.addObject("message", "New extra service added successfully");
            return modelAndView;
        }
    }

    @GetMapping("/delete-contract/{id}")
    public String deleteContract(@CookieValue(name="username",defaultValue = "") String username, @ModelAttribute("contract") Contract contract, HttpServletResponse response){
        username+=":"+contract.getId()+":"+ contract.getStartDate() +"-/-"+ contract.getEndDate() +":";
        Cookie cookie=new Cookie("username",username);
        cookie.setMaxAge(600);
        cookie.setPath("/");
        response.addCookie(cookie);
        contractService.remove(contract.getId());
        return "redirect:/contractList";
    }
}