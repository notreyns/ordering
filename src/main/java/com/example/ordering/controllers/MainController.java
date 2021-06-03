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
    @Autowired
    private BasketRepository basketRepo;

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
    public String basket(Model model){
        model.addAttribute("orders",basketRepo.findAll() );
        return "basket";
    }
    @PostMapping("/orders/add")
    public String addNewOrder(@RequestParam String name,@RequestParam String colorradio, @RequestParam String materialradio, Model model) {
        Basket item=new Basket(name,colorradio, materialradio);
        basketRepo.save(item);
        return "redirect:/";
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("items", itemsRepository.findAll());
        model.addAttribute("colors", colorsRepo.findAll());
        model.addAttribute("materials", materialsRepo.findAll());
        return "homepage";
    }
    @PostMapping("/orders/{id}/delete")
    public String orderDelete(@PathVariable(value="id") int id, Model model){
        Basket item = basketRepo.findById(id).orElseThrow(IllegalStateException::new);
        basketRepo.delete(item);
        return "redirect:/basket";
    }
}