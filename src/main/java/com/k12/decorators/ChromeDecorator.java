package com.k12.decorators;

import com.k12.AutomatedBrowser;
import com.k12.decoratorbase.AutomatedBrowserBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

public class ChromeDecorator extends AutomatedBrowserBase {

    final boolean headless;

    public ChromeDecorator(final AutomatedBrowser automatedBrowser) {
        super(automatedBrowser);
        this.headless = false;
    }

    public ChromeDecorator(final boolean headless, final AutomatedBrowser automatedBrowser) {
        super(automatedBrowser);
        this.headless = headless;
    }

    @Override
    public void init() {
        final ChromeOptions options = new ChromeOptions();
        options.setHeadless(headless);
        options.merge(getDesiredCapabilities());
        options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
        final WebDriver webDriver = new ChromeDriver(options);
        getAutomatedBrowser().setWebDriver(webDriver);
        getAutomatedBrowser().init();

    }
}