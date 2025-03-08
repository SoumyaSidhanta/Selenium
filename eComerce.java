import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class eComerce {
    public static void main(String[] args) throws InterruptedException {


        System.setProperty(" web driver.chrome.driver", "C:\\Users\\mohan\\OneDrive\\Documents\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String[] itemsNeeded = {"Cucumber", "Brocolli", "Beetroot", "Carrot"};

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        Thread.sleep(2000L);
        additems(driver, itemsNeeded);
    }

    public static void additems(WebDriver driver, String[] itemsNeeded) throws InterruptedException {
        int j = 0;
        // here we return list of web elements that's why we used find elements
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
        // here we have 30 product so let's iterate and match the element


        // Scanning all the products
        //identifying multiple product name
        for (int i = 0; i < products.size(); i++) {
            // carrot - 1kg
            String[] name = (products.get(i).getText().split("-"));
            String formattedName = name[0].trim();
            //formating the name Cucumber - 1 Kg to Cucumber only
            // check whether name you extracted is present in the array or not
            // convert array in array list(runtime)
            List<String> itemsNeededList = Arrays.asList(itemsNeeded);

            if (itemsNeededList.contains(formattedName)) {

                j++;
                // click on add to cart
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

                if (j == itemsNeeded.length)
                    break;
            }
        }

        // opening cart icon and proceed to checkout
        driver.findElement(By.className("cart-icon")).click();
        //div[@class='action-block']
        driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();

        //here we used promocode and click the apply  button and extracted the text
        driver.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.className("promoBtn")).click();

        // Explicit Wait
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
        WebElement element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoInfo")));
        System.out.println(driver.findElement(By.className("promoInfo")).getText());

        Thread.sleep(1000L);
        List<WebElement> buttons = driver.findElements(By.cssSelector("button"));
        for (WebElement button : buttons) {
            if (button.getText().equals("Place Order")) {
                button.click(); // or any other operation
                break;
            }
        }

        //div[@style='width: 360px; margin: 10px auto;']//select[@style='width: 200px;']


        // dynamic drop down handling
        WebElement selectElement = driver.findElement(By.xpath("//select"));
        selectElement.click();
        List<WebElement> options = selectElement.findElements(By.tagName("option"));

        for (WebElement option : options) {

            if (option.getText().equalsIgnoreCase("India")) {
                option.click();
                break;
            }
        }
        Thread.sleep(2000L);
        driver.findElement(By.className("chkAgree")).click();
        driver.findElement(By.xpath("//button[text()='Proceed']")).click();

        driver.quit();
    }

}
