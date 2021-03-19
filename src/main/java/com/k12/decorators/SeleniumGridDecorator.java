package com.k12.decorators;

import com.k12.AutomatedBrowser;
import com.k12.decoratorbase.AutomatedBrowserBase;
import com.k12.exceptions.ConfigurationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;

import java.net.URL;

public class SeleniumGridDecorator extends AutomatedBrowserBase {


    public SeleniumGridDecorator(final AutomatedBrowser automatedBrowser) {
        super(automatedBrowser);
    }

    @Override
    public void init() {
        try {
            String host="localhost";
            if(System.getProperty("HUB_HOST")!= null){
                host=System.getProperty("HUB_HOST");
            }
            final String hub="4444/wd/hub";
            final String url = "http://" +
                    host + ":" + hub;
//            final WebDriver webDriver = new RemoteWebDriver(new URL(url), getDesiredCapabilities());
//                ((RemoteWebDriver) webDriver).setFileDetector(new LocalFileDetector());

            final RemoteWebDriver webDriver = new RemoteWebDriver(new URL(url), getDesiredCapabilities());
            webDriver.setFileDetector(new LocalFileDetector());

            getAutomatedBrowser().setWebDriver(webDriver);
            getAutomatedBrowser().init();
        } catch (MalformedURLException ex) {
            throw new ConfigurationException(ex);
        }
    }
}