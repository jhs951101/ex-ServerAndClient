package pkg;

import java.io.DataInputStream;
import java.net.Socket;

public class Receiver extends Thread {
	
	//private GUI gui;
	private Socket socket;
	private DataInputStream in;
    
    public Receiver(/*GUI gui, */Socket s){
		try {
			//this.gui = gui;
	    	this.socket = s;
            this.in = new DataInputStream(socket.getInputStream());
        } catch(Exception e) {
            e.printStackTrace();
        }
	}
    
    @Override
	public void run(){
    	String[] orderinfo;  // orderinfo[]: ��ɹ��� ���⸦ �������� �и��ؼ� �����ϱ� ���� �迭
    	
    	try {
            while(in != null) {
            	byte[] bytes = new byte[1024];
                in.read(bytes, 0, 1024);
                String str = new String(bytes, "UTF-8");
                orderinfo = str.split("\n")[0].split(" ");
                 
                /*
                if(orderinfo[0].equals("setUnable")) {
                	
                }
                */
             } 
         } catch(Exception e) {
        	 e.printStackTrace();
         }
	}
}