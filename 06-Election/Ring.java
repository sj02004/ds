import java.util.Scanner;

public class Ring {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n;

        System.out.print("Enter number of processes: ");
        n = sc.nextInt();

        int[] processes = new int[n];

        // Assign process IDs
        for (int i = 0; i < n; i++) {
            processes[i] = i;
        }

        System.out.print("Enter process initiating election: ");
        int initiator = sc.nextInt();

        System.out.println(
                "\nElection message passing:");

        int maxId = initiator;

        int current = initiator;

        do {

            System.out.println(
                    "Process "
                    + current
                    + " passes message to Process "
                    + ((current + 1) % n));

            if (current > maxId) {
                maxId = current;
            }

            current = (current + 1) % n;

        } while (current != initiator);

        System.out.println(
                "\nProcess "
                + maxId
                + " becomes COORDINATOR");

        sc.close();
    }
}