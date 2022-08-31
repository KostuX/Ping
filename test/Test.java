package test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import os.*;

public class Test {

    public static void main(String[] args) {
	

	
	
	System.out.println(getProgramByPID(getPidByPort(139)));

    }
    
    public static String getProgramByPID(int pid) {
	
	 String arr = Windows_CMD.run_CMD("tasklist");	
	 
	String ar[] = arr.split("\t");
	// List<String> lStr = Arrays.asList(ar);

	 String delim_1 = "\t";
 
	 String stage1 =  Arrays.stream(ar)
		   .flatMap(Pattern.compile("\n")::splitAsStream) 
		   .map(t -> t.replaceAll(" \\s+", delim_1))
		   .filter(t->t.contains(delim_1+pid+" "))
		   .map(t->t.substring(0, t.indexOf(delim_1)))
		 //only one result must be at this stage but just in case use "Or:" as delimiter/seperator
		   .collect(Collectors.joining(" Or: "));
	 return stage1; 
	
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
