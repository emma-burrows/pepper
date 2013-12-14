package com.pepper.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pepper.services.DrugService;

/**
 * Controller that handles database search requests from the user interface.
 * @author Ross Laidlaw
 */
@Controller
@RequestMapping("/search")
public class SearchController
{
  @Autowired
  private DrugService drugService;

  /**
   * Returns a drug via the search view.
   * @param name the name of the drug (optional)
   * @param model the model for the view
   * @return the view to use
   */
  @RequestMapping(method = RequestMethod.GET)
  public String getDrug(@RequestParam(value="name", required=false) String name,
    Model model)
  {
    model.addAttribute("drugs", drugService.getAllByName(name));
    return "search";
  }
}
