import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.io.File;

public class HandlingCheckBox {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("web driver.chrome.driver", "C:\\Users\\mohan\\OneDrive\\Documents\\chromedriver.exe");

        // add extension in selenium real time test
        ChromeOptions options =new ChromeOptions();
        options.addExtensions(new File("C:\\Users\\mohan\\Downloads\\SelectorsHub-XPath-Helper-Chrome-Web-Store.crx"));
        options.setAcceptInsecureCerts(true);


        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
        driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();// using regular expression

        System.out.println(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected()); // check box is selected or not

        System.out.println(driver.findElement(By.cssSelector("label[for*='friendsandfamily']")).getText());
        Thread.sleep(3000);

        driver.findElement(By.cssSelector("input[name*='SeniorCitizenDiscount']")).click(); //using R.E
        System.out.println(driver.findElement(By.cssSelector("label[for*='SeniorCitizenDiscount']")).isSelected());
        Assert.assertTrue(driver.findElement(By.cssSelector("label[for*='SeniorCitizenDiscount']")).isSelected());


        //CheckBox Count how many CheckBox are there in the html page
        //ANS- "6"
        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
        driver.quit();
}}