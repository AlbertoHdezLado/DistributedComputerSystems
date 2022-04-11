package xmlrpcserwer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import org.apache.xmlrpc.WebServer;

public class ServerRPC {
	static String information = new String();
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		try {
			MyData.info();
			System.out.println();
			System.out.println("Starting XML_RPC server...");
			int port = (10000 + 1);
			WebServer server = new WebServer(port);
			//Bellow server object with name MyServer is created and run:
			server.addHandler("MyServer", new ServerRPC());
			server.start();
			System.out.println("Server started successfully.");
			System.out.println("Listening on port: " + port);
			System.out.println("Write info for information of the procedures.");
			information = scan.next();
			if(information == "info") {
				System.out.println("show()");
			}
			System.out.println("Press <ENTER> to stop the server.");

		} catch (Exception exception) {
			System.err.println("XML-RPC server: " + exception);
		}
	}


	public Integer echo(int x, int y) {
		return (x+y);
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

	static void addMyVector(Collection<Object> coll) {
		Vector<Object> vec = new Vector<Object>();
		vec.addAll(coll);
	}

	public static double distance(double lat1, double lat2, double lon1, double lon2, double el1, double el2) {

		int R = 6371; // Radius of the earth

		double latitudeDistance = Math.toRadians(lat2 - lat1);
		double longitudeDistance = Math.toRadians(lon2 - lon1);
		//Partial calculations
		double a = Math.sin(latitudeDistance / 2) * Math.sin(latitudeDistance / 2)
				+ Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
				* Math.sin(longitudeDistance / 2) * Math.sin(longitudeDistance / 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		double distance = R * c * 1000; // Convert it to meters

		double h = el1 - el2; //Calculate the height

		distance = Math.pow(distance, 2) + Math.pow(h, 2); //Calculates distance

		return Math.sqrt(distance);
	}

	public static String primes(int num1, int num2){
		List<Integer> list = new ArrayList<Integer>();
		for (int i = num1; i <=num2; i++) {
			boolean prime = true;
			if(i == 0) {
				continue;
			}
			if (i == 2 || i == 1) {
				list.add(i);
			} else {
				for(int j = 2; (j * j) <= i; j++) {
					if(i % j == 0) {
						prime = false;
						break;
					}
				}
				if (prime) {
					list.add(i);
				}
			}

		}
		System.out.println("There is a total of " + list.size() + " primes numbers, and the last one is: " + list.get(list.size() - 1));

		return "There is a total of " + list.size() + " primes numbers, and the last one is: " + list.get(list.size() - 1);
	}

	public String show() {
		String menu = "";
		menu += "1.  echo(int x, int y) - Prints results of an add.\n";
		menu += "2.  distance(double lat1, double lat2, double lon1, double lon2, double el1, double el2) - Prints the distance between two points giving their cords.\n";
		menu += "3.  primes(int num1, int num2) - Returns the number of primes found between two given numbers and the last one.\n";
		menu += "4.  show() - Shows method names, parameters and descriptions.\n";
		return menu;
	}
}