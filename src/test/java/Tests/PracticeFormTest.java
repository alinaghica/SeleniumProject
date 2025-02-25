package Tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.io.File;

public class PracticeFormTest {

    public WebDriver driver;

    @Test
    public void AutomationMethod() {

        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");  //deschidem pagina de Chrome
        driver.manage().window().maximize(); // maximizam fereastra
        //facem un scroll
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Varianta1 - Scroll down till the bottom of the page - aceasta varianta merge mai bine la ecranul meu
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        //Varianta2
        //js.executeScript(("widow.scrollBy(0,400)"));

        //facem click pe Forms
        WebElement formsField = driver.findElement(By.xpath("//h5[normalize-space()='Forms']"));
        formsField.click();

        //click pe Practice Forms
        WebElement practiceFormsField = driver.findElement(By.xpath("//span[normalize-space()='Practice Form']"));
        practiceFormsField.click();

        //Scoatem bannerul publicitar :)
        WebElement adsElement = driver.findElement(By.id("fixedban"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].remove();", adsElement);

        //completare camp First Name
        WebElement firstNameField = driver.findElement(By.id("firstName"));
        String firstNameFieldValue = "Alina";
        firstNameField.sendKeys(firstNameFieldValue);

        //completare camp Last Name
        WebElement lastNameField = driver.findElement(By.id("lastName"));
        String lastNameFieldValue = "Ghica";
        lastNameField.sendKeys(lastNameFieldValue);

        //completare camp email
        WebElement emailField = driver.findElement(By.id("userEmail"));
        String emailFieldValue = "alina@alina.com";
        emailField.sendKeys(emailFieldValue);

        //completare numar mobil
        WebElement mobileNumber = driver.findElement(By.cssSelector("input[placeholder='Mobile Number']"));
        String mobileNumberValue = "0712435564";
        mobileNumber.sendKeys(mobileNumberValue);

        //incarcare poze
        WebElement pictureElement = driver.findElement(By.id("uploadPicture"));
        File picture = new File("src/test/resources/Poza_brad.jpg");
        pictureElement.sendKeys(picture.getAbsolutePath());

        WebElement maleElement = driver.findElement((By.xpath("//label[normalize-space()='Male']")));
        WebElement femaleElement = driver.findElement(By.xpath("//label[@for='gender-radio-2']"));
        WebElement otherElement = driver.findElement(By.xpath("//label[@for='gender-radio-3']"));

        String gender = "Female";

        if (maleElement.getText().equals(gender)) {
            maleElement.click();
        } else if (femaleElement.getText().equals(gender)) {
            femaleElement.click();
        } else if (otherElement.getText().equals(gender)) {
            otherElement.click();
        }

        WebElement subjectsElement = driver.findElement(By.id("subjectsInput"));
        String subjectsValue="Social Studies";
        subjectsElement.sendKeys(subjectsValue);
        subjectsElement.sendKeys(Keys.ENTER);

        WebElement stateElement = driver.findElement(By.id("react-select-3-input"));
        js.executeScript("arguments[0].click();", stateElement);
        stateElement.sendKeys("NCR");
        stateElement.sendKeys(Keys.ENTER);

        WebElement cityElement = driver.findElement(By.id("react-select-4-input"));
        js.executeScript("arguments[0].click();", cityElement);
        cityElement.sendKeys("Noida");
        cityElement.sendKeys(Keys.ENTER);

        WebElement submitElement = driver.findElement(By.id("submit"));
        js.executeScript("arguments[0].click();", submitElement);

    }

}
