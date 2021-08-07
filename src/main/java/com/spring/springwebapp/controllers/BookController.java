package com.spring.springwebapp.controllers;

import com.spring.springwebapp.commands.BookCommand;
import com.spring.springwebapp.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/book/show/{id}")
    public String showById(@PathVariable String id, Model model) {
        model.addAttribute("book", bookService.findById(Long.valueOf(id)));

        return "book/show";
    }

    @RequestMapping("book/new")
    public String newBook(Model model) {
        model.addAttribute("book", new BookCommand());

        return "book/bookform";
    }

    @PostMapping("book")
    public String saveOrUpdate(@ModelAttribute BookCommand command) {
        System.out.println(command.toString());
        BookCommand savedCommand = bookService.saveBookCommand(command);

        return "redirect:/book/show/" + savedCommand.getId();
    }

    @GetMapping
    @RequestMapping("book/{id}/delete")
    public String deleteById(@PathVariable String id) {

        bookService.deleteById(Long.valueOf(id));
        return "redirect:/";
    }

    @RequestMapping("book/{id}/update")
    public String updateBook(@PathVariable String id, Model model) {
        model.addAttribute("book", bookService.findCommandById(Long.valueOf(id)));
        return "book/bookform";
    }

}
