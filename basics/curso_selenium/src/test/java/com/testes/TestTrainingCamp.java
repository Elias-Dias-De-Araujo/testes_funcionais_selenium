package com.testes;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestTrainingCamp {

	@Test
	public void testTextFields() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1000, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/resources/componentes.html");

		// Test inputField Nome
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Writing");
		assertEquals(driver.findElement(By.id("elementosForm:nome")).getAttribute("value"), "Writing");

		// Test inputField Sobrenome
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Writing");
		assertEquals(driver.findElement(By.id("elementosForm:sobrenome")).getAttribute("value"), "Writing");

		driver.quit();
	}

	@Test
	public void testTextArea() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1000, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/resources/componentes.html");

		// Test textArea Sugestoes
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Writing");
		assertEquals(driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"), "Writing");

		driver.quit();
	}
}
