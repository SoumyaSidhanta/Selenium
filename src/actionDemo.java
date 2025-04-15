import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class actionDemo {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("web driver.chrome.driver", "C:/Users/mohan/OneDrive/Documents/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Actions a=new Actions(driver);
        WebElement move= driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));
        a.moveToElement(move).contextClick().build().perform();
        a.moveToElement(driver.findElement(By.id("//input[@id='twotabsearchtextbox']"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
//        a.moveToElement(move).


    }
}
