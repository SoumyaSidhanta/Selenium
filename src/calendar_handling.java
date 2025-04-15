import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.Objects;

public class calendar_handling {
    public static void main(String[] args) {

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

//        System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());

        System.out.println(driver.findElement(By.id("Div1")).getDomAttribute("style"));
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        System.out.println(driver.findElement(By.id("Div1")).getDomAttribute("style"));


      if(Objects.requireNonNull(driver.findElement(By.id("Div1")).getDomAttribute("style")).contains("1"))
      {
          System.out.println("it is enable");
          Assert.assertTrue(true);

      }
      else {
          Assert.fail();
      }
//        System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());

    }
}
