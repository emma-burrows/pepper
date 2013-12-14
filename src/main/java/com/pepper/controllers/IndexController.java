package com.pepper.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pepper.services.DrugService;

/**
 * Controller for the welcome page with database record count.
 * @author Emma Burrows
 */
@Controller
@RequestMapping("/")
public class IndexController
{
  @Autowired
  private DrugService drugService;

  /**
   * Returns a welcome screen.
   * @param model the model for the view
   * @return the view to use
   */
  @RequestMapping(method = RequestMethod.GET)
  public String index(Model model)
  {
    model.addAttribute("drugcount", drugService.getCount());
    model.addAttribute("title", "Drug Database");
    return "index";
  }
}
