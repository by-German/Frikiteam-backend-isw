package com.cucumber.steps;

import com.frikiteam.events.configuration.MyWebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EventNotificationStepdefs {
    String Path = System.getProperty("user.dir");
    public WebDriver webDriver = MyWebDriver.getWebDriver();

    @Given("the user wants to be notified when changes are posted to the events they follow or will attend")
    public void theUserWantsToBeNotifiedWhenChangesArePostedToTheEventsTheyFollowOrWillAttend() {
        webDriver.findElement(By.xpath("html/body/app-root/app-nav-bar/mat-toolbar/button[5]")).click();
        webDriver.findElement(By.xpath("//*[@id=\"mat-menu-panel-0\"]/div/button[1]")).click();
        webDriver.findElement(By.xpath("//*[@id=\"mat-input-1\"]")).sendKeys("josias@correo.com");
        webDriver.findElement(By.xpath("//*[@id=\"mat-input-2\"]")).sendKeys("contraseña123");
        webDriver.findElement(By.xpath("/html/body/app-root/app-nav-bar/mat-sidenav-container/mat-sidenav-content/main/app-login/div/form/button")).click();
        try {
            Thread.sleep(3*1000);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @When("events are modified")
    public void eventsAreModified() {
        webDriver.findElement(By.xpath("/html/body/app-root/app-nav-bar/mat-toolbar/button[3]")).click();
    }

    @Then("the application sends notifications of these modified events.")
    public void theApplicationSendsNotificationsOfTheseModifiedEvents() {
    }
}
