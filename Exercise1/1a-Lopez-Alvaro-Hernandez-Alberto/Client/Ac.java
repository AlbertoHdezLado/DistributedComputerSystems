package partA;

import java.net.URL;

import org.apache.xmlrpc.AsyncCallback;

public class Ac implements AsyncCallback {

	@Override
	public void handleError(Exception arg0, URL arg1, String arg2) {
		System.err.println("Exception: " + arg0);
		System.out.println("URL: " + arg1);
		System.out.println("Method: " + arg2);
	}

	@Override
	public void handleResult(Object arg0, URL arg1, String arg2) {
		System.out.println("Result: " + arg0);
		System.out.println("URL: " + arg1);
		System.out.println("Method: " + arg2);
		
	}

}
