import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import java.time.Duration;

public class checkBox_assignment {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("web driver.chrome.driver", "C:/Users/mohan/OneDrive/Documents/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

            //* For 1st CheckBox

            Thread.sleep(2000);
                for (int i = 0; i <2 ; i++) {
                    driver.findElement(By.id("checkBoxOption1")).click();
                    System.out.println(driver.findElement(By.id("checkBoxOption1")).isSelected());
                }

                Assert.assertFalse(driver.findElement(By.id("checkBoxOption1")).isSelected());

            //* For 2nd CheckBox

                for (int i = 0; i <2 ; i++) {
                    driver.findElement(By.name("checkBoxOption2")).click();
                    System.out.println(driver.findElement(By.name("checkBoxOption2")).isSelected());
                }

                Assert.assertFalse(driver.findElement(By.name("checkBoxOption2")).isSelected());

            //* For 3rd CheckBox

                for (int i = 0; i <2 ; i++) {
                    driver.findElement(By.cssSelector("input[value='option3']")).click();
                    System.out.println(driver.findElement(By.cssSelector("input[value='option3']")).isSelected());
                    }

                Assert.assertFalse(driver.findElement(By.cssSelector("input[value='option3']")).isSelected());


        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());


    }
}
