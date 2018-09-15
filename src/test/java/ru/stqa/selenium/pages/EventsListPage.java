package ru.stqa.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Inka on 14-Sep-18.
 */
public class EventsListPage extends Page {

    @FindBy(xpath="//div[@class='mat-select-value']")
    WebElement filterCitiesButton;

    public EventsListPage(WebDriver driver) {
        super(driver);
    }

    public EventsListPage eventsListPageLoading(){
        waitUntilElementIsLoadedCustomTime(
                filterCitiesButton,
                45,
                "Events list Page was not loaded (filterCitiesButton was not loaded)");
        return this;
    }

    public EventsListPage citiesButtonClick(){
        filterCitiesButton.click();
        return this;
    }
}
