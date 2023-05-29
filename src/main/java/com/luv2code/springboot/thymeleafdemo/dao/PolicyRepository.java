package com.luv2code.springboot.thymeleafdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.luv2code.springboot.thymeleafdemo.entity.Policy;
import java.util.List;


public interface PolicyRepository extends JpaRepository<Policy, Integer> {

    // add a method to sort by last name
    // public List<Policy> findAllByOrderByLastNameAsc();
    public List<Policy> findAllByOrderByIdAsc();

}