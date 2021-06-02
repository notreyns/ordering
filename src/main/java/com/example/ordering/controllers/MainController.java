package com.example.ordering.controllers;

import com.example.ordering.pagesbehavior.Items;
import com.example.ordering.pagesbehavior.ItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("/")
public class MainController {
    @Autowired
    private ItemsRepository itemsRepository;

    @PostMapping("/add")
    public @ResponseBody
    String addNewUser(@RequestBody Items item) {
        itemsRepository.save(item);
        return "OK";
    }

    @GetMapping("/basket")
    public @ResponseBody
    Iterable<Items> getAllItems() {
        return itemsRepository.findAll();
    }
}