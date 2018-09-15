package ru.stqa.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Sample page
 */
public class HomePage extends Page {

  //@FindBy(how = How.TAG_NAME, using = "h1")
 // @CacheLookup

  @FindBy(xpath="//span[contains(text(),'Login')]")
  WebElement loginLink;


  public WebElement header;

  public HomePage(WebDriver webDriver) {
    super(webDriver);
  }

  public HomePage pageHomeLoading(){
     waitUntilElementIsLoadedCustomTime(
            loginLink,
            45,
            "Page home was not loaded (loginLink was not loaded)");
     return this;
  }

  public HomePage loginLinkClick(){
    loginLink.click();
    return this;
  }
}
