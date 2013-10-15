package com.pharmpress.pepper.spring.controllers;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pharmpress.pepper.resources.DrugEntity;

/**
 * @author Ross Laidlaw
 */
@Controller
@RequestMapping("/search")
public class SearchController
{
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
    Configuration configuration = new Configuration();
    configuration.configure();
    ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
      .applySettings(configuration.getProperties()).buildServiceRegistry();
    SessionFactory sessionFactory = configuration
      .buildSessionFactory(serviceRegistry);

    // This is a read-only transaction, so perhaps the try...catch is
    // not needed here...
    Session session = sessionFactory.openSession();
    try
    {
      session.beginTransaction();
      Query query = session
        .createQuery("from DrugEntity where name like :name");
      query.setParameter("name", '%' + name + '%');

      List<DrugEntity> drugs = new ArrayList<DrugEntity>();
      for(Object object : query.list())
      {
        drugs.add((DrugEntity) object);
      }
      model.addAttribute("drugs", drugs);
      model.addAttribute("title", "Search results");
      session.getTransaction().commit();
    }
    catch (RuntimeException e)
    {
      session.getTransaction().rollback();
    }
    finally
    {
      session.close();
      sessionFactory.close();
    }

    return "search";
  }
}