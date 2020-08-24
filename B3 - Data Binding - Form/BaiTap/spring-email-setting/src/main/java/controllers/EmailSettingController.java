package controllers;

import model.EmailSetting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.EmailSettingService;
import service.impl.EmailSettingServiceImpl;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/emailSetting")
@Controller
public class EmailSettingController {

    private EmailSettingService emailSettingService = new EmailSettingServiceImpl();

    @GetMapping("")
    public ModelAndView getEmailPage(){
        return new ModelAndView("email", "emails", emailSettingService.findAll());
    }

    @GetMapping("/addEmailSetting")
    public ModelAndView formAddEmail(Model model){
        List<String> languages = new ArrayList<>();
        List<String> pagesize = new ArrayList<>();
        languages.add("English");
        languages.add("Vietnamese");
        languages.add("Japanese");
        languages.add("Chinese");
        pagesize.add("5");
        pagesize.add("10");
        pagesize.add("15");
        pagesize.add("25");
        pagesize.add("50");
        pagesize.add("100");
        model.addAttribute("languages", languages);
        model.addAttribute("pagesize", pagesize);
        return new ModelAndView("addEmailSetting", "email", new EmailSetting());
    }

    @PostMapping("/addEmailSetting")
    public String addEmailSetting(@ModelAttribute EmailSetting emailSetting){
        emailSettingService.save(emailSetting);
        return "redirect:/emailSetting";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView getEditPage(@PathVariable Integer id, Model model ){
        EmailSetting email = emailSettingService.findById(id);
        List<String> languages = new ArrayList<>();
        List<String> pagesize = new ArrayList<>();
        languages.add("English");
        languages.add("Vietnamese");
        languages.add("Japanese");
        languages.add("Chinese");
        pagesize.add("5");
        pagesize.add("10");
        pagesize.add("15");
        pagesize.add("25");
        pagesize.add("50");
        pagesize.add("100");
        model.addAttribute("languages", languages);
        model.addAttribute("pagesize", pagesize);
        return new ModelAndView("editEmailSetting", "email", email);
    }
    @PostMapping("/edit")
    public String getEditStudent(@ModelAttribute EmailSetting emailSetting){
        emailSettingService.save(emailSetting);
        return "redirect:/emailSetting";
    }
}
