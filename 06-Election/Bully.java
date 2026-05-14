import java.util.Scanner;

public class Bully {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n;

        System.out.print("Enter number of processes: ");
        n = sc.nextInt();

        int[] processes = new int[n];

        // Active processes
        for (int i = 0; i < n; i++) {
            processes[i] = 1;
        }

        System.out.print("Enter process that starts election: ");
        int initiator = sc.nextInt();

        System.out.println("\nElection Started by Process " + initiator);

        int coordinator = initiator;

        // Bully election
        for (int i = initiator + 1; i < n; i++) {

            if (processes[i] == 1) {

                System.out.println(
                        "Process "
                        + initiator
                        + " sends ELECTION message to Process "
                        + i);

                System.out.println(
                        "Process "
                        + i
                        + " sends OK message");

                coordinator = i;
            }
        }

        System.out.println(
                "\nProcess "
                + coordinator
                + " becomes COORDINATOR");

        sc.close();
    }
}