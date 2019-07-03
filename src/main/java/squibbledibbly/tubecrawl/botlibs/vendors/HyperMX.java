package squibbledibbly.tubecrawl.botlibs.vendors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import squibbledibbly.tubecrawl.genericlibs.Generic;
import squibbledibbly.tubecrawl.genericlibs.Humanify;

import java.util.List;
import java.util.Random;

public class HyperMX {

    Random r = new Random();

    private static String yesNoQualifier = "I prefer not to answer";

    private static String yahoo_qualifier;

    public static void start (WebDriver driver) {
        filterIntro(driver);
        watchLoop(driver);
    }

    public static void filterIntro (WebDriver driver) {
        Humanify.wait(2.5, 3.5);
        List<WebElement> all = driver.findElements(By.cssSelector("*"));
        System.out.println("---endsource---\n\nNo of elements: "+all.size());

        System.out.println(driver.getPageSource());
        for (WebElement element : all) {

            try  {
                String qualifier = element.getText();
                System.out.println("str: "+qualifier);
                if (qualifier.contains(yesNoQualifier)) {
                    element.click();
                    driver.findElement(By.id("demosubmitbutton")).click();
                }
            }catch (Exception e) {
                e.printStackTrace();
                System.out.println("no attribute 'id' found");
            }
        }
        Humanify.wait(0.3, 0.5);
        //passPopupButton(driver);
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

    public static void watchLoop (WebDriver driver) {
        for (int i = 0; i < 10; i++ ) {
            if (Generic.elementExists("id", "webtraffic_popup_next_button", driver)) {
                driver.findElement(By.id("webtraffic_popup_next_button")).click();
            } else {
                Humanify.wait(10.056, 11.32);
            }
        }
        //WebElement nextButton = driver.findElement(By.id("webtraffic_popup_next_button"));
        //WebElement.

    }
}


