import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
public class assignment2 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("web driver.chrome.driver", "C:/Users/mohan/OneDrive/Documents/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        /*
        *   FORM FILL UP
        * */

        driver.get("https://rahulshettyacademy.com/angularpractice/");

        driver.findElement(By.cssSelector("input[class*='ng-untouched']")).sendKeys("Soumya Sidhanta ");
        driver.findElement(By.cssSelector("div[class='form-group'] input[name='email']")).sendKeys("mohanta@gmail.com");
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("Mohanta@442005");

        driver.findElement(By.id("exampleCheck1")).click();

        // FOR DROPDOWN
        WebElement dropdown = driver.findElement(By.id("exampleFormControlSelect1"));
        Select dropdowns = new Select(dropdown);
        dropdowns.selectByVisibleText("Male");
        System.out.println(dropdowns.getFirstSelectedOption().getText());


        driver.findElement(By.name("inlineRadioOptions")).click();
        driver.findElement(By.name("bday")).sendKeys("04/04/2005");
        driver.findElement(By.cssSelector("input[class*='btn-success']")).click();

        //GRABBING ALERT MESSAGE
        System.out.println(driver.findElement(By.cssSelector("div[class*='alert-success']")).getText());


    }
}
