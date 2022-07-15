package ru.kata_3_1_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.kata_3_1_1.model.User;
import ru.kata_3_1_1.service.UserService;
import ru.kata_3_1_1.service.UserServiceImpl;

import javax.validation.Valid;

@Controller

public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/")
    public String printCars (Model model){
        model.addAttribute("allUsers", userService.allUsers());

        return "printuser";
    }

    @GetMapping("/{id}")
    public String getUserById (@PathVariable("id") long id, Model model){
        model.addAttribute("userById", userService.getById(id));
        return "userbyid";
    }

    @GetMapping("/newuser")
    public String newUser (Model model){
        model.addAttribute("newPerson", new User());

        return "newuser";
    }

    @PostMapping
    public String create (@ModelAttribute("newPerson") @Valid User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "newuser";
        }
        userService.createUser(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/update")
    public String updateUser ( @PathVariable("id") long id, Model model){
        model.addAttribute("userById", userService.getById(id));
        return "update";
    }
    @PatchMapping("/{id}")
    public String update (@ModelAttribute("updateUser") @Valid User user, BindingResult bindingResult,
                          @PathVariable("id") long id){
        if (bindingResult.hasErrors()) {
            return "update";
        }
        userService.updateUser(user);
        return "redirect:/";

    }
    @DeleteMapping("/{id}")
    public String delete ( @PathVariable("id") long id){
        userService.deleteUser(id);
        return "redirect:/";

    }
}
