package br.ce.mcaquino.tasks.functional;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class tasksTest {
	
	public WebDriver acessarAplicacao() {
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://localhost:8001/tasks");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	@Test
	public void deveSalvarTarefaComSucesso() {
		WebDriver driver = acessarAplicacao();
		try {
		
			//clicar em add Todo
			driver.findElement(By.id("addTodo")).click();
			
			//escrever a descri��o
			driver.findElement(By.id("task")).sendKeys("Teste Via Selenium");
			
			//escrever a data		
			driver.findElement(By.id("dueDate")).sendKeys("03/03/2023");
			
			//clicar em salvar
			driver.findElement(By.id("saveButton")).click();
			
			//validar msg de sucesso
			String message = driver.findElement(By.id("message")).getText();
			Assert.assertEquals("Success!", message);
		} finally {
			//fechar o browser
			driver.quit();
			}
		}
	
	@Test
	public void naoDeveSalvarTarefaSemDescricao() {
		WebDriver driver = acessarAplicacao();
		try {
		
			//clicar em add Todo
			driver.findElement(By.id("addTodo")).click();
			
			//escrever a data		
			driver.findElement(By.id("dueDate")).sendKeys("03/03/2023");
			
			//clicar em salvar
			driver.findElement(By.id("saveButton")).click();
			
			//validar msg de sucesso
			String message = driver.findElement(By.id("message")).getText();
			Assert.assertEquals("Fill the task description", message);
		} finally {
			//fechar o browser
			driver.quit();
			}
		}
	
	@Test
	public void naoDeveSalvarTarefaSemData() {
		WebDriver driver = acessarAplicacao();
		try {
		
			//clicar em add Todo
			driver.findElement(By.id("addTodo")).click();
			
			//escrever a descri��o
			driver.findElement(By.id("task")).sendKeys("Teste Via Selenium");			
			
			//clicar em salvar
			driver.findElement(By.id("saveButton")).click();
			
			//validar msg de sucesso
			String message = driver.findElement(By.id("message")).getText();
			Assert.assertEquals("Fill the due date", message);
		} finally {
			//fechar o browser
			driver.quit();
			}
		}
	
	@Test
	public void naoDeveSalvarTarefaComDataPassada() {
		WebDriver driver = acessarAplicacao();
		try {
		
			//clicar em add Todo
			driver.findElement(By.id("addTodo")).click();
			
			//escrever a descri��o
			driver.findElement(By.id("task")).sendKeys("Teste Via Selenium");
			
			//escrever a data		
			driver.findElement(By.id("dueDate")).sendKeys("10/10/2010");
			
			//clicar em salvar
			driver.findElement(By.id("saveButton")).click();
			
			//validar msg de sucesso
			String message = driver.findElement(By.id("message")).getText();
			Assert.assertEquals("Due date must not be in past", message);
		} finally {
			//fechar o browser
			driver.quit();
			}
		}
		
 	}
