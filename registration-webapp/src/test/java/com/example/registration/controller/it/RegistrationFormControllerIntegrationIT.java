package com.example.registration.controller.it;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RegistrationFormControllerIntegrationIT {
    private FirefoxDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.get("http://localhost:8080/registration-webapp/");
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void testFormExist() { 
    	List<WebElement> elements = this.driver.findElementsByXPath("//form[@class='x-panel-body x-form']");
        Assert.assertNotNull(elements);
        Assert.assertEquals(1, elements.size());
    }
    
    @Test
    public void testFormOk()throws InterruptedException{ 
    	WebElement element = driver.findElement(By.name("username"));
    	element.sendKeys("userTest");
    	element = driver.findElement(By.name("postCode"));
    	element.sendKeys("E145E");
    	element = driver.findElement(By.name("email"));
    	element.sendKeys("userTest@mail.co.uk");
    	
    	element = driver.findElementByTagName("button");
    	element.click();
    	
    	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    	
    	List<WebElement> elements = this.driver.findElementsByLinkText("XML");
        Assert.assertNotNull(elements);
        Assert.assertEquals(1, elements.size());
    }
    
    @Test
    public void testFormKO() throws InterruptedException{ 
    	WebElement element = driver.findElement(By.name("username"));
    	element.sendKeys("userTest");
    	element = driver.findElement(By.name("postCode"));
    	element.sendKeys("E145E");
    	element = driver.findElement(By.name("email"));
    	element.sendKeys("userTest@mail.com");
    	
    	element = driver.findElementByTagName("button");
    	element.click();
    	
    	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    	
    	List<WebElement> elements = this.driver.findElementsByLinkText("XML");
        Assert.assertNotNull(elements);
        Assert.assertEquals(0, elements.size());
    }
}
