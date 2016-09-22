package com.carpool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/student")
public class StudentController {

  @RequestMapping(method = RequestMethod.GET)
  public String loadHome(ModelMap model) {
    return "student";
  }

}