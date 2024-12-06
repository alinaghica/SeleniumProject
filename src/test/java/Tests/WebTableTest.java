package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebTableTest {
    public WebDriver driver;

    @Test
    public void automationMethod(){

        //deschidem un browser de Chrome
        driver = new ChromeDriver();

        //accesam o pagina web
        driver.get("https://demoqa.com/");

        //facem browserul in modul maximize
        driver.manage().window().maximize();

        //facem un scroll
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Varianta1 - Scroll down till the bottom of the page
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        //Varianta2
        //js.executeScript(("widow.scrollBy(0,400)"));

        //declaram un element
        WebElement elementsFiled = driver.findElement(By.xpath("//h5[text()='Elements']"));
        //Long yOffset = (Long) js.executeScript("return arguments[0].getBoundingClientRect().top + window.scrollY;", elementsFiled);
        elementsFiled.click();


        // dam click pe web tables
        WebElement webTableField = driver.findElement(By.xpath("//span[text()='Web Tables']"));
        //js.executeScript(("widow.scrollBy(0,400)"));
        //Long yOffset2 = (Long) js.executeScript("return arguments[0].getBoundingClientRect().top + window.scrollY;", webTableField);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webTableField);
        webTableField.click();


        //click pe 'Add'
        WebElement addField = driver.findElement(By.id("addNewRecordButton"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addField);
        addField.click();

        //inseram o valoare intr-un field
        WebElement firstNameField = driver.findElement(By.id("firstName"));
        String firstNameValue = "Alina";
        firstNameField.sendKeys(firstNameValue);

        //inseram last Name
        WebElement lastNameField = driver.findElement(By.id("lastName"));
        String lastNameValue = "Ghica";
        lastNameField.sendKeys(lastNameValue);

        //inseram adresa de email
        WebElement emailField = driver.findElement((By.id("userEmail")));
        String emailAddressValue = "alina@alina.com";
        emailField.sendKeys(emailAddressValue);

        //inseram varsta
        WebElement ageField = driver.findElement(By.id("age"));
        String ageValue = "40";
        ageField.sendKeys(ageValue);

        //inseram salary
        WebElement salaryField = driver.findElement(By.id("salary"));
        String salaryValue = "20000";
        salaryField.sendKeys(salaryValue);

        //inseram Departament
        WebElement departmentField = driver.findElement(By.id("department"));
        String departmentValue = "ABC DEFG";
        departmentField.sendKeys(departmentValue);

        //click on Submit
        WebElement submitField = driver.findElement(By.id("submit"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitField);
        submitField.click();

        //inserted comment


    }





}
