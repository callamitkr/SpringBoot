package com.amit.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amit.model.UserRecord;
import com.amit.repository.UserRepository;
@Service  
public class UserService {  
    @Autowired  
    private UserRepository userRepository;  
    public List<UserRecord> getAllUsers(){  
        List<UserRecord>userRecords = new ArrayList<>();  
        userRepository.findAll().forEach(userRecords::add);  
        return userRecords;  
    }  
    public UserRecord getUser(Long id){
        return userRepository.findOne(id);  
    }  
    public void addUser(UserRecord userRecord){  
        userRepository.save(userRecord);  
    }  
    public void delete(Long id){
        userRepository.delete(id);  
    }

    public List<UserRecord> getUserBySalaryRange(int sal1,int sal2){
        List<UserRecord>userRecords = new ArrayList<>();
        userRepository.findBySalaryBetween(sal1,sal2).forEach(userRecords::add);
        return userRecords;
    }
    public UserRecord findBySalary(int sal){
        return userRepository.findBySalary(sal);
    }
}  