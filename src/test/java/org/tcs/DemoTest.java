package org.tcs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.tcs.PageComponents.MultiTrip;
import org.tcs.PageComponents.RoundTrip;
import org.tcs.PageObjects.TravelHomePage;
import org.testng.annotations.Test;

public class DemoTest {

   // By sectionElement= By.id("flightSearchContainer");

    @Test
    public void flightTest(){
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Executables\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        TravelHomePage travelHomePage=new TravelHomePage(driver);
        travelHomePage.goTo();
       // travelHomePage.getFooterNav().selectFlight();
        System.out.println(travelHomePage.getFooterNav().getFlightAttribute());
        System.out.println(travelHomePage.getNavBar().getFlightAttribute());
        System.out.println(travelHomePage.getFooterNav().getLinksCount());
        System.out.println(travelHomePage.getNavBar().getLinksCount());

      //  travelHomePage.setBookingStrategy(new MultiTrip(driver,sectionElement));
        travelHomePage.setBookingStrategy("multitrip");
        travelHomePage.checkAvail("MAA","HYD");


        //one way , round trip, multi trip - checkAvailibility(origin,destination


    }
}
