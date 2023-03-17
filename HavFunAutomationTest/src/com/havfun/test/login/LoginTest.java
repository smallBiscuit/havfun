package com.havfun.test.login;

import java.io.UnsupportedEncodingException;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginTest {
	
	@Test
    public void testLoginEmptyAll(){

        WebDriver driver = new FirefoxDriver();

        driver.navigate().to("http://www.havfun.co");

        WebElement element = driver.findElement(By.className("topbar-signin"));

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
	
	@Test
    public void testLoginEmptyAccount(){

        WebDriver driver = new FirefoxDriver();

        driver.navigate().to("http://www.havfun.co/account/login/");

        // Check the title of the page
        WebElement nameTextInput = driver.findElement(By.name("username"));
        WebElement passwordTextInput = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.name("login"));
        
        
        nameTextInput.sendKeys( "eafdsffsf" );
        passwordTextInput.sendKeys( "" );
        
        loginButton.click();
        
        WebElement errorMessage = driver.findElement(By.className("woocommerce-error"));
        
        System.out.println("Page title is: " + errorMessage.getText() );        

		Assert.assertEquals("\u932F\u8AA4: \u5FC5\u9808\u586B\u5165\u4F7F\u7528\u8005\u540D\u7A31\u3002", errorMessage.getText() );
        
        driver.close();
        driver.quit();
    }
	
	@Test
    public void testLoginEmptyPassword(){

        WebDriver driver = new FirefoxDriver();

        driver.navigate().to("http://www.havfun.co/account/login/");

        // Check the title of the page
        WebElement nameTextInput = driver.findElement(By.name("username"));
        WebElement passwordTextInput = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.name("login"));
        
        
        nameTextInput.sendKeys( "" );
        passwordTextInput.sendKeys( "eafdsffsf" );
        
        loginButton.click();
        
        WebElement errorMessage = driver.findElement(By.className("woocommerce-error"));
        
        System.out.println("Page title is: " + errorMessage.getText() );        

		Assert.assertEquals("\u932F\u8AA4: \u5FC5\u9808\u586B\u5165\u4F7F\u7528\u8005\u540D\u7A31\u3002", errorMessage.getText() );
        
        driver.close();
        driver.quit();
    }
	
	@Test
    public void testLoginWrongLoginData(){

        WebDriver driver = new FirefoxDriver();

        driver.navigate().to("http://www.havfun.co/account/login/");

        // Check the title of the page
        WebElement nameTextInput = driver.findElement(By.name("username"));
        WebElement passwordTextInput = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.name("login"));
        
        
        nameTextInput.sendKeys( "eafdsffsf" );
        passwordTextInput.sendKeys( "eafdsffsf" );
        
        loginButton.click();
        
        WebElement errorMessage = driver.findElement(By.className("woocommerce-error"));
        
        System.out.println("Page title is: " + errorMessage.getText() );        

		Assert.assertEquals("\u932F\u8AA4\uFF1A\u5E33\u865F\u4E0D\u6B63\u78BA\u3002\u5FD8\u8A18\u5BC6\u78BC\u4E86\u55CE\uFF1F", errorMessage.getText() );
        
        driver.close();
        driver.quit();
    }
	
	@Test
    public void testLoginSuccess(){
		/*
        WebDriver driver = new FirefoxDriver();

        driver.navigate().to("http://www.havfun.co/account/login/");

        // Check the title of the page
        WebElement nameTextInput = driver.findElement(By.name("username"));
        WebElement passwordTextInput = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.name("login"));
        
        
        nameTextInput.sendKeys( "eafdsffsf" );
        passwordTextInput.sendKeys( "eafdsffsf" );
        
        loginButton.click();
        
        WebElement errorMessage = driver.findElement(By.className("woocommerce-error"));
        
        System.out.println("Page title is: " + errorMessage.getText() );        

		Assert.assertEquals("\u932F\u8AA4\uFF1A\u5E33\u865F\u4E0D\u6B63\u78BA\u3002\u5FD8\u8A18\u5BC6\u78BC\u4E86\u55CE\uFF1F", errorMessage.getText() );
        
        driver.close();
        driver.quit();
        */
    }
}
