import java.rmi.Naming;

public class RMIClient {
        public static void main(String[] args) {

        try {

            // Lookup remote object
            RemoteInterface addServer = (RemoteInterface) Naming.lookup("rmi://localhost/Addition");

            // Numbers
            double d1 = 10;
            double d2 = 20;

            // Call remote method
            double result = addServer.add(d1, d2);

            System.out.println("Addition Result = " + result);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
