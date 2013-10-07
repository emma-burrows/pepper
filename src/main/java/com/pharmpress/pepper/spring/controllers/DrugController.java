package com.pharmpress.pepper.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Ross Laidlaw
 */
@Controller
@RequestMapping("/drug")
public class DrugController
{
  @RequestMapping(method = RequestMethod.GET)
  public String getDrug(@RequestParam(value="name", required=false,
    defaultValue="aspirin") String name, Model model)
  {
    model.addAttribute("name", name);
    return "drug";
  }
}
