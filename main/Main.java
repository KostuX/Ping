package main;

import iPv4.*;
import os.Windows_CMD;
import port.PortScan;

import java.net.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import host.Host;
import java.io.IOException;

public class Main{
public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
	
PortScan portScan = new PortScan();
	
String ipString = "192.168.0.1";
int scanHosts = 10;
int timeout =1000;
	
SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm:ss");
	  
System.out.println("\n\t --- " + new java.util.Date() +" ---" );
System.out.println("\t\t --- Scann Started ---" );



// get hosts   
List<Host> onlineHosts = new ArrayList<>();
IPv4.getIPs(ipString, scanHosts, timeout).forEach(address->onlineHosts.add(new Host(address)));

String s =onlineHosts.get(0).getAddress().toString().substring(1);
String cmd = "arp -a " + s;
System.out.println(os.Windows_CMD.run_CMD(cmd));


System.out.println("Hosts found: " + Host.totalHosts);

// print all hosts
onlineHosts.forEach(t->
			{
			    System.out.print(t.getAddress() + "\t");
			    try {
				System.out.println(
                				os.Windows_CMD.run_CMD(
                					"arp -a " + t.getAddress().toString().substring(1)
                					)
					);
			    } catch (IOException e) {
				
				e.printStackTrace();
			    }
			});


// add ports
onlineHosts.forEach(host->portScan.portScanner(host)); 


//onlineHosts.get(0).getPorts().forEach(System.out::println);
 

System.out.println("\n\t\t --- The end ---");
System.out.println( "\n\t --- " + formatTime.format(new java.util.Date()) + " ---");
}



}