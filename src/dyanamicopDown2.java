import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class dyanamicopDown2
{
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("web driver.chrome.driver", "C:\\Users\\mohan\\OneDrive\\Documents\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        // AUTO SUGGESSTION

        driver.findElement(By.id("autosuggest")).sendKeys("Ind");
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


        List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
        for (WebElement option :options) {
            if (option.getText().equalsIgnoreCase("India")){
                option.click();
                break;
            }

        }
    }
}
