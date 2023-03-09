import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardOrderTest {
    private WebDriver driver;

    @BeforeAll
    static void setUpAll() {
        WebDriverManager.chromedriver().setup();
        //System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");
    }

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--disable-dev-shm-usage");
        //options.addArguments("--no-sandbox");
        //options.addArguments("--headless");
        //driver = new ChromeDriver(options);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        //driver = null;
    }

    @Test
    void shouldTestV1() {

        driver.get("http://localhost:9999/");
        //List<WebElement> inputs = driver.findElements(By.tagName("input"));

        //inputs.get(0).sendKeys("Василий");
        //inputs.get(1).sendKeys("+79261234455");

        driver.findElements(By.tagName("input")).get(0).sendKeys("Василий");
        driver.findElements(By.className("input__control")).get(1).sendKeys("+79261234455");
        driver.findElement(By.className("checkbox__box")).click();
        driver.findElement(By.className("button__text")).click();


        //driver.findElement().sendKeys("Василий");
        //driver.findElement().sendKeys("+79261234455");
        //driver.findElement().click();
        //driver.findElement().click();

        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        String actual = driver.findElement(By.tagName("p")).getText().trim();
        assertEquals(expected, actual);
    }
}
