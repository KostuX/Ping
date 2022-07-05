package iPv4;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;


public class IPv4 {	

static List<InetAddress> ipRange = new ArrayList<>();
static List<InetAddress> ipReachable = new ArrayList<>();

public static List<InetAddress> getIPs(String ipAddress, int range, int timeOut ) throws UnknownHostException {	
    
	System.out.println("Getting IPs...\n");  
	  
	  InetAddress address = InetAddress.getByName(ipAddress);
	  
	  long addressLong = ipToLong(address);
	  
	for (long i = 0 ; i < range; i++) {
		IPv4.ipRange.add(InetAddress.getByName("" + addressLong++ ));
	}
	
	
	ipReachable = ipRange.stream()
	.filter(i->{
		try {
			return i.isReachable(timeOut);
		} catch (IOException e) { e.printStackTrace(); }
		return true;
	})
	.collect(Collectors.toList());
		
	return ipReachable;
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
    
public static void test() throws UnknownHostException, SocketException {
    // Get subnet
    InetAddress localHost = Inet4Address.getLocalHost();
    NetworkInterface networkInterface = NetworkInterface.getByInetAddress(localHost);
    
    System.out.println(localHost);
    
    
    for (InterfaceAddress address : networkInterface.getInterfaceAddresses()) {
       System.out.println(address.getNetworkPrefixLength());
    }
}
}
