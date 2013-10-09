package com.pharmpress.pepper.spring.controllers;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
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
  /**
   * Returns a drug via the drug view.
   * @param name the name of the drug (optional)
   * @param model the model for the view
   * @return the view to use
   */
  @RequestMapping(method = RequestMethod.GET)
  public String getDrug(@RequestParam(value="name", required=false,
    defaultValue="aspirin") String name, Model model)
  {
    model.addAttribute("name", name);
    return "drug";
  }
  
  /**
   * Returns a drug via the drug view
   * @param body the body of the POST request, containing the name of the drug
   * @param model the model for the view
   * @return
   * @throws IOException
   */
  @RequestMapping(method = RequestMethod.POST)
  public String logs(@RequestBody String body, Model model) 
  {
    model.addAttribute("name", body);

      return null;
  }
}
