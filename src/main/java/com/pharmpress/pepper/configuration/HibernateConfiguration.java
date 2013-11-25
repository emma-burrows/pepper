package com.pharmpress.pepper.configuration;

import org.hibernate.cfg.Configuration;

/**
 * Creates Hibernate Configurations programmatically, overriding settings in the
 * Hibernate XML configuration.
 * @author rlaidlaw
 */
public class HibernateConfiguration
{
  /**
   * Creates a new Hibernate Configuration instance and sets properties for the
   * database URL, username and password dynamically using system/environment
   * variables (DATABASE_URL_PEPPER for URL, DATABASE_USERNAME_PEPPER for
   * username and DATABASE_PASSWORD_PEPPER for password).
   * @return a Hibernate Configuration instance
   */
  public static Configuration create()
  {
    Configuration configuration = new Configuration();
    configuration.configure();
    configuration.setProperty("hibernate.connection.url",
      "jdbc:" + System.getProperty("DATABASE_URL_PEPPER"));
    configuration.setProperty("hibernate.connection.username",
      System.getProperty("DATABASE_USERNAME_PEPPER"));
    configuration.setProperty("hibernate.connection.password",
      System.getProperty("DATABASE_PASSWORD_PEPPER"));
    return configuration;
  }
}
