package com.k12;

import com.k12.decorators.*;

public class AutomatedBrowserFactory {

    public AutomatedBrowser getAutomatedBrowser(final String browser) {

        if ("Chrome".equalsIgnoreCase(browser)) {
            return getChromeBrowser(false);
        }

        if ("ChromeHeadless".equalsIgnoreCase(browser)) {
            return getChromeBrowser(true);
        }

        if ("Firefox".equalsIgnoreCase(browser)) {
            return getFirefoxBrowser(false);
        }

        if ("FirefoxHeadless".equalsIgnoreCase(browser)) {
            return getFirefoxBrowser(true);
        }
        if ("ChromeNoImplicitWait".equalsIgnoreCase(browser)) {
            return getChromeBrowserNoImplicitWait();
        }

        if ("FirefoxNoImplicitWait".equalsIgnoreCase(browser)) {
            return getFirefoxBrowserNoImplicitWait();
        }

        if ("BrowserStackEdge".equalsIgnoreCase(browser)) {
            return getBrowserStackEdge();
        }

        if ("BrowserStackEdgeNoImplicitWait".equalsIgnoreCase(browser)) {
            return getBrowserStackEdgeNoImplicitWait();
        }

        if ("BrowserStackAndroid".equalsIgnoreCase(browser)) {
            return getBrowserStackAndroid();
        }

        if ("BrowserStackAndroidNoImplicitWait".equalsIgnoreCase(browser)) {
            return getBrowserStackAndroidNoImplicitWait();
        }

        if ("SeleniumGridChrome".equalsIgnoreCase(browser)) {
            return getSeleniumGridChrome();
        }

        if ("SeleniumGridChromeNoImplicitWait".equalsIgnoreCase(browser)) {
            return getSeleniumGridChromeNoImplicitWait();
        }

        if ("SeleniumGridFirefox".equalsIgnoreCase(browser)) {
            return getSeleniumGridFirefox();
        }

        if ("SeleniumGridFirefoxNoImplicitWait".equalsIgnoreCase(browser)) {
            return getSeleniumGridFirefoxNoImplicitWait();
        }
        throw new IllegalArgumentException("Unknown browser " + browser);

    }
    private AutomatedBrowser getSeleniumGridFirefox() {
        return new SeleniumGridDecorator(
                new SeleniumGridFirefoxDecorator(
                        new ImplicitWaitDecorator(10,
                                new WebDriverDecorator()
                        )
                )
        );
    }

    private AutomatedBrowser getSeleniumGridFirefoxNoImplicitWait() {
        return new SeleniumGridDecorator(
                new SeleniumGridFirefoxDecorator(
                        new WebDriverDecorator()
                )
        );
    }

    private AutomatedBrowser getSeleniumGridChrome() {
        return new SeleniumGridDecorator(
                new SeleniumGridChromeDecorator(
                        new ImplicitWaitDecorator(10,
                                new WebDriverDecorator()
                        )
                )
        );
    }

    private AutomatedBrowser getSeleniumGridChromeNoImplicitWait() {
        return new SeleniumGridDecorator(
                new SeleniumGridChromeDecorator(
                        new WebDriverDecorator()
                )
        );
    }

    private AutomatedBrowser getChromeBrowserNoImplicitWait() {
        return new ChromeDecorator(
                new BrowserMobDecorator(
                        new WebDriverDecorator()
                )
        );
    }

    private AutomatedBrowser getFirefoxBrowserNoImplicitWait() {
        return new FirefoxDecorator(
                new BrowserMobDecorator(
                        new WebDriverDecorator()
                )
        );
    }

    private AutomatedBrowser getFirefoxBrowser(final boolean headless) {
        return new FirefoxDecorator(headless,
                new ImplicitWaitDecorator(10,
                        new BrowserMobDecorator(
                                new WebDriverDecorator()
                        )
                )
        );
    }

    private AutomatedBrowser getChromeBrowser(final boolean headless) {
        return new ChromeDecorator(headless,
                new ImplicitWaitDecorator(10,
                        new BrowserMobDecorator(
                                new WebDriverDecorator()
                        )
                )
        );
    }
    private AutomatedBrowser getBrowserStackEdge() {
        return new BrowserStackDecorator(
                new BrowserStackEdgeDecorator(
                        new ImplicitWaitDecorator(10,
                                new WebDriverDecorator()
                        )
                )
        );
    }

    private AutomatedBrowser getBrowserStackEdgeNoImplicitWait() {
        return new BrowserStackDecorator(
                new BrowserStackEdgeDecorator(
                        new WebDriverDecorator()
                )
        );
    }

    private AutomatedBrowser getBrowserStackAndroid() {
        return new BrowserStackDecorator(
                new BrowserStackAndroidDecorator(
                        new ImplicitWaitDecorator(10,
                                new WebDriverDecorator()
                        )
                )
        );
    }

    private AutomatedBrowser getBrowserStackAndroidNoImplicitWait() {
        return new BrowserStackDecorator(
                new BrowserStackAndroidDecorator(
                        new WebDriverDecorator()
                )
        );
    }

}