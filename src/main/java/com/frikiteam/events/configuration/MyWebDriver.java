package com.frikiteam.events.configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyWebDriver {
    public static WebDriver webDriver;

    private MyWebDriver() {

    }
    public static WebDriver getWebDriver() {
        if(webDriver == null) {
            String urlPage = "https://frikiteam.netlify.app/";
            // Establece el chrome driver
            //WebDriver webDriver;
            String pathDriver = System.getProperty("user.dir") + "/driver/chromedriver_95.exe";
            System.setProperty("webdriver.chrome.driver", pathDriver);
            webDriver = new ChromeDriver();

            webDriver.get(urlPage);

            // --Maximiza la ventana
            webDriver.manage().window().maximize();
        }
        return webDriver;
    }
}