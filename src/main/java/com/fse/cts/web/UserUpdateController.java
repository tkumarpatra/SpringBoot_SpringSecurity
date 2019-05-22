package com.fse.cts.web;


import com.fse.cts.model.User;
import com.fse.cts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/update")
public class UserUpdateController {

    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public User user() {
        return new User();
    }

    @PostMapping
    public String updateUserAccount(@ModelAttribute("user") User user,
                                      BindingResult result){

        User existing = userService.findByEmail(user.getEmail());

        if (result.hasErrors()){
            return "registration";
        }
        user.setRoles(existing.getRoles());
        user.setId(existing.getId());
        userService.saveUser(user);
        return "redirect:/?success";
    }
}
