package org.tcs;

import io.cucumber.java.hu.Ha;
import io.cucumber.java.it.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.tcs.PageComponents.MultiTrip;
import org.tcs.PageComponents.RoundTrip;
import org.tcs.PageObjects.TravelHomePage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

public class DemoTest extends  BaseTest{


    WebDriver driver;
    TravelHomePage travelHomePage;
   // By sectionElement= By.id("flightSearchContainer");

    @BeforeTest
    public void setUp(){
        driver=initializeDriver();
        travelHomePage=new TravelHomePage(driver);
    }

    @Test(dataProvider = "getData")
    public void flightTest(HashMap<String,String> reservationDetails){

        travelHomePage.goTo();
       // travelHomePage.getFooterNav().selectFlight();
        System.out.println(travelHomePage.getFooterNav().getFlightAttribute());
        System.out.println(travelHomePage.getNavBar().getFlightAttribute());
        System.out.println(travelHomePage.getFooterNav().getLinksCount());
        System.out.println(travelHomePage.getNavBar().getLinksCount());

      //  travelHomePage.setBookingStrategy(new MultiTrip(driver,sectionElement));
        travelHomePage.setBookingStrategy("multitrip");

        travelHomePage.checkAvail(reservationDetails);
        //one way , round trip, multi trip - checkAvailibility(origin,destination
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

    @DataProvider
    public Object[][] getData(){
        HashMap<String,String> reservationDetails=new HashMap<String,String>();
        reservationDetails.put("origin","MAA");
        reservationDetails.put("destination","HYD");
        reservationDetails.put("destination2","DEL");
        HashMap<String,String> reservationDetails1=new HashMap<String,String>();
        reservationDetails1.put("origin","DEL");
        reservationDetails1.put("destination","HYD");
        reservationDetails1.put("destination2","MAA");
        return new Object[][]
                {
                        {reservationDetails},{reservationDetails1}
        };

    };
}
