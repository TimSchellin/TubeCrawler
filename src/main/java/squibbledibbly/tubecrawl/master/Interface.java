package squibbledibbly.tubecrawl.master;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import squibbledibbly.tubecrawl.botlibs.instagc.Navigate;
import squibbledibbly.tubecrawl.botlibs.vendors.HyperMX;
import squibbledibbly.tubecrawl.genericlibs.Humanify;
import squibbledibbly.tubecrawl.genericlibs.Web;

import java.awt.*;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class Interface {

    private static int count = 0;
    private static String username = "";
    private static String password = "";
    private static String instaUrl = "https://www.instagc.com/users/login";

    public static void main(String[] args) {
        System.out.println("main");

        try {

            /* ====================================================================================================== */

            //normalStart();
            test();

            /* ====================================================================================================== */

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void test () throws Exception {
        WebDriver driver = createDriver();
        //driver.manage().window().setSize(new Dimension(1024, 768));
        driver.get("https://www.google.com/");
        WebElement element = driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[3]/center/input[1]"));
        Humanify.clickOn(element);

        //driver.manage().window().maximize

    }

    private static void normalStart() throws Exception {
        while (count == 0){
            if (Web.isConnected()) {
                mainProcedure();
                //test();
                System.out.println(count);
                count++;
            }
            TimeUnit.MINUTES.sleep(5);
        }
    }

    private static void mainProcedure() throws Exception {
        WebDriver driver = createDriver();

        verifyIP();
        instalogin(driver);
        while (true) {  // Need to mix up some human activity here.
            navToHyperMX(driver);
            hyperWatch(driver);

        }
    }

    private static void instalogin(WebDriver driver) {
        driver.get(instaUrl);
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"login\"]/form/section/div[3]/button")).click();
    }

    private static void navToHyperMX(WebDriver driver) {
        Navigate.gotoHyperMX(driver);
    }

    private static void hyperWatch(WebDriver driver) throws Exception {
        Navigate.switchIframeHyperMX(driver);
        HyperMX.start(driver);
        Navigate.leaveIframe(driver);

        Robot iRobot = new Robot();

    }

    private static WebDriver createDriver() {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.addArguments("-incognito");
        System.setProperty("webdriver.chrome.driver", "C://chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();//setSize(new Dimension(1366,768)); //
        return driver;
    }

    private static void verifyIP() throws Exception {
        String myIP = Web.getPublicIP();

        if (myIP.equals("76.169.39.125")) {
            System.out.println("IP is good");
            username = "SenatorGooslings";
            password = "2!vnd7TgfSxU";
        } else if (myIP.equals("97.93.136.204")) {
            System.out.println("IP is good");
            username = "SquibbleDibbly";
            password = "vhuZ8WY8K6BiS7E";
        } else if (myIP.equals("174.211.7.112")) {
            System.out.println("IP is good");
            username = "IntimateDentist";
            password = "iF39#zJojnLS";
        } else if (myIP.equals("71.93.212.128")) {
            System.out.println("IP is good");
            username = "loungePeacocks";
            password = "@58yk7H%jJ9u";
        } else {
            System.out.println("IP is bad");
            System.out.println("IP: "+myIP);
        }
    }
}

/*

=== DISCARDED TEST METHODS GO HERE =====================================================================================










 */

