package com.example.zadanie_201;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/add")
        //Nie rozumiem jak ma dzialac ten adres "/add?imie=Daniel&nazwisko=Abacki&wiek=15", wyskakiwal mi error ciagle
    String addUser(@RequestParam(defaultValue = "true", name = "imie") String name,
                   @RequestParam(name = "nazwisko") String lastName,
                   @RequestParam(name = "wiek") int age) {
        if (name.equals(null)) { //Tutaj tez nie wiem czemu gdy nie podaje imienia to nie dziala
            return "redirect:/err.html";
        } else {
            userRepository.addUser(new User(name, lastName, age));
            return "redirect:/success.html";
        }
    }

    @GetMapping("/users")
    @ResponseBody
    String printUserList() {
        userRepository.addUser(new User("Daniel", "Abacki", 36));
        userRepository.addUser(new User("Jan", "Kowalski", 22));
        userRepository.addUser(new User("Basia", "Zawadzka", 17));
        StringBuilder result = new StringBuilder();
        for (User user : userRepository.getUserList()) {
            result.append(user.getFirstName()).append(" ").append(user.getLastName()).append(", wiek: ").append(user.getAge()).append("<br/>");
        }
        return result.toString();
    }
}
