package pkg;

import java.net.Socket;
import javax.swing.JOptionPane;

public class Client {
	
	//private GUI gui;
	
	private Sender sender;  // sender: Client for Sending
	private Receiver receiver;  // receiver: Client for Receiving
	
	private String IPAddress;  // IPAddress: IP�ּ�
	private int portNumber;  // portNumber: ��Ʈ��ȣ
	
	public Client(/*GUI ui, */String IP, int port){
		this.IPAddress = IP;
		this.portNumber = port;
		//this.gui = ui;
	}
	
	public void start(){
		// ������ �����ϴ� ����
		try {
            Socket socket = new Socket(IPAddress, portNumber);  // ������ �����ϰ� ������ ������
            //JOptionPane.showMessageDialog(gui, "������ ���������� ���� �Ǿ����ϴ�!", "Notice", JOptionPane.INFORMATION_MESSAGE);

            sender = new Sender(socket);
    		receiver = new Receiver(socket);
    		
    		sender.start();
    		receiver.start();  // Thread Start
    		
        } catch(Exception e) {
        	//JOptionPane.showMessageDialog(gui, "���ῡ �����Ͽ����ϴ�.", "Error...", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            //gui.exit();
        }
	}
}

/*
	@Override
    public void run() {
        try {
            serverAddr = InetAddress.getByName(IPAddress);
            socket = new Socket(serverAddr, portNumber);
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());
            pythonExecuter = new PythonExecuter();
            
            String[] arguments = new String[1];
        	arguments[0] = "C:/Projects/JAVA Projects/CafeConfirmClient/Learning_Data_Face.xml";

            while (true) {
            	String str = "setNumOfPeople " + GUI.cafeName + " ";
            	str += pythonExecuter.executePython("C:/Projects/JAVA Projects/CafeConfirmClient", "FaceRecignition.py", arguments);
                str += "\n";
                out.write(str.getBytes("UTF-8"));
                out.flush();
                
                Thread.sleep(5000);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
				socket.close();
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
    }
*/