import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class frameTest {
    public static void main(String[] args) {

        System.setProperty("web driver.chrome.driver", "C:/Users/mohan/OneDrive/Documents/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/droppable/");

        System.out.println(driver.findElements(By.tagName("iframe")).size());
        //BY web element or frame element
//        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));
        // by index
        driver.switchTo().frame(0);
        System.out.println(driver.findElement(By.id("draggable")).isDisplayed());

        // Drag and Drop Element
        Actions a =new Actions(driver);
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.className("ui-droppable"));
        a.dragAndDrop(source,target).build().perform();

        driver.switchTo().defaultContent();
        driver.quit();
    }
}
