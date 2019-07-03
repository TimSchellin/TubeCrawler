package squibbledibbly.tubecrawl.genericlibs;

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

    public static void mouseMove() {
        // nothing yet
    }

    public static void defeatCapcha() {
        // haha I cant do that

        // take image of sceen
        // use classifier network to determine what type of capcha it is
        // run appropriate gotcha algo
    }
}
