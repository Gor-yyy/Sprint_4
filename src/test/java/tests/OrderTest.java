package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.OrderPage;
import static org.junit.Assert.assertTrue;


@RunWith(Parameterized.class)
public class OrderTest {

    private WebDriver driver;

    private final boolean useTopButton;
    private final String name;
    private final String surname;
    private final String address;
    private final String station;
    private final String number;
    private final String date;
    private final String period;
    private final String color;


public OrderTest(boolean useTopButton, String name, String surname, String address, String station,String number,String date, String period,String color){
    this.useTopButton = useTopButton;
    this.name = name;
    this.surname = surname;
    this.address = address;
    this.station = station;
    this.number = number;
    this.date = date;
    this.period = period;
    this.color = color;
}

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {
                        true,
                        "Иван",
                        "Иванов",
                        "Москва",
                        "Черкизовская",
                        "89111111111",
                        "20.08.2026",
                        "трое суток",
                        "black"
                },
                {
                        false,
                        "Петр",
                        "Петров",
                        "Санкт-Петербург",
                        "Сокольники",
                        "89222222222",
                        "25.08.2026",
                        "сутки",
                        "black"
                }


        };
    }

  @Before
    public void setUp(){
    driver = new ChromeDriver();
    driver.get("https://qa-scooter.praktikum-services.ru/");
  }

  @Test
    public void checkOrder(){
    OrderPage orderPage = new OrderPage(driver);

      if (useTopButton) {
          orderPage.clickTopOrderButton();
      } else {
          orderPage.clickBottomOrderButton();
      }

      orderPage.fillFirstOrderForm(name, surname, address, station, number);
      orderPage.fillSecondOrderForm(date, period);
      orderPage.enterFinalButtonOrder();
      orderPage.clickYes();
       String actualResult = orderPage.getSuccessOrderMessage();
      assertTrue(actualResult.contains("Заказ оформлен"));
    }

    @After
    public void closePage(){
    driver.quit();
    }

}