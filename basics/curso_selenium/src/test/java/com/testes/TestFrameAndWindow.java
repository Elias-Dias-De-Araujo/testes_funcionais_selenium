package com.testes;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestFrameAndWindow {

	private WebDriver driver;

	@Before
	public void begin() {
		driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1000, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/resources/componentes.html");
	}

	@After
	public void end() {
		driver.quit();
	}

	@Test
	public void testFrameButton() {
		driver.switchTo().frame("frame1").findElement(By.id("frameButton")).click();
		Alert alert = driver.switchTo().alert();
		assertEquals("Frame OK!", alert.getText());
		alert.accept();
	}

	@Test
	public void testWindowButton() {
		driver.findElement(By.id("buttonPopUpEasy")).click();
		Object[] windows = driver.getWindowHandles().toArray();
		driver.switchTo().window(windows[1].toString());
		driver.findElement(By.tagName("textarea")).sendKeys("Escrevendo na area de texto");
		String msg = driver.findElement(By.tagName("textarea")).getText();
		driver.close();
		driver.switchTo().window(windows[0].toString());
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys(msg);
	}

	@Test
	public void testWindowButtonNoName() {
		driver.findElement(By.id("buttonPopUpHard")).click();
		Object[] windows = driver.getWindowHandles().toArray();
		driver.switchTo().window(windows[1].toString());
		driver.findElement(By.tagName("textarea")).sendKeys("Escrevendo na area de texto");
		String msg = driver.findElement(By.tagName("textarea")).getText();
		driver.close();
		driver.switchTo().window(windows[0].toString());
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys(msg);
	}
}
