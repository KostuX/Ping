package port;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.*;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;



import host.Host;

//import java.io.IOException;

public class PortScan {
    
   {readPortFile() ;}
    
    public static HashMap<Integer, String> portHashMap= new HashMap<>();
   
    
   static  List<Integer> listOfports = portHashMap.keySet().stream().sorted().collect(Collectors.toList());
     
     
   static int[] portList_Known2 = listOfports.stream().mapToInt(i->i).toArray();
    
    
   static int portList_Known[] ={1,3,7,9,13,17,19,21,22,23,25,26,37,53,79,81,82,80,88,100,106,110,111,113,119,135,139,143,144,179,199,254,255,280,311,389,427,443,445,464,465,497,513,515,543,544,548,554,587,593,625,631,636,646,787,808,873,902,990,993,995,1000,1022,1024,1033,1035,1041,1044,1048,1050,1053,1054,1056,1058,1059,1064,1066,1069,1071,1074,1080,1110,1234,1433,1494,1521,1720,1723,1755,1761,1801,1900,1935,1998,2000,2001,2002,2003,2004,2005,2006,2007,2008,2009,2010,2049,2103,2105,2107,2121,2161,2179,2301,2383,2401,2601,2717,2869,2967,3000,3001,3128,3268,3306,3389,3689,3690,3703,3986,4000,4001,4045,4899,5000,5001,5003,5009,5050,5051,5060,5080,5101,5120,5190,5357,5432,5555,5631,5666,5800,5900,5901,6000,6002,6004,6112,6646,6666,7000,7070,7547,7937,7938,8000,8002,8008,8010,8031,8080,8081,8443,8888,9000,9001,9050,9090,9100,9102,9999,10001,10010,32768,32771,49152,49157,50000};
   static int portList_Known1[] ={21,22,23,25,80,443,8080};
   

  public  void  portScanner(Host host){
      
      HashMap<Integer, String> openPorts = new HashMap<>();
      
      // Integer[] portList_Known = new Integer[listOfports.size()];
      //listOfports.toArray(portList_Known);
      
      InetAddress inAddress = host.getAddress();


  //  int counter = portList_Known.length;

//while(counter > 0)
//{
   

      for (int i = 0; i < portList_Known.length; i++) {
	

    try
    {       
	Socket scannerSocket = new Socket();
	 
        scannerSocket.connect(new InetSocketAddress(inAddress, portList_Known[i]),50);
        scannerSocket.close();
        
     
       
        openPorts.put(portList_Known[i], portName(portList_Known[i]));//    .put(portList_Known[i], portName(portList_Known[i]));
       
        System.out.println(inAddress.toString().substring(1) + ": "+ portList_Known[i] + "\t"+ portHashMap.get(portList_Known[i]) + " \t\t"+test.Test.getProgramByPID(test.Test.getPidByPort(portList_Known[i])));
     
      }catch(Exception e){}
    	//finally{counter--;}
    }
   //   }
    
host.setPorts(openPorts);
  };
  
  
  
  public static  void readPortFile() 
  {
    	String st;
      File file = new File("port_list.txt");
      
	try ( BufferedReader br = new BufferedReader(new FileReader(file));)
	{
	    while ((st = br.readLine()) != null) {
		
		String spStr[] = st.split("\t");		
		portHashMap.put(Integer.valueOf( spStr[0].trim()), spStr[1].trim());		
	    }
	   
	} 
	catch (Exception e) {
	    e.printStackTrace();
	}
  
  }
  
  
  

