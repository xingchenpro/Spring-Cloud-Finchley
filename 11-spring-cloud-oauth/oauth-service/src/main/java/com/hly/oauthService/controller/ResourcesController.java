package com.hly.oauthService.controller;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/11/20
 */

@RestController
public class ResourcesController {
    @GetMapping("/article/{id}")
    public String getArticle(@PathVariable String id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.err.println("articleAuth："+authentication);
        return "article id : " + id;
    }

    @GetMapping("/video/{id}")
    public String getVideo(@PathVariable String id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.err.println("videoAuth："+authentication);
        return "video id : " + id;
    }

    @GetMapping("/book/{id}")
    public String getBook(@PathVariable String id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.err.println("videoAuth："+authentication);
        return "book id : " + id;
    }

    @GetMapping("/403")
    public String error403(){
        return "403没有权限";
    }

}
