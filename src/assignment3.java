import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;
import java.util.Objects;

public class assignment3 {
    public static void main(String[] args) throws InterruptedException {


        System.setProperty("web driver.chrome.driver", "C:/Users/mohan/OneDrive/Documents/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
        driver.findElement(By.xpath("//a[@value= 'DEL']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //here we give the parent tag with child using x path
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value= 'MAA']")).click();
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click();
        if(Objects.requireNonNull(driver.findElement(By.id("Div1")).getDomAttribute("style")).contains("1"))
        {
            System.out.println("it is enable");
            Assert.assertTrue(true);

        }
        else {
            Assert.fail();
        }
        driver.findElement(By.cssSelector("input[name*='SeniorCitizenDiscount']")).click();

        Thread.sleep(2000L);

        for (int i = 1; i <5 ; i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }

        driver.findElement(By.id("btnclosepaxoption")).click();

        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(),"5 Adult");
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

        WebElement staticDropdown= driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));

        Select dropdown=new Select(staticDropdown);// we have to give knowledge of the dropdown as an argument in
        //select tag
        dropdown.selectByIndex(3); // select usd from drop down // select any option with index
        System.out.println(dropdown.getFirstSelectedOption().getText());
        driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
        driver.quit();






    }
}
