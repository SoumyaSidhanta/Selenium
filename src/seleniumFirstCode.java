import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class seleniumFirstCode {
    public static void main(String[] args) {
        System.setProperty("web driver.chrome.driver"," C:\\Users\\mohan\\OneDrive\\Documents\\chromedriver.exe ");
        WebDriver driver =new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.manage().window().maximize();
        driver.get("https://google.com");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//        driver.close();
        driver.quit();


    }

}
