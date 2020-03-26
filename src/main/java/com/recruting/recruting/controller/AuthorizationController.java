package com.recruting.recruting.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthorizationController {

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public void doLogin(@RequestBody String body) {
        System.out.println("body = " + body);
    }

    @PostMapping("/logout")
    @ResponseStatus(HttpStatus.OK)
    public void doLogout() {

    }

    @GetMapping("/registration")
    public String getRegistrationPageForSeeker() {
        /**
         * {
         *     "login": "asfasdf",
         *     "pass": "adsfasdf",
         *     "email": "asfsdaf",
         *     "phone": "880809",
         *     ?
         * }
         *
         * */
        return "registration2";
    }

    @GetMapping("/registration2")
    public String getRegistrationPageForCompanies() {
        /**
         * {
         *     "login": "asfasdf",
         *     "pass": "adsfasdf",
         *     "email": "asfsdaf",
         *     "phone": "880809",
         *     ?
         * }
         *
         * */
        return "registration";
    }

    @PostMapping("/registration")
    @ResponseBody
    public ResponseEntity doRegistration(@RequestBody String body) {
        System.out.println("body = " + body);
        return new ResponseEntity("response", HttpStatus.OK);
    }

    @PostMapping("/registration2")
    @ResponseBody
    public ResponseEntity doRegistration2(@RequestBody String body) {
        System.out.println("body = " + body);
        return new ResponseEntity("response", HttpStatus.OK);
    }
}
