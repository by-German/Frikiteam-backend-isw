package com.cucumber.steps;

import com.frikiteam.events.configuration.MyWebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SeeDetailsEventStepdefs {
    //webDriver.findElement(By.xpath(""))
    public static WebDriver webDriver = MyWebDriver.getWebDriver();

    @Given("que el usuario quiere visualizar la descripción del evento")
    public void queElUsuarioQuiereVisualizarLaDescripciónDelEvento() {

    }

    @When("elige uno de los eventos")
    public void eligeUnoDeLosEventos() {
        try {
            Thread.sleep(500);
        } catch (Exception e) {
            System.out.println(e);
        }
        webDriver.findElement(By.xpath("/html/body/app-root/app-nav-bar/mat-sidenav-container/mat-sidenav-content/main/app-home/div/div[3]/div[1]/mat-card/mat-card-header")).click();



    }

    @Then("se aprecia información básica del evento")
    public void seApreciaInformaciónBásicaDelEvento() {
        // Aparece la pestaña con los eventos.
    }
}
