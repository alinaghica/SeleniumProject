package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.List;

public class Recursivitate {

    public WebDriver driver;

    @Test

    public void parcurgereLista() {

        driver = new ChromeDriver();
        driver.get("https://demoqa.com/sortable");  //deschidem pagina de Chrome
        driver.manage().window().maximize(); // maximizam fereastra

        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Varianta1 - Scroll down till the bottom of the page - aceasta varianta merge mai bine la ecranul meu
        // js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        //Scoatem bannerul publicitar :)
        WebElement adsElement = driver.findElement(By.id("fixedban"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].remove();", adsElement);

        List<WebElement> list = (List<WebElement>) driver.findElements(By.xpath("//div[@id='demo-tabpane-list'//div[@class='list-group-item list-group-item-action']"));

        Actions actions = new Actions(driver);

        for (int i = 0; i <= list.size() - 1; i++) {

            WebElement webElement = list.get(i);
            WebElement urmatorulElement = list.get(i++);
            System.out.println("Numarul elementului este: " + webElement.getText());
            actions.clickAndHold(webElement)
                    .moveToElement(urmatorulElement)
                    .release()
                    .build()
                    .perform();

        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

    }


}
