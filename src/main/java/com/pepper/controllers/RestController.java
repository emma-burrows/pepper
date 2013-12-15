package com.pepper.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.pepper.services.DrugService;

/**
 * Controller that provides a RESTful service.
 * @author Ross Laidlaw
 */
@Controller
@RequestMapping("/rest")
public class RestController
{
  @Autowired
  private DrugService drugService;

  /**
   * Gets a JSON array containing information used by the search
   * autocomplete feature.
   * @return a JSON array containing the autocomplete information
   */
  @RequestMapping(value="autocomplete", method = RequestMethod.GET,
    produces={"application/json"})
  @ResponseBody
  public String getAutocomplete()
  {
    // A Gson object to manage the creation of the JSON data.
    Gson gson = new Gson();

    // The main JSON array for the autocomplete data.
    JsonArray jsonArray = new JsonArray();

    for(String name : drugService.getAllNamesAsc())
    {
      // Add the value data to the JSON object.
      JsonObject jsonObj = new JsonObject();
      jsonObj.addProperty("value", name);

      // Add the tokens data to the JSON object.
      JsonArray tokens = new JsonArray();
      tokens.add(gson.toJsonTree(name));
      jsonObj.add("tokens", tokens);

      // Add the JSON object to the JSON array.
      jsonArray.add(jsonObj);
    }

    // Send the JSON data as a String in the response.
    return gson.toJson(jsonArray);
  }
}
