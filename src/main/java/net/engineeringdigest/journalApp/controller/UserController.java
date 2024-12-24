package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getAllUser")
    public ResponseEntity<?> getAllUser(){
        List<User> list = this.userService.getAllUser();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/createUser/{User}")
    public User createUser(@RequestBody User user){
        User user1 = this.userService.createUser(user);
        return new ResponseEntity<>(user1, HttpStatus.CREATED).getBody();
    }


}
