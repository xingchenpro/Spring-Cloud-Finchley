package com.myssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author :hly
 * @date :2018/4/8
 */
@Controller
public class IndexController {
    @RequestMapping(value = "index")
    public ModelAndView getIndex(){
        ModelAndView view = new ModelAndView("index");
        return view;
    }

}
