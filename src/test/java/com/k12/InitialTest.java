package com.k12;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.URISyntaxException;

public class InitialTest {
    private static final AutomatedBrowserFactory AUTOMATED_BROWSER_FACTORY
            = new AutomatedBrowserFactory();


//    @Test
//    public void openURL() {
//        final ChromeDriver chromeDriver = new ChromeDriver();
//        chromeDriver.get("https://ipublicmarketing.s3.amazonaws.com/form.html");
//        chromeDriver.quit();
//    }
//
//    @Test
//    public void openURLFirefox() {
//        final FirefoxDriver firefoxDriver = new FirefoxDriver();
//        firefoxDriver.get("https://ipublicmarketing.s3.amazonaws.com/form.html");
//        firefoxDriver.quit();
//    }

    @Test
    @Parameters("browser")
    public void openURL1(String browser) {
        final AutomatedBrowser automatedBrowser =
                AUTOMATED_BROWSER_FACTORY.getAutomatedBrowser(browser);

        automatedBrowser.init();
        automatedBrowser.goTo("https://ipublicmarketing.s3.amazonaws.com/form.html");
        automatedBrowser.destroy();
    }

    @Test
    @Parameters("browser")
    public void captureHarFile(String browser) throws URISyntaxException {
        final AutomatedBrowser automatedBrowser =
                AUTOMATED_BROWSER_FACTORY.getAutomatedBrowser(browser);

        try {
            automatedBrowser.init();
            automatedBrowser.captureHarFile();
            automatedBrowser.goTo("https://ipublicmarketing.s3.amazonaws.com/form.html");
        } finally {
            try {
                automatedBrowser.saveHarFile("test.har");
            } finally {
                automatedBrowser.destroy();
            }
        }
    }
}