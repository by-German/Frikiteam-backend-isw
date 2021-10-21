package com.cucumber.steps;

import com.frikiteam.events.configuration.MyWebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static java.lang.Thread.sleep;

public class SoldTicketsSteps {
    String Path = System.getProperty("user.dir");
    public WebDriver webDriver = MyWebDriver.getWebDriver();
    String urlPage = "https://frikiteam.netlify.app/";

    /*
     * Scenario 1
     * */

    @Given("the organizer wants to see the number of tickets sold")
    public void organizerWantsToSeeTheNumberOfTicketsSold() {
        webDriver.get(urlPage);
    }

    @When("the organizer chooses one of your events")
    public void organizerChoosesOneOfYourEvents() throws InterruptedException {
        webDriver.findElement(By.xpath("/html/body/app-root/app-nav-bar/mat-toolbar/button[5]")).click();
        webDriver.findElement(By.xpath("//*[@id=\"mat-menu-panel-0\"]/div/button[1]")).click();
        sleep(1000);

        webDriver.findElement(By.xpath("/html/body/app-root/app-nav-bar/mat-sidenav-container/mat-sidenav-content/main/app-login/div/form/mat-form-field[1]/div/div[1]/div/input"))
                .sendKeys("german@gmail.com");
        webDriver.findElement(By.xpath("/html/body/app-root/app-nav-bar/mat-sidenav-container/mat-sidenav-content/main/app-login/div/form/mat-form-field[2]/div/div[1]/div/input"))
                .sendKeys("123");
        webDriver.findElement(By.xpath("/html/body/app-root/app-nav-bar/mat-sidenav-container/mat-sidenav-content/main/app-login/div/form/button")).click();
        sleep(1000);

    }

    @Then("the system will also show you the information of the number of tickets sold")
    public void systemWillAlsoShowYouTheInformationOfTheNumberOfTicketsSold() throws InterruptedException {
        webDriver.findElement(By.xpath("/html/body/app-root/app-nav-bar/mat-toolbar/button[5]")).click();
        webDriver.findElement(By.xpath("//*[@id=\"mat-menu-panel-0\"]/div/button[3]")).click();
        sleep(1000);
        webDriver.findElement(By.xpath("/html/body/app-root/app-nav-bar/mat-toolbar/button[5]")).click();
        webDriver.findElement(By.xpath("//*[@id=\"mat-menu-panel-0\"]/div/button[4]")).click();
    }

    /*
     * Scenario 1
     * */

    @Given("the organizer did not log in")
    public void organizerDidNotLogIn() {
        webDriver.get(urlPage);
    }

    @When("the organizer select the option to see your events")
    public void organizerSelectTheOptionToSeeYourEvents() {
        webDriver.findElement(By.xpath("/html/body/app-root/app-nav-bar/mat-toolbar/button[5]")).click();
    }

    @Then("the system tells you that you must be logged in")
    public void systemTellsYouThatYouMustBeLoggedIn() {
        webDriver.findElement(By.xpath("//*[@id=\"mat-menu-panel-0\"]/div/button[1]")).click();
    }

}
