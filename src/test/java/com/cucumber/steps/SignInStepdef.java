package com.cucumber.steps;

import com.frikiteam.events.configuration.MyWebDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInStepdef {
    //webDriver.findElement(By.xpath(""))

    public static WebDriver webDriver = MyWebDriver.getWebDriver();

    @Given("cuando selecciona el boton de la imagen de usuario")
    public void cuandoSeleccionaElBotonDeLaImagenDeUsuario() {
        webDriver.findElement(By.xpath("html/body/app-root/app-nav-bar/mat-toolbar/button[5]")).click();

    }

    @And("selecciona el boton Register")
    public void seleccionaElBotonRegister() {
        webDriver.findElement(By.xpath("//*[@id=\"mat-menu-panel-0\"]/div/button[2]")).click();
    }

    @When("selecciona la categoria ORGANIZER")
    public void seleccionaLaCategoriaORGANIZER() {
        webDriver.findElement(By.xpath("//*[@id=\"mat-tab-label-0-1\"]")).click();
    }

    @And("llena el formulario de datos")
    public void llenaElFormularioDeDatos() {
        WebElement inputEmail = webDriver.findElement(By.xpath("//*[@id=\"mat-input-6\"]"));
        inputEmail.sendKeys("hola@correo.com");
        webDriver.findElement(By.xpath("//*[@id=\"mat-input-7\"]")).sendKeys("Joc");
        webDriver.findElement(By.xpath("//*[@id=\"mat-input-8\"]")).sendKeys("Oliwis");
        webDriver.findElement(By.xpath("//*[@id=\"mat-input-9\"]")).sendKeys("contraseña123");
        webDriver.findElement(By.xpath("//*[@id=\"mat-input-10\"]")).sendKeys("Soy una persona aburrida que le gustan las fiestas 7w7");
    }

    @Then("el sistema guarda los datos asociados al perfil e ingresa al sistema automaticamente")
    public void elSistemaGuardaLosDatosAsociadosAlPerfilEIngresaAlSistemaAutomaticamente() {
        //webDriver.findElement(By.xpath("//*[@id=\"mat-tab-content-0-1\"]/div/div/form/button")).click();
    }
}
