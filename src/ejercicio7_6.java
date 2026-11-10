
import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

 public class ejercicio7_6 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            driver.get("https://www.selenium.dev/selenium/web/dynamic.html");

            WebElement boton = wait.until(ExpectedConditions.elementToBeClickable(By.id("reveal")));
            boton.click();


            WebElement campo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("revealed")));

            campo.sendKeys("Prueba Selenium ADSO");

            String texto = campo.getDomProperty("value");

            System.out.println("Texto ingresado: " + texto);

            if (texto.equals("Prueba Selenium ADSO")) {
                System.out.println("PRUEBA EXITOSA: El texto fue ingresado correctamente.");

                File captura = ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.FILE);

                FileHandler.copy(captura, new File("evidencia_selenium.png"));

                System.out.println("Captura guardada correctamente.");
            } else {
                System.out.println("PRUEBA FALLIDA: El texto no coincide.");
            }

        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());

        } finally {
            driver.quit();
        }
    }
}
