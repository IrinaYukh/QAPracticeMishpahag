package ru.stqa.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by Inka on 14-Sep-18.
 */
public class LoginPage extends Page {

    @FindBy(xpath="//span[contains(text(),'Log in')]")
    WebElement loginButton;

    @FindBy(xpath = "//div [@class='mat-input-infix mat-form-field-infix']/input")
    List<WebElement> webElements;

    WebElement loginField;
    WebElement passwordField;

    public LoginPage(WebDriver driver) {
        super(driver);
        //loginField = webElements.get(0);
        //passwordField = webElements.get(1);
    }
    public LoginPage loginPageLoading(){
        waitUntilElementIsLoadedCustomTime(
                loginButton,
                45,
                "Login Page was not loaded (loginButton was not loaded)");
        return this;
    }

    public LoginPage enterLogin(String value){
        loginField = webElements.get(0);
        loginField.clear();
        loginField.click();
        loginField.sendKeys(value);
        return this;
    }

    public LoginPage enterPassword(String value){
        passwordField = webElements.get(1);
        passwordField.clear();
        passwordField.click();
        passwordField.sendKeys(value);
        return this;
    }

    public LoginPage loginButtonClick(){
        loginButton.click();
        return this;
    }
}
