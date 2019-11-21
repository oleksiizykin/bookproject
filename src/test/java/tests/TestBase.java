package tests;

import api.ConfigurationIO;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.URL;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class TestBase {
    private ConfigurationIO configurationIO = new ConfigurationIO();
    private String baseUrl;
    private String browser;
    private String browserVersion;

    {
        try {
            baseUrl = "http://" + configurationIO.getProperty("BASE_URL", ConfigurationIO.pathToConfiguration);
            browser = configurationIO.getProperty("BROWSER", ConfigurationIO.pathToConfiguration);
            browserVersion = configurationIO.getProperty("BROWSER_VERSION", ConfigurationIO.pathToConfiguration);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    protected void setupDriver() throws IOException {
        if (configurationIO.getProperty("RUN_REMOTELY", ConfigurationIO.pathToConfiguration).equals("1")) {
            configurationRemoteDriver();
        } else {
            configurationDriver();
        }
    }

    private void configurationDriver() {
        Configuration.baseUrl = baseUrl;
        Configuration.browser = browser;
        Configuration.browserVersion = browserVersion;
        Configuration.timeout = 10000;
        Configuration.startMaximized = true;
    }

    private void configurationRemoteDriver() throws IOException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(browser);
        capabilities.setVersion(browserVersion);
        Configuration.baseUrl = baseUrl;
        Configuration.timeout = 10000;
        // If you will run on Selenoid
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        //----------------------------

        RemoteWebDriver driver = new RemoteWebDriver(
                new URL(configurationIO.getProperty("HUB", ConfigurationIO.pathToConfiguration)),
                capabilities);
        setWebDriver(driver);
        getWebDriver().manage().window().setSize(new Dimension(1920, 1080));
    }

    public void removeDriver() {
        getWebDriver().quit();
    }
}
