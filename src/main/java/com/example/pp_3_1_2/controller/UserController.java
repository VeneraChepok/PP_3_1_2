package com.example.pp_3_1_2.controller;


import com.example.pp_3_1_2.model.User;
import com.example.pp_3_1_2.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String showAllUser(ModelMap model) {
        List<User> messages = userService.getAllUser();
        model.addAttribute("messages", messages);
        return "users";
    }

    @GetMapping("/addNewUser")
    public String addNewUser(ModelMap model) {
        model.addAttribute("messages", new User());
        return "userInfo";
    }

    @PostMapping("/addNewUser")
    public String addUser(@ModelAttribute("messages") User user) {
        userService.add(user);

        return "redirect:/user";
    }

    @PatchMapping("/user-update/{id}")
    public String editUserInfo(@PathVariable("id") Long id, ModelMap model) {
        User messages = userService.getUser(id);
        model.addAttribute("messages", messages);
        return "userInfo";
    }

    @PostMapping()
    public String updateUser(@ModelAttribute("messages") User user) {
        userService.updateUser(user);
        return "redirect:/user";
    }

    @DeleteMapping("user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/user";

    }

}