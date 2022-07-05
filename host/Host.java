package host;

import java.net.InetAddress;

public class Host {
	
	private InetAddress address;
	private int ports[];
	private String macAddress;
	private boolean local;
	
	
	public Host(InetAddress address, int[] ports, String macAddress, boolean local) {
		super();
		this.address = address;
		this.ports = ports;
		this.macAddress = macAddress;
		this.local = local;
	}


	public Host(InetAddress address) {
		this.address = address;
	}


	public InetAddress getAddress() {
		return address;
	}


	public void setAddress(InetAddress address) {
		this.address = address;
	}


	public int[] getPorts() {
		return ports;
	}


	public void setPorts(int[] ports) {
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
