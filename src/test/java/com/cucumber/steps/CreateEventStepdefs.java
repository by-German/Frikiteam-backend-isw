package com.cucumber.steps;

import com.frikiteam.events.configuration.MyWebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateEventStepdefs {
    //webDriver.findElement(By.xpath(""))
    String Path = System.getProperty("user.dir");
    public  WebDriver webDriver = MyWebDriver.getWebDriver();

    @Given("que el usuario quiere crear un evento")
    public void queElUsuarioQuiereCrearUnEvento() {
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
    }

    @When("ingresa los datos del evento y selecciona el boton guardar")
    public void ingresaLosDatosDelEventoYSeleccionaElBotonGuardar() {
        webDriver.findElement(By.xpath("/html/body/app-root/app-nav-bar/mat-toolbar/button[4]")).click();

        // Aqui enviamos el titulo del evento
        WebElement inputTitle = webDriver.findElement(By.xpath("//*[@id=\"mat-input-1\"]"));
        inputTitle.sendKeys("Tamales, los buenos tamales");

        // Descripcion
        WebElement textArea = webDriver.findElement(By.xpath("//*[@id=\"mat-input-2\"]"));
        textArea.sendKeys("Aqui se venden tamales esperalos con ansias 7w7");

        // Imagen
        webDriver.findElement(By.xpath("//*[@id=\"input-img\"]")).sendKeys(Path + "/images/fiesta.jpg");

        // Country
        WebElement mathInputCountry = webDriver.findElement(By.xpath("//*[@id=\"mat-select-0\"]"));
        mathInputCountry.click();
        WebElement selectCountry = webDriver.findElement(By.xpath("//*[@id=\"mat-option-0\"]/span"));
        selectCountry.click();
        try {
            //Ponemos a "Dormir" el programa durante los ms que queremos
            Thread.sleep(500);
        } catch (Exception e) {
            System.out.println(e);
        }
        // City
        webDriver.findElement(By.xpath("/html/body/app-root/app-nav-bar/mat-sidenav-container/mat-sidenav-content/main/app-create-event/mat-drawer-container/mat-drawer-content/div/div/app-general-information/div/form/mat-form-field[4]/div/div[1]")).click();
        webDriver.findElement(By.xpath("//*[@id=\"mat-option-1\"]")).click();
        try {
            //Ponemos a "Dormir" el programa durante los ms que queremos
            Thread.sleep(500);
        } catch (Exception e) {
            System.out.println(e);
        }
        // District
        webDriver.findElement(By.xpath("/html/body/app-root/app-nav-bar/mat-sidenav-container/mat-sidenav-content/main/app-create-event/mat-drawer-container/mat-drawer-content/div/div/app-general-information/div/form/mat-form-field[5]")).click();
        webDriver.findElement(By.xpath("//*[@id=\"mat-option-2\"]")).click();

        // Estacion atocongo - address
        WebElement inputPlace = webDriver.findElement(By.xpath("//*[@id=\"mat-input-4\"]"));
        inputPlace.sendKeys("Estacion Atocongo");

        // Referencia
        WebElement inputReference = webDriver.findElement(By.xpath("//*[@id=\"mat-input-5\"]"));
        inputReference.sendKeys("Cerca del Metro-centro comercial");

        // BUSINESS INFORMATION
        // Price
        WebElement inputPrice = webDriver.findElement(By.xpath("//*[@id=\"mat-input-6\"]"));
        inputPrice.sendKeys("20");

        // Number of entries
        WebElement inputEntries = webDriver.findElement(By.xpath("//*[@id=\"mat-input-3\"]"));
        inputEntries.sendKeys("50");

        // Enter a date range
        webDriver.findElement(By.xpath("/html/body/app-root/app-nav-bar/mat-sidenav-container/mat-sidenav-content/main/app-create-event/mat-drawer-container/mat-drawer-content/div/div/app-general-information/div/form/mat-form-field[10]/div/div[1]/div[2]/mat-datepicker-toggle/button")).click();
        webDriver.findElement(By.xpath("//*[@id=\"mat-datepicker-0\"]/mat-calendar-header/div/div/button[3]")).click();
        webDriver.findElement(By.xpath("//*[@id=\"mat-datepicker-0\"]/div/mat-month-view/table/tbody/tr[4]/td[3]")).click();
        webDriver.findElement(By.xpath("//*[@id=\"mat-datepicker-0\"]/div/mat-month-view/table/tbody/tr[6]/td")).click();

        webDriver.findElement(By.xpath("/html/body/app-root/app-nav-bar/mat-sidenav-container/mat-sidenav-content/main/app-create-event/mat-drawer-container/mat-drawer-content/div/div/app-general-information/div/form/button")).click();

        try {
            //Ponemos a "Dormir" el programa durante los ms que queremos
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println(e);
        }

        // agregamos itinarario
        webDriver.findElement(By.xpath("//*[@id=\"mat-input-7\"]")).sendKeys("123");

        // agregamos información detallada
        webDriver.findElement(By.xpath("//*[@id=\"mat-input-8\"]")).sendKeys("Tamales");
        webDriver.findElement(By.xpath("//*[@id=\"mat-input-9\"]")).sendKeys("Se venden tamales, recien salidos del horno");
        webDriver.findElement(By.xpath("//*[@id=\"input-img\"]")).sendKeys(Path + "/images/tamales.jpeg");
        webDriver.findElement(By.xpath("/html/body/app-root/app-nav-bar/mat-sidenav-container/mat-sidenav-content/main/app-create-event/mat-drawer-container/mat-drawer-content/div/div/app-detailed-information/div/form[2]/button[2]")).click();

        try {
            //Ponemos a "Dormir" el programa durante los ms que queremos
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println(e);
        }

        webDriver.findElement(By.xpath("//*[@id=\"mat-input-10\"]")).sendKeys("tamales-tamaleros01.com");
        webDriver.findElement(By.xpath("/html/body/app-root/app-nav-bar/mat-sidenav-container/mat-sidenav-content/main/app-create-event/mat-drawer-container/mat-drawer-content/div/div/app-optional-information/div/form/button")).click();
        try {
            //Ponemos a "Dormir" el programa durante los ms que queremos
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Then("el evento es guardado en la base de datos.")
    public void elEventoEsGuardadoEnLaBaseDeDatos() {
    }
}