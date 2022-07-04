package iPv4;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import java.util.ArrayList;

import java.util.List;








public class IPv4 {	
	

static List<InetAddress> ipRange = new ArrayList<>();
List<InetAddress> ipReachable = new ArrayList<>();







public static void test() throws UnknownHostException {
	
	System.out.println("Getting IPs");
	
	
	
	  long ipLo = ipToLong(InetAddress.getByName("192.200.0.0"));
	  
	  
	  InetAddress address = InetAddress.getByName("192.168.0.1");
	  
	  long addressLong = ipToLong(address);
	  
	  System.out.println(ipLo);
	  
	for (long i = 0 ; i < 300; i++) {
	
		IPv4.ipRange.add(InetAddress.getByName("" + addressLong++ ));	
		
		
	}
	ipRange.stream()
	.filter(i->{
		try {
			return i.isReachable(200);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}).forEach(System.out::println);
	
	
		
	}



	
	
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
