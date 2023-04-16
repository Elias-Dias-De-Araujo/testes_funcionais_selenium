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
import static org.junit.Assert.assertEquals;

public class TestSignUp {
	@Test
	public void testSignUp() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1000, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/resources/componentes.html");

		// Nome
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Luna");

		// Sobrenome
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Madalena");

		// Sexo
		driver.findElement(By.id("elementosForm:sexo:1")).click();

		// Comida
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:1")).click();

		// Escolaridade
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select select = new Select(element);
		select.selectByValue("1grauincomp");

		// Esportes
		element = driver.findElement(By.id("elementosForm:esportes"));
		select = new Select(element);
		select.selectByValue("natacao");
		select.selectByValue("Corrida");

		// Sugestões
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Texto Digitado \n aqui");

		driver.findElement(By.id("elementosForm:cadastrar")).click();

		// assertTrue("Cadastrado!",
		// driver.findElement(By.id("resultado")).getText().startsWith("Cadastrado!"));
		assertEquals("Cadastrado!", driver.findElement(By.id("resultado")).findElement(By.tagName("span")).getText());
		assertEquals("Luna", driver.findElement(By.id("descNome")).findElement(By.tagName("span")).getText());
		assertEquals("Madalena", driver.findElement(By.id("descSobrenome")).findElement(By.tagName("span")).getText());
		assertEquals("Feminino", driver.findElement(By.id("descSexo")).findElement(By.tagName("span")).getText());
		// assertTrue("Carne
		// Frango",driver.findElement(By.id("descComida")).getText().endsWith("Carne
		// Frango"));
		assertEquals("Carne Frango",
				driver.findElement(By.id("descComida")).findElement(By.tagName("span")).getText());
		assertEquals("1grauincomp",
				driver.findElement(By.id("descEscolaridade")).findElement(By.tagName("span")).getText());
		assertEquals("Natacao Corrida",
				driver.findElement(By.id("descEsportes")).findElement(By.tagName("span")).getText());
		assertEquals("Texto Digitado aqui",
				driver.findElement(By.id("descSugestoes")).findElement(By.tagName("span")).getText());
		driver.quit();
	}
}
