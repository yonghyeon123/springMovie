package com.aia.springMovie.controller;

import com.aia.springMovie.model.UserDTO;
import com.aia.springMovie.service.MovieService;
import com.aia.springMovie.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/movie/")
public class MovieController {
    @Autowired
    private MovieService service;
    @Autowired
    private RateService rateService;

    private final int SIZE = 1;

    @GetMapping("showAll/{pageNo}")
    public String showAll(HttpSession session, Model model, @PathVariable int pageNo){
        UserDTO logIn = (UserDTO) session.getAttribute("logIn");
        if(logIn == null){
            return "redirect:/";
        }

        List<Map<Object, Object>> list = service.selectAll(pageNo, SIZE);
        model.addAttribute("list", list);

        int totalCount = service.countAll();
        int totalPage = totalCount / SIZE;
        if(totalCount % SIZE != 0){
            totalPage++;
        }

        int startPage = 1;
        int endPage = 5;

        if(pageNo > 3){
            startPage = pageNo - 2;
            endPage = pageNo + 2;
        }
        if(pageNo > totalPage - 3){
            startPage = totalPage - 4;
            endPage = totalPage;
        }if(totalPage <= 5){
            startPage = 1;
            endPage = totalPage;
        }

        Map rateMovieMap = rateService.AvgByMovieId();

        model.addAttribute(rateMovieMap);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("currentPage", pageNo);

        return "/movie/showAll";
    }
}
