package com.example.taskmanagementapi.Controller;

import com.example.taskmanagementapi.CustomException.UserNameAlreadyExistsException;
import com.example.taskmanagementapi.CustomException.UserNotFoundException;
import com.example.taskmanagementapi.Entity.User;
import com.example.taskmanagementapi.Service.Implementation.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity saveUser(@RequestBody User user) throws UserNameAlreadyExistsException {
        try {
            userService.saveUser(user);
            return new ResponseEntity("New User Created", HttpStatus.CREATED);
        }
        catch (UserNameAlreadyExistsException e)
        {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        catch (Exception e)
        {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getUserById/{userId}")
    public ResponseEntity getUserById(@PathVariable Long userId) throws UserNotFoundException {
        try {
            User user = userService.getUserById(userId);
            return new ResponseEntity(user, HttpStatus.OK) ;
        }
        catch (UserNotFoundException e)
        {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        catch (Exception e)
        {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getUserByUsername")
    public ResponseEntity getUserByUsername(@RequestParam String username) throws UserNotFoundException {
        try {
            User user = userService.getUserByUsername(username);
            return new ResponseEntity(user, HttpStatus.OK);
        }
        catch (UserNotFoundException e)
        {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        catch (Exception e)
        {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
