package os;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import host.Host;

public class Windows_CMD {

    public static String run_CMD(String param) throws IOException {
	
	String line = "";
        Process p = Runtime.getRuntime().exec(param);    
        BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));  
    
        while ( input.readLine() != null) { line += input.readLine(); }       
        input.close();
        return line;
    }
    
    
    
    // extract mac from "arp -a ip"
    public static void getMacByIp(Host host)  {

	String arp_A = "arp -a " + host.getAddress().toString().substring(1);
	
        String arr[] = null;
	try {
	    arr = run_CMD(arp_A).split("   ");
	} catch (IOException e) {
	    
	    e.printStackTrace();
	}
        for (String string : arr) {
        
   
            if (string.trim().length() == 17) {
        	    String  s = string.trim().toUpperCase();
        	   // System.out.println(s);
                host.setMacAddress(s); 
                break;
            }            
            
            }
        }
    
    
    //ping -a -n 1  192.168.0.8
    public static void getHostName(Host host) 
    {
	String hostAddress = host.getAddress().toString().substring(1);
	String hostname = "ping -a -n 1 " + hostAddress;
	
        String arr[] = null;
	try {
	    arr = run_CMD(hostname).split(" ");
	} catch (IOException e) {
	    
	    e.printStackTrace();
	}
       // if(arr[1].equals(hostAddress)) {host.setHostName(null); }
	if(!arr[1].equals(hostAddress)) {host.setHostName(arr[1].toString());}
    }
    
    
    }