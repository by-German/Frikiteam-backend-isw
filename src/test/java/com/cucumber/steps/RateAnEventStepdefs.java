package com.cucumber.steps;

import com.frikiteam.events.configuration.MyWebDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RateAnEventStepdefs {
    String Path = System.getProperty("user.dir");
    public WebDriver webDriver = MyWebDriver.getWebDriver();

    @Given("that the Friki user wants to rate an event, that has ended,")
    public void thatTheFrikiUserWantsToRateAnEventThatHasEnded() {
    }

    @And("has logged into his account.")
    public void hasLoggedIntoHisAccount() {
        try {
            Thread.sleep(500);
        } catch (Exception e) {
            System.out.println(e);
        }
        webDriver.findElement(By.xpath("/html/body/app-root/app-nav-bar/mat-sidenav-container/mat-sidenav-content/main/app-home/div/div[3]/div[1]/mat-card/mat-card-header")).click();
        try {
            Thread.sleep(500);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @When("the user completes the requested qualification data.")
    public void theUserCompletesTheRequestedQualificationData() {
    }

    @Then("the system registers the rating provided by the user.")
    public void theSystemRegistersTheRatingProvidedByTheUser() {
    }
}
