package main;



//@todo;
//get own ip;
//get own network range;
//get mac address vendor
//get process for which have open specific port

//threads


//https://www.printsupportcenter.com/hc/en-us/articles/115003386949-Determine-which-program-uses-or-blocks-a-port
//C:\Users\My>netstat -ano -p tcp |find "192.168.0.8:139" 
//tasklist /svc /FI "PID eq 488"



import iPv4.*;
import port.PortScan;
import os.*;

import java.net.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


import host.Host;
import java.io.IOException;

public class Main{
public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
	
PortScan portScan = new PortScan();

List<Host> onlineHosts = new ArrayList<>();	
String ipString = "192.168.0.1";
int scanHosts = 1;
int timeout =500;

	
SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm:ss:SSS");
Date startTime = new java.util.Date();
	  
System.out.println("\n\t --- " + startTime +" ---" );
System.out.println("\t\t --- Scann Started ---" );


//macAddress.MacAddress.readFile();
System.out.println(0x00001E);

int nr = 0x00001E;

switch (nr) {
case 0x00001E: {
    
    System.out.println("this"+ 0x00001E);
    break;
}
default:
   System.out.println("n");
}


// get hosts   

IPv4.getIPs(ipString, scanHosts, timeout).forEach(address-> {onlineHosts.add(new Host(address));});

System.out.println("Hosts found: " + Host.totalHosts);


// add Hostname
onlineHosts.forEach(t->{ Windows_CMD.getHostName(t); });

// add MAC address
onlineHosts.forEach(t->{Windows_CMD.getMacByIp(t);});

//add ports
onlineHosts.forEach(host->portScan.portScanner(host)); 






onlineHosts.forEach(System.out::println);

System.out.println("\n\t\t --- The end ---\n");
time.TimeHelper.printTimeLapsed(startTime);

}



}