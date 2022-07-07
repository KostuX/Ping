package main;

import iPv4.*;
import port.PortScan;
import os.*;

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
int timeout =500;
	
SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm:ss");
	  
System.out.println("\n\t --- " + new java.util.Date() +" ---" );
System.out.println("\t\t --- Scann Started ---" );

//C:\Users\HP>ping -a 192.168.0.8
//https://www.printsupportcenter.com/hc/en-us/articles/115003386949-Determine-which-program-uses-or-blocks-a-port


// get hosts   
List<Host> onlineHosts = new ArrayList<>();
IPv4.getIPs(ipString, scanHosts, timeout).forEach(address->onlineHosts.add(new Host(address)));


System.out.println("Hosts found: " + Host.totalHosts);

onlineHosts.forEach(t->{
    try {
	Windows_CMD.getMacByIp(t);
    } catch (IOException e) {
	
	e.printStackTrace();
    }
});
//onlineHosts.forEach(System.out::println);

// print all hosts

/*
 * onlineHosts.forEach(t-> { System.out.print(t.getAddress() + "\t"); try {
 * System.out.println( os.Windows_CMD.run_CMD( "arp -a " +
 * t.getAddress().toString().substring(1) ) ); } catch (IOException e) {
 * 
 * e.printStackTrace(); } });
 */



// add ports
onlineHosts.forEach(host->portScan.portScanner(host)); 


onlineHosts.forEach(System.out::println);

//onlineHosts.get(0).getPorts().forEach(System.out::println);
 

System.out.println("\n\t\t --- The end ---");
System.out.println( "\n\t --- " + formatTime.format(new java.util.Date()) + " ---");
}



}