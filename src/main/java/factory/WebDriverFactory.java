package factory;


public class WebDriverFactory {
    public static DriverManager getDriver(DriverType driverType){
        DriverManager webDriver;
        switch (driverType){
            case CHROME:
                webDriver = new ChromeDriverManager();
                break;
            case IE:
                webDriver = new InternetExplorerDriverManager();
                break;
            case FIREFOX:
                webDriver = new FirefoxDriverManager();
                break;
            default:
                throw new RuntimeException("Not supported Driver: " + driverType);
        }
        return webDriver;
    }
}
