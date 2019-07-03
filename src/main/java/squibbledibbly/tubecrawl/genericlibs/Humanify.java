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
            } else {
                waitTries = 0;
                System.err.println("error message--");
                System.err.println(e.getMessage());
                System.err.println("--end message\n");
                e.printStackTrace();
            }
        }
    }

    public static void mouseMove() {
        // nothing yet
    }
}
