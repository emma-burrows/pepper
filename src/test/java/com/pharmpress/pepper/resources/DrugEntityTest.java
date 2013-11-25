package com.pharmpress.pepper.resources;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Test;

import com.pharmpress.pepper.configuration.HibernateConfiguration;

/**
 * @author Ross Laidlaw
 */
public class DrugEntityTest
{
  /**
   * This test fires a query at the database and prints out the returned
   * results.
   */
  @Test
  public void testDatabaseConnection()
  {
    Configuration configuration = HibernateConfiguration.create();
    ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
      .applySettings(configuration.getProperties()).buildServiceRegistry();
    SessionFactory sessionFactory = configuration
      .buildSessionFactory(serviceRegistry);

    // This is a read-only transaction, so perhaps the try...catch is
    // not needed here...
    Session session = sessionFactory.openSession();
    try
    {
      String name = "aspirin";
      session.beginTransaction();
      Query query = session
        .createQuery("from DrugEntity where name like :name");
      query.setParameter("name", '%' + name + '%');

      List<DrugEntity> drugs = new ArrayList<DrugEntity>();
      for(Object object : query.list())
      {
        drugs.add((DrugEntity) object);
      }
      for(DrugEntity drug : drugs)
      {
        System.out.println(drug.getName());
      }
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
  }
}
