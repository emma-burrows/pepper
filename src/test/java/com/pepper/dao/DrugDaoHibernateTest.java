package com.pepper.dao;

import com.pepper.domain.DrugEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Tests the {@link DrugDaoHibernate} class.
 * @author Ross Laidlaw
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-servlet-cfg.xml"})
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class DrugDaoHibernateTest
{
  @Autowired
  private DrugDao drugDao;



  /**
   * Adds some test data to the drugs table in the database.
   * This test data is deleted after each test by the TransactionConfiguration
   * of 'defaultRollback = true', so there's no corresponding @After tearDown()
   * method.
   */
  @Before
  public void setUp()
  {
    DrugEntity d1 = new DrugEntity();
    d1.setName("paracetamol");
    d1.setFormula("C8H9NO2");
    d1.setWeight("151.1");
    d1.setCas("103-90-2");
    d1.setAtc("N02BE01");
    d1.setUnii("362O9ITL9D");
    d1.setImageName("paracetamol");

    DrugEntity d2 = new DrugEntity();
    d2.setName("warfarin");
    d2.setFormula("C19H16O4");
    d2.setWeight("308.3");
    d2.setCas("81-81-2");
    d2.setAtc("B01AA03");
    d2.setUnii("5Q7ZVV76EI");
    d2.setImageName("warfarin");

    DrugEntity d3 = new DrugEntity();
    d3.setName("aspirin");
    d3.setFormula("C9H8O4");
    d3.setWeight("180.2");
    d3.setCas("50-78-2");
    d3.setAtc("A01AD05 B01AC06, N02BA01");
    d3.setUnii("R16CO5Y76E");
    d3.setImageName("aspirin");

    drugDao.save(d1);
    drugDao.save(d2);
    drugDao.save(d3);
  }



  /**
   * Tests the {@link DrugDao#getAllByName(String)} method.
   * @throws Exception
   */
  @Test
  public void testGetAllByName() throws Exception
  {
    List<DrugEntity> results = drugDao.getAllByName("aspirin");
    assertEquals("Wrong number of results.", 1, results.size());
    DrugEntity drug = results.get(0);
    assertEquals("Incorrect drug name.", "aspirin", drug.getName());
    assertEquals("Incorrect drug formula.", "C9H8O4", drug.getFormula());
    assertEquals("Incorrect molecular weight for drug.", "180.2",
      drug.getWeight());
    assertEquals("Incorrect CAS number for drug.", "50-78-2", drug.getCas());
    assertEquals("Incorrect ATC code for drug.", "A01AD05 B01AC06, N02BA01",
      drug.getAtc());
    assertEquals("Incorrect UNII identifier for drug.", "R16CO5Y76E",
      drug.getUnii());
    assertEquals("Incorrect image name for drug.", "aspirin",
      drug.getImageName());
  }



  /**
   * Tests the {@link DrugDaoHibernate#getAllNamesAsc()} method.
   * @throws Exception
   */
  @Test
  public void testGetAllNamesAsc() throws Exception
  {
    List<String> results = drugDao.getAllNamesAsc();
    assertEquals("Wrong number of results returned.", 3, results.size());
    assertEquals("Results did not appear in the correct order.", "aspirin",
      results.get(0));
    assertEquals("Results did not appear in the correct order.", "paracetamol",
      results.get(1));
    assertEquals("Results did not appear in the correct order.", "warfarin",
      results.get(2));
  }



  /**
   * Tests the {@link DrugDaoHibernate#getCount()} method.
   * @throws Exception
   */
  @Test
  public void testGetCount() throws Exception
  {
    assertEquals("Count result did not match the expected value.", 3,
      drugDao.getCount());
  }
}
