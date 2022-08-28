package main;



//@todo;

//get own ip;
//get own network range;

//get process for which have open specific port
//add response time 



//https://www.printsupportcenter.com/hc/en-us/articles/115003386949-Determine-which-program-uses-or-blocks-a-port
//C:\Users\My>netstat -ano -p tcp |find "192.168.0.8:139" 
//tasklist /svc /FI "PID eq 488"



import iPv4.*;
import port.PortScan;
import os.*;


import java.net.*;
import java.util.Date;
import java.util.Enumeration;
import java.util.ArrayList;
import java.util.List;


import host.Host;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
	
PortScan portScan = new PortScan();



List<Host> onlineHosts = new ArrayList<>();	
String ipString = "127.0.0.1";
int scanHosts = 1;
int timeout =500;

	

Date startTime = new java.util.Date();

test();
	  
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



System.err.println("\nSummary\n");
onlineHosts.forEach(System.out::println);

System.out.println("\n\t\t --- The end ---\n");
time.TimeHelper.printTimeLapsed(startTime);

}

public static void test() throws IOException {
    try (final DatagramSocket datagramSocket = new DatagramSocket()) {
	    datagramSocket.connect(InetAddress.getByName("8.8.8.8"), 12345);
	   System.out.println(datagramSocket.getLocalAddress().getHostAddress()); 
	   
	   String localHost = datagramSocket.getLocalAddress().getHostAddress();
	   NetworkInterface networkInterface = NetworkInterface.getByInetAddress( InetAddress.getByName(localHost));
	  System.out.println( networkInterface.getInterfaceAddresses().get(0).getNetworkPrefixLength());
	}
    
    String urlString = "http://checkip.amazonaws.com/";
    URL url = new URL(urlString);
    try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()))) {
        System.out.println(br.readLine());
    }
}

}