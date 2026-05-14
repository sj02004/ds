import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

class RemoteObjectImpl extends UnicastRemoteObject implements RemoteInterface{

    protected RemoteObjectImpl() throws RemoteException {
        super();
    }

    @Override
    public double add(double d1, double d2) throws RemoteException  {
        return d1 + d2;
    }
    
}