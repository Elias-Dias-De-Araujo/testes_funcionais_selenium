package com.testes;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import static org.junit.Assert.assertEquals;

public class TestFrameAndWindow {
	@Test
	public void testFrameButton() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1000, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/resources/componentes.html");

		driver.switchTo().frame("frame1").findElement(By.id("frameButton")).click();
		Alert alert = driver.switchTo().alert();
		assertEquals("Frame OK!", alert.getText());
		alert.accept();

		driver.quit();
	}

	@Test
	public void testWindowButton() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1000, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/resources/componentes.html");

		driver.findElement(By.id("buttonPopUpEasy")).click();
		Object[] windows = driver.getWindowHandles().toArray();
		driver.switchTo().window(windows[1].toString());
		driver.findElement(By.tagName("textarea")).sendKeys("Escrevendo na area de texto");
		String msg = driver.findElement(By.tagName("textarea")).getText();
		driver.close();
		driver.switchTo().window(windows[0].toString());
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys(msg);

		driver.quit();
	}

	@Test
	public void testWindowButtonNoName() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1000, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/resources/componentes.html");

		driver.findElement(By.id("buttonPopUpHard")).click();
		Object[] windows = driver.getWindowHandles().toArray();
		driver.switchTo().window(windows[1].toString());
		driver.findElement(By.tagName("textarea")).sendKeys("Escrevendo na area de texto");
		String msg = driver.findElement(By.tagName("textarea")).getText();
		driver.close();
		driver.switchTo().window(windows[0].toString());
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys(msg);

		driver.quit();
	}
}
