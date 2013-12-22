package com.pepper.dao;

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
 * Tests the DrugDaoHibernate class.
 * @author Ross Laidlaw
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-servlet-cfg.xml"})
@Transactional
public class DrugDaoHibernateTest
{
  @Autowired
  private DrugDao drugDao;

  /**
   * Tests the {@link DrugDao#getAllByName(String)} method.
   * @throws Exception
   */
  @Test
  public void testGetAllByName() throws Exception
  {
    List<DrugEntity> results = drugDao.getAllByName("aspirin");
    assertEquals("Drug DAO results didn't match expected size", 0,
      results.size());
  }

  /**
   * Tests the {@link DrugDaoHibernate#getAllNamesAsc()} method.
   * @throws Exception
   */
  @Test
  public void testGetAllNamesAsc() throws Exception
  {
    List<String> results = drugDao.getAllNamesAsc();
    assertEquals("Drug DAO results didn't match expected size", 0,
      results.size());
  }

  /**
   * Tests the {@link DrugDaoHibernate#getCount()} method.
   * @throws Exception
   */
  @Test
  public void testGetCount() throws Exception
  {
    assertEquals("Drug DAO count didn't match expected value.", 0,
      drugDao.getCount());
  }
}
