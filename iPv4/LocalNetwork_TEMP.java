package iPv4;
import java.net.*;
import java.io.IOException;

public class LocalNetwork_TEMP {

    // method returns local ip address in int array
    public static int[] getLocal(String returnIp) {
        InetAddress inet = null;

        try {

            InetAddress inetAddress = InetAddress.getLocalHost();
            //System.out.println("IP Address:- " + inetAddress.getHostAddress());
            // System.out.println("Host Name:- " + inetAddress.getHostName());
            String netString = inetAddress.getHostAddress().replace(".", " ");
            String[] netStringArray = netString.split(" ");

            int[] netByteArray = new int[netStringArray.length];
            int i = 0;
            for (String string : netStringArray) {
                netByteArray[i] = Integer.parseInt(string);
                i++;
            }







            
            // Get subnet
            InetAddress localHost = Inet4Address.getLocalHost();
            NetworkInterface networkInterface = NetworkInterface.getByInetAddress(localHost);
            
            System.out.println(localHost.toString() + "  --  " +networkInterface.toString());
            
            for (InterfaceAddress address : networkInterface.getInterfaceAddresses()) {
               System.out.println(address.getNetworkPrefixLength());
            }






                        /*
             * inet = InetAddress.getByAddress(new byte[] { 127, 0, 0, 1 });
             * 
             * System.out.println("Sending Ping Request to " + inet);
             * System.out.println(inet.isReachable(5000) ? "Host is reachable" :
             * "Host is NOT reachable");
             * 
             * inet = InetAddress.getByAddress(new byte[] { (byte) 8, (byte) 8, 8, 8 });
             * System.out.println("Sending Ping Request to " + inet);
             * System.out.println(inet.isReachable(5000) ? "Host is reachable" :
             * "Host is NOT reachable");
             * 
             * 
             * InetAddress addr = InetAddress.getByName("8.8.8.9");
             * System.out.println("Host name is: " + addr.getHostName());
             * System.out.println("Ip address is: " + addr.getHostAddress());
             */

            return netByteArray;


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

}