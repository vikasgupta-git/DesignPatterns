package org.tcs.PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.tcs.AbstractComponents.AbstractComponent;
import org.tcs.AbstractComponents.SearchFlightAvail;

import java.util.HashMap;

public class RoundTrip extends AbstractComponent implements SearchFlightAvail {

    private By rdo= By.id("ctl00_mainContent_rbtnl_Trip_1");
    private By from=By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    private By to = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    private By cb=By.id("ctl00_mainContent_chk_IndArm");
    private By searchBtn=By.id("ctl00_mainContent_btn_FindFlights");


    public RoundTrip(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }

    @Override
    public void checkAvail(HashMap<String,String> reservationDetails) {
        System.out.println("I am inside Round Trip method");
        findElement(rdo).click();
        findElement(from).click();
        selectOriginCity(reservationDetails.get("origin"));
        selectDestinationCity(reservationDetails.get("destination"));
        findElement(cb).click();
        findElement(searchBtn).click();
    }

    public void selectOriginCity(String origin)
    {
        findElement(from).click();
        findElement(By.xpath("//a[@value='"+origin+"']")).click();
    }
    public void selectDestinationCity(String destination)
    {
        findElement(to).click();
        findElement(By.xpath("(//a[@value='"+destination+"'])[2]")).click();
    }
}
