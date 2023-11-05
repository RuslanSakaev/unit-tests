package seminars.five;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SeleniumTest {
    // https://github.com/google/guava/releases - ссылка для скачивания Гуава

    private WebDriver webDriver;

    @BeforeEach
    void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // Открыть браузер в максимальном размере
        webDriver = new ChromeDriver(options);
    }

    @AfterEach
    void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

    @Test
    void googleSearchSeleniumTest() {
        webDriver.get("https://www.google.com");
        WebElement searchBox = webDriver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium");
        searchBox.submit();

        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10)); // Использую Duration в связи с изменением версии WebDriverWait
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("https://www.selenium.dev")));

        List<WebElement> searchResults = webDriver.findElements(By.cssSelector("div"));
        boolean linkFound = false;
        for (WebElement result : searchResults) {
            if (result.getText().contains("https://www.selenium.dev")) {
                linkFound = true;
                break;
            }
        }

        assertThat(linkFound).isTrue();
    }

    @Test
    void saucedemoAuthorizationTest() {
        webDriver.get("https://www.saucedemo.com");
        WebElement usernameField = webDriver.findElement(By.id("user-name"));
        usernameField.sendKeys("standard_user");
        WebElement passwordField = webDriver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");
        passwordField.submit();

        WebElement productsLabel = webDriver.findElement(By.className("title"));
        assertThat(productsLabel.getText()).isEqualTo("Products");

        List<WebElement> productItems = webDriver.findElements(By.className("inventory_item"));
        assertThat(productItems).isNotEmpty();
    }
}
