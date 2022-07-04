package main;

import iPv4.*;
import macAddress.*;
import port.*;

import java.net.*;
import java.sql.Timestamp;
import java.util.ArrayList;

import iPv4.GetIpList;

import java.io.IOException;

public class Main{
public static void main(String[] args) throws UnknownHostException, IOException {
	
	  Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	  
	  
		System.out.println("\n\t --- " + timestamp +" ---" );
	System.out.println("\n\t\t --- Scann Started ---" );

    
    
    IPv4.test();


 

System.out.println("\n\t\t --- The end ---");
System.out.println( "\n\t --- " + new Timestamp(System.currentTimeMillis()) + " ---");
}



}