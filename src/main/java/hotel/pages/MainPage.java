package hotel.pages;


import hotel.utils.LogUtil;
import io.qameta.allure.Step;
import hotel.utils.LogUtil;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;


public class MainPage {

    private WebDriver driver;


    private static Logger log = LogUtil.getLogger (MainPage.class);


    @FindBy(xpath = "//span[normalize-space()='Article']")
    private WebElement articleButton;

    @FindBy(xpath = "//span[normalize-space()='New']")
    private WebElement newButton;

    @FindBy(xpath = "//span[normalize-space()='Hotel']")
    private WebElement HotelButton;

    @FindBy(xpath = "//input[@id='add_hotel:Inputname']")
    private WebElement name;

    @FindBy(xpath = "//input[@id='add_hotel:dateOfConstruction_input']")
    private WebElement date;

    @FindBy(xpath = "//label[@id='add_hotel:country_label']")
    private WebElement country;

    @FindBy(xpath = "//label[@id='add_hotel:city_label']")
    private WebElement city;

    @FindBy(xpath = "//input[@id='add_hotel:short_description']")
    private WebElement descriptionShort;

    @FindBy(xpath = "//textarea[@id='add_hotel:InputDestription']")
    private WebElement description;

    @FindBy(xpath = "//textarea[@id='add_hotel:notes']")
    private WebElement notes;

    @FindBy(xpath = "//span[normalize-space()='Save']")
    private WebElement save;


    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements (driver, this);
    }

    private String returnFileAbsolutePath(String propValue) {
        return new File (propValue).getAbsolutePath ();
    }


    @Step("Click on the articleButton : {0}")
    public MainPage setArticleButton() {
        log.info ("Click on the articleButton");
        articleButton.click ();
        return this;
    }


    @Step("Click on the newButton : {0}")
    public MainPage setNewButton() {
        log.info ("Click on the newButton");
        newButton.click ();
        return this;
    }

    @Step("Click on the HotelButton : {0}")
    public MainPage setHotelButton() {
        log.info ("Click on the HotelButton");
        HotelButton.click ();
        return this;
    }

    @Step("Set Inputname wo the name field: {0}")
    public MainPage setName(String Inputname) {
        log.info ("Set Inputname file: %s to name Field");
        name.sendKeys (returnFileAbsolutePath (Inputname));
        return this;
    }

    @Step("Set InputDate wo the date field: {0}")
    public MainPage setDate(String InputDate) {
        log.info ("Set InputDate file: %s to date Field");
        date.sendKeys (returnFileAbsolutePath (InputDate));
        return this;
    }

    @Step("Set countryInput wo the country field: {0}")
    public MainPage setCountry(String countryInput) {
        log.info ("Set countryInput file: %s to country Field");
        country.sendKeys (returnFileAbsolutePath (countryInput));
        return this;
    }

    @Step("Set inputCity wo the city field: {0}")
    public MainPage setCity(String inputCity) {
        log.info ("Set inputCity file: %s to city Field");
        city.sendKeys (returnFileAbsolutePath (inputCity));
        return this;
    }

    @Step("Set shortInput wo the short field: {0}")
    public MainPage setDescriptionShort(String shortInput) {
        log.info ("Set shortInput file: %s to short Field");
        descriptionShort.sendKeys (returnFileAbsolutePath (shortInput));
        return this;
    }

    @Step("Set InputDestription wo the description field: {0}")
    public MainPage setDescription(String InputDestription) {
        log.info ("Set conf InputDestription: %s to description Field");
        description.sendKeys (returnFileAbsolutePath (InputDestription));
        return this;
    }

    @Step("Set InputNotes wo the notes field: {0}")
    public MainPage setNotes(String InputNotes) {
        log.info ("Set InputNotes file: %s to notes Field");
        notes.sendKeys (returnFileAbsolutePath (InputNotes));
        return this;
    }

    @Step("Click on the save : {0}")
    public MainPage setSave() {
        log.info ("Click on the save");
        save.click ();
        return this;
    }

}
    /**public RegistrationHotelPage openRegistrationHotelPage() {
     Actions action = new Actions (driver);
     action.moveToElement (articleButton)
     .moveToElement (newButton)
     .moveToElement (HotelButton)
     .click (HotelButton)
     .build ().perform ();
     return new RegistrationHotelPage (driver);}*/


