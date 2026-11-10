
import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

public class ejercicio7 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        try {

            driver.get("https://demoqa.com/text-box");

            WebElement nombre = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userName"))
            );

            nombre.sendKeys("Laura Martínez");
            driver.findElement(By.id("userEmail")).sendKeys("laura@gmail.com");
            driver.findElement(By.id("currentAddress")).sendKeys("Calle 25 # 10-20");
            driver.findElement(By.id("permanentAddress")).sendKeys("Carrera 15 # 30-40");

            WebElement boton = wait.until(ExpectedConditions.elementToBeClickable(By.id("submit"))
            );

            boton.click();

            WebElement resultado = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("output"))
            );

            String datos = resultado.getText();

            if (datos.contains("Laura Martínez") &&
                    datos.contains("laura@gmail.com")) {

                System.out.println("PRUEBA EXITOSA: Los datos se registraron correctamente.");

            } else {
                System.out.println("PRUEBA FALLIDA: Los datos no coinciden.");
            }

        } finally {

        }
    }
}
