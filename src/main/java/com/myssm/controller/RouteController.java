package com.myssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author :  Amayadream
 * Date   :  2016.01.09 17:54
 * TODO   :  路由控制器
 */
@Controller
@RequestMapping(value = "")
public class RouteController {
    /**
     * @param：设置tomcat默认启动页面，否则tomcat启动后404，需要输入url才能访问
     * @return
     */
    @RequestMapping(value = "")
    public String index() {
        return "redirect:/user/login";
    }
    @RequestMapping(value = "/about")
    public String about() {
        return "about";
    }

    @RequestMapping(value = "/help")
    public String help() {
        return "help";
    }

    @RequestMapping(value = "/system")
    public String system() {
        return "system-setting";
    }

}
