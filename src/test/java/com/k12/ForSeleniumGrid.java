package com.k12;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.URISyntaxException;

import static org.testng.AssertJUnit.assertEquals;

public class ForSeleniumGrid {

    private static final AutomatedBrowserFactory AUTOMATED_BROWSER_FACTORY = new AutomatedBrowserFactory();


    @Test
    @Parameters("browser")
    public void formTestByID(String browser) throws URISyntaxException {
        final AutomatedBrowser automatedBrowser =
                AUTOMATED_BROWSER_FACTORY.getAutomatedBrowser(browser);

        try {
            automatedBrowser.init();
            automatedBrowser.goTo("https://ipublicmarketing.s3.amazonaws.com/form.html");

            automatedBrowser.clickElementWithId("button_element");
            assertEquals("Button Clicked", automatedBrowser.getTextFromElementWithId("message"));
            automatedBrowser.populateElementWithId("text_element", "test text");
            assertEquals("Text Input Changed", automatedBrowser.getTextFromElementWithId("message"));

            automatedBrowser.populateElementWithId("textarea_element", "test text");
            assertEquals("Text Area Changed", automatedBrowser.getTextFromElementWithId("message"));


        } finally {
            automatedBrowser.destroy();
        }
    }
}
