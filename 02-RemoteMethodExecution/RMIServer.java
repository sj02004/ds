import java.rmi.Naming;

public class RMIServer {
    public static void main(String[] args) {

        try {
            // Create object
            RemoteInterface obj = new RemoteObjectImpl();

            // Bind object with name
            Naming.rebind("Addition", obj);

            System.out.println("RMI Server Started...");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
