import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class invoke {
    public static void main(String[] args) throws InterruptedException {


        System.setProperty(" web driver.chrome.driver","C:\\Users\\mohan\\OneDrive\\Documents\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys("Soumia Siddhartha Mohana");
        driver.findElement(By.name("inputPassword")).sendKeys(" 442005");
        driver.findElement(By.name("chkboxOne")).click();
        driver.findElement(By.id("chkboxTwo")).click();
        driver.findElement(By.className("signInBtn")).click();
        Thread.sleep(2000L);

        System.out.println(driver.findElement(By.className("error")).getText());

    }

}
