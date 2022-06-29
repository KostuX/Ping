import java.net.*;
import java.util.ArrayList;
import java.io.IOException;

public class Main{
public static void main(String[] args) throws UnknownHostException, IOException {

    GetIpList getIpList = new GetIpList();
    PortScan portScan = new PortScan();


    int timeout = 152; 
    int[] ip = {192,168,0,1};   // ip address in array
    int[] endIp = {192,168,0,4};

  MacAddress.run_program_with_catching_output("shutdown -s  ");
   
   // ArrayList<InetAddress> list =  getIpList.getIpList(ip, endIp, timeout);


 //   for (InetAddress inetAddress : list) {
  //      portScan.portScanner(inetAddress);
 //  }
System.out.println("\n\t" + getOperatingSystem());
 

System.out.println("\n\t\t --- The end ---");
}

public static String getOperatingSystem() {
        String os = System.getProperty("os.name");
    
    return os;
}

}