import Pages.MainPageScooter;
import Pages.OrderPageScooterSelenium;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class PositiveScenarioTest extends BaseTest {

    private final String name;
    private final String surname;
    private final String address;
    private final String metroStation;
    private final String phoneNumber;
    private final int deliveryDate;
    private final String rentalDays;
    private final String colorOfScooter;
    private final String commentForСourier;

    public PositiveScenarioTest(
            String name,
            String surname,
            String address,
            String metroStation,
            String phoneNumber,
            int deliveryDate,
            String rentalDays,
            String colorOfScooter,
            String commentForСourier
    ) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metroStation = metroStation;
        this.phoneNumber = phoneNumber;
        this.deliveryDate = deliveryDate;
        this.rentalDays = rentalDays;
        this.colorOfScooter = colorOfScooter;
        this.commentForСourier = commentForСourier;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"Екатерина", "Гордон", "ул. Пятницкое шоссе, д.42", "Фрунзенская", "89070520562", 10, "двое суток", "grey", "Оставить у двери"},
                {"Мария", "Хворова", "ул. Парковая, д.10", "Академическая", "+796356655", 5, "пятеро суток", "black", "Позвонить в домофон"},
        };
    }

    @Test
    public void shouldMakeOrder() {
        MainPageScooter mainPage = new MainPageScooter(driver); // Создаем экземпляр класса MainPageScooter
        OrderPageScooterSelenium orderPageScooterSelenium = new OrderPageScooterSelenium(driver);
        mainPage.open();
        orderPageScooterSelenium
                .fillNameField(name)
                .fillSurnameField(surname)
                .fillAddressField(address)
                .selectMetroStation(metroStation)
                .fillPhoneNumberField(phoneNumber)
                .clickNextButton()
                .selectDeliveryDate(deliveryDate)
                .selectRentalDaysField(rentalDays)
                .selectColorOfScooter(colorOfScooter)
                .fillCommentForСourierField(commentForСourier)
                .clickMakeOrderMiddleButton()
                .clickConfirmOrderWindowYesButton();

        assertTrue(
                "Сообщение об успешном оформлении заказа не появилось.",
                orderPageScooterSelenium.isOrderPlaced()
        );
    }
}

