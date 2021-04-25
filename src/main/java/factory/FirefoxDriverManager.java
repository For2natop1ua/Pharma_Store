package factory;

import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


public class FirefoxDriverManager extends DriverManager {
    //Selenium does not support Manager for Firefox =(

    @Override
    protected void startService() {
    }

    @Override
    protected void stopService() {
    }

    @Override
    protected void createDriver() {
        System.setProperty("webdriver.gecko.driver", "src/Driver/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
