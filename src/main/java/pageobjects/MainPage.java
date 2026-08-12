package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class MainPage {

    private WebDriver driver;

   private By questionByIndex(int index){
       return By.id("accordion__heading-" + index);
   }

    public void clickQuestion(int index) {
        WebElement question = driver.findElement(questionByIndex(index));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block: 'center'});", question);

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(question));

        question.click();
    }

   private By getAnswer(int index){
       return By.id("accordion__panel-" + index);
   }

   public String getAnswerText(int index){
       return driver.findElement(getAnswer(index)).getText();
   }

    public void waitForAnswer(int index) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(getAnswer(index)));
    }

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
}