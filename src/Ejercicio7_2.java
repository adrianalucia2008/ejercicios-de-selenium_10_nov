
import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ejercicio7_2 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        try {

            WebDriverWait wait = new WebDriverWait(
                    driver, Duration.ofSeconds(15)
            );

            driver.get("https://demoqa.com/radio-button");
            driver.manage().window().maximize();

            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector("label[for='yesRadio']")
            ));

            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector("label[for='impressiveRadio']")
            ));

            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector("label[for='noRadio']")
            ));


            WebElement impressive = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.cssSelector("label[for='impressiveRadio']")
                    )
            );

            impressive.click();


            WebElement radio = driver.findElement(
                    By.id("impressiveRadio")
            );


            WebElement mensaje = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.cssSelector(".text-success")
                    )
            );

            String resultado = mensaje.getText();

            System.out.println("Mensaje obtenido: " + resultado);

            if (radio.isSelected() &&
                    resultado.contains("Impressive")) {

                System.out.println(
                        "PRUEBA EXITOSA:Fue seleccionado correctamente."
                );

            } else {

                System.out.println(
                        "PRUEBA FALLIDA: No se confirmó la selección."
                );
            }

        } finally {

            driver.quit();

        }
    }
}
