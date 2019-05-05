package com.hly.oauthservice.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.security.Principal;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/4/20
 */

@RestController
public class UserController {

    @RequestMapping(value = "/current", method = RequestMethod.GET)
    public Principal getUser(Principal principal) {
        return principal;
    }


    //@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/session", method = RequestMethod.GET)
    public String session(HttpServletRequest request){
        if(request.getSession()!=null)
            System.err.println(request.getSession());
        return String.valueOf(request.getSession());
    }

    @RequestMapping("/hi")
    public String hi(){
        return "hi";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")  //
    @RequestMapping("/hello")
    public String hello (){
        return "hello";
    }

    @PreAuthorize("hasAuthority('ROLE_STUDENT')")  //
    @RequestMapping("/student")
    public String student (){
        return "student";
    }

    @GetMapping("/getPrinciple")
    public Object getPrinciple(OAuth2Authentication oAuth2Authentication, Principal principal,
                                             Authentication authentication){
        System.err.println(oAuth2Authentication.getUserAuthentication().getAuthorities().toString());
        System.err.println(oAuth2Authentication.toString());
        System.err.println("principal.toString()"+principal.toString());
        System.err.println("principal.getName()"+principal.getName());
        System.err.println("authentication:"+authentication.getAuthorities().toString());

        return authentication.getAuthorities().toString();
    }
}
