package com.luv2code.springboot.thymeleafdemo.service;

import com.luv2code.springboot.thymeleafdemo.dao.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.luv2code.springboot.thymeleafdemo.entity.Policy;


@Service
public class PolicyServiceImplementation implements PolicyService {

    private PolicyRepository policyRepository;

    @Autowired
    public PolicyServiceImplementation(PolicyRepository thePolicyRepository) {
        policyRepository = thePolicyRepository;
    }

    @Override
    public List<Policy> findAll() {
        // return policyRepository.findAllByOrderByLastNameAsc();
        return policyRepository.findAllByOrderByIdAsc();
    }

    @Override
    public Policy findById(int theId) {
        Optional<Policy> result = policyRepository.findById(theId);

        Policy thePolicy = null;

        if (result.isPresent()) {
            thePolicy = result.get();
        }
        else {
            // we didn't find the policy
            throw new RuntimeException("Did not find policy id - " + theId);
        }

        return thePolicy;
    }

    @Override
    public void save(Policy thePolicy) {
        policyRepository.save(thePolicy);
    }

    @Override
    public void deleteById(int theId) {
        policyRepository.deleteById(theId);
    }

}
