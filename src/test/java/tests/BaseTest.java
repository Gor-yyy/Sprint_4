package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    protected WebDriver driver;

    protected static final String BASE_URL =
            "https://qa-scooter.praktikum-services.ru/";

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}