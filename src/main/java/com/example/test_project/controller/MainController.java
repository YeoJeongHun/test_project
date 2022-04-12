package com.example.test_project.controller;

import com.example.test_project.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MainController {

//    @Autowired
    ArticleService articleService;

    @RequestMapping(method = RequestMethod.GET, path = "/test")
    public String testRequest() {
        return "hihi";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/doWrite")
    public String doWrite() {
        articleService.doWrite("test", "test");
        return "성공";
    }
}
