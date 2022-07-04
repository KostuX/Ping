package main;

import iPv4.*;
import macAddress.*;
import port.*;

import java.net.*;

import java.util.ArrayList;

import iPv4.GetIpList;

import java.io.IOException;

public class Main{
public static void main(String[] args) throws UnknownHostException, IOException {

    GetIpList getIpList = new GetIpList();
    PortScan portScan = new PortScan();
    
    
    IPv4.test();


    int timeout = 152; 
    int[] ip = {10,165,74,173};   // ip address in array 10.165.74.173
    int[] endIp = {10,165,74,173};

 // MacAddress.run_program_with_catching_output("cmd command ");
   
    ArrayList<InetAddress> list =  getIpList.getIpList(ip, endIp, timeout);


    for (InetAddress inetAddress : list) {
     //   portScan.portScanner(inetAddress);
   }

 

System.out.println("\n\t\t --- The end ---");
}



}