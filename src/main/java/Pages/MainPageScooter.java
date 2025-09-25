package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPageScooter {

    private WebDriver driver;
    private String MAIN_PAGE_RELATIVE_URL = "/";

    public MainPageScooter(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://qa-scooter.praktikum-services.ru");

    }

    public void clickHeaderOrderButton() {
        driver.findElement(By.xpath(".//div[contains(@class,'Header_Nav')]/button[text()='Заказать']")).click();
    }

    public void clickHomeOrderButton() {
        driver.findElement(By.xpath(".//div[contains(@class,'Home_Finish')]/button[text()='Заказать']")).click();
    }

    public void clickQuestionWithText(String text) {
        driver.findElement(By.xpath(String.format(".//div[text()='%s']", text))).click();
    }

    public String getTextOfExpandedAnswer() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement expandedAnswer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='accordion__panel' and not(@hidden)]")));
        return expandedAnswer.getText();
    }
}
