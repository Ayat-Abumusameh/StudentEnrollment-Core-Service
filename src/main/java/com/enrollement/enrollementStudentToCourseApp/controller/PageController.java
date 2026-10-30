package com.enrollement.enrollementStudentToCourseApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String index() {
        return "index"; // it will open index.html automatically (it exist in templates folder)
    }
}
