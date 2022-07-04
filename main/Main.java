package main;

import iPv4.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;



import java.io.IOException;

public class Main{
public static void main(String[] args) throws UnknownHostException, IOException {
	

	//Date timeNow = new java.util.Date();	
	//  String timeStamp = new SimpleDateFormat("HH.mm.ss").format(timeNow);
	
SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm:ss");
	  
System.out.println("\n\t --- " + new java.util.Date() +" ---" );
System.out.println("\t\t --- Scann Started ---" );

    
    
     IPv4.getIPs("192.168.0.1", 20, 100).forEach(System.out::println);;


 

System.out.println("\n\t\t --- The end ---");
System.out.println( "\n\t --- " + formatTime.format(new java.util.Date()) + " ---");
}



}