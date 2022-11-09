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
            return "redirect:/movie/showAll/1";
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
            model.addAttribute("message", "해당 아이디가 이미 존재합니다.");
            model.addAttribute("userDTO", userDTO);

            return "user/register";
        }

        service.register(userDTO);
        return "redirect:/";
    }

    @GetMapping("index")
    public String showIndex(HttpSession session, Model model){
        UserDTO logIn = (UserDTO) session.getAttribute("logIn");
        if(logIn == null){
            return "redirect:/";
        }

        model.addAttribute("logIn", logIn);

        return "/user/index";
    }

    @GetMapping("update")
    public String goToUpdate(HttpSession session, Model model){
        UserDTO logIn = (UserDTO) session.getAttribute("logIn");
        if(logIn == null){
            return "redirect:/";
        }

        model.addAttribute("logIn", logIn);

        return "/user/update";
    }

    @PostMapping("update")
    public String update(HttpSession session, Model model, UserDTO userDTO, String newPassword){
        UserDTO logIn = (UserDTO) session.getAttribute("logIn");

        //입력한 기존 비밀번호가 틀렸을 경우
        if(service.auth(userDTO) == null){
            model.addAttribute("logIn", logIn);
            model.addAttribute("message", "비밀번호가 일치하지 않습니다.");
            return "/user/update";
        }

        if(newPassword != null){
            logIn.setPassword(newPassword);
        }

        logIn.setNickname(userDTO.getNickname());

        service.update(logIn);

        session.setAttribute("logIn", logIn);
        return "/user/index";
    }

    @GetMapping("delete")
    public String delete(HttpSession session){
        UserDTO logIn = (UserDTO) session.getAttribute("logIn");
        //System.out.println(logIn);
        if(logIn == null){
            return "redirect:/";
        }

        service.delete(logIn.getId());

        return "redirect:/";
    }

    @GetMapping("logOut")
    public String logOut(HttpSession session){
        session.removeAttribute("logIn");
        return "redirect:/";
    }

    @GetMapping("generate")
    public String generate(){
        for(int i = 1; i <= 3; i++){
            UserDTO u = new UserDTO();
            u.setUsername("user" + i);
            u.setPassword("" + i);
            u.setNickname("평론가" + i);
            u.setGrade(2);
            service.register(u);
        }

        for(int i = 4; i <= 8; i++){
            UserDTO u = new UserDTO();
            u.setUsername("user" + i);
            u.setPassword("" + i);
            u.setNickname("관람객" + i);
            u.setGrade(1);
            service.register(u);
        }

        return "redirect:/";
    }
}
