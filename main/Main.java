package main;



//@todo;
//add response time 
//get own ip;
//get own network range;
//get mac address vendor
//get process for which have open specific port
// read ports from file

//threads


//https://www.printsupportcenter.com/hc/en-us/articles/115003386949-Determine-which-program-uses-or-blocks-a-port
//C:\Users\My>netstat -ano -p tcp |find "192.168.0.8:139" 
//tasklist /svc /FI "PID eq 488"



import iPv4.*;
import port.PortScan;
import os.*;
//import helper.*;

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



// get hosts   
System.out.println("Getting IPs..."); 
IPv4.getIPs(ipString, scanHosts, timeout).parallelStream().forEach(address-> {onlineHosts.add(new Host(address));});

System.out.println("Found: " + Host.totalHosts +"\n");


// add Hostname
System.out.println("Getting HostNames..." );
onlineHosts.parallelStream().forEach(t->{ Windows_CMD.getHostName(t); });


// add MAC address
System.out.println("Getting MAC..." );
onlineHosts.parallelStream().forEach(t->{Windows_CMD.getMacByIp(t);});
onlineHosts.parallelStream().forEach(t->macAddress.MacAddress.readFile(t));
//macAddress.MacAddress.readFile(onlineHosts.get(0));


//add ports
System.out.println("Getting Ports..." );
onlineHosts.parallelStream().forEach(host->portScan.portScanner(host)); 










System.out.println("\nSummary\n");
onlineHosts.forEach(System.out::println);

System.out.println("\n\t\t --- The end ---\n");
time.TimeHelper.printTimeLapsed(startTime);

}



}