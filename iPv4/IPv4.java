package iPv4;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.server.RemoteStub;
import java.util.ArrayList;
import java.util.List;








public class IPv4 {	
	

List<InetAddress> ipRange = new ArrayList<>();
List<InetAddress> ipReachable = new ArrayList<>();







public static void test() {}


	
	
/// for replacament
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
