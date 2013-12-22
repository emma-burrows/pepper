package com.pepper.services;

import com.pepper.domain.DrugEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Tests the DrugServiceHibernate class.
 * @author Ross Laidlaw
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-servlet-cfg.xml"})
@Transactional
public class DrugServiceHibernateTest
{
  @Autowired
  private DrugService drugService;

  /**
   * Tests the {@link DrugServiceHibernate#getAllByName(String)} method.
   * @throws Exception
   */
  @Test
  public void testGetAllByName() throws Exception
  {
    List<DrugEntity> results = drugService.getAllByName("aspirin");
    assertEquals("Drug service results didn't match expected size", 0,
      results.size());
  }

  /**
   * Tests the {@link DrugServiceHibernate#getAllNamesAsc()} method.
   * @throws Exception
   */
  @Test
  public void testGetAllNamesAsc() throws Exception
  {
    List<String> results = drugService.getAllNamesAsc();
    assertEquals("Drug service results didn't match expected size", 0,
      results.size());
  }

  /**
   * Tests the {@link DrugServiceHibernate#getCount()} method.
   * @throws Exception
   */
  @Test
  public void testGetCount() throws Exception
  {
    assertEquals("Drug service count didn't match expected value.", 0,
      drugService.getCount());
  }
}
