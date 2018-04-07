package com.myssm.controller;

import com.myssm.model.User;
import com.myssm.service.UserService;
import com.myssm.util.DefinedMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author :hly
 * @date :2018/4/7
 */

/**
 * )//①将ModelMap中属性名为"users"的属性
 * //放到Session属性列表中，以便这个属性可以跨请求访问
 */
@Controller
@RequestMapping(value = "/user")
//@SessionAttributes("userid")
public class RegisterController {
    @Resource
    private UserService userService;
    /**
     * 聊天主页
     */
    /**
     * ModelAndView构造方法可以指定返回的页面名称，
     * 也可以通过setViewName()方法跳转到指定的页面 ,
     */
    /**
     * 也可以这样写：
     *
     * @RequestMapping(value = "register")
     * public String getIndex() {
     * return "register";
     * }
     * <p>
     * https://blog.csdn.net/shuduti/article/details/53540142,@PathVariable("userid")
     * ModelAndView对象有两个作用：
     * 作用一 设置转向地址,如下所示（这也是ModelAndView和ModelMap的主要区别）
     * ModelAndView view = new ModelAndView("path:ok");
     * 作用二 用于传递控制方法处理结果数据到结果页面，也就是说我们把需要在结果页面上需要的数据放到ModelAndView对象中即可，他的作用类似于request对象的setAttribute方法的作用，用来在一个请求过程中传递处理的数据。通过以下方法向页面传递参数：
     * addObject(String key,Object value);
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(String username, String password, String phone_number, String email, DefinedMessage definedMessage, RedirectAttributes attributes,
                           HttpServletRequest request, HttpSession session, ModelMap map) {
        User user = userService.selectUserByUserid(username);
        /**
         * 这里要抛出异常
         */
        try {
            if (user.getUserid() != null) {
                attributes.addFlashAttribute("error", definedMessage.REGISTER_EXIT);
                return "redirect:/user/register";
            }
        }catch (Exception e){
        }
        finally {
            attributes.addFlashAttribute("error", username);
            User newUser = new User(username, password, username, 1, 1, "1", "1", "1", "1", 1);
            //newUser.setUserid(username);
            //newUser.setPassword(password);
            userService.insert(newUser);
            return "redirect:/index";
        }

    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "register";
    }

}
