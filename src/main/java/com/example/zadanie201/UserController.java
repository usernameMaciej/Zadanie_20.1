package com.example.zadanie201;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping("/add")
    String addUser(@RequestParam(required = false, name = "imie") String name,
                   @RequestParam(name = "nazwisko") String lastName,
                   @RequestParam(name = "wiek") int age) {
        if (!StringUtils.hasText(name)) {
            return "redirect:/err.html";
        } else {
            userRepository.addUser(new User(name, lastName, age));
            return "redirect:/success.html";
        }
    }

    @GetMapping("/users")
    @ResponseBody
    String printUserList() {
        StringBuilder result = new StringBuilder();
        for (User user : userRepository.getUserList()) {
            result.append(user.getFirstName()).append(" ").append(user.getLastName()).append(", wiek: ").append(user.getAge()).append("<br/>");
        }
        return result.toString();
    }
}
