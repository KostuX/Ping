import java.io.IOException;
import java.net.*;
import java.util.*;

public class GetIpList {

    public ArrayList<InetAddress> getIpList( int[] ip , int[] endIp, int timeout ) throws IOException {

        ArrayList<InetAddress> ipArrayList = new ArrayList<>();
scan();
        int totalFound= 0;

        try {

            while (ip[2] <= endIp[2])
            {
                
            while (ip[3] <= endIp[3] )
            {
                InetAddress inet = InetAddress.getByAddress(new byte[] { (byte) ip[0], (byte) ip[1], (byte) ip[2], (byte) ip[3] });
                if (inet.isReachable(timeout)) 
                {
                    String hostIP = inet.getHostAddress() ;
                   System.out.println("IP: " + inet + "\tHostName: " + inet.getCanonicalHostName()+ " \tMAC: "+MacAddress.run_program_with_catching_output("arp -a" + inet.getAddress()) + "\tTotal found =   "+ ++totalFound);
                 //MacAddress.run_program_with_catching_output("arp -a " + hostIP);
                   
                   ipArrayList.add(inet);
                                     
                }
             
                ip[3]++;
            }
            ip[2]++;
        }


       
        } 
    catch (UnknownHostException uhe) {System.out.println("\nUnknown Host Exception\n"+uhe.getStackTrace());}

    return ipArrayList;
    
    

    }
    
    public static long ipToLong(InetAddress ip) {
        byte[] octets = ip.getAddress();
        long result = 0;
        for (byte octet : octets) {
            result <<= 8;
            result |= octet & 0xff;
        }
        return result;
    }

    public static void scan() throws UnknownHostException {
        long ipLo = ipToLong(InetAddress.getByName("192.200.0.0"));
        long ipHi = ipToLong(InetAddress.getByName("192.255.0.0"));
        long ipToTest = ipToLong(InetAddress.getByName("192.200.3.0"));

        System.out.println(ipToTest >= ipLo && ipToTest <= ipHi);
    }
    
}