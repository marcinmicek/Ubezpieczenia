package com.luv2code.springboot.thymeleafdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.luv2code.springboot.thymeleafdemo.entity.Policy;
import java.util.List;


public interface PolicyRepository extends JpaRepository<Policy, Integer> {

    // add a method to sort by last name
    // public List<Policy> findAllByOrderByLastNameAsc();

    // add a method to sort by id
    // public List<Policy> findAllByOrderByIdAsc();

    // add a method to sort by endingDate
    public List<Policy> findAllByOrderByEndingDateAsc();

    // add a method to filter data based on first name
    // public List<Policy> findByFirstNameLike(String theName);
    public List<Policy> findByFirstName(String theName);

    // add a method to filter data based on last name
    public List<Policy> findByLastName(String theName);
}