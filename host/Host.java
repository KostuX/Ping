package host;

import java.net.InetAddress;
import java.util.List;

public class Host {
	
	private InetAddress address;
	

	private List<Integer> ports ;
	private String macAddress,macVendor, hostName;

	public static int totalHosts;
	
	@Override
	public String toString() {
	    return "Host IP: " + address.toString().substring(1) 
		    + getHostName().equals(null)?"\nHostname: " + getHostName():""
		    + "\nmacAddress: " + getMacAddress()  
		    + "\nmacVendor: " + getMacVendor() 
		    + "\nports= " + getPorts() + "\n";
	}



	public Host(InetAddress address) {
		
		this.address = address;
	
		totalHosts++;
	}
	
	public String getMacVendor() {
	    	if(this.macVendor == null) {return "Not found";}
	    	else return macVendor;
	}



	public void setMacVendor(String macVendor) {
		this.macVendor = macVendor;
	}

	
	
	public String getHostName() {
	    if(this.hostName == null) {return "Not found";}
	    else return hostName;
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
	    if(this.macAddress == null) {return "Not found";}
	    else return this.macAddress;
	}


	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}


	
	
	
	
}
