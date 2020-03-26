package com.recruting.recruting.controller;

import com.recruting.recruting.models.Company;
import com.recruting.recruting.repositories.CompanyRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@Data
public class MainPageController {
    private final CompanyRepository companyRepository;

    @GetMapping("/")
    public String getMainPage(Model model) {
        List<Company> companyList = companyRepository.findAll();
        model.addAttribute("companies", companyList);
        return "mainPage";
    }

    @GetMapping("/test1")
    @ResponseBody
    public String getPost() {
        return "{\"status\":\"ok\"}";
    }


    @GetMapping("/test2/{pathV}")
    @ResponseBody
    public void getTest2(@PathVariable String pathV) {
        System.out.println("pathV = " + pathV);
    }

    @GetMapping("/test3")
    @ResponseBody
    public void getTest3(@RequestBody(required = false) String body) {
        if(body == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "lkdjfglsdjflgl;sdfg ");
        System.out.println("body = " + body);
    }

    @GetMapping("/test4")
    @ResponseBody
    public void getTest4(@RequestParam String paran, @RequestParam Integer id, HttpServletRequest httpServletRequest) {
        System.out.println("paran = " + paran);
        System.out.println("id = " + id);
        System.out.println("httpServletRequest = " + httpServletRequest);
    }
}
