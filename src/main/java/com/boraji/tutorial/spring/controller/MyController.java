package com.boraji.tutorial.spring.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

  @GetMapping("/")
  public String index(Model model, Principal principal) {
    model.addAttribute("message", "You are logged in as " + principal.getName());
    return "index";
  }
  
  @GetMapping("/admin")
  public String admin(Model model, Principal principal) {
    model.addAttribute("message", "You are logged in Profile " + principal.getName());
    return "index";
  }
  
  @GetMapping("/user1")
  public String user1(Model model, Principal principal) {
    model.addAttribute("message", "You are logged in Profile " + principal.getName());
    return "index";
  }
  
  @GetMapping("/user2")
  public String user2(Model model, Principal principal) {
    model.addAttribute("message", "You are logged in Profile " + principal.getName());
    return "index";
  }
}
