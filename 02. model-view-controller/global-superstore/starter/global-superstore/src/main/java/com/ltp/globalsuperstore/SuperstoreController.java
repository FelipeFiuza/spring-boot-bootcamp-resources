package com.ltp.globalsuperstore;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.servlet.handler.AbstractHandlerMethodMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class SuperstoreController {

    private List<Item> items = new ArrayList<Item>();

    @GetMapping("/")
    public String getForm(Model model, @RequestParam(required = false) String id) {
        model.addAttribute("categories", Constants.CATEGORIES);
        
        Integer itemIndex = findItem(id);
        
        model.addAttribute("item", itemIndex == null ? new Item() : items.get(itemIndex));        
        return "form";
    }

    @PostMapping("/submitItem")
    public String handleSubmit(Item item, RedirectAttributes redirectAttributes) {
        Integer itemIndex = findItem(item.getId());
        String status = Constants.SUCCESS_STATUS;
        
        if(itemIndex == null) {
            items.add(item);
        } else if (within5Days(item.getDate(), items.get(itemIndex).getDate())){
            items.set(itemIndex, item);
        } else {
            status = Constants.FAILED_STATUS;
        }

        redirectAttributes.addFlashAttribute("status", status);
        return "redirect:/inventory";
    }
    
    @GetMapping("/inventory")
    public String getInventory(Model model) {
        model.addAttribute("items", items);
        return "inventory";
    }

    private Integer findItem(String id) {
        for(int index = 0; index < items.size(); index++) {
            if(items.get(index).getId().equals(id)) {
                return index;
            }
        }
        return null;
    }

    public boolean within5Days(Date newDate, Date oldDate) {
        long diff = Math.abs(newDate.getTime() - oldDate.getTime());
        return (int) (TimeUnit.MILLISECONDS.toDays(diff)) <= 5;
    }

    
}
