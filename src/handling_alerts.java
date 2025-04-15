import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class handling_alerts {
    public static void main(String[] args) throws InterruptedException {

        String text="Soumya";
        System.setProperty("web driver.chrome.driver", "C:/Users/mohan/OneDrive/Documents/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        driver.findElement(By.id("name")).sendKeys(text);

        Thread.sleep(2000L);
        driver.findElement(By.id("alertbtn")).click();
        // for handling an alert we have to switch the context,
        // from browser driver - alerts

        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        driver.findElement(By.id("confirmbtn")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();

        driver.quit();


    }
}
