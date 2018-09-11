package ru.stqa.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Abstract class representation of a Page in the UI. Page object pattern
 */
public abstract class Page {

  protected WebDriver driver;

  /*
   * Constructor injecting the WebDriver interface
   * 
   * @param webDriver
   */
  public Page(WebDriver driver) {
    this.driver = driver;
  }

  public String getTitle() {
    return driver.getTitle();
  }

  public WebElement waitUntilElementIsLoadedCustomTime(By by, int time, String error_message) {
    WebDriverWait wait = new WebDriverWait(driver, time);
    wait.withMessage(error_message + "\n");
    return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
  }

  public void waitUntilElementIsDisappearedCustomTime(WebElement element, int time, String error_message) {
    WebDriverWait wait = new WebDriverWait(driver, time);
    wait.withMessage(error_message + "\n");
    wait.until(ExpectedConditions.invisibilityOf(element));
  }

}
