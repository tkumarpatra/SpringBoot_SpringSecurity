package com.fse.cts.web;

import com.fse.cts.model.User;
import com.fse.cts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ModelAndView root(HttpServletRequest request, ModelAndView modelAndView) {

        String email = null != request ? request.getUserPrincipal().getName(): "";
        User user = userService.findByEmail(email);
        modelAndView.addObject("user", user);
        modelAndView.setViewName("update");
        return modelAndView;
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/user")
    public String userIndex() {
        return "user/index";
    }
}
