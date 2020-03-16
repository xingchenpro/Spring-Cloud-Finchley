package com.javahly.userservice.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2020/3/16
 * @QQ :1136513099
 * @desc :
 */
@RestController
public class UserController {


    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/guest")
    public String guest() {
        return "guest";
    }
}
