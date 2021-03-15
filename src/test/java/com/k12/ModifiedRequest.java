package com.k12;

import org.testng.annotations.Test;

public class ModifiedRequest {

    private static final AutomatedBrowserFactory AUTOMATED_BROWSER_FACTORY = new AutomatedBrowserFactory();

    @Test
    public void modifyRequests() {
        final AutomatedBrowser automatedBrowser =
                AUTOMATED_BROWSER_FACTORY.getAutomatedBrowser("SeleniumGridFirefox");
        try {
            automatedBrowser.init();
            automatedBrowser.captureHarFile();
            automatedBrowser.blockRequestTo(".*?\\.svg", 201);
            automatedBrowser.blockRequestTo("https://.*?twitter\\.com/", 500);
            automatedBrowser.goTo("https://www.facebook.com/");
        } finally {
            try {
                automatedBrowser.saveHarFile("testFacebook.har");
            } finally {
                automatedBrowser.destroy();

            }
        }
    }
}
