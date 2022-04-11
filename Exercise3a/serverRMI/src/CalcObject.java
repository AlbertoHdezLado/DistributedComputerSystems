import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CalcObject extends Remote {
    double calculate(double a, double b) throws RemoteException;

}
