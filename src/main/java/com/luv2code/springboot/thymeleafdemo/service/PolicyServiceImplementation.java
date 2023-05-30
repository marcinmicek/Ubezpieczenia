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
        // return policyRepository.findAllByOrderByIdAsc();
        return policyRepository.findAllByOrderByEndingDateAsc();
    }

    @Override
    public Policy findById(int theId) {
        Optional<Policy> result = policyRepository.findById(theId);

        Policy thePolicy = null;

        if (result.isPresent()) {
            thePolicy = result.get();
        }
        else {
            // we didn't find the policy with the chosen id
            // throw new RuntimeException("Brak polisy o numerze id: " + theId);
            System.out.println("Brak polisy o numerze id: " + theId);
        }

        return thePolicy;
    }

    @Override
    public List<Policy> findByFirstName(String theName) {

        // List<Policy> results = policyRepository.findByFirstNameLike("%oma%");
        List<Policy> results = policyRepository.findByFirstName(theName);

        if (results.isEmpty()) {
            // we didn't find the policy with the chosen name
            // throw new RuntimeException("Nie istnieją polisy o zadanym kryterium");
            System.out.println("Nie istnieją polisy o zadanym kryterium");
        }

        return results;
    }

    @Override
    public List<Policy> findByLastName(String theName) {

        // List<Policy> results = policyRepository.findByFirstNameLike("%oma%");
        List<Policy> results = policyRepository.findByLastName(theName);

        if (results.isEmpty()) {
            // we didn't find the policy with the chosen name
            // throw new RuntimeException("Nie istnieją polisy o zadanym kryterium");
            System.out.println("Nie istnieją polisy o zadanym kryterium");
        }

        return results;
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
