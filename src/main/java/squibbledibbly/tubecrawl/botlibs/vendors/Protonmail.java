package squibbledibbly.tubecrawl.botlibs.vendors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class Protonmail {

    private static void signup(WebDriver driver, String username, String password){

        driver.get("https://protonmail.com/signup");
        driver.findElement(By.xpath("//*[@id=\"signup-plans\"]/div[5]/div[1]/div[1]/div/div[2]/p")).click();
        driver.findElement(By.xpath("//*[@id=\"freePlan\"]")).click();
        try {
            TimeUnit.SECONDS.sleep(20);//.sleep();
        } catch (Exception e){
            e.printStackTrace();
        }

        WebElement myElement = driver.findElement(By.xpath("//input[@name=\"username\"]"));
        String js = "arguments[0].setAttribute(\'value\',\'\"+username+\"\')";
        ((JavascriptExecutor) driver).executeScript(js, myElement);

        driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys(username);
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"passwordc\"]")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/footer/button")).click();

        // a captcha will be required at this point

    }

}
