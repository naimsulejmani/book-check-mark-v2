package dev.naimsulejmani.bookcheckmarkv2.controllers;

import dev.naimsulejmani.bookcheckmarkv2.mappers.BookMapper;
import dev.naimsulejmani.bookcheckmarkv2.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService service;


    @GetMapping
    public String index(Model model) {
        model.addAttribute("books", service.findAll());
        return "books/index";
    }

}











