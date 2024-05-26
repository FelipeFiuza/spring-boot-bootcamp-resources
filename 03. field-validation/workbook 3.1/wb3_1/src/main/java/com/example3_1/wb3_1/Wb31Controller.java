package com.example3_1.wb3_1;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class Wb31Controller {
    
    @GetMapping("/result")
    public String getResult() {
        return "result";
    }

    @GetMapping("/")
    public String getForm(Model model) {
        model.addAttribute("user", new User());
        return "sign-up";
    }

    @PostMapping("/submitItem")
    public String handleSubmit(@Valid User user, BindingResult result) {
        
        if(user.getLastName().equals(user.getFirstName())) {
            result.rejectValue("lastName", "", "please enter valid data");
        }
        
        if(result.hasErrors()) {
            return "sign-up";
        }
        
        return "redirect:/result";
    }
    
}
