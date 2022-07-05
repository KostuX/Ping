package main;

import iPv4.*;
import macAddress.MacAddress;

import java.net.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



import java.io.IOException;

public class Main{
public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
	
List<InetAddress> onlineAddresses = new ArrayList<>();
	
SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm:ss");
	  
System.out.println("\n\t --- " + new java.util.Date() +" ---" );
System.out.println("\t\t --- Scann Started ---" );


    
onlineAddresses = IPv4.getIPs("192.168.0.1", 50, 1000); // .forEach(System.out::println);
System.out.println( "\n\t --- " + formatTime.format(new java.util.Date()) + " ---");
     
 onlineAddresses.forEach(System.out::println);

  
 

System.out.println("\n\t\t --- The end ---");
System.out.println( "\n\t --- " + formatTime.format(new java.util.Date()) + " ---");
}



}