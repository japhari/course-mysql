package com.example.mysql.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.mysql.model.Customer;
import com.example.mysql.repository.CustomerRepository;

@RestController
public class WebController {
   @Autowired
   CustomerRepository repository;
     
   @RequestMapping("/save")
   public String process(){
       repository.save(new Customer("Japhari", "Juma"));
       repository.save(new Customer("Daniel", "Kimathi"));
       repository.save(new Customer("Musa", "Daniel"));
       repository.save(new Customer("Klugger", "Williams"));
       repository.save(new Customer("Mushi", "Davis"));
       return "Done";
   }
     
     
   @RequestMapping("/findall")
   public String findAll(){
       String result = "<html>";
         
       for(Customer cust : repository.findAll()){
           result += "<div>" + cust.toString() + "</div>";
       }
         
       return result + "</html>";
   }
     
   @RequestMapping("/findbyid")
   public String findById(@RequestParam("id") long id){
       String result = "";
       result = repository.findById(id).toString();
       return result;
   }
     
   @RequestMapping("/findbylastname")
   public String fetchDataByLastName(@RequestParam("lastname") String lastName){
       String result = "<html>";
         
       for(Customer cust: repository.findByLastName(lastName)){
           result += "<div>" + cust.toString() + "</div>"; 
       }
         
       return result + "</html>";
   }
}