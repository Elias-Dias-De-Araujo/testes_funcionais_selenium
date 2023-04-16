package com.testes;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

public class TestAlert {
	@Test
	public void testAlertSimple() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1000, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/resources/componentes.html");

		driver.findElement(By.id("alert")).click();
		Alert alert = driver.switchTo().alert();
		assertEquals("Alert Simples", alert.getText());

		driver.quit();
	}

	@Test
	public void testAlertConfirm() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1000, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/resources/componentes.html");

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

		driver.quit();
	}
}
