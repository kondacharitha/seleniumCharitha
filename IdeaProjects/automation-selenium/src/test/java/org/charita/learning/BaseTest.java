package org.charita.learning;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Step 1. Launch Browser
 * Step 2. Navigate the application
 * Step 3. Perform some actions
 * Step 4. Validations
 * Step 5. Quit
 */

public class BaseTest {

    WebDriver driver = new ChromeDriver();

    Properties prop;

    public BaseTest() throws IOException,FileNotFoundException {
        String current = System.getProperty("user.dir");
        prop = new Properties();
        String path = current+"\\src\\test\\resources\\config.properties";
        System.out.println(path);
        FileInputStream fis = new FileInputStream(path);
        prop.load(fis);
        prop.keySet();

       }

        public void launchBrowser() {

            String browserType = prop.getProperty("browser");
            if (browserType.equalsIgnoreCase("Chrome")) {

                WebDriverManager.chromedriver().setup();
                ChromeDriver driver = new ChromeDriver();


            } else if (browserType.equalsIgnoreCase("Firefox")) {

                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();

            } else {
                System.out.println("Invalid browser type");
            }
        }
   public void goToApp() throws InterruptedException {
        driver.navigate().to(prop.getProperty("appUrl"));
       System.out.println(prop.getProperty("appUrl"));
       Thread.sleep(10000);

   }
    public void searchProperty() throws InterruptedException{

          driver.findElement(By.id("searchLocation")).sendKeys(prop.getProperty("postcode"));
        System.out.println("searching for location on right move" );
        Thread.sleep(5000);
    }

    public void closeBrowser(){

            driver.quit();
        }
    }
