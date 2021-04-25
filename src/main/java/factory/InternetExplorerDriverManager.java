package factory;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class InternetExplorerDriverManager extends DriverManager {
    private InternetExplorerDriverService ieService;
    @Override
    protected void startService() {
        if(ieService == null) {
            System.setProperty("webdriver.ie.driver", "src/Driver/IEDriverServer.exe");
            ieService = new InternetExplorerDriverService.Builder().usingAnyFreePort().build();
            try {
                ieService.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void stopService() {
        if(ieService.isRunning() && ieService != null) {
            ieService.stop();
        }
    }

    @Override
    protected void createDriver() {
        driver = new InternetExplorerDriver(ieService);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
}
