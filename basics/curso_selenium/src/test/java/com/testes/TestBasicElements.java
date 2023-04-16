package com.testes;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestBasicElements {

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
	public void testTextField() {
		// Nome
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Writing");
		assertEquals(driver.findElement(By.id("elementosForm:nome")).getAttribute("value"), "Writing");

		// Sobrenome
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Writing");
		assertEquals(driver.findElement(By.id("elementosForm:sobrenome")).getAttribute("value"), "Writing");
	}

	@Test
	public void testTextArea() {
		// Sugestoes
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Writing");
		assertEquals(driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"), "Writing");
	}

	@Test
	public void testRadioButtom() {
		// Masculino
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());

		// Feminino
		driver.findElement(By.id("elementosForm:sexo:1")).click();
		assertTrue(driver.findElement(By.id("elementosForm:sexo:1")).isSelected());
	}

	@Test
	public void testCheckBox() {
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
	}

	@Test
	public void testSelect() {
		String[] values = {
				"1grauincomp", "1graucomp", "2grauincomp", "2graucomp", "superior", "especializacao",
				"mestrado", "doutorado" };
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select select = new Select(element);

		// Testing size of available elements
		assertEquals(8, select.getOptions().size());

		// Testing values
		for (int i = 0; i < select.getOptions().size(); i++) {
			select.selectByValue(select.getOptions().get(i).getAttribute("value"));
			assertEquals(values[i], select.getFirstSelectedOption().getAttribute("value"));
		}
	}

	@Test
	public void testSelectMultiple() {
		String[] values = { "natacao", "futebol", "Corrida", "Karate", "nada" };
		WebElement element = driver.findElement(By.id("elementosForm:esportes"));
		Select select = new Select(element);

		// Testing size of available elements
		assertEquals(5, select.getOptions().size());

		// Testing values
		for (int i = 0; i < select.getOptions().size(); i++) {
			select.selectByValue(select.getOptions().get(i).getAttribute("value"));
			assertEquals(values[i], select.getAllSelectedOptions().get(i).getAttribute("value"));
		}

		// Testing amount of selected elements
		assertEquals(5, select.getAllSelectedOptions().size());

		// Testing amount of unselected elements
		for (int i = 5; i < select.getOptions().size(); i++) {
			select.deselectByValue(select.getOptions().get(i).getAttribute("value"));
			assertEquals(i, select.getAllSelectedOptions().size());
		}
	}

	@Test
	public void testButtom() {
		WebElement buttom = driver.findElement(By.id("buttonSimple"));
		buttom.click();

		assertEquals("Obrigado!", buttom.getAttribute("value"));
	}

	@Test
	public void testLink() {
		WebElement link = driver.findElement(By.linkText("Voltar"));
		link.click();
		assertEquals("Voltou!", driver.findElement(By.id("resultado")).getText());
	}
}
