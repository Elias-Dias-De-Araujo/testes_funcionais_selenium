package com.testes;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestTrainingCamp {

	@Test
	public void testTextField() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1000, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/resources/componentes.html");

		// Nome
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Writing");
		assertEquals(driver.findElement(By.id("elementosForm:nome")).getAttribute("value"), "Writing");

		// Sobrenome
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Writing");
		assertEquals(driver.findElement(By.id("elementosForm:sobrenome")).getAttribute("value"), "Writing");

		driver.quit();
	}

	@Test
	public void testTextArea() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1000, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/resources/componentes.html");

		// Sugestoes
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Writing");
		assertEquals(driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"), "Writing");

		driver.quit();
	}

	@Test
	public void testRadioButtom() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1000, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/resources/componentes.html");

		// Masculino
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());

		// Feminino
		driver.findElement(By.id("elementosForm:sexo:1")).click();
		assertTrue(driver.findElement(By.id("elementosForm:sexo:1")).isSelected());

		driver.quit();
	}

	@Test
	public void testCheckBox() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1000, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/resources/componentes.html");

		// Carne
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:0")).isSelected());

		// Frango
		driver.findElement(By.id("elementosForm:comidaFavorita:1")).click();
		assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:1")).isSelected());

		// Pizza
		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());

		// Vegetariano
		driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
		assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:3")).isSelected());

		driver.quit();
	}

	@Test
	public void testSelect() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1000, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/resources/componentes.html");
		String[] values = {
				"1grauincomp", "1graucomp", "2grauincomp", "2graucomp", "superior", "especializacao",
				"mestrado", "doutorado" };
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select select = new Select(element);

		assertEquals(8, select.getOptions().size());

		// Testing values
		for (int i = 0; i < select.getOptions().size(); i++) {
			select.selectByValue(select.getOptions().get(i).getAttribute("value"));
			assertEquals(values[i], select.getFirstSelectedOption().getAttribute("value"));
		}

		driver.quit();
	}
}
