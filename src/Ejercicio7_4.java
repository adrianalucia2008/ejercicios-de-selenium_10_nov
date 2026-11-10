
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ejercicio7_4 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        try {

            driver.get("https://demoqa.com/buttons");

            driver.manage().window().maximize();


            WebElement boton = wait.until(ExpectedConditions.elementToBeClickable(By.id("doubleClickBtn")));


            Actions acciones = new Actions(driver);


            acciones.doubleClick(boton).perform();


            WebElement mensaje = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("doubleClickMessage")));


            String resultado = mensaje.getText();

            System.out.println("Mensaje obtenido: " + resultado);



            if (resultado.contains("You have done a double click")) {

                System.out.println("PRUEBA EXITOSA: Se realizó el doble clic correctamente.");

            } else {

                System.out.println("PRUEBA FALLIDA: No se confirmó el doble clic.");

            }

        } finally {


            driver.quit();

        }
    }
}
