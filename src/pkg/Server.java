package pkg;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {
	
	private static final int portNumber = 1234;
	
	private Socket socket;
	private DataInputStream in;
	private DataOutputStream out;
	//private DBOperation dbService;
	
	public Server(Socket socket) {
		try {
			this.socket = socket;
			//dbService = new DBOperation();
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
			closeAll();
		}
	}
	
	public void run() {
		try {
			String order;
			String[] orderInfo;
			boolean available = true;
			
			while(available) {
				byte[] bytes = new byte[1024];
	        	in.read(bytes, 0, 1024);
	        	String str = new String(bytes, "UTF-8");
	        	str = str.split("\n")[0];
	        	orderInfo = str.split(" ");
	        	
	        	if(orderInfo[0].equals("disconnect")) {
					order = orderInfo[0];
					order += "\n";
					
	        		out.write(order.getBytes("UTF-8"));
        			out.flush();
	        		available = false;
	        	}
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeAll();
			System.out.println("\nA User Quit");
        }
	}
	
	public void closeAll() {
		try {
			if(socket != null)
				socket.close();
			if(in != null)
				in.close();
			if(out != null)
				out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		ServerSocket serverSocket = null;
		
		try {
			System.out.println("Server Started");
			System.out.println("IP Address: " + Inet4Address.getLocalHost().getHostAddress());
			System.out.println("Port Number: " + portNumber);
			
			serverSocket = new ServerSocket(portNumber);
			
			while(true) {
				Socket socket = serverSocket.accept();
				Server m = new Server(socket);
				m.start();
				System.out.println("\nA User Accessed!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(serverSocket != null);
					serverSocket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
