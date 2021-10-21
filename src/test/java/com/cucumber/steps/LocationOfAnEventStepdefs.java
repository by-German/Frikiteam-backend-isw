package com.cucumber.steps;

import com.frikiteam.events.configuration.MyWebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LocationOfAnEventStepdefs {

    public static WebDriver webDriver = MyWebDriver.getWebDriver();


    @Given("El usuario quiere ver la localización de un evento")
    public void elUsuarioQuiereVerLaLocalizaciónDeUnEvento() {
    }

    @When("Selecciona un evento")
    public void seleccionaUnEvento() {
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
        webDriver.findElement(By.xpath("/html/body/app-root/app-nav-bar/mat-sidenav-container/mat-sidenav-content/main/app-event/mat-drawer-container/mat-drawer-content/div/div[2]/button[2]")).click();
    }

    @Then("Una ventana se muestra con la localización del evento")
    public void unaVentanaSeMuestraConLaLocalizaciónDelEvento() {
    }
}
