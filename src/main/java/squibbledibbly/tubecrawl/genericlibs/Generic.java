package squibbledibbly.tubecrawl.genericlibs;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class Generic {

    public static boolean elementExists(String byType, String identifier, WebDriver driver) {
        try {
            if (byType.equals("id")) {
                driver.findElement(By.id(identifier));
            } else if (byType.equals("xpath")) {
                driver.findElement(By.xpath(identifier));
            } else if (byType.equals("css")) {
                driver.findElement(By.cssSelector(identifier));
            } else if (byType.equals("name")) {
                driver.findElement(By.name(identifier));
            } else if (byType.equals("tag")) {
                driver.findElement(By.tagName(identifier));
            } else if (byType.equals("class")) {
                driver.findElement(By.className(identifier));
            } else if (byType.equals("linkText")) {
                driver.findElement(By.linkText(identifier));
            } else if (byType.equals("partialLink")) {
                driver.findElement(By.partialLinkText(identifier));
            } else {
                System.err.println("byType not recognized");
                return false;
            }
        } catch (NoSuchElementException e){
            return false;
            // LOG element not found
        }
        return true;
    }

    public static int hoursToMillis(double hours) {
        return (int) (hours * 3600000.0);
    }

    public static double millisToHours(int millis) {
        return ((double) millis) / (3600000.0);
    }

    public static double randGuassian(double min, double max) {
        return 0.0;
    }

    public static double randLogistic(double min, double max) {
        return 0.0;
    }

    public static double randSkewedGuassian(double min, double max, double mean) {
        return 0.0;
    }

    public static double randCustomDistribution(double min, double max, double mean, double std) {
        return 0.0;
    }

    public static double rDoubleInRange(double min, double max) {
        return 0.0;
    }

    public static int rIntInRange(int min, int max) {
        return 0;
    }
}
