package com.pepper.controllers;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    JSONArray jsonArray = new JSONArray();
    for(String name : drugService.getAllNamesAsc())
    {
      // Add the value data to the JSON object.
      JSONObject jsonObj = new JSONObject();
      jsonObj.put("value", name);

      // Add the tokens data to the JSON object.
      JSONArray tokens = new JSONArray();
      tokens.add(name);
      jsonObj.put("tokens", tokens);

      // Add the JSON object to the JSON array.
      jsonArray.add(jsonObj);
    }

    return jsonArray.toJSONString();
  }
}
