package com.cybage.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cybage.exception.RecordNotFoundException;

import java.util.ArrayList;
import java.util.List;


@Controller
public class FirstController {
 @GetMapping("/hello")
 @ResponseBody
 public String sayHello()
 { int i=5;
 	if(i==5)
 		throw new RecordNotFoundException("Error from first controller");
    return "Hello from REST API";
 }

 @GetMapping("/falful")
 @ResponseBody
 public List<String> getFruits()
 {
List<String> fruitsList= new ArrayList<>();
fruitsList.add("Apple");
fruitsList.add("Banana");
fruitsList.add("Papaya");
fruitsList.add("Pineapple");
fruitsList.add("Grapes");
return fruitsList;

 }

}

