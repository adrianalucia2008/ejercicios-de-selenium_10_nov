
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ejercicio7_3 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            driver.get("https://www.selenium.dev/selenium/web/web-form.html");

            driver.manage().window().maximize();


            WebElement texto = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("my-text")));



            texto.sendKeys("Prueba ADSO");

            driver.findElement(By.name("my-password")).sendKeys("Sena2026");

            driver.findElement(By.name("my-textarea")).sendKeys("Automatización con Selenium");


            WebElement boton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
            boton.click();
            By cuerpo = By.tagName("body");
            wait.until(ExpectedConditions.textToBePresentInElementLocated(cuerpo, "Received!"));
            String resultado = driver.findElement(cuerpo).getText();

            System.out.println("Resultado obtenido: " + resultado);


            if (resultado.contains("Received!")) {

                System.out.println("PRUEBA EXITOSA: El formulario fue enviado correctamente.");

            } else {

                System.out.println("PRUEBA FALLIDA: No apareció el mensaje esperado.");

            }

        } finally {


            driver.quit();

        }
    }
}
