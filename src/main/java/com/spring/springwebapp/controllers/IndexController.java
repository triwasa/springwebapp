package com.spring.springwebapp.controllers;

import com.spring.springwebapp.services.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class IndexController {

    private final BookService bookService;

    public IndexController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping({"", "/", "index"})
    public String index(Model model) {

        model.addAttribute("books", bookService.getBooks());

        return "index";

    }
}
