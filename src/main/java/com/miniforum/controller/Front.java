package com.miniforum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Front {

    @GetMapping(value = {"/index", "/"})
    public String getIndex() {
        return "index";
    }

    @GetMapping("/general")
    public String paramsPage() {
        return "general";
    }




}

