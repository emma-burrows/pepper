package com.pepper.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Tests the search view using the MVC servlet.
 * @author Emma Burrows
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:test-servlet-cfg.xml"})
public class SearchViewTest
{
  @Autowired
  private WebApplicationContext wac;

  private MockMvc mockMvc;

  /**
   * Creates a mock web application context.
   */
  @Before
  public void setup()
  {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
  }

  /**
   * Tests that the search URL returns the correct view.
   * @throws Exception
   */
  @Test
  public void testSearchDrug() throws Exception
  {
    String drugName = "aspirin";
    this.mockMvc.perform(get("/search")
        .param("name", drugName)
          .accept(MediaType.APPLICATION_XML))
      .andExpect(status().isOk())
      .andExpect(view().name("search"));
  }
}
