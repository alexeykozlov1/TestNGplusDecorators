package com.k12;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class BrowserStack {

    private static final AutomatedBrowserFactory AUTOMATED_BROWSER_FACTORY = new AutomatedBrowserFactory();
    @Test
    public void browserStackTest() {


        final AutomatedBrowser automatedBrowser =
                AUTOMATED_BROWSER_FACTORY.getAutomatedBrowser("BrowserStackEdge");

        final String formButtonLocator = "button_element";
        final String formTextBoxLocator = "text_element";
        final String formTextAreaLocator = "textarea_element";
        final String formDropDownListLocator = "[name=select_element]";
        final String formCheckboxLocator = "//*[@name=\"checkbox1_element\"]";

        final String messageLocator = "message";

        try {
            automatedBrowser.init();

            automatedBrowser.goTo("https://ipublicmarketing.s3.amazonaws.com/form.html");

            automatedBrowser.clickElement(formButtonLocator);
            assertEquals("Button Clicked", automatedBrowser.getTextFromElement(messageLocator));

            automatedBrowser.populateElement(formTextBoxLocator, "test text");
            assertEquals("Text Input Changed", automatedBrowser.getTextFromElement(messageLocator));

            automatedBrowser.populateElement(formTextAreaLocator, "test text");
            assertEquals("Text Area Changed", automatedBrowser.getTextFromElement(messageLocator));

            automatedBrowser.selectOptionByTextFromSelect("Option 2.1", formDropDownListLocator);
            assertEquals("Select Changed",  automatedBrowser.getTextFromElement(messageLocator));

            automatedBrowser.clickElement(formCheckboxLocator);
            assertEquals("Checkbox Changed",  automatedBrowser.getTextFromElement(messageLocator));

        } finally {
            automatedBrowser.destroy();
        }
    }

    @Test
    public void browserStackAndroidTest() {

        final AutomatedBrowser automatedBrowser =
                AUTOMATED_BROWSER_FACTORY.getAutomatedBrowser("BrowserStackAndroid");

        final String formButtonLocator = "button_element";
        final String formTextBoxLocator = "text_element";
        final String formTextAreaLocator = "textarea_element";
        final String formDropDownListLocator = "[name=select_element]";
        final String formCheckboxLocator = "//*[@name=\"checkbox1_element\"]";
        final String messageLocator = "message";

        try {
            automatedBrowser.init();

            automatedBrowser.goTo("https://ipublicmarketing.s3.amazonaws.com/form.html");

            automatedBrowser.clickElement(formButtonLocator);
            assertEquals("Button Clicked", automatedBrowser.getTextFromElement(messageLocator));

            automatedBrowser.populateElement(formTextBoxLocator, "test text");
            assertEquals("Text Input Changed", automatedBrowser.getTextFromElement(messageLocator));

            automatedBrowser.populateElement(formTextAreaLocator, "test text");
            assertEquals("Text Area Changed", automatedBrowser.getTextFromElement(messageLocator));

            automatedBrowser.selectOptionByTextFromSelect("Option 2.1",
                    formDropDownListLocator);
            assertEquals("Select Changed", automatedBrowser.getTextFromElement(messageLocator));

            automatedBrowser.clickElement(formCheckboxLocator);
            assertEquals("Checkbox Changed", automatedBrowser.getTextFromElement(messageLocator));
        } finally {
            automatedBrowser.destroy();
        }
    }

    @Test
    public void browserStackEdgeTest() {
        final AutomatedBrowser automatedBrowser =
                AUTOMATED_BROWSER_FACTORY.getAutomatedBrowser("BrowserStackEdge");

        final String formButtonLocator = "button_element";
        final String formTextBoxLocator = "text_element";
        final String formTextAreaLocator = "textarea_element";
        final String formDropDownListLocator = "[name=select_element]";
        final String formCheckboxLocator = "//*[@name=\"checkbox1_element\"]";

        final String messageLocator = "message";

        try {
            automatedBrowser.init();

            automatedBrowser.maximizeWindow();

            automatedBrowser.goTo("https://ipublicmarketing.s3.amazonaws.com/form.html");

            automatedBrowser.clickElement(formButtonLocator);
            assertEquals("Button Clicked", automatedBrowser.getTextFromElement(messageLocator));

            automatedBrowser.populateElement(formTextBoxLocator, "test text");

            assertEquals("Text Input Changed", automatedBrowser.getTextFromElement(messageLocator));

            automatedBrowser.populateElement(formTextAreaLocator, "test text");

            assertEquals("Text Area Changed", automatedBrowser.getTextFromElement(messageLocator));

            automatedBrowser.selectOptionByTextFromSelect("Option 2.1", formDropDownListLocator);
            assertEquals("Select Changed", automatedBrowser.getTextFromElement(messageLocator));

            automatedBrowser.clickElement(formCheckboxLocator);
            assertEquals("Checkbox Changed", automatedBrowser.getTextFromElement(messageLocator));
        } finally {
            automatedBrowser.destroy();
        }
    }
}
