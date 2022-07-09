package macAddress;

import java.io.*;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
public class MacAddress {
    


    public static String getMacAddrHost(String host) throws IOException, InterruptedException {
        //
        boolean ok = ping3(host);
        System.out.println(ok);
   
        if (ok) {
            InetAddress address = InetAddress.getByName(host);
            String ip = address.getHostAddress();
            return run_program_with_catching_output("arp -a " + ip);
        }
        //
        return null;
        //
    }


 public static boolean ping3(String host) throws IOException, InterruptedException {
        boolean isWindows = System.getProperty("os.name").toLowerCase().contains("win");

        ProcessBuilder processBuilder = new ProcessBuilder("ping", isWindows ? "-n" : "-c", "1", host);
        Process proc = processBuilder.start();

       // int returnVal = proc.waitFor();
        return true;
    }

    public static String run_program_with_catching_output(String param) throws IOException {
        Process p = Runtime.getRuntime().exec(param);
        BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        while ((line = input.readLine()) != null) {
            if (!line.trim().equals("")) {
                // keep only the process name
                line = line.substring(1);
                System.out.println(line);
                String mac = extractMacAddr(line);
                if (mac.isEmpty() == false) {
                    return mac;
                }
            }

        }
        return null;
    }

    public static String extractMacAddr(String str) {
        String arr[] = str.split("   ");
        for (String string : arr) {
            if (string.trim().length() == 17) {
                return string.trim().toUpperCase();
            }
        }
        return "";
    }

  public static  void readFile()
    {
	   
        File file = new File("mac-vendor.txt");
 
        BufferedReader br = null;
	try {
	    br = new BufferedReader(new FileReader(file));
	} catch (FileNotFoundException e) { e.printStackTrace();}
 
     
        String st;

        try {
	    while ((st = br.readLine()) != null) 
		writeFile(st.split("\t"));
	} catch (IOException e) {e.printStackTrace();
	}
    }
  
      public static void writeFile(String[] s) {
        try {
          FileWriter myWriter = new FileWriter("filename.txt", true);
          BufferedWriter bw = new BufferedWriter(myWriter);
          bw.newLine();
          myWriter.write("case\t" + s[0] +":  macVendor = \""+ s[1] +"\"; break;\n");
          bw.newLine();
         
          myWriter.close();
          
        } catch (IOException e) {e.printStackTrace();}
      }
      
      
      
      
      
   
}
