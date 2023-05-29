package com.luv2code.springboot.thymeleafdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.luv2code.springboot.thymeleafdemo.entity.Policy;
import java.util.List;


public interface PolicyRepository extends JpaRepository<Policy, Integer> {

    // that's it ... no need to write any code LOL!

    // add a method to sort by last name
    public List<Policy> findAllByOrderByLastNameAsc();

}