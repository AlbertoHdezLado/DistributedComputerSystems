package main;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

import org.apache.xmlrpc.XmlRpcClient;
import main.Ac;

public class ClientRPC {

	public static void main(String[] args) {
		try {
			XmlRpcClient srv = new XmlRpcClient("http://localhost:10001");

			Ac cb = new Ac();

			Object returned;

			int option = -1;
			Vector<Object> params;
			Object result = null;
			do {
				System.out.println();
				System.out.println("MENU");
				System.out.println("1.  echo()");
				System.out.println("2.  distance()");
				System.out.println("3.  primes()");
				System.out.println("4.  show()");
				System.out.println("0.  exit");
				System.out.print("Option: ");

				Scanner scan = new Scanner(System.in);

				option = scan.nextInt();
				System.out.println();
				switch (option) {
					case 1:
						params = new Vector<Object>();
						System.out.print("Choose Number 1: ");
						params.add(scan.nextInt());
						System.out.print("Choose Number 2: ");
						params.add(scan.nextInt());
						returned = srv.execute("MyServer.echo", params);
						result = ((Integer) returned).intValue();
						System.out.println(result);

						break;
					case 2:
						params = new Vector<Object>();
						System.out.print("Choose Latitude 1: ");
						double lat1 = scan.nextInt();
						System.out.print("Choose Latitude 2: ");
						double lat2 = scan.nextInt();
						System.out.print("Choose Longitude 1: ");
						double lon1 = scan.nextInt();
						System.out.print("Choose Longitude 2: ");
						double lon2 = scan.nextInt();
						System.out.print("Choose height 1: ");
						double el1 = scan.nextInt();
						System.out.print("Choose Height 2: ");
						double el2 = scan.nextInt();
						params.add(lat1);
						params.add(lat2);
						params.add(lon1);
						params.add(lon2);
						params.add(el1);
						params.add(el2);

						returned = srv.execute("MyServer.distance", params);
						result = (double) returned;
						System.out.println(result);
						break;
					case 3:
						params = new Vector<Object>();
						System.out.print("Choose Number 1: ");
						int num1 = scan.nextInt();
						System.out.print("Choose Number 2: ");
						int num2 = scan.nextInt();
						Vector<Object> p2 = new Vector<Object>();
						params.add(num1);
						params.add(num2);
						srv.executeAsync("MyServer.primes", params, cb);
						break;
					case 4:
						params = new Vector<Object>();
						returned = srv.execute("MyServer.show", params);
						System.out.println("Available methods:");
						System.out.println(returned);
						System.out.print("Press enter to continue...");

						scan = new Scanner(System.in);
						scan.nextLine();
						break;
					default:
						break;
				}
			} while (option != 0);
		} catch (Exception exception) {
			System.err.println("XML-RPC client: " + exception);
		}
	}

	static void myVector(Object obj) {
		Vector<Object> vec = new Vector<Object>();
		vec.add(obj);
	}
}