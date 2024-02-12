package com.handle.shadow;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.URL;

public class HandlingShadowElement {

    private static final String url = "http://watir.com/examples/shadow_dom.html";
    private static WebDriver driver;
    static By shadowElement = By.cssSelector("#shadow_host");

    public static void getShadowElement(WebDriver driver) {

        SearchContext shadowRoot = driver.findElement(shadowElement).getShadowRoot();
        String text = shadowRoot.findElement(By.cssSelector("#shadow_content>span")).getText();
        System.out.println(text);


    }

    public static void main(String[] args) {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.navigate().to(url);

        getShadowElement(driver);

        driver.close();
    }
}
