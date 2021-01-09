package com.ofis;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestCase03 {
    /*
     1. wikipedia.org sitesine gidin
     2. arama kutusuna selenium webdriver ı girin
     3. Sonuçlar kısmındaki Selenium (software) e tıklayın
     4. url'nin Selenium_(software)' ile bittiğini doğrulayın

     */
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\pc\\Documents\\selenium dependencies\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.wikipedia.org");
        WebElement aramaKutusu = driver.findElement(By.id("searchInput"));
        aramaKutusu.sendKeys("selenium webdriver" + Keys.ENTER);
        WebElement seleniumLink = driver.findElement(By.linkText("Selenium (software)"));
        seleniumLink.click();

        boolean isTrue = driver.getCurrentUrl().endsWith("Selenium_(software)");
        if (isTrue) {
            System.out.println("İstenen şekilde bitmektedir");
        } else {
            System.out.println("İstenen şekilde bitmemektedir.");
        }
        driver.quit();
    }
}
