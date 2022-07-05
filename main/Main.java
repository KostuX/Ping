package main;

import iPv4.*;
import macAddress.MacAddress;

import java.net.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.w3c.dom.ls.LSOutput;

import java.io.IOException;

public class Main{
public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
	
List<InetAddress> onlineAddresses = new ArrayList<>();
	
SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm:ss");
	  
System.out.println("\n\t --- " + new java.util.Date() +" ---" );
System.out.println("\t\t --- Scann Started ---" );


    
onlineAddresses = IPv4.getIPs("192.168.0.1", 10, 100); // .forEach(System.out::println);
System.out.println( "\n\t --- " + formatTime.format(new java.util.Date()) + " ---");
     
    
for (InetAddress inetAddress : onlineAddresses) {
    System.out.println(inetAddress);
    System.out.println(MacAddress.getMacAddrHost("/192.168.0.1"));;
    
}

  
 

System.out.println("\n\t\t --- The end ---");
System.out.println( "\n\t --- " + formatTime.format(new java.util.Date()) + " ---");
}



}