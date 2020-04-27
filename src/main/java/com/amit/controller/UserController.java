package com.amit.controller;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.RequestBody;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.bind.annotation.RestController;

import com.amit.model.UserRecord;
import com.amit.service.UserService;

import java.util.List;  
  
@RestController  
public class UserController {  
    @Autowired  
    private UserService userService;   
    @RequestMapping("/")  
    public List<UserRecord> getAllUser(){  
        return userService.getAllUsers();  
    }     
    @RequestMapping(value="/add-user", method=RequestMethod.POST)  
    public void addUser(@RequestBody UserRecord userRecord){  
        userService.addUser(userRecord);  
    }  
    @RequestMapping(value="/user/{id}", method=RequestMethod.GET)  
    public UserRecord getUser(@PathVariable Long id){
        return userService.getUser(id);  
    }
    @RequestMapping(value="/userBySalaryRange/{sal1}/{sal2}", method=RequestMethod.GET)
    public List<UserRecord> getUserBySalaryRange(@PathVariable int sal1,@PathVariable int sal2){

        return userService.getUserBySalaryRange(sal1,sal2);
    }
    @RequestMapping(value="/userBySalary/{sal1}", method=RequestMethod.GET)
    public UserRecord getUserBySalaryRange(@PathVariable int sal1){

        return userService.findBySalary(sal1);
    }
}  
