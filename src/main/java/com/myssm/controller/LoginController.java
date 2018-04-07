package com.myssm.controller;

import com.myssm.model.User;
import com.myssm.service.UserService;
import com.myssm.util.DefinedMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author :hly
 * @date :2018/4/6
 */

/**
 * @Repository：用于标注数据访问组件，即DAO组件我们注解这个类，更多的是对它有个数据库操作的管理
 * @Service：用于业务层
 * @Controller：控制层（Web 层）
 */
@Controller
@RequestMapping(value = "/user")
public class LoginController {
    @Resource
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    /**
     * 和jsp参数不一致可以用@ModelAttribute("username") String userid来接收，详情看书
     */
    public String login(@ModelAttribute("username") String userid, String password, DefinedMessage definedMessage, RedirectAttributes attributes,
                        HttpServletRequest request, HttpSession session, ModelMap map) {
        User user = userService.selectUserByUserid(userid);
        if (user == null) {
           attributes.addFlashAttribute("error", definedMessage.LOGIN_USERID_ERROR);
            //map.addAttribute("error",definedMessage.LOGIN_USERID_ERROR);
            return "redirect:/user/login";
        } else {
            if (!user.getPassword().equals(password)) {
                attributes.addFlashAttribute("error", definedMessage.LOGIN_PASSWORD_ERROR);
                //map.addAttribute("error",definedMessage.LOGIN_USERID_ERROR);
                return "redirect:/user/login";
            } else {
                /**
                 * session.setAttribute("sessionName",Object);
                 用来设置session值的，sessionName是名称，object是你要保存的对象。
                 session.getAttribute("sessionName");
                 用来得到对应名称的session值，即得到object对象，注意需要进行类型转换！
                 */
                //session.setAttribute("userid", userid);
                //session.setAttribute("login_status", true);
                attributes.addFlashAttribute("message", definedMessage.LOGIN_SUCCESS);
                return "redirect:/register";
            }
        }
    }
}



