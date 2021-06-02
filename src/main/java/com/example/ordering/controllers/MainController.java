package com.example.ordering.controllers;

import com.example.ordering.pagesbehavior.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class MainController {
    @Autowired
    private ItemsRepository itemsRepository;
    @Autowired
    private ColorsRepository colorsRepo;
    @Autowired
    private MaterialsRepository materialsRepo;

    @PostMapping("/shape/add")
    public @ResponseBody
    String addNewItem(@RequestBody Items item) {
        itemsRepository.save(item);
        return "OK";
    }


    @PostMapping("/color/add")
    public @ResponseBody
    String addNewColor(@RequestBody Colors color) {
        colorsRepo.save(color);
        return "OK";
    }

    @PostMapping("/material/add")
    public @ResponseBody
    String addNewMaterial(@RequestBody Materials material) {
        materialsRepo.save(material);
        return "OK";
    }

    @GetMapping("/basket")
    public @ResponseBody
    Iterable<Items> getAllItems() {
        return itemsRepository.findAll();
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("items", itemsRepository.findAll());
        model.addAttribute("colors", colorsRepo.findAll());
        model.addAttribute("materials", materialsRepo.findAll());
        return "homepage";
    }
}