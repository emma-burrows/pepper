package com.pharmpress.pepper.views;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Tests for the index page view.
 * @author Emma Burrows
 *
 */
public class IndexViewTest
{

  static WebDriver webDriver;
  /**
   * Search for "aspirin" and check we get an accordion back (which is on the Search page).
   */
  @Test
  public void searchForAspirin()
  {
    
    webDriver = new HtmlUnitDriver();
    
    // TODO: This is awkward
    webDriver.get("http://localhost:8081/pepper/");
    (new WebDriverWait(webDriver, 100)).until(ExpectedConditions.presenceOfElementLocated(By.id("content")));

    // Search
    WebElement element = webDriver.findElement(By.id("search-box"));
    element.clear();
    element.sendKeys("aspirin");
    webDriver.findElement(By.id("search-submit")).click();
    
    (new WebDriverWait(webDriver, 100)).until(ExpectedConditions.visibilityOfElementLocated(By.id("accordion")));
    
  }

}
