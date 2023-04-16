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

public class TestAlert {

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
	public void testAlertSimple() {
		driver.findElement(By.id("alert")).click();
		Alert alert = driver.switchTo().alert();
		assertEquals("Alert Simples", alert.getText());
	}

	@Test
	public void testAlertConfirm() {
		driver.findElement(By.id("confirm")).click();
		Alert alert_accept = driver.switchTo().alert();
		assertEquals("Confirm Simples", alert_accept.getText());
		alert_accept.accept();
		assertEquals("Confirmado", alert_accept.getText());
		alert_accept.accept();

		driver.switchTo().defaultContent();

		// driver.findElement(By.id("confirm")).click();
		// Alert alert_deny = driver.switchTo().alert();
		// alert_deny.dismiss();
		// assertEquals("Negado", alert_deny.getText());
		// alert_deny.accept();
	}
}
