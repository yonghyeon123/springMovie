package com.aia.springMovie.controller;

import com.aia.springMovie.model.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/movie/")
public class MovieController {
    @GetMapping("showAll")
    public String showAll(HttpSession session){
        UserDTO logIn = (UserDTO) session.getAttribute("logIn");
        if(logIn == null){
            return "redirect:/";
        }

        return "/movie/showAll";
    }
}
