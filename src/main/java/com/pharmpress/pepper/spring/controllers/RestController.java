package com.pharmpress.pepper.spring.controllers;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pharmpress.pepper.configuration.HibernateConfiguration;

/**
 * Controller that provides a RESTful service.
 * @author Ross Laidlaw
 */
@Controller
@RequestMapping("/rest")
public class RestController
{
  private static final Logger logger = Logger.getLogger("RestController");

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

    Configuration configuration = HibernateConfiguration.create();
    ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
      .applySettings(configuration.getProperties()).buildServiceRegistry();
    SessionFactory sessionFactory = configuration
      .buildSessionFactory(serviceRegistry);

    Session session = sessionFactory.openSession();
    try
    {
      session.beginTransaction();

      // Generate data for the autocomplete feature of the search field.
      Query autocomplete = session
        .createQuery("select D.name from DrugEntity D order by D.name asc");
      for(Object object : autocomplete.list())
      {
        // Add the value data to the JSON object.
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("value", object);

        // Add the tokens data to the JSON object.
        JSONArray tokens = new JSONArray();
        tokens.add(object);
        jsonObj.put("tokens", tokens);

        // Add the JSON object to the JSON array.
        jsonArray.add(jsonObj);
      }

      // Commit the transaction.
      session.getTransaction().commit();
    }
    catch (RuntimeException e)
    {
      logger.error("Error retrieving autocomplete data.", e);
      session.getTransaction().rollback();
    }
    finally
    {
      session.close();
      sessionFactory.close();
    }

    return jsonArray.toJSONString();
  }
}
