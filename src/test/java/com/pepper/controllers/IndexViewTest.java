package com.pepper.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

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
 * Tests for the index page using the MVC servlet
 * @author Emma Burrows
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:**/test-servlet-context.xml"})
public class IndexViewTest
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
    mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
  }

  /**
   * Tests that the root URL returns the correct view and that the view contains
   * a drugcount attribute.
   * @throws Exception
   */
  @Test
  public void testIndex() throws Exception
  {
    mockMvc.perform(get("/")
      .accept(MediaType.TEXT_HTML))
      .andExpect(status().isOk())
      .andExpect(view().name("index"))
      .andExpect(model().attributeExists("drugcount"));
  }
}
