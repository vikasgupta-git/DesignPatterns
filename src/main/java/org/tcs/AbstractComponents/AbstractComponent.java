package org.tcs.AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AbstractComponent {
    WebDriver driver;
    WebElement sectionElement;
    public AbstractComponent(WebDriver driver, By sectionElement) {
    this.driver=driver;
    this.sectionElement=driver.findElement(sectionElement);
    }

    public  WebElement findElement(By findElement) {
        return sectionElement.findElement(findElement);
    }

    public List<WebElement> findElements(By findElement) {
        return sectionElement.findElements(findElement);
    }
}

