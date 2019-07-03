package squibbledibbly.tubecrawl.master;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import squibbledibbly.tubecrawl.botlibs.instagc.Navigate;
import squibbledibbly.tubecrawl.botlibs.vendors.HyperMX;
import squibbledibbly.tubecrawl.genericlibs.Web;

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
            while (count == 0){
                if (Web.isConnected()) {
                    mainProcedure();
                    //test();
                    System.out.println(count);
                    count++;
                }
                TimeUnit.MINUTES.sleep(5);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void test () throws Exception {
        verifyIP();
    }

    private static void mainProcedure() throws Exception {
        WebDriver driver = createDriver();

        verifyIP();
        instalogin(driver);
        while (true) {
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

    private static void hyperWatch(WebDriver driver) {
        Navigate.switchIframeHyperMX(driver);
        HyperMX.start(driver);
        Navigate.leaveIframe(driver);

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
        } else if (myIP.equals("174.211.7.112")) {
            System.out.println("IP is good");
            username = "IntimateDentist";
            password = "iF39#zJojnLS";
        } else {
            System.out.println("IP is bad");
            System.out.println("IP: "+myIP);
        }
    }


}

