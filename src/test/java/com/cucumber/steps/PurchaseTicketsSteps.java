package com.cucumber.steps;

import com.frikiteam.events.configuration.MyWebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static java.lang.Thread.sleep;


public class PurchaseTicketsSteps {
    String Path = System.getProperty("user.dir");
    public WebDriver webDriver = MyWebDriver.getWebDriver();
    String urlPage = "https://frikiteam.netlify.app/";

    /*
    * Scenario 1
    * */

    @Given("the user wants to purchase tickets to an event")
    public void userWantsToPurchaseTicketsToEvent() throws InterruptedException {
        webDriver.get(urlPage);
        webDriver.findElement(By.xpath("/html/body/app-root/app-nav-bar/mat-sidenav-container/mat-sidenav-content/main/app-home/div/div[3]/div/mat-card")).click();
        sleep(1000);
    }

    @When("the user enters the number of tickets")
    public void userEntersTheNumberOfTickets() throws InterruptedException {
        webDriver.findElement(By.xpath("/html/body/app-root/app-nav-bar/mat-sidenav-container/mat-sidenav-content/main/app-event/mat-drawer-container/mat-drawer-content/div/div[2]/button[3]")).click();
        sleep(1000);
    }

    @When("payment method with the requested information")
    public void paymentMethodWithTheRequestedInformation() {
        WebElement inputEmail = webDriver.findElement(By.xpath("/html/body/app-root/app-nav-bar/mat-sidenav-container/mat-sidenav-content/main/app-event/div/div/div/div/form/mat-form-field/div/div[1]/div/input"));
        inputEmail.sendKeys("emailTest@gmail.com");

    }

    @Then("the system notifies the user that their purchase was successful")
    public void systemNotifiesTheUserThatTheirPurchaseWasSuccessful() {
        webDriver.findElement(By.xpath("/html/body/app-root/app-nav-bar/mat-sidenav-container/mat-sidenav-content/main/app-event/div/div/div/div/form/div[2]/button[2]")).click();
    }

    /*
     * Scenario 2
     * */

    @When("the payment method with the wrong information")
    public void paymentMethodWithTheWrongInformation() {
        WebElement inputEmail = webDriver.findElement(By.xpath("/html/body/app-root/app-nav-bar/mat-sidenav-container/mat-sidenav-content/main/app-event/div/div/div/div/form/mat-form-field/div/div[1]/div/input"));
        inputEmail.sendKeys("emailTestWrong");
    }

    @Then("the user is notified that it has not been possible to complete the purchase")
    public void userIsNotifiedThatItHasNotBeenPossibleToCompleteThePurchase() {
        webDriver.findElement(By.xpath("/html/body/app-root/app-nav-bar/mat-sidenav-container/mat-sidenav-content/main/app-event/div/div/div/div/form/div[2]/button[1]")).click();
    }

    /*
     * Scenario 3
     * */

    @When("the payment method does not present credit for the action")
    public void paymentMethodDoesNotPresentCreditForTheAction() {
        WebElement inputEmail = webDriver.findElement(By.xpath("/html/body/app-root/app-nav-bar/mat-sidenav-container/mat-sidenav-content/main/app-event/div/div/div/div/form/mat-form-field/div/div[1]/div/input"));
        inputEmail.sendKeys("emailTest@gmail.com");
    }

    @Then("the user is notified that the purchase could not be completed")
    public void userIsNotifiedThatThePurchaseCouldNotBeCompleted() {
        webDriver.findElement(By.xpath("/html/body/app-root/app-nav-bar/mat-sidenav-container/mat-sidenav-content/main/app-event/div/div/div/div/form/div[2]/button[1]")).click();
    }
}
