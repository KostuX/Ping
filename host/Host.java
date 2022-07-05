package host;

import java.net.InetAddress;
import java.util.List;

public class Host {
	
	private InetAddress address;
	private List<Integer> ports ;
	private String macAddress;
	private boolean local;
	public static int totalHosts;
	
	
	public Host(InetAddress address, List<Integer> ports, String macAddress, boolean local) {
		super();
		this.address = address;
		this.ports = ports;
		this.macAddress = macAddress;
		this.local = local;
	}


	public Host(InetAddress address) {
		
		this.address = address;
	
		totalHosts++;
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


	public boolean isLocal() {
		return local;
	}


	public void setLocal(boolean local) {
		this.local = local;
	}	

	
	
	
	
}
