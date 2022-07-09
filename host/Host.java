package host;

import java.net.InetAddress;
import java.util.List;

public class Host {
	
	private InetAddress address;
	public String getMacVendor() {
		return macVendor;
	}



	public void setMacVendor(String macVendor) {
		this.macVendor = macVendor;
	}


	private List<Integer> ports ;
	private String macAddress,macVendor, hostName;

	public static int totalHosts;
	
	@Override
	public String toString() {
	    return "Host: " + address.toString().substring(1) 
		    + "\nHostname: " + hostName
		    + "\nmacAddress: " + macAddress  
		    + "\nmacVendor: " + macVendor 
		    + "\nports= " + ports + "\n";
	}



	public Host(InetAddress address) {
		
		this.address = address;
	
		totalHosts++;
	}
	
	
	public String getHostName() {
	    return hostName;
	}


	public void setHostName(String hostName) {
	    String hostnm = hostName.equals(address.toString().substring(1))? "":hostName;
	    this.hostName = hostnm;
	}



	
	
	
	
	



	public InetAddress getAddress() {
		return address;
	}


	public void setAddress(InetAddress address) {
		this.address = address;
	}


	public List<Integer> getPorts() {
		return ports;
	}


	public void setPorts(List<Integer> ports) {
		this.ports = ports;
	}


	public String getMacAddress() {
		return macAddress;
	}


	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}


	
	
	
	
}
