package squibbledibbly.tubecrawl.botlibs.instagc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Navigate {

    public static void gotoHyperMX(WebDriver driver){
        String tableUrl = "https://www.instagc.com/earn/";
        if(driver.getCurrentUrl().equals(tableUrl)) {
            driver.findElement(By.cssSelector("a[href*='hyprmx'")).click();
        } else {
            driver.get(tableUrl);
        }
    }

    public static void switchIframeHyperMX(WebDriver driver) {
        WebElement frame = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(frame);
    }

    public static void leaveIframe(WebDriver driver) {
        driver.switchTo().parentFrame();
    }
}
