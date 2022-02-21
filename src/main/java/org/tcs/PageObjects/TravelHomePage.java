package org.tcs.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.tcs.AbstractComponents.SearchFlightAvail;
import org.tcs.AbstractComponents.StrategyFactor;
import org.tcs.PageComponents.FooterNavigation;
import org.tcs.PageComponents.MultiTrip;
import org.tcs.PageComponents.NavigationBar;
import org.tcs.PageComponents.RoundTrip;

public class TravelHomePage {

    By footerNavSectionElement=By.id("buttons");
    By sectionElement=By.cssSelector("div#traveller-home.middle-cont.color-f0efef.hide-xs.hide-sm");
    WebDriver driver;
    SearchFlightAvail searchFlightAvail;
    public TravelHomePage(WebDriver driver)
    {
        this.driver=driver;
    }
    public NavigationBar getNavBar(){
        return new NavigationBar(driver,footerNavSectionElement);

    }

    public FooterNavigation getFooterNav(){
        return new FooterNavigation(driver,sectionElement);
    }

    public void goTo(){
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
    }

    public RoundTrip roundTrip(){
        return new RoundTrip(driver,sectionElement);
    }
    public MultiTrip multiTrip(){
        return new MultiTrip(driver,sectionElement);
    }

    public void setBookingStrategy(String strategyType){
        StrategyFactor strategyFactor=new StrategyFactor(driver);
       searchFlightAvail= strategyFactor.createStrategy(strategyType);
        this.searchFlightAvail=searchFlightAvail;


    }
    public void checkAvail(String origin,String destination){

        searchFlightAvail.checkAvail(origin,destination);
    }
}

