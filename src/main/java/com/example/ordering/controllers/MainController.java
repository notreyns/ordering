package com.example.ordering.controllers;

import com.example.ordering.pagesbehavior.Items;
import com.example.ordering.pagesbehavior.MainOrdering;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

@Controller
public class MainController {
    MainOrdering orders=new MainOrdering("3d ordering");

    @PostConstruct
    public void addcustomers(){

        orders.add_item(new Items("Cone",45.5,"cone"));
        orders.add_item(new Items("Cylinder",122.5,"cylinder"));
        orders.add_item(new Items("Sphere",12.5,"sphere"));
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Ordering");
        return "homepage";
    }

    @GetMapping("/basket")
    public String basket(Model model) {
        model.addAttribute("title", "Basket");
        return "basket";
    }
}