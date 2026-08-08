package pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class OrderPage {
    private WebDriver driver;
private By topOrderButton = By.xpath("//div[contains(@class,'Header_Nav')]//button[text()='Заказать']");
private By nameField = By.xpath(".//input[@placeholder = '* Имя']");
private By surnameField = By.xpath(".//input[@placeholder = '* Фамилия']");
private By adressField = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");
private By metroField = By.xpath(".//input[@placeholder = '* Станция метро']");
private By numberField = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");
private By buttonNext = By.xpath(".//button[text() = 'Далее']");
private By cherkizovskayaStation = By.xpath(".//button[@value='Черкизовская']");
private By orderDateField = By.xpath(".//input[@placeholder = '* Когда привезти самокат']");
private By rentalPeriodField = By.xpath(".//div[text() = '* Срок аренды']");
private By finalButtonOrder = By.xpath("//div[contains(@class,'Order_Buttons')]//button[text()='Заказать']");
private By bottomOrderButton = By.xpath("//div[contains(@class,'Home_FinishButton')]//button");
private By buttonYes = By.xpath(".//button[text() = 'Да']");
    private By blackColorCheckbox =  By.xpath(".//label[@for='black']");
private By SuccessOrderMessage = By.xpath(".//div[text() = 'Заказ оформлен']");
private By buttonDalle = By.xpath(".//button[text() = 'Далее']");

public void clickDalle(){
    driver.findElement(buttonDalle).click();
}

public void clicktopOrderButton(){
    driver.findElement(topOrderButton).click();
}

public void enterName(String name){
    driver.findElement(nameField).sendKeys(name);
}

public void enterSurname(String surname){
    driver.findElement(surnameField).sendKeys(surname);
}

public void enterAddress(String address){
    driver.findElement(adressField).sendKeys(address);
}

    public void chooseMetroStation(String station) {
        driver.findElement(metroField).click();

        By stationOption = By.xpath(
                "//div[contains(@class,'select-search__select')]//*[normalize-space(.)='" + station + "']"
        );

        WebElement option = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(stationOption));

        option.click();
    }


   public void enterNumberField(String number){
    driver.findElement(numberField).sendKeys(number);
   }
public void enterButtonNext(){
    driver.findElement(buttonNext).click();
}

    public void enterOrderDate(String date) {
        driver.findElement(orderDateField).sendKeys(date);
    }


    public void chooseRentalPeriod(String period) {
        driver.findElement(rentalPeriodField).click();

        By periodOption = By.xpath(
                "//*[normalize-space(text())='" + period + "']"
        );

        WebElement option = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(periodOption));

        option.click();
    }
    public void chooseBlackColor() {
        driver.findElement(blackColorCheckbox).click();
    }

    public void enterFinalButtonOrder(){
    driver.findElement(finalButtonOrder).click();
    }

public void clickYes(){
    driver.findElement(buttonYes).click();
}

public void clickBottomOrderButton(){
    driver.findElement(bottomOrderButton).click();
}

public String getSuccessOrderMessage(){
    return driver.findElement(SuccessOrderMessage).getText();
}

public OrderPage(WebDriver driver) {
    this.driver = driver;
}

public void fillFirstOrderForm(String name, String SurName,String address, String station, String number ){
    enterName(name);
    enterSurname(SurName);
    enterAddress(address);
    chooseMetroStation(station);
    enterNumberField(number);
    clickDalle();
}

public  void fillSecondOrderForm(String date, String period){
    enterOrderDate(date);
    chooseRentalPeriod(period);
    chooseBlackColor();
}


}
