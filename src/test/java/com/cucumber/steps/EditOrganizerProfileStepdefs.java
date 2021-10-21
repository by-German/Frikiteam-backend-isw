package com.cucumber.steps;

import com.frikiteam.events.configuration.MyWebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class EditOrganizerProfileStepdefs {
    String Path = System.getProperty("user.dir");
    public  WebDriver webDriver = MyWebDriver.getWebDriver();

    @Given("the organizer wants to edit your profile")
    public void theOrganizerWantsToEditYourProfile() {
        webDriver.findElement(By.xpath("html/body/app-root/app-nav-bar/mat-toolbar/button[5]")).click();
        webDriver.findElement(By.xpath("//*[@id=\"mat-menu-panel-0\"]/div/button[1]")).click();
        webDriver.findElement(By.xpath("//*[@id=\"mat-input-1\"]")).sendKeys("juan@correo.com");
        webDriver.findElement(By.xpath("//*[@id=\"mat-input-2\"]")).sendKeys("contraseña123");
        webDriver.findElement(By.xpath("/html/body/app-root/app-nav-bar/mat-sidenav-container/mat-sidenav-content/main/app-login/div/form/button")).click();
        try {
            Thread.sleep(1*1000);
        } catch (Exception e) {
            System.out.println(e);
        }

        webDriver.findElement(By.xpath("/html/body/app-root/app-nav-bar/mat-toolbar/button[5]")).click();
        webDriver.findElement(By.xpath("//*[@id=\"mat-menu-panel-0\"]/div/button[3]")).click();
        webDriver.findElement(By.xpath("/html/body/app-root/app-nav-bar/mat-sidenav-container/mat-sidenav-content/main/app-user/mat-drawer-container/mat-drawer/div/div/div/div[1]/button")).click();

    }

    @When("the user enters the data, they want to update")
    public void theUserEntersTheDataTheyWantToUpdate() {
        webDriver.findElement(By.xpath("//*[@id=\"mat-input-1\"]")).clear();
        webDriver.findElement(By.xpath("//*[@id=\"mat-input-1\"]")).sendKeys("Juan Carlo");

        webDriver.findElement(By.xpath("//*[@id=\"mat-input-2\"]")).clear();
        webDriver.findElement(By.xpath("//*[@id=\"mat-input-2\"]")).sendKeys("El Tamalero");

    }

    @Then("the system will notify you that the data was updated correctly")
    public void theSystemWillNotifyYouThatTheDataWasUpdatedCorrectly() {
        webDriver.findElement(By.xpath("/html/body/app-root/app-nav-bar/mat-sidenav-container/mat-sidenav-content/main/app-user/div/div/div[2]/button[1]")).click();
        webDriver.findElement(By.xpath("/html/body/app-root/app-nav-bar/mat-toolbar/button[2]")).click();
    }
}