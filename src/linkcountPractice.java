import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class linkcountPractice {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("web driver.chrome.driver", "C:/Users/mohan/OneDrive/Documents/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // PRINT THE LINK COUNT IN THE PAGE (entire page)
        System.out.println("entire page link count:" + driver.findElements(By.tagName("a")).size());
        // Printing only footer links
        //footerDriver sub
        WebElement footerDriver = driver.findElement(By.id("gf-BIG"));// limiting webDriver scope
        System.out.println("only footer(last) link count:" + footerDriver.findElements(By.tagName("a")).size());

        WebElement columnDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        System.out.println("1st column list count:" + columnDriver.findElements(By.tagName("a")).size());

        // click on each link in the column and check if the page are opening
        // optimized
//        for (int i = 1; i < columnDriver.findElements(By.tagName("a")).size(); i++)
//        {
//            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//            String clickingLinks =Keys.chord(Keys.CONTROL,Keys.ENTER);
//            columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickingLinks);
//
//            Set<String> abc =driver.getWindowHandles();
//            Iterator<String> it = abc.iterator();
//            while(it.hasNext())
//            {
//                driver.switchTo().window(it.next());
//                System.out.println(driver.getTitle());
//            }
//        }
// Get all links
        List<WebElement> links = columnDriver.findElements(By.tagName("a"));

        List<String> windowHandles = null;
        for (int i = 1; i < links.size(); i++) {
            WebElement link = links.get(i);

            // Use JavaScript to open the link in a new tab
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.open(arguments[0].href,'_blank');", link);

            // Wait for new tab to open
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.numberOfWindowsToBe(i + 1));

            // Switch to newly opened tab
            windowHandles = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(windowHandles.get(windowHandles.size() - 1));

            // Wait until the page is fully loaded
            wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

            // Print the title after ensuring it's loaded
            System.out.println(driver.getTitle());
        }

// Switch back to the original tab
        driver.switchTo().window(windowHandles.get(0));


    }
}
