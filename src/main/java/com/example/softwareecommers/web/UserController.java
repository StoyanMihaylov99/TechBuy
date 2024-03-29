package com.example.softwareecommers.web;

import com.example.softwareecommers.models.dtos.UserEntityDTO;
import com.example.softwareecommers.services.Impl.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
    private final UserServiceImpl userServiceImpl;

    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }


    @GetMapping("/register")
    public String getRegister(Model model) {
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute(name = "user") UserEntityDTO user) {
        userServiceImpl.registerUser(user);
        return "login";
    }


    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }





}
