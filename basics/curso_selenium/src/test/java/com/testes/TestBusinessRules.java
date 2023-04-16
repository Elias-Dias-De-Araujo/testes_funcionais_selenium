package com.testes;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestBusinessRules {

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
	public void testNameNotEmpty() {
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		assertEquals("Nome eh obrigatorio", alert.getText());
		alert.accept();
	}

	@Test
	public void testSurnameNotEmpty() {
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Maria");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		assertEquals("Sobrenome eh obrigatorio", alert.getText());
		alert.accept();
	}

	@Test
	public void testSexNotEmpty() {
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Maria");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Rosa");

		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		assertEquals("Sexo eh obrigatorio", alert.getText());
		alert.accept();
	}

	@Test
	public void testVegetarian() {
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Maria");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Rosa");
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();

		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		assertEquals("Tem certeza que voce eh vegetariano?", alert.getText());
		alert.accept();
	}

	@Test
	public void testSportsNotEm() {
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Maria");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Rosa");
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();

		WebElement element = driver.findElement(By.id("elementosForm:esportes"));
		Select select = new Select(element);

		select.selectByValue("nada");

		for (int i = 0; i < select.getOptions().size() - 1; i++) {
			select.selectByValue(select.getOptions().get(i).getAttribute("value"));
			driver.findElement(By.id("elementosForm:cadastrar")).click();
			Alert alert = driver.switchTo().alert();
			assertEquals("Voce faz esporte ou nao?", alert.getText());
			alert.accept();
			select.deselectByValue(select.getOptions().get(i).getAttribute("value"));
		}
	}
}
