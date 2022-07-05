package main;

import iPv4.*;
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


    
List<Host> onlineHosts = new ArrayList<>();
IPv4.getIPs(ipString, scanHosts, timeout).forEach(address->onlineHosts.add(new Host(address)));

System.out.println("Hosts found:" + Host.totalHosts);

onlineHosts.forEach(t->System.out.println(t.getAddress()));


if(true)
onlineHosts.forEach(t->t.setPorts(portScan.portScanner(t.getAddress()))); 
System.err.println("Port scann set to null");


  
 

System.out.println("\n\t\t --- The end ---");
System.out.println( "\n\t --- " + formatTime.format(new java.util.Date()) + " ---");
}



}