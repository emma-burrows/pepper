package com.pharmpress.pepper.spring.controllers;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pharmpress.pepper.resources.DrugEntity;

/**
 * Controller for the welcome page with database record count.
 * @author Emma Burrows
 */
@Controller
@RequestMapping("/")
public class IndexController
{
  private static final Logger logger = Logger.getLogger("IndexController");

  /**
   * Returns a welcome screen.
   * @param model the model for the view
   * @return the view to use
   */
  @RequestMapping(method = RequestMethod.GET)
  public String index(Model model)
  {
    Configuration configuration = new Configuration();
    configuration.configure();
    ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
      .applySettings(configuration.getProperties()).buildServiceRegistry();
    SessionFactory sessionFactory = configuration
      .buildSessionFactory(serviceRegistry);

    Session session = sessionFactory.openSession();
    try
    {
      session.beginTransaction();
      
      // Return count of all the rows in the drugs table
      Criteria criteria = session.createCriteria(DrugEntity.class);
      criteria.setProjection(Projections.rowCount());
      long count = (Long)criteria.uniqueResult();

      model.addAttribute("drugcount", count);
      model.addAttribute("title", "Drug database");

      session.getTransaction().commit();
    }
    catch (RuntimeException e)
    {
      logger.error("Error retrieving data count: ",
        e);
      session.getTransaction().rollback();
    }
    finally
    {
      session.close();
      sessionFactory.close();
    }

    return "index";
  }
}
