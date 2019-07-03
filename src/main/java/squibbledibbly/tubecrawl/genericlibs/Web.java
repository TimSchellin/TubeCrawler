package squibbledibbly.tubecrawl.genericlibs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;

public class Web {

    public static String getPublicIP() throws Exception {
        URL whatismyip = new URL("http://checkip.amazonaws.com");
        BufferedReader in = new BufferedReader(new InputStreamReader(
                whatismyip.openStream()));
        return (in.readLine());
    }

    public static boolean isConnected() throws Exception {
        String testUrl = "8.8.8.8";
        return(InetAddress.getByName(testUrl).isReachable(1000));
    }
}
