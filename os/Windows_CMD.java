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
        return line;
    }
    
    
    
    // extract mac from "arp -a ip"
    public static void getMacByIp(Host host) throws IOException {

	String arp_A = "arp -a " + host.getAddress().toString().substring(1);
	
        String arr[] = run_CMD(arp_A).split("   ");
        for (String string : arr) {
        
   
            if (string.trim().length() == 17) {
        	    String  s = string.trim().toUpperCase();
        	   // System.out.println(s);
                host.setMacAddress(s); 
                break;
            }
            
            else {
        	 host.setMacAddress("Not:this:time");
	    }
            
        }
       
    }
    }