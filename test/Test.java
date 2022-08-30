package test;

import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

import os.*;

public class Test {

    public static void main(String[] args) {
	

	
	
	System.out.println(getProgramByPID(getPidByPort(5060)));

    }
    
    public static String getProgramByPID(int pid) {
	
	
	 String arr = Windows_CMD.run_CMD("tasklist ");
	 
	 
 String ar[] = arr.split("\t");
 
 for (int i = 0; i < ar.length; i++) {
     

if(ar[i].contains(" "+pid+" ")) {
    
    
    
String tmp = ar[i].substring(0,ar[i].indexOf("  "));

String[] str = tmp.split("\t");
return str[0];

}
    
}
return null;
	
	
    }
    
    
    public static int getPidByPort(int port) {
	int pid = -1;
	
	 String arr = Windows_CMD.run_CMD("netstat -ano -p tcp ");
	 String ar[] = arr.split("\t");
	 
	 for (int i = 0; i < ar.length; i++) {
	     
	     if(ar[i].contains(":"+port)) {
	    
	     
	     String inAr[] = ar[i].split(" ");
	     
	    int count = 0;
	     for (int j = 0; j < inAr.length; j++) {
		
		 
		 if(inAr[j].length() == 0) continue;
		 count++;
		// System.err.println("found" +inAr[j].trim() + count) ;
		 
		if (count == 5) return (int) Integer.valueOf(inAr[j].trim()) ;
		 
		
	    }
	     System.out.println("\n");
	     
	     }
	    
	}
	

	
	return pid;
    }

   
}
