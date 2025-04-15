import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class assignment4 {
    public static void main(String[] args) {

        System.setProperty("web driver.chrome.driver", "C:/Users/mohan/OneDrive/Documents/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        //Name and Password
        driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys("learning");
        //Radio Button
        driver.findElement(By.className("checkmark")).click();
        //Alert
        //
        //

        System.out.println(driver.findElement(By.xpath("//select[@class='form-control']")).isDisplayed());


        // Explicit Wait
        // Webdriver wait
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("//select[contains(@class,'form-control')]")));
        //Dropdown

        WebElement staticDropdown =driver.findElement(By.xpath("//select[contains(@class,'form-control')]"));
        Select dropdown =new Select(staticDropdown);
        dropdown.selectByValue("consult");
        System.out.println(dropdown.getFirstSelectedOption().getText());
        //checkbox
        driver.findElement(By.xpath("//input[@id='terms']")).click();
        driver.findElement(By.id("signInBtn")).click();

    }
}
