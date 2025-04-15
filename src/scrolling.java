import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class scrolling {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("web driver.chrome.driver", "C:/Users/mohan/OneDrive/Documents/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        JavascriptExecutor js= (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,600)");
        Thread.sleep(2000);
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");

        List<WebElement> totalValue = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
        // iterate each web element and some them
        int sum=0;
        for(int i = 0; i < totalValue.size(); i++)
        {
            // convert the string into integer
        sum= sum + Integer.parseInt(totalValue.get(i).getText());
        }
        System.out.println(sum);

        driver.findElement(By.cssSelector(".totalAmount")).getText();

        int total = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
        Assert.assertEquals(sum,total);
        driver.quit();
    }
}
