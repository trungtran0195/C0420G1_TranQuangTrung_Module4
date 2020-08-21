package controllers;

import model.DictModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.DictionaryService;
import service.impl.DictionaryServiceImpl;

import java.util.List;

@Controller
public class DictController {

    @Autowired
    private DictionaryService dictionaryService = new DictionaryServiceImpl();

    @GetMapping("/dictionary")
    public String translate(@RequestParam("engWord") String word, Model model) {
        List<DictModel> dictionary = this.dictionaryService.findAll();
        for (int i = 0; i < dictionary.size(); i++) {
            if (word.equalsIgnoreCase(dictionary.get(i).getEng())) {
                String result =dictionary.get(i).getVi();
                model.addAttribute("resultWord",result);
            }else{
                String result = "từ này không có trong từ điển";
                model.addAttribute("resultWord",result);
            }
        }
        return "result";
    }
}
