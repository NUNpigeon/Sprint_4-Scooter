
package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OrderPageScooterSelenium {

    private WebDriver driver;
    private final String ORDER_PAGE_URL = "/order";
    private final By nameField = By.xpath(".//input[@placeholder='* Имя']");
    private final By surnameField = By.xpath(".//input[@placeholder='* Фамилия']");
    private final By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By metroStationField = By.xpath(".//input[@placeholder='* Станция метро']");
    private final By phoneNumberField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By nextButtonOrderPage = By.xpath(".//button[text()='Далее']");
    private final By deliveryDateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private final By rentalDaysField = By.xpath(".//div[@class='Dropdown-root']");
    private final By colorOfScooterGreyCheckbox = By.id("grey"); //локатор для серого цвета
    private final By colorOfScooterBlackCheckbox = By.id("black"); //локатор для черного цвета
    private final By commentForСourierField = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    private final By makeOrderMiddleButton = By.xpath(".//button[contains(@class, 'Button_Middle') and text()='Заказать']");
    private final By confirmOrderWindowYesButton = By.xpath(".//button[text()='Да']");
    private final By orderHasBeenPlaced = By.xpath(".//div[text()='Заказ оформлен']");


    public OrderPageScooterSelenium(WebDriver driver) {
        this.driver = driver;
    }


    public OrderPageScooterSelenium open(String baseUrl) {
        driver.get(baseUrl + ORDER_PAGE_URL);
        return this;
    }

    public OrderPageScooterSelenium fillNameField(String name) {
        driver.findElement(nameField).sendKeys(name);
        return this;
    }

    public OrderPageScooterSelenium fillSurnameField(String surname) {
        driver.findElement(surnameField).sendKeys(surname);
        return this;
    }

    public OrderPageScooterSelenium fillAddressField(String address) {
        driver.findElement(addressField).sendKeys(address);
        return this;
    }

    public OrderPageScooterSelenium selectMetroStation(String metroStation) {
        driver.findElement(metroStationField).click();
        driver.findElement(By.xpath(String.format("//*[text()='%s']/parent::*", metroStation))).click();
        return this;
    }

    public OrderPageScooterSelenium fillPhoneNumberField(String phoneNumber) {
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
        return this;
    }

    public OrderPageScooterSelenium clickNextButton() {
        driver.findElement(nextButtonOrderPage).click();
        return this;
    }

    public OrderPageScooterSelenium selectRentalDaysField(String rentalDays) {
        driver.findElement(rentalDaysField).click();
        driver.findElement(By.xpath(String.format("//div[@class='Dropdown-menu']/div[text()='%s']", rentalDays))).click();
        return this;
    }


    public OrderPageScooterSelenium selectDeliveryDate(int daysAfterToday) {
        driver.findElement(deliveryDateField).click();

        LocalDate futureDate = LocalDate.now().plusDays(daysAfterToday);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d");
        String day = futureDate.format(formatter);
        String xpath = String.format(".//div[@class='react-datepicker__month']/div/div[not(contains(@class, '--outside-month')) and text()='%s']", day);
        driver.findElement(By.xpath(xpath)).click();
        return this;
    }

    public OrderPageScooterSelenium selectColorOfScooter(String color) {
        if (color.equalsIgnoreCase("grey")) {
            driver.findElement(colorOfScooterGreyCheckbox).click();
        } else if (color.equalsIgnoreCase("black")) {
            driver.findElement(colorOfScooterBlackCheckbox).click();
        }
        return this;
    }


    public OrderPageScooterSelenium fillCommentForСourierField(String comment) {
        driver.findElement(commentForСourierField).sendKeys(comment);
        return this;
    }

    public OrderPageScooterSelenium clickMakeOrderMiddleButton() {
        driver.findElement(makeOrderMiddleButton).click();
        return this;
    }

    public OrderPageScooterSelenium clickConfirmOrderWindowYesButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(confirmOrderWindowYesButton)); // Явное ожидание
        driver.findElement(confirmOrderWindowYesButton).click();
        return this;
    }

    public boolean isOrderPlaced() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(orderHasBeenPlaced));
        return driver.findElement(orderHasBeenPlaced).isDisplayed();
    }


}
