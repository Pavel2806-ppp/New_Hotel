package test;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import hotel.pages.MainPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Feature("conf Comparing")
@Story("User able to compare seven different conf files")
public class RegistrationHotelPageTest extends BaseTest {
    private String name, date, shorting, notes, description, country, city;
    private MainPage mainPage;



    @Test
    public void testCanOpenRegistrationPage () {
       mainPage.setArticleButton ()
               .setNewButton ()
               .setHotelButton ()
               .setName (name)
               .setDate (date)
               .setCountry (country)
               .setCity (city)
               .setDescriptionShort (shorting)
               .setDescription (description)
               .setNotes (notes)
               .setSave ();


    }

   @BeforeMethod
   public void beforeRegistrationTest(){
       mainPage = new MainPage (driver);
       name = config.getProperty ("Inputname");
       date = config.getProperty ("InputDate");
       shorting= config.getProperty ("shortInput");
       notes = config.getProperty ("InputNotes");
       description = config.getProperty ("InputDestription");
       country = config.getProperty ("countryInput");
       city = config.getProperty ("inputCity");
   }

}
