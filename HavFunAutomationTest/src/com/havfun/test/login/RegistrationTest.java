package com.havfun.test.login;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RegistrationTest {

	@Test
    public void testLoginEmptyAll(){

        WebDriver driver = new FirefoxDriver();

        driver.navigate().to("http://preview.havfun.co/account/registration/");

        WebElement element = driver.findElement(By.name("submit"));

        // Enter something to search for
        element.click();

        // Check the title of the page
        WebElement nameTextInput = driver.findElement(By.name("username"));
        WebElement passwordTextInput = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.name("login"));
        
        
        nameTextInput.sendKeys( "" );
        passwordTextInput.sendKeys( "" );
        
        loginButton.click();
        
        WebElement errorMessage = driver.findElement(By.className("woocommerce-error"));
        
        System.out.println("Page title is: " + errorMessage.getText() );        

		Assert.assertEquals("\u932F\u8AA4: \u5FC5\u9808\u586B\u5165\u4F7F\u7528\u8005\u540D\u7A31\u3002", errorMessage.getText() );
        
        driver.close();
        driver.quit();
    }
}
