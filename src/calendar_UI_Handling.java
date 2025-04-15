import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class calendar_UI_Handling {

    public static void main(String[] args) {

        String monthNumber="4";
        String date="4";
        String year = "2030";
        String[] expectedList={monthNumber, date , year};


        System.setProperty("web driver.chrome.driver", "C:\\Users\\mohan\\OneDrive\\Documents\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.className("react-date-picker__inputGroup")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
        driver.findElement(By.xpath("//button[text()='"+year+"']")).click();

        //convert string into integer
        //Integer.parseInt()
        driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(monthNumber)-1).click();
        driver.findElement(By.xpath("//abbr[text()='"+date+"']")).click();


        List<WebElement> actualList =driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
        for (int i = 0; i <actualList.size(); i++) {

            System.out.println(actualList.get(i).getDomAttribute("value"));
            Assert.assertEquals(actualList.get(i).getDomAttribute("value"), expectedList[i]);
        }

        driver.quit();

        



    }
}
