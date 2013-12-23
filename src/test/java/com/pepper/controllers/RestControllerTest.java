package com.pepper.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Tests the {@link RestController} class.
 * @author Ross Laidlaw
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:test-servlet-cfg.xml"})
public class RestControllerTest
{
  @Autowired
  private WebApplicationContext wac;

  private MockMvc mockMvc;


  @Before
  public void setUp()
  {
    mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
  }


  @Test
  public void testGetAutocomplete() throws Exception
  {
    mockMvc.perform(get("/rest/autocomplete"))
      .andExpect(status().isOk())
      .andExpect(content().contentType("application/json"));
  }
}
