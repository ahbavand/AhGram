import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Workstation extends Thread {

	Server s;
	Socket client;
	InputStream input;
	OutputStream output;
	String username;

	public Workstation(Socket client, Server s) {
		this.client = client;
		this.s = s;
		try {
			input = client.getInputStream();
			output = client.getOutputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		
		boolean flag = false;
		while (!flag) {
			byte[] b = new byte[200];

			try {
				
				
				int i = input.read(b);
				if (i == -1) {
					flag = true;
					continue;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
			String o=new String(b).trim();
		//	System.out.println(o);
//			
			
			s.recieve(o,this);
		}
	}
}
