package com.example.projectwork.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/homepage")
public class homepageCtrl {
    @GetMapping
    public String homeCliente() {
        return "homepage";
    }

}
