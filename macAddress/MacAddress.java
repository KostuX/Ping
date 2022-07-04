package macAddress;
import java.io.*;
import java.io.IOException;
public class MacAddress {
    


public static String run_program_with_catching_output(String param) throws IOException {

    Process p = Runtime.getRuntime().exec(param);

    BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));

    String line;

    while ((line = input.readLine()) != null) {
        if (!line.trim().equals("")) {
           
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



}
