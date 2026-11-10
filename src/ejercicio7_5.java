
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ejercicio7_5 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        try {
            driver.get("https://demoqa.com/webtables");
            driver.manage().window().maximize();

            WebElement agregar = wait.until(ExpectedConditions.elementToBeClickable(By.id("addNewRecordButton")));

            agregar.click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("registration-form-modal")));

            driver.findElement(By.id("firstName")).sendKeys("Carlos");
            driver.findElement(By.id("lastName")).sendKeys("Ramírez");
            driver.findElement(By.id("userEmail")).sendKeys("carlos@gmail.com");
            driver.findElement(By.id("age")).sendKeys("25");
            driver.findElement(By.id("salary")).sendKeys("2500000");
            driver.findElement(By.id("department")).sendKeys("Sistemas");

            WebElement guardar = wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));

            guardar.click();

            By pagina = By.tagName("body");

            wait.until(ExpectedConditions.textToBePresentInElementLocated(pagina, "carlos@gmail.com"));

            WebElement buscar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchBox")));

            buscar.clear();
            buscar.sendKeys("Carlos");

            wait.until(ExpectedConditions.textToBePresentInElementLocated(pagina, "carlos@gmail.com"));

            String resultado = driver.findElement(pagina).getText();

            System.out.println("Registro encontrado:");
            System.out.println(resultado);

            if (resultado.contains("Carlos")
                    && resultado.contains("Ramírez")
                    && resultado.contains("carlos@gmail.com")
                    && resultado.contains("25")
                    && resultado.contains("2500000")
                    && resultado.contains("Sistemas")) {

                System.out.println("PRUEBA EXITOSA: El registro fue agregado y encontrado correctamente.");

            } else {

                System.out.println("PRUEBA FALLIDA: Los datos del registro no coinciden.");
            }

        } finally {
            driver.quit();
        }
    }
}
