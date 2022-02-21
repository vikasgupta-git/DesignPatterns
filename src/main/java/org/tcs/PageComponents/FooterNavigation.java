package org.tcs.PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.tcs.AbstractComponents.AbstractComponent;

public class FooterNavigation extends AbstractComponent {

    By flights=By.cssSelector("[title='Flights']");
    By links=By.cssSelector("a");
    public FooterNavigation(WebDriver driver, By sectionElement)
    {
        super(driver,sectionElement);
    }

    public void selectFlight(){
        findElement(flights).click();
    }
    public String getFlightAttribute(){
        return findElement(flights).getAttribute("class");
    }

    public int getLinksCount(){
        return findElements(links).size();
    }
}
