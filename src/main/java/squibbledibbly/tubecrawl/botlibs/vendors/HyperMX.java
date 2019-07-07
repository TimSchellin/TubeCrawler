package squibbledibbly.tubecrawl.botlibs.vendors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import squibbledibbly.tubecrawl.genericlibs.Humanify;

import java.util.List;
import java.util.Random;

public class HyperMX {

    Random r = new Random();

    private static String yesNoQualifier = "I prefer not to answer";
    private static String prosceniumQualifier = "video";
    private static String yahoo_qualifier = "webtraffic_popup_start_button";

    public static void start (WebDriver driver) {
        decideSequence(driver);
        //watchLoop(driver);
    }

    public static void decideSequence(WebDriver driver){
        Humanify.wait(2.5, 3.5);
        System.out.println(driver.getPageSource());
        List<WebElement> all = driver.findElements(By.cssSelector("*"));

        for (WebElement element : all) {
            if (element.getAttribute("id").contains(prosceniumQualifier)) {
                 driver.findElement(By.id("player")).click();
                 break;
            }
            if (element.getText().contains(yesNoQualifier) && element.getAttribute("class").equals("inputlabel")) {
                element.click();
                driver.findElement(By.id("demosubmitbutton")).click();
                passPopupButton(driver);
                watchLoop1(driver);
                break;
            }
            if (element.getAttribute("id").contains(yahoo_qualifier)) {
                passPopupButton(driver);
                watchLoop1(driver);
                break;
            }
        }

    }

    public static void filterIntro (WebDriver driver) {
        Humanify.wait(2.5, 3.5);
        List<WebElement> all = driver.findElements(By.cssSelector("*"));;
        for (WebElement element : all) {
            try {
                System.out.println("text: "+element.getText());
            } catch (Exception e) {
                System.out.println("getText cannot be retrieved from element");
            }
            try {
                System.out.println("id: "+element.getAttribute("id"));
            } catch (Exception e) {
                System.out.println("element has no attribute: id");
            }
            try {
                System.out.println("for: "+element.getAttribute("for"));
            } catch (Exception e) {
                System.out.println("element has no attribute: for");
            }
            try {
                System.out.println("class: "+element.getAttribute("class"));
            } catch (Exception e) {
                System.out.println("element has no attribute: class");
            }
            System.out.println("----END OF ELEMENT----");
        }
        System.out.println("----END OF ELEMENT LIST----");
        System.out.println("total elements: "+all.size());
        System.out.println("Page source code below:\n\n");
        System.out.println(driver.getPageSource());
    }

    public static void passLowesSurvey (WebDriver driver) {
        //driver.findElement(By.id("lowesprofessionals_survey_b_button")).click();
        driver.findElement(By.id("lowesprofessionals_survey_c_button")).click();
        driver.findElement(By.id("demosubmitbutton")).click();
        passPopupButton(driver);
    }

    public static void passPopupButton(WebDriver driver) {
        driver.findElement(By.id("webtraffic_popup_start_button")).click();
    }

    public static void watchLoop1 (WebDriver driver) {
        String mainWindow = driver.getWindowHandle();
        for (int i = 0; i < 10; i++ ) {
            WebElement next = driver.findElement(By.id("webtraffic_popup_next_button"));
            if (next.isEnabled()) {
                next.click();
            } else {
                Humanify.wait(10.056, 11.32);
            }
        }
        //WebElement nextButton = driver.findElement(By.id("webtraffic_popup_next_button"));
        //WebElement.

    }
}