  public static String portName(int scannedPort){

String description="";

    switch(scannedPort)
    {
        case 1: description = "TCP Port Service Multiplexer (TCPMUX)";
            break;
        case 2: description = "CompressNET Management Utility";
            break;
        case 3: description = "CompressNET Compression Process";
            break;
        case 5: description = "Remote job entry";
            break;
        case 7: description = "Echo Protocol";
            break;
        case 9: description = "Discard Protocol";
            break;
        case 11: description = "Active Users (systat service)";
            break;
        case 13: description = "Daytime Protocol (RFC 867)";
            break;
        case 17: description = "Quote Of The Day";
            break;
        case 19: description = "Character Generator Protocol";
            break;
        case 20: description = "FTP data transfer";
            break;
        case 21: description = "FTP control (command)";
            break;
        case 22: description = "Secure Shell (SSH), secure logins, file transfers (SCP, SFTP)";
            break;
        case 23: description = "Telnet protocol - unencrypted text communications";
            break;
        case 24: description = "Priv-mail, any private mail system";
            break;
        case 25: description = "Simple Mail Transfer Protocol (SMTP)";
            break;
        case 27: description = "NSW User System FE";
            break;
        case 29: description = "MSG ICP";
            break;
        case 33: description = "Display Support Protocol";
            break;
        case 35: description = "Any private printer server protocol";
            break;
        case 37: description = "Time Protocol";
            break;
        case 39: description = "Resource Location Protocol (RLP)";
            break;
        case 42: description = "ARPA Host Name Server Protocol";
            break;
        case 43: description = "WHOIS protocol";
            break;
        case 47: description = "NI FTP";
            break;
        case 49: description = "TACACS+ Login Host protocol";
            break;
        case 50: description = "Remote Mail Checking Protocol";
            break;
        case 51: description = "IMP Logical Address Maintenance";
            break;
        case 52: description = "XNS (Xerox Network Systems) Time Protocol";
            break;
        case 53: description = "Domain Name System (DNS)";
            break;
        case 54: description = "Xerox Network Systems (XNS) clearinghouse";
            break;
        case 55: description = "ISI Graphics Language (ISI-GL)";
            break;
        case 56: description = "Xerox Network Systems (XNS) authentication";
            break;
        case 57: description = "Any private terminal access";
            break;
        case 58: description = "Xerox Network Systems (XNS) Mail";
            break;
        case 64: description = "CI (Travelport) (formerly Covia) Comms Integrator";
            break;
        case 67: description = "Bootstrap Protocol (BOOTP) server or Dynamic Host Configuration Protocol (DHCP)";
            break;
        case 68: description = "Bootstrap Protocol (BOOTP) client or Dynamic Host Configuration Protocol (DHCP)";
            break;
        case 69: description = "Trivial File Transfer Protocol (TFTP)";
            break;
        case 70: description = "Gopher protocol";
            break;
        case 71: description = "NETRJS protocol";
            break;
        case 72: description = "NETRJS protocol";
            break;
        case 73: description = "NETRJS protocol";
            break;
        case 74: description = "NETRJS protocol";
            break;
        case 77: description = "Any private Remote job entry";
            break;
        case 79: description = "Finger protocol";
            break;
        case 80: description = "Hypertext Transfer Protocol (HTTP)";
            break;
        case 81: description = "Hypertext Transfer Protocol (HTTP) ????";
        break;
        case 88: description = "Kerberos authentication system";
            break;
        case 90: description = "DNSIX Security Attribute Token Map";
            break;
        case 101: description = "NIC host name";
            break;
        case 102: description = "ISO Transport Service Access Point (TSAP)";
            break;
        case 104: description = "ACR/NEMA Digital Imaging and Communications in Medicine (DICOM)";
            break;
        case 105: description = "CCSO Nameserver Protocol (Qi/Ph)";
            break;
        case 107: description = "Remote Telnet Service protocol";
            break;
        case 108: description = "SNA Gateway Access Server";
            break;
        case 109: description = "Post Office Protocol v2 (POP2)";
            break;
        case 110: description = "Post Office Protocol v3 (POP3)";
            break;
        case 111: description = "ONC RPC (Sun RPC)";
            break;
        case 113: description = "Ident, authentication service/identification protocol";
            break;
        case 115: description = "Simple File Transfer Protocol";
            break;
        case 118: description = "Structured Query Language (SQL) Services";
            break;
        case 119: description = "Network News Transfer Protocol (NNTP)";
            break;
        case 123: description = "Network Time Protocol (NTP)";
            break;
        case 126: description = "Formerly Unisys Unitary Login, renamed by Unisys to NXEdit";
            break;
        case 135: description = "DCE endpoint resolution || Microsoft Remote Procedure Call";
            break;
        case 137: description = "NetBIOS Name Service";
            break;
        case 138: description = "NetBIOS Datagram Service";
            break;
        case 139: description = "NetBIOS Session Service";
            break;
        case 143: description = "Internet Message Access Protocol (IMAP)";
            break;
        case 152: description = "Background File Transfer Program (BFTP)";
            break;
        case 153: description = "Simple Gateway Monitoring Protocol (SGMP)";
            break;
        case 156: description = "SQL Service";
            break;
        case 162: description = "Simple Network Management Protocol Trap (SNMPTRAP)";
            break;
        case 170: description = "Print-srv, Network PostScript";
            break;
        case 175: description = "VMNET (IBM z/VM, z/OS & z/VSE—Network Job Entry (NJE))";
            break;
        case 177: description = "X Display Manager Control Protocol (XDMCP)";
            break;
        case 179: description = "Border Gateway Protocol (BGP)";
            break;
        case 194: description = "Internet Relay Chat (IRC)";
            break;
        case 199: description = "SMUX, SNMP Unix Multiplexer";
            break;
        case 201: description = "AppleTalk Routing Maintenance";
            break;
        case 209: description = "Quick Mail Transfer Protocol";
            break;
        case 210: description = "ANSI Z39.50";
            break;
        case 213: description = "Internetwork Packet Exchange (IPX)";
            break;
        case 218: description = "Message posting protocol (MPP)";
            break;
        case 220: description = "Internet Message Access Protocol (IMAP), version 3";
            break;
        case 259: description = "Efficient Short Remote Operations (ESRO)";
            break;
        case 262: description = "Arcisdms";
            break;
        case 264: description = "Border Gateway Multicast Protocol (BGMP)";
            break;
        case 280: description = "http-mgmt";
            break;
        case 308: description = "Novastor Online Backup";
            break;
        case 311: description = "Mac OS X Server Admin";
            break;
        case 318: description = "PKIX Time Stamp Protocol (TSP)";
            break;
        case 350: description = "Mapping of Airline Traffic over Internet Protocol (MATIP) type A";
            break;
        case 351: description = "Mapping of Airline Traffic over Internet Protocol (MATIP) type B";
            break;
        case 356: description = "cloanto-net-1 (used by Cloanto Amiga Explorer and VMs)";
            break;
        case 366: description = "On-Demand Mail Relay (ODMR)";
            break;
        case 369: description = "Rpc2portmap";
            break;
        case 370: description = "codaauth2, Coda authentication server";
            break;
        case 371: description = "ClearCase albd";
            break;
        case 383: description = "HP data alarm manager";
            break;
        case 384: description = "A Remote Network Server System";
            break;
        case 387: description = "AURP (AppleTalk Update-based Routing Protocol)[22]";
            break;
        case 389: description = "Lightweight Directory Access Protocol (LDAP)";
            break;
        case 399: description = "Digital Equipment Corporation DECnet (Phase V+) over TCP/IP";
            break;
        case 401: description = "Uninterruptible power supply (UPS)";
            break;
        case 427: description = "Service Location Protocol (SLP)";
            break;
        case 433: description = "NNSP, part of Network News Transfer Protocol";
            break;
        case 434: description = "Mobile IP Agent (RFC 5944)";
            break;
        case 443: description = "Hypertext Transfer Protocol over TLS/SSL (HTTPS)";
            break;
        case 444: description = "Simple Network Paging Protocol (SNPP), RFC 1568";
            break;
        case 445: description = "Microsoft-DS Active Directory, Windows shares";
            break;
        case 464: description = "Kerberos Change/Set password";
            break;
        case 465: description = "URL Rendezvous Directory for SSM (Cisco protocol)";
            break;
        case 475: description = "tcpnethaspsrv, Aladdin Knowledge Systems Hasp services";
            break;
        case 497: description = "Dantz Retrospect";
            break;
        case 500: description = "Internet Security Association and Key Management Protocol (ISAKMP) / Internet Key Exchange (IKE)";
            break;
        case 502: description = "Modbus Protocol";
            break;
        case 504: description = "Citadel, multiservice protocol for dedicated clients for the Citadel groupware system";
            break;
        case 510: description = "FirstClass Protocol (FCP)";
            break;
        case 512: description = "Rexec, Remote Process Execution";
            break;
        case 513: description = "rlogin";
            break;
        case 514: description = "Remote Shell, used to execute non-interactive commands on a remote system (Remote Shell, rsh, remsh)";
            break;
        case 515: description = "Line Printer Daemon (LPD), print service";
            break;
        case 520: description = "efs, extended file name server";
            break;
        case 524: description = "NetWare Core Protocol (NCP)";
            break;
        case 530: description = "Remote procedure call (RPC)";
            break;
        case 532: description = "netnews";
            break;
        case 540: description = "Unix-to-Unix Copy Protocol (UUCP)";
            break;
        case 542: description = "commerce (Commerce Applications)";
            break;
        case 543: description = "klogin, Kerberos login";
            break;
        case 544: description = "kshell, Kerberos Remote shell";
            break;
        case 546: description = "DHCPv6 client";
            break;
        case 547: description = "DHCPv6 server";
            break;
        case 548: description = "Apple Filing Protocol (AFP) over TCP";
            break;
        case 550: description = "new-rwho, new-who";
            break;
        case 554: description = "Real Time Streaming Protocol (RTSP)";
            break;
        case 556: description = "Remotefs, RFS, rfs_server";
            break;
        case 563: description = "NNTP over TLS/SSL (NNTPS)";
            break;
        case 587: description = "e-mail message submission (SMTP)";
            break;
        case 591: description = "FileMaker 6.0 (and later) Web Sharing (HTTP Alternate)";
            break;
        case 593: description = "HTTP RPC Ep Map";
            break;
        case 601: description = "Reliable Syslog Service";
            break;
        case 604: description = "TUNNEL profile";
            break;
        case 631: description = "Internet Printing Protocol (IPP)";
            break;
        case 635: description = "RLZ DBase";
            break;
        case 636: description = "Lightweight Directory Access Protocol over TLS/SSL (LDAPS)";
            break;
        case 639: description = "MSDP, Multicast Source Discovery Protocol";
            break;
        case 641: description = "SupportSoft Nexus Remote Command (control/listening)";
            break;
        case 643: description = "SANity";
            break;
        case 646: description = "Label Distribution Protocol (LDP)";
            break;
        case 647: description = "DHCP Failover protocol";
            break;
        case 648: description = "Registry Registrar Protocol (RRP)";
            break;
        case 651: description = "IEEE-MMS";
            break;
        case 653: description = "SupportSoft Nexus Remote Command";
            break;
        case 654: description = "Media Management System (MMS) Media Management Protocol (MMP)";
            break;
        case 657: description = "IBM RMC (Remote monitoring and Control) protocol";
            break;
        case 660: description = "Mac OS X Server administration";
            break;
        case 674: description = "Application Configuration Access Protocol (ACAP)";
            break;
        case 688: description = "REALM-RUSD (ApplianceWare Server Appliance Management Protocol)";
            break;
        case 690: description = "Velneo Application Transfer Protocol (VATP)";
            break;
        case 691: description = "MS Exchange Routing";
            break;
        case 694: description = "Linux-HA high-availability heartbeat";
            break;
        case 695: description = "IEEE Media Management System over SSL (IEEE-MMS-SSL)";
            break;
        case 700: description = "Extensible Provisioning Protocol (EPP)";
            break;
        case 701: description = "Link Management Protocol (LMP)";
            break;
        case 702: description = "IRIS (Internet Registry Information Service) over BEEP";
            break;
        case 706: description = "Secure Internet Live Conferencing (SILC)";
            break;
        case 711: description = "Cisco Tag Distribution Protocol";
            break;
        case 712: description = "Topology Broadcast based on Reverse-Path Forwarding routing protocol (TBRPF)";
            break;
        case 749: description = "Kerberos (protocol) administration";
            break;
        case 753: description = "Reverse Routing Header (RRH)";
            break;
        case 754: description = "tell send";
            break;
        case 800: description = "mdbs-daemon";
            break;
        case 830: description = "NETCONF over SSH";
            break;
        case 831: description = "NETCONF over BEEP";
            break;
        case 832: description = "NETCONF for SOAP over HTTPS";
            break;
        case 833: description = "NETCONF for SOAP over BEEP";
            break;
        case 847: description = "DHCP Failover protocol";
            break;
        case 848: description = "Group Domain Of Interpretation (GDOI) protocol";
            break;
        case 860: description = "iSCSI (RFC 3720)";
            break;
        case 861: description = "OWAMP control (RFC 4656)";
            break;
        case 862: description = "TWAMP control (RFC 5357)";
            break;
        case 873: description = "rsync file synchronization protocol";
            break;
        case 902: description = "ideafarm-door (IdeaFarm (tm) Operations)";
            break;
        case 903: description = "ideafarm-panic (IdeaFarm (tm) Operations)";
            break;
        case 989: description = "FTPS Protocol (data), FTP over TLS/SSL";
            break;
        case 990: description = "FTPS Protocol (control), FTP over TLS/SSL";
            break;
        case 991: description = "Netnews Administration System (NAS)";
            break;
        case 992: description = "Telnet protocol over TLS/SSL";
            break;
        case 993: description = "Internet Message Access Protocol over TLS/SSL (IMAPS)";
            break;
        case 994: description = "Internet Relay Chat over TLS/SSL (IRCS)";
            break;
        case 995: description = "Post Office Protocol 3 over TLS/SSL (POP3S)";
            break;
        case 1025: description = "Microsoft RPC";
            break;
        case 1080: description = "SOCKS Proxy";
            break;
        case 1194: description = "OpenVPN";
            break;
        case 1241: description = "Nessus";
            break;
        case 1311: description = "Dell OpenManage";
            break;
        case 1433: description = "Microsoft SQL";
            break;
        case 1434: description = "Microsoft SQL";
            break;
        case 1512: description = "WINS";
            break;
        case 1589: description = "Cisco VQP";
            break;
        case 1701: description = "L2TP";
            break;
        case 1723: description = "MS PPTP";
            break;
        case 1741: description = "CiscoWorks 2000";
            break;
        case 1812: description = "RADIUS";
            break;
        case 1813: description = "RADIUS";
            break;
        case 1985: description = "Cisco HSRP";
            break;
        case 2000: description = "Cisco SCCP";
            break;
        case 2002: description = "Cisco ACS";
            break;
        case 2049: description = "NFS";
            break;
        case 2082: description = "cPanel";
            break;
        case 2083: description = "cPanel";
            break;
        case 2100: description = "Oracle XDB";
            break;
        case 2222: description = "DirectAdmin";
            break;
        case 2483: description = "Oracle DB";
            break;
        case 2484: description = "Oracle DB";
            break;
        case 3050: description = "Interbase DB";
            break;
        case 3124: description = "HTTP Proxy";
            break;
        case 3128: description = "HTTP Proxy";
            break;
        case 3222: description = "GLBP";
            break;
        case 3260: description = "iSCSI Target";
            break;
        case 3306: description = "MySQL";
            break;
        case 3389: description = "Terminal Server";
            break;
        case 3689: description = "iTunes";
            break;
        case 3690: description = "Subversion";
            break;
        case 4333: description = "mSQL";
            break;
        case 4664: description = "Google Desktop";
            break;
        case 4899: description = "Radmin";
            break;
        case 5000: description = "UPnP";
            break;
        case 5001: description = "iperf";
            break;
        case 5004: description = "RTP";
            break;
        case 5005: description = "RTP";
            break;
        case 5060: description = "Session Initiation Protocol (SIP)";
        break;
        case 5357: description = "Microsoft Network Discovery OR Web Services for Devices";
        break;
        case 5432: description = "PostgreSQL";
            break;
        case 5500: description = "VNC Server";
            break;
        case 5555: description = "SoftEther VPN (Ethernet Over HTTPS)";
        break;
        case 5631: description = "pcAnywhere";
            break;
        case 5632: description = "pcAnywhere";
            break;
        case 5800: description = "VNC over HTTP";
            break;
        case 6000: description = "X11";
            break;
        case 6001: description = "X11";
            break;
        case 6129: description = "DameWare";
            break;
        case 6566: description = "SANE";
            break;
        case 6588: description = "AnalogX";
            break;
            case 7547: description = "Customer-premises WAN management protocol";
            break;
        case 8080: description = "HTTP Proxy";
            break;
        case 8200: description = "VMware Server";
            break;
        case 8500: description = "Adobe ColdFusion";
            break;
        case 9050: description = "Tor - Versiera Agent Listener";
        break;
        case 9100: description = "HP JetDirect";
            break;
        case 9101: description = "Bacula";
            break;
        case 9102: description = "Bacula";
            break;
        case 9103: description = "Bacula";
            break;
        case 9800: description = "WebDAV";
            break;
        case 10000: description = "Webmin";
            break;
        case 11371: description = "OpenPGP";
            break;
        case 13720: description = "NetBackup";
            break;
        case 13721: description = "NetBackup";
            break;
        case 19226: description = "AdminSecure";
            break;
        case 19638: description = "Ensim";
            break;
        case 20000: description = "Usermin";
            break;
        case 24800: description = "Synergy";
            break;
        default: description = "No description";
            break;
    }


return description;
  }
    
}
