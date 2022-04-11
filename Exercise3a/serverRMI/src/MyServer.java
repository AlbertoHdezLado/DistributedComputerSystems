import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MyServer {
    public static void main(String[] args){
        if (args.length == 0){
            System.out.println("You have to enter RMI object address in the form: //host_addres/service_name");
            return;
        }
        try {
            Registry reg = LocateRegistry.createRegistry(1099);

        } catch (RemoteException e) {
            e.printStackTrace();
        }
        System.setProperty("java.rmi.server.hostname","192.168.56.1");
        System.setProperty("java.security.policy","D:\\2022_DCS\\zf\\cw3a_tel\\serverRMI\\src\\srv.policy");
//        if(System.getSecurityManager() == null)
//            System.setSecurityManager(new SecurityManager());
        try{
            MyData.info();
            CalcObjImpl mySrvObj = new CalcObjImpl();
            System.out.println(args[0]);
            java.rmi.Naming.rebind(args[0], mySrvObj);
            System.out.println("Server is registered now :-)");
            //System.out.println("Press Crl+C to stop...");
        } catch (Exception e) {
            System.out.println("SERVER  CAN`T BE REGISTERED!");
            e.printStackTrace();
            return;
        }
        try {
            CalcObjImpl2 mySrvObj2 = new CalcObjImpl2();
            System.out.println(args[1]);
            Naming.rebind(args[1], mySrvObj2);
            java.rmi.Naming.rebind(args[1], mySrvObj2);
            System.out.println("Server2 is registered now!");
            //System.out.println("Press Ctrl + C to stop...");
        } catch (Exception e) {
            System.out.println("Server can't be registered");
            e.printStackTrace();
            return;
        }
    }
}
