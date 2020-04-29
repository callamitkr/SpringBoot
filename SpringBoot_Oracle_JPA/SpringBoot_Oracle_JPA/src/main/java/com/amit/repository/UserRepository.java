package com.amit.repository;

import org.springframework.data.repository.CrudRepository;

import com.amit.model.UserRecord;

import java.util.List;

public interface UserRepository extends CrudRepository<UserRecord, Long> {

   List<UserRecord> findBySalaryBetween(int sal1, int sal2);
   UserRecord findBySalary(int sal);
}  