import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class locator {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty(" web driver.chrome.driver","C:\\Users\\mohan\\OneDrive\\Documents\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        driver.findElement(By.id("inputUsername")).sendKeys(" Bug Hunter");
        driver.findElement(By.name("inputPassword")).sendKeys(" hello1");
        driver.findElement(By.name("chkboxOne")).click();
        driver.findElement(By.name("chkboxTwo")).click();
        driver.findElement(By.className("submit")).click();

//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());

        driver.findElement(By.linkText("Forgot your password?")).click();







    }
}
