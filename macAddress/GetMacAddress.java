package macAddress;
public class GetMacAddress {

    public String extractMAC(String  input){

        
            String arr[] = input.split("   ");
            for (String string : arr) {
                if (string.trim().length() == 17) {
                    return string.trim().toUpperCase();
                }
            }
            return "";
        
    }
    
}
