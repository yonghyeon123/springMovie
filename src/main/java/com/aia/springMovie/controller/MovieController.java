package com.aia.springMovie.controller;

import com.aia.springMovie.model.UserDTO;
import com.aia.springMovie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/movie/")
public class MovieController {
    @Autowired
    private MovieService service;

    @GetMapping("showAll/{pageNo")
    public String showAll(HttpSession session, @PathVariable int pageNo){
        UserDTO logIn = (UserDTO) session.getAttribute("logIn");
        if(logIn == null){
            return "redirect:/";
        }



        return "/movie/showAll";
    }
}
