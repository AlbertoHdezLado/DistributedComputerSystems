package main;

import org.apache.xmlrpc.WebServer;

public class ServerRPC {
	
	public static void main(String[] args) {
		try {
			System.out.println("Starting XML_RPC server...");
			int port = (10000 + 1);
			WebServer server = new WebServer(port);
			//Bellow server object with name MyServer is created and run:
			server.addHandler("MyServer", new ServerRPC());
			server.start();
			System.out.println("Server started successfully."); 
			System.out.println("Listening on port: " + port); 
			System.out.println("Press Ctrl+C to stop the server.");
			
		} catch (Exception exception) {
			System.err.println("XML-RPC server: " + exception);
		}
	}

	
	@SuppressWarnings("deprecation")
	public Integer echo(int x, int y) {
		return new Integer(x+y);
	}
	
	public int execAsy(int x) {
		System.out.println("...execAasy called - processing");
		try {
			Thread.sleep(x);
		} catch(InterruptedException ex) {
			ex.printStackTrace();
			Thread.currentThread().interrupt();
		}
		System.out.println("...execAsy - finished");
		return 123;
	}
	
}

  