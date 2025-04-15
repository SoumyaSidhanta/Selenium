import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {
    public static void main(String[] args) {
        System.setProperty("web driver.chrome.driver", "C:/Users/mohan/OneDrive/Documents/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        // dropdown with select tag
        //
        //  Static Dropdown
        WebElement staticDropdown= driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));

        Select dropdown=new Select(staticDropdown);// we have to give knowledge of the dropdown as an argument in
                                                        //select tag
        dropdown.selectByIndex(3); // select usd from drop down // select any option with index
        System.out.println(dropdown.getFirstSelectedOption().getText());

        //select by visible text
        dropdown.selectByVisibleText("AED");
        System.out.println(dropdown.getFirstSelectedOption().getText());

        //select by value (attribute)
        dropdown.selectByValue("INR");
        System.out.println(dropdown.getFirstSelectedOption().getText());


    }
}
