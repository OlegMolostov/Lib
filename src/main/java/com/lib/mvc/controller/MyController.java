//package com.lib.mvc.controller;
//
//
//import com.lib.mvc.entity.*;
//
//import com.lib.mvc.service.AuthorService;
//import com.lib.mvc.service.ProfileService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.List;
//
//@Controller
//public class MyController {

//    @Autowired
//    private ProfileService profileService;
//
//    @Autowired
//    private AuthorService authorService;
//
//
//    @GetMapping("/registration")
//    public String registration(Model model){
//        return "registration";
//    }
//
//    @PostMapping("/registration")
//    public String addUser(){
//        return "login1";
//    }
//
//
//    @RequestMapping("/")
//    public String loggin(Model model) {
//
//        List<TitleOfBook> allTitleOfBook = profileService.getAllTitleTheOfBook();
//        model.addAttribute("allTitle", allTitleOfBook);
//
//        return "loggin";
//    }
//
//    @RequestMapping("/authorAllTitle")
//    public String authorAllTitle(@RequestParam("autId") int id,
//            Model model) {
//
//        model.addAttribute("author",authorService.getAuthor(id));
//        model.addAttribute("authorAllTitles",authorService.getTitleOfBookList(id));
//
//        return "author-all-title";
//    }
//}
