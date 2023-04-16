package com.testes;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class TestGoogleTitle {
    /**
     * Rigorous Test :-)
     */

    private WebDriver driver;

    @Before
    public void begin() {
        driver = new FirefoxDriver();
        driver.manage().window().setSize(new Dimension(1000, 765));
        driver.get("https://www.google.com/");
    }

    @After
    public void end() {
        driver.quit();
    }

    @Test
    public void TitleTest0() {
        assertEquals("Google", driver.getTitle());
    }

}
