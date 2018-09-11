package ru.stqa.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ru.stqa.selenium.pages.HomePage;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomePageTest extends TestBase {

  private HomePage homepage;

  @BeforeMethod
  public void initPageObjects() {
    homepage = PageFactory.initElements(driver, HomePage.class);
    driver.get(baseUrl);

  }
  @Test
  public void isHomePageTest(){
    WebElement linkGoToEvents = homepage.waitUntilElementIsLoadedCustomTime(
            By.xpath("//span[contains(text(),'Go to Event list')]"),
            40,
            "'Go to Events List' wasn't loaded");

    Assert.assertTrue(
            driver.findElement(By.xpath("//h1[@class='mat-display-3']"))
                    .getText()
                    .equals("Shabbat in the family circle"));

}
  @Test
  public void testLoginPositive() {

    WebElement loginLink = homepage.waitUntilElementIsLoadedCustomTime(
            By.xpath("//span[contains(text(),'Login')]"),
            40,
            "Login link was not loaded");

    loginLink.click();
    WebElement buttonLogin = homepage.waitUntilElementIsLoadedCustomTime(
            By.xpath("//span[contains(text(),'Log in')]"),
            40,
            "Login field element was not loaded");

    List<WebElement> webElements
            = driver.findElements(
                    By.xpath("//div [@class='mat-input-infix mat-form-field-infix']/input"));

    WebElement fieldLogin = webElements.get(0);
    fieldLogin.click();
    fieldLogin.sendKeys("alexshufutinsk@gmail.com");

    WebElement fieldPassword = webElements.get(1);
    fieldPassword.click();
    fieldPassword.sendKeys("123456");

    buttonLogin.click();

    WebElement filterCities = homepage.waitUntilElementIsLoadedCustomTime(
            By.xpath("//div[@class='mat-select-value']"),
            40,
            "Filter Cities element was not loaded");

    filterCities.click();
  }

  @Test
  public void testWrongPassword(){

    WebElement loginLink = homepage.waitUntilElementIsLoadedCustomTime(
            By.xpath("//span[contains(text(),'Login')]"),
            40,
            "Login link was not loaded");

    loginLink.click();

    WebElement buttonLogin = homepage.waitUntilElementIsLoadedCustomTime(
            By.xpath("//span[contains(text(),'Log in')]"),
            40,
            "Login field element was not loaded");


    List<WebElement> webElements
            = driver.findElements(
            By.xpath("//div [@class='mat-input-infix mat-form-field-infix']/input"));
    WebElement fieldLogin = webElements.get(0);
    fieldLogin.click();
    fieldLogin.sendKeys("alexshufutinsk@gmail.com");

    WebElement wrongPassword = webElements.get(1);
    wrongPassword.click();
    wrongPassword.sendKeys("ghghhghsgshsg");
    //wrongPassword.click();
    buttonLogin.click();
    WebElement wrongMessage = homepage.waitUntilElementIsLoadedCustomTime(
            By.xpath("//*[contains(text(),'Wrong authorization, login or password')]"),
            50,
            "Wrong message was not displayed");
    WebElement cancelButton = homepage.waitUntilElementIsLoadedCustomTime(
            By.xpath("//span[contains(text(),'Cancel')]"),
            25,
            "Cancel button wasn't found");

    cancelButton.click();
    WebElement linkGoToEvents = homepage.waitUntilElementIsLoadedCustomTime(
            By.xpath("//span[contains(text(),'Go to Event list')]"),
            30,
            "'Go to Events List' wasn't loaded");


  }

  @Test
  public void testLoginFromEventsListPage() {
    //driver.get(baseUrl);
   // driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    WebElement goToEventListLink = homepage.waitUntilElementIsLoadedCustomTime(By.xpath("//button[@class = 'mat-stroked-button']"),50, "'Go to event list' wasn't found");
    System.out.println("Link text: " + goToEventListLink.getText());
    goToEventListLink.click();

   // driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    WebElement filterButton = homepage.waitUntilElementIsLoadedCustomTime(By.xpath("//button[@class='mat-raised-button']"),50, "'Filters' button wasn't found");
    System.out.println("Name of the button: " + filterButton.getText());

    //driver.get(baseUrl);
    WebElement loginMenuButton = homepage.waitUntilElementIsLoadedCustomTime(By.xpath("//span[contains(text(),'Login')]"),40,
            "The page with Login is not loaded");
    loginMenuButton.click();

    WebElement inputLogin = homepage.waitUntilElementIsLoadedCustomTime(By.xpath("//input[@type='email']"),
            40,"The Login form is not loaded");

    List<WebElement> webElements = driver.findElements(By.xpath("//div [@class='mat-input-infix mat-form-field-infix']/input"));
    System.out.println("class: "+inputLogin.getAttribute("class"));
    inputLogin.click();
    inputLogin.sendKeys("marina@123.com");

    WebElement inputPassword = webElements.get(1);
    inputPassword.click();
    inputPassword.sendKeys("marina");

    WebElement buttonLogin = homepage.waitUntilElementIsLoadedCustomTime(By.xpath("//button[@type='submit']"),
            40,"'Login' button was not loaded");
            //driver.findElement(By.xpath("//span[contains(text(),'Log in')]"));
    buttonLogin.click();

    homepage.waitUntilElementIsDisappearedCustomTime(loginMenuButton,40, "'Login' button was is still present");
    WebElement filterCities = homepage.waitUntilElementIsLoadedCustomTime(By.xpath("//span[contains(text(),'Cities')]"),
            60,"Filter button wasn't loaded");
    filterCities.click();

    Assert.assertTrue(true);
  }





}
