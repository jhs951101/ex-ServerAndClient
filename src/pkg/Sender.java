package pkg;

import java.io.DataOutputStream;
import java.net.Socket;

public class Sender extends Thread {
	
	//private GUI gui;
	private Socket socket;
	private DataOutputStream out;
	
	public Sender(/*GUI gui, */Socket s){
		try {
			//this.gui = gui;
			this.socket = s;
			this.out = new DataOutputStream(socket.getOutputStream());
        } catch(Exception e) {
            e.printStackTrace();
        }
	}
	
	@Override
	public void run(){
		/*
		gui.button.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			try{
    				String str = "msg";
            		str += "\n";
                	out.write(str.getBytes("UTF-8"));
                	out.flush();
    			} catch(Exception e2){
    				e2.printStackTrace();
    			}
    		}
        });
        */
		
		/*
		try {
            while(out != null){
                if(order != null){
                    order += "\n";
                    out.write(order.getBytes("UTF-8"));
                    out.flush();

                    if(order.equals("disconnect"))
                        break;

                    order = null;
                }
            }
        } catch(IOException e) {
            e1.printStackTrace();
        } finally {
            closeAll();
        }
        */
	}
}