package com.luv2code.springboot.thymeleafdemo.service;

import java.util.List;
import com.luv2code.springboot.thymeleafdemo.entity.Policy;

public interface PolicyService {

    List<Policy> findAll();

    Policy findById(int theId);

    void save(Policy thePolicy);

    void deleteById(int theId);

}
