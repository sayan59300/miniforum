package com.miniforum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FrontController {

    @GetMapping(value = {"/index", "/"})
    public String getIndex() {
        return "index";
    }

    @GetMapping("/newSubjectAccess")
    public String getSubjectAccess() {
        return "newSubject";
    }

    @GetMapping("/general")
    public String paramsPage() {
        return "general";
    }




}

