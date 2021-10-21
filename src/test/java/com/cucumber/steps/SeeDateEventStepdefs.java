package com.cucumber.steps;

import com.frikiteam.events.configuration.MyWebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SeeDateEventStepdefs {

    public static WebDriver webDriver = MyWebDriver.getWebDriver();
    @Given("El usuario friki quiere poder ver la fecha de un evento")
    public void elUsuarioFrikiQuierePoderVerLaFechaDeUnEvento() {
    }

    @When("Observa uno de los eventos")
    public void observaUnoDeLosEventos() {
        try {
            Thread.sleep(500);
        } catch (Exception e) {
            System.out.println(e);
        }
        webDriver.findElement(By.xpath("/html/body/app-root/app-nav-bar/mat-sidenav-container/mat-sidenav-content/main/app-home/div/div[3]/div[1]/mat-card/mat-card-header")).click();
    }

    @Then("Puede observar la fecha en la descripción del evento")
    public void puedeObservarLaFechaEnLaDescripciónDelEvento() {
    }
}
