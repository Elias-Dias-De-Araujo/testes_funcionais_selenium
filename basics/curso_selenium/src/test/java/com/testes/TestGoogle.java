package com.testes;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class TestGoogle {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void TitleTest0() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().setSize(new Dimension(1000, 765));
        driver.get("https://www.google.com/");
        assertEquals("Google", driver.getTitle());
        driver.quit();
    }

}
