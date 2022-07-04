package iPv4;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;








public class IPv4 {	
	

static List<InetAddress> ipRange = new ArrayList<>();
List<InetAddress> ipReachable = new ArrayList<>();







public static void test() throws UnknownHostException {
	
	System.out.println("Getting IPs\n");
	
	
	

	  
	  
	  InetAddress address = InetAddress.getByName("192.168.0.1");
	  
	  long addressLong = ipToLong(address);
	  

	  
	for (long i = 0 ; i < 254; i++) {
	
		IPv4.ipRange.add(InetAddress.getByName("" + addressLong++ ));	
		
		
	}
	
	
	
	
ipRange.stream()
	.filter(i->{
		try {
			return i.isReachable(10);
		} catch (IOException e) { e.printStackTrace(); }
		return true;
	})
	.forEach(System.out::println);;
	
	
	
	
	
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



}
