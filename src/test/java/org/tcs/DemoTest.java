package org.tcs;

import io.cucumber.java.hu.Ha;
import io.cucumber.java.it.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.tcs.PageComponents.MultiTrip;
import org.tcs.PageComponents.RoundTrip;
import org.tcs.PageObjects.TravelHomePage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

public class DemoTest {


   // By sectionElement= By.id("flightSearchContainer");

    @Test(dataProvider = "getData")
    public void flightTest(HashMap<String,String> reservationDetails){
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

        travelHomePage.checkAvail(reservationDetails);
        //one way , round trip, multi trip - checkAvailibility(origin,destination
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
