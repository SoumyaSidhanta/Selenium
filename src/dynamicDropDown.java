import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class dynamicDropDown
{
    public static void main(String[] args) {
        System.setProperty("web driver.chrome.driver", "C:\\Users\\mohan\\OneDrive\\Documents\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");


        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
        driver.findElement(By.xpath("//a[@value= 'BLR']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//a[@value= 'MAA']")).click();

        // parent to child traversing
        //here we give the parent tag with child using x path
//        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value= 'MAA']")).click();

        driver.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click();
        driver.quit();


   }
}
