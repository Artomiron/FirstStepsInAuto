package packageOne;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class classOne {
    @Test
    public  void firstTestMethod(){
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://rozetka.com.ua/ua/");
        System.out.println("Rozetka opened");
        driver.quit();
    }

    @Test
    public  void secondTestMethod(){
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.linkedin.com/feed/");
        System.out.println("Linkedin opened");
        driver.quit();
    }

}
