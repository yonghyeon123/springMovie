package com.aia.springMovie.controller;

import com.aia.springMovie.model.UserDTO;
import com.aia.springMovie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/user/")
public class UserController {
    @Autowired
    private UserService service;


    @PostMapping("auth")
    public String auth(HttpSession session, UserDTO userDTO){
        UserDTO logIn = service.auth(userDTO);

        if(logIn != null){
            session.setAttribute("logIn", logIn);
            return "movie/showAll/1";
        }
        else{
            return "redirect:/";
        }
    }

    @GetMapping("register")
    public String moveToRegister(){
        return "/user/register";
    }

    @PostMapping("register")
    public String register(UserDTO userDTO, Model model){
        //username이 중복인 아이디가 없다면
        if(!service.validateUsername(userDTO)){
            //회원가입 진행
            service.register(userDTO);
            return "redirect:/";
        }
        else{
            return "redirect:/user/register";
        }
    }


}
