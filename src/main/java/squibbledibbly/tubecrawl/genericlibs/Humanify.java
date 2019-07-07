package squibbledibbly.tubecrawl.genericlibs;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Humanify {

    static Random rand = new Random();
    static int waitTries = 0;

    public static void wait(double lowerBound, double upperBound) {
        try {
            double randomValue = lowerBound + (upperBound - lowerBound) * rand.nextDouble();
            TimeUnit.MILLISECONDS.sleep((long) randomValue * 1000);
        } catch (InterruptedException e) {
            if (waitTries < 5){
                wait(lowerBound, upperBound);
                waitTries++;
            } else {
                waitTries = 0;
                System.err.println("failed to wait after 5 attempts");
                e.printStackTrace();
            }
        }
    }

    public static void humanMovement(WebDriver driver, float duration) throws Exception {
        // how mouse moves are executed will depend on operating system
        String os = System.getProperty("os.name");
        Robot iRobot = new Robot();
    }

    public static void defeatCapcha() {
        // haha I cant do that

        // take image of sceen
        // use classifier network to determine what type of capcha it is
        // run appropriate gotcha algo
    }

    public static void clickOn(WebElement element) throws Exception {
        Point position = element.getLocation();
        Dimension size = element.getSize();


        int offset = 115;

        String[] prefix = { "pX", "pY", "sW", "sH"};
        int[] coords = {position.getX(), position.getY(), size.getWidth(), size.getHeight()};
        for(int i = 0; i < prefix.length; i++) {
            System.out.println(prefix[i]+" : "+coords[i]);
        }

        Robot bot = new Robot();
        bot.mouseMove(coords[0], coords[1]+offset);
    }
}
