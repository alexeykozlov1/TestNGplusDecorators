package com.k12;

import com.k12.AutomatedBrowser;
import org.testng.annotations.Test;

import java.net.URISyntaxException;

public class HarTraffic {
    private static final AutomatedBrowserFactory AUTOMATED_BROWSER_FACTORY = new AutomatedBrowserFactory();
    @Test
    public void captureCompleteHarFile() throws URISyntaxException {


        final AutomatedBrowser automatedBrowser =
                AUTOMATED_BROWSER_FACTORY.getAutomatedBrowser("Chrome");

        try {
            automatedBrowser.init();
            automatedBrowser.captureCompleteHarFile();
            automatedBrowser.goTo("https://ipublicmarketing.s3.amazonaws.com/form.html");
        } finally {
            try {
                automatedBrowser.saveHarFile("test2.har");
            } finally {
                automatedBrowser.destroy();
            }
        }
    }
}
