package com.hly.clientservice.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/4/24
 */
@RestController
public class TestController {


    @RequestMapping("/hi")
    public String hi(){
        return "hi";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")  //
    @RequestMapping("/hello")
    public String hello (){
        return "hello";
    }

    //@PreAuthorize("hasAuthority('ROLE_STUDENT')")  //
    @RequestMapping("/student")
    public String student (){
        return "student";
    }

    @GetMapping("/getPrinciple")
    public OAuth2Authentication getPrinciple(OAuth2Authentication oAuth2Authentication, Principal principal,
                                             Authentication authentication){

        System.err.println(oAuth2Authentication.getUserAuthentication().getAuthorities().toString());
        System.err.println(oAuth2Authentication.toString());
        System.err.println("principal.toString()"+principal.toString());
        System.err.println("principal.getName()"+principal.getName());
        System.err.println("authentication:"+authentication.getAuthorities().toString());

        return oAuth2Authentication;

    }


}
