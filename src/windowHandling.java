import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class windowHandling {
    public static void main(String[] args) {
        System.setProperty("web driver.chrome.driver", "C:/Users/mohan/OneDrive/Documents/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.findElement(By.cssSelector("a[class='blinkingText']")).click();
        //switching tab/window in selenium
        //window variable can store parent and child id
        Set<String> window =driver.getWindowHandles();
        Iterator <String>  it = window.iterator();
        String parentID = it.next();
        String childID =it.next();
        driver.switchTo().window(childID);

        System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
        String emailId = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];

        driver.switchTo().window(parentID);
        driver.findElement(By.id("username")).sendKeys(emailId);
        System.out.println(emailId);



    }
}
