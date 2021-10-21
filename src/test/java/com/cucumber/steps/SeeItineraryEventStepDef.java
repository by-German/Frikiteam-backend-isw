package com.cucumber.steps;

import com.frikiteam.events.configuration.MyWebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SeeItineraryEventStepDef {

    public static WebDriver webDriver = MyWebDriver.getWebDriver();
    @Given("El usuario quiere ver el itinerario del evento")
    public void elUsuarioQuiereVerElItinerarioDelEvento() {
    }

    @When("Selecciona uno de los evento")
    public void seleccionaUnoDeLosEvento() {
        try {
            Thread.sleep(500);
        } catch (Exception e) {
            System.out.println(e);
        }
        webDriver.findElement(By.xpath("/html/body/app-root/app-nav-bar/mat-sidenav-container/mat-sidenav-content/main/app-home/div/div[3]/div[1]/mat-card/mat-card-header")).click();
    }

    @Then("La información básica del evento se muestra")
    public void laInformaciónBásicaDelEventoSeMuestra() {
    }


}
