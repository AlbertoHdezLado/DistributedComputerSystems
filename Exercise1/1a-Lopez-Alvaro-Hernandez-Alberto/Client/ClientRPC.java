package partA;

import java.util.Vector;

import org.apache.xmlrpc.XmlRpcClient;

public class ClientRPC {

	public static void main(String[] args) {
		try {
			XmlRpcClient srv = new XmlRpcClient("http://localhost:10001");
			Vector<Integer> params = new Vector<Integer>();
			params.addElement(13);
			params.addElement(21);
			Object result = srv.execute("MyServer.echo", params);
			int value = ((Integer) result).intValue();
			System.out.println(value);
			
			Ac cb = new Ac();
			Vector<Integer> params2 = new Vector<Integer>();
			params2.addElement(1000);
			srv.executeAsync("MyServer.execAsy", params2, cb);
			System.out.println("Wywolano asynchronicznie");
		} catch (Exception exception) {
			System.err.println("XML-RPC client: " + exception);
		}
	}
}

  