import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;//Подключаем менеджер веб драйвера

// Базовый класс для тестов
public class BaseTest {

    protected WebDriver driver; // Защищенный доступ для использования в дочерних классах

    // Метод, выполняемый перед каждым тестом
    @Before
    public void setUp() {
        // Инициализация WebDriverManager для автоматической настройки драйвера
        WebDriverManager.chromedriver().setup();
        // Создание экземпляра ChromeDriver
        driver = new ChromeDriver();
        // Открытие главной страницы сайта
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    // Метод, выполняемый после каждого теста

    }
