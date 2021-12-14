package com.lib.mvc.controller;

import com.lib.mvc.entity.*;
import com.lib.mvc.service.*;
import com.lib.mvc.validator.UserValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private TitleOfBookService titleOfBookService;

    @Autowired
    private BooksThatAreReadService booksThatAreReadService;

    @Autowired
    private FavoriteBooksService favoriteBooksService;

    @Autowired
    private ReadBookService readBookService;

    @Autowired
    private WantToReadService wantToReadService;

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new Profile());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") Profile userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getEmail(), userForm.getConfirmPassword());

        return "redirect:/welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Username or password is incorrect.");
        }

        if (logout != null) {
            model.addAttribute("message", "Logged out successfully.");
        }

        return "login";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {

        UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Profile profile = userDetail.getProfile();


//        List<BooksThatAreRead> titleOfBookThatAreReadList=booksThatAreReadService.getAllByProfile(profile);


        model.addAttribute("user", profile);

//        model.addAttribute("readsTitles",titleOfBookThatAreReadList);
//        model.addAttribute("title",new TitleOfBook());

        List<JS> genres = new ArrayList<>();

        List<TitleOfBook> allTitleOfBook = titleOfBookService.getAllBy();
        for (int i = 0; i < allTitleOfBook.size(); i++) {
            boolean b = true;
            for (int j = 0; j < genres.size(); j++) {
                if (genres.get(j).getName() == allTitleOfBook.get(i).getGenre().getTypeGenre()) {
                    genres.set(j, new JS(allTitleOfBook.get(i).getGenre().getTypeGenre(), genres.get(j).getCount() + 1));
                    b = false;
                    break;

                }
            }
            if (b) {
                genres.add(new JS(allTitleOfBook.get(i).getGenre().getTypeGenre(), 1));
            }
        }


//       List<JS> sections=new ArrayList<>();
//       sections.add(new JS("FavoriteBooks",(int)favoriteBooksService.count()));
//       sections.add(new JS("ReadBook",(int) readBookService.count()));
//       sections.add(new JS("BooksThatAreRead",(int) booksThatAreReadService.count()));
//       sections.add(new JS("WantToRead",(int) wantToReadService.count()));
//


        model.addAttribute("sections", genres);


        model.addAttribute("allTitle", allTitleOfBook);
        return "welcome";
    }

    @RequestMapping(value = "/BooksThatAreReadInfo", method = RequestMethod.GET)
    public String BooksThatAreReadInfo(Model model) {

        UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Profile profile = userDetail.getProfile();
        List<BooksThatAreRead> allTitleOfBook = booksThatAreReadService.getAllByProfile(profile);

        if (allTitleOfBook.size() > 0) {
            List<JS> genres = new ArrayList<>();
            for (int i = 0; i < allTitleOfBook.size(); i++) {
                boolean b = true;
                for (int j = 0; j < genres.size(); j++) {
                    if (genres.get(j).getName() == allTitleOfBook.get(i).getTitleOfBook().getGenre().getTypeGenre()) {
                        genres.set(j, new JS(allTitleOfBook.get(i).getTitleOfBook().getGenre().getTypeGenre(), genres.get(j).getCount() + 1));
                        b = false;
                        break;

                    }
                }
                if (b) {
                    genres.add(new JS(allTitleOfBook.get(i).getTitleOfBook().getGenre().getTypeGenre(), 1));
                }
            }
            model.addAttribute("sections", genres);
        }


        model.addAttribute("titleOfBookThatAreReadList", allTitleOfBook);
        model.addAttribute("user", profile);

        return "Books-that-are-read";
    }


    @RequestMapping(value = "/FavoriteBooksInfo", method = RequestMethod.GET)
    public String FavoriteBooksInfo(Model model) {

        UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Profile profile = userDetail.getProfile();
        List<FavoriteBooks> allTitleOfBook = favoriteBooksService.getAllByProfile(profile);
        if (allTitleOfBook.size() > 0) {
            List<JS> genres = new ArrayList<>();
            for (int i = 0; i < allTitleOfBook.size(); i++) {
                boolean b = true;
                for (int j = 0; j < genres.size(); j++) {
                    if (genres.get(j).getName() == allTitleOfBook.get(i).getTitleOfBook().getGenre().getTypeGenre()) {
                        genres.set(j, new JS(allTitleOfBook.get(i).getTitleOfBook().getGenre().getTypeGenre(), genres.get(j).getCount() + 1));
                        b = false;
                        break;

                    }
                }
                if (b) {
                    genres.add(new JS(allTitleOfBook.get(i).getTitleOfBook().getGenre().getTypeGenre(), 1));
                }
            }
            model.addAttribute("sections", genres);
        }


        model.addAttribute("favoriteBooksList", allTitleOfBook);
        model.addAttribute("user", profile);

        return "favorite-books";
    }


    @RequestMapping(value = "/ReadBookInfo", method = RequestMethod.GET)
    public String ReadBookInfo(Model model) {

        UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Profile profile = userDetail.getProfile();
        List<ReadBook> allTitleOfBook = readBookService.getAllByProfile(profile);
        if (allTitleOfBook.size() > 0) {
            List<JS> genres = new ArrayList<>();
            for (int i = 0; i < allTitleOfBook.size(); i++) {
                boolean b = true;
                for (int j = 0; j < genres.size(); j++) {
                    if (genres.get(j).getName() == allTitleOfBook.get(i).getTitleOfBook().getGenre().getTypeGenre()) {
                        genres.set(j, new JS(allTitleOfBook.get(i).getTitleOfBook().getGenre().getTypeGenre(), genres.get(j).getCount() + 1));
                        b = false;
                        break;

                    }
                }
                if (b) {
                    genres.add(new JS(allTitleOfBook.get(i).getTitleOfBook().getGenre().getTypeGenre(), 1));
                }
            }
            model.addAttribute("sections", genres);
        }

        model.addAttribute("readBookList", allTitleOfBook);
        model.addAttribute("user", profile);

        return "read-book";
    }


    @RequestMapping(value = "/WantToReadInfo", method = RequestMethod.GET)
    public String WantToReadInfo(Model model) {

        UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Profile profile = userDetail.getProfile();
        List<WantToRead> allTitleOfBook = wantToReadService.getAllByProfile(profile);
        if (allTitleOfBook.size() > 0) {
            List<JS> genres = new ArrayList<>();
            for (int i = 0; i < allTitleOfBook.size(); i++) {
                boolean b = true;
                for (int j = 0; j < genres.size(); j++) {
                    if (genres.get(j).getName() == allTitleOfBook.get(i).getTitleOfBook().getGenre().getTypeGenre()) {
                        genres.set(j, new JS(allTitleOfBook.get(i).getTitleOfBook().getGenre().getTypeGenre(), genres.get(j).getCount() + 1));
                        b = false;
                        break;

                    }
                }
                if (b) {
                    genres.add(new JS(allTitleOfBook.get(i).getTitleOfBook().getGenre().getTypeGenre(), 1));
                }
            }
            model.addAttribute("sections", genres);
        }


        model.addAttribute("wantToReadList", allTitleOfBook);
        model.addAttribute("user", profile);

        return "want-to-read";
    }


    @RequestMapping(value = "/deleteFavoriteBook")
    public String DeleteFavoriteBook(@RequestParam("bookId") int id) {
        favoriteBooksService.deleteByTitleOfBookTitleOfBookId(id);
        return "redirect:/FavoriteBooksInfo";
    }

    @RequestMapping(value = "/deleteWantToReadBook")
    public String DeleteWantToReadBook(@RequestParam("bookId") int id) {
        wantToReadService.deleteByTitleOfBookTitleOfBookId(id);
        return "redirect:/WantToReadInfo";
    }

    @RequestMapping(value = "/deleteReadBook")
    public String DeleteReadBook(@RequestParam("bookId") int id) {
        readBookService.deleteByTitleOfBookTitleOfBookId(id);
        return "redirect:/ReadBookInfo";
    }

    @RequestMapping(value = "/deleteBooksThatAreRead")
    public String DeleteBooksThatAreRead(@RequestParam("bookId") int id) {
        booksThatAreReadService.deleteByTitleOfBookTitleOfBookId(id);
        return "redirect:/BooksThatAreReadInfo";
    }


    @RequestMapping(value = "/autInfo", method = RequestMethod.GET)
    public String authorInfo(Model model, @RequestParam("aut") int id) {
        UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Profile profile = userDetail.getProfile();

        Author author = authorService.getById(id);


        System.out.println("" +
                "wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww" +
                id);


        model.addAttribute("author", author);
        model.addAttribute("user", profile);

        return "author-all-title";
    }

    @RequestMapping(value = "bookInfo", method = RequestMethod.GET)
    public String bookInfo(Model model, @RequestParam("book") int id) {
        UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Profile profile = userDetail.getProfile();
        TitleOfBook titleOfBook = titleOfBookService.getByTitleOfBookId(id);


//        HashMap<String,String>  section=new HashMap<>();
//        section.put("FavoriteBook","FavoriteBook");
//        section.put("WantToReadBook","WantToReadBook");
//        section.put("ReadBook","ReadBook");
//        section.put("BooksThatAreRead","BooksThatAreRead");
//
//
//        String s="";
//        model.addAttribute("sec",s);
//        model.addAttribute("section",section);
        model.addAttribute("user", profile);
        model.addAttribute("book", titleOfBook);
        return "add-book";
    }

    @RequestMapping(value = "/addBook", method = RequestMethod.POST)
    public String AddBook(String section, @RequestParam("book") int id) {

        System.out.println(section + " " + id);
        UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Profile profile = userDetail.getProfile();

        switch (section) {
            case "FavoriteBook":
                favoriteBooksService.save(new FavoriteBooks(titleOfBookService.getByTitleOfBookId(id), profile));
                break;
            case "WantToReadBook":
                wantToReadService.save(new WantToRead(titleOfBookService.getByTitleOfBookId(id), profile));
                break;
            case "ReadBook":
                readBookService.save(new ReadBook(titleOfBookService.getByTitleOfBookId(id), profile));
                break;
            case "BooksThatAreRead":
                booksThatAreReadService.save(new BooksThatAreRead(titleOfBookService.getByTitleOfBookId(id), profile));
                break;

        }

        return "redirect:/welcome";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(Model model,
                         @RequestParam("title") String title,
                         @RequestParam("author") String author,
                         @RequestParam("genre") String genre)  {


        List<TitleOfBook> allTitleOfBook = titleOfBookService.findByTitleContainsAndAuthorSurnameContainsAndGenreTypeGenreContains(title, author, genre);



        System.out.println(title + "-" + author + "-" + genre);
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");

        UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Profile profile = userDetail.getProfile();

        for (TitleOfBook t : allTitleOfBook
        ) {
            System.out.println(t.getTitle());
        }
        model.addAttribute("allTitle", allTitleOfBook);
        model.addAttribute("user", profile);
        return "search";
    }



}