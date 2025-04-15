import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
public class selenium {
    public static void main(String[] args) {
        System.setProperty("web driver.chrome.driver", "C:/Users/mohan/OneDrive/Documents/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.w3schools.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

    }
}
