package org.tcs.PageComponents;

import io.reactivex.rxjava3.functions.Consumer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.tcs.AbstractComponents.AbstractComponent;
import org.tcs.AbstractComponents.SearchFlightAvail;

public class MultiTrip extends AbstractComponent implements SearchFlightAvail {
    private By from=By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    private By to=By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    private By submit=By.id("ctl00_mainContent_btn_FindFlights");
    private By multCity_rdo=By.id("ctl00_mainContent_rbtnl_Trip_2");
    private  By destination_2=By.id("ctl00_mainContent_ddl_originStation2_CTXT");
    private By modalPopUp=By.id("MultiCityModelAlert");

    public MultiTrip(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }

    public void checkAvail(final String origin, String destination) {
        makeStateReady(s->selectOriginCity(origin));
       // selectOriginCity(origin);
        selectDestinationCity(destination);
        selectDestinationCity2("BLR");


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

    public void selectDestinationCity2(String destination2)
    {
        findElement(destination_2).click();
        findElement(By.xpath("(//a[@value='"+destination2+"'])[3]")).click();
    }

    public void makeStateReady(Consumer<MultiTrip> consumer){
        System.out.println("I am  inside multitrip");
        findElement(multCity_rdo).click();
        findElement(modalPopUp).click();
        waitForElementToDisappear(modalPopUp);
        try {
            consumer.accept(this);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("I am done");
    }

}
