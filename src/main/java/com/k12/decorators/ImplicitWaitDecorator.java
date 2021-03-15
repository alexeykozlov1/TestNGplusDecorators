package com.k12.decorators;

import com.k12.AutomatedBrowser;
import com.k12.decoratorbase.AutomatedBrowserBase;
import java.util.concurrent.TimeUnit;

public class ImplicitWaitDecorator extends AutomatedBrowserBase {

    private final int waitTime;

    public ImplicitWaitDecorator(final int waitTime, final AutomatedBrowser automatedBrowser) {

        super(automatedBrowser);
        this.waitTime = waitTime;
    }

    @Override
    public void init() {
        getAutomatedBrowser()
                .getWebDriver()
                .manage()
                .timeouts()
                .implicitlyWait(waitTime, TimeUnit.SECONDS);

        getAutomatedBrowser().init();
    }
}