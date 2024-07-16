package com.lab.product_management_system.controllers;

import com.lab.product_management_system.model.AdditionalData;
import com.lab.product_management_system.services.AdditionalDataServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdditionalDataController {

    private final AdditionalDataServices additionalDataService;

    public AdditionalDataController(AdditionalDataServices additionalDataService) {
        this.additionalDataService = additionalDataService;
    }

    @GetMapping("/additional-data")
    public String showAdditionalData(Model model) {
        model.addAttribute("additionalData", additionalDataService.getAllData());
        return "additional-data";
    }

    @PostMapping("/additional-data")
    public String createAdditionalData(@RequestParam String key, @RequestParam String value) {
        AdditionalData data = new AdditionalData();
        data.setKey(key);
        data.setValue(value);
        additionalDataService.createData(data);
        return "redirect:/additional-data";
    }
}
