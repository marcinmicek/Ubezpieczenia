package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Policy;
import com.luv2code.springboot.thymeleafdemo.service.PolicyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/policies")
public class PolicyController {

    private PolicyService policyService;

    public PolicyController(PolicyService thePolicyService) {
        policyService = thePolicyService;
    }

    // add mapping for "/list"

    @GetMapping("/list")
    public String listPolicies(Model theModel) {

        // get the policies from db
        List<Policy> thePolicies = policyService.findAll();

        // add to the spring model
        theModel.addAttribute("policies", thePolicies);

        return "policies/list-policies";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        Policy thePolicy = new Policy();

        theModel.addAttribute("policy", thePolicy);

        return "policies/policy-form";
    }

    // add form for choosing month
    @GetMapping("/showChooseMonthForm")
    public String showChooseMonthForm(Model theModel) {

        // create model attribute to bind form data
        Policy thePolicy = new Policy();

        theModel.addAttribute("policy", thePolicy);

        return "policies/month-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("policyId") int theId, Model theModel) {

        // get the employee from the service
        Policy thePolicy = policyService.findById(theId);

        // set employee as a model attribute to pre-populate the form
        theModel.addAttribute("policy", thePolicy);

        // send over to our form
        return "policies/policy-form";
    }

    @PostMapping("/save")
    public String savePolicy(@ModelAttribute("policy") Policy thePolicy) {

        // save the policy
        policyService.save(thePolicy);

        // use a redirect to prevent duplicate submissions
        return "redirect:/policies/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("policyId") int theId) {

        // delete the employee
        policyService.deleteById(theId);

        // redirect to the /employees/list
        return "redirect:/policies/list";
    }
}