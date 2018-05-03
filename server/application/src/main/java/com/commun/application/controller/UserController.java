package com.commun.application.controller;

import com.commun.application.entity.User;
import com.commun.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "/user") // Map ONLY GET Requests
    public @ResponseBody
    Iterable<User> getAllUsers() {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        return userRepository.findAll();
    }


    @PostMapping(path = "/user") // Map ONLY GET Requests
    public @ResponseBody
    /*String addNewUser(@RequestParam String name
            , @RequestParam String email) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        User n = new User();
        n.setName(name);
        n.setEmail(email);
        userRepository.save(n);
        return "Saved";
    }*/

    String addNewUser(@RequestBody User user) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        User u = new User();
        u.setName(user.getName());
        u.setEmail(user.getEmail());
        userRepository.save(u);
        return "Saved";
    }


}
