import java.util.Scanner;

public class TokenRing {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n;

        // Number of processes
        System.out.print("Enter number of processes: ");
        n = sc.nextInt();

        int token = 0;

        System.out.println("\nInitial Token Holder: Process " + token);

        char choice = 'y';

        while (choice == 'y' || choice == 'Y') {

            int sender;

            // Process requesting critical section
            System.out.print("\nEnter process requesting CS: ");
            sender = sc.nextInt();

            System.out.println(
                    "\nToken passing:");

            // Pass token until it reaches sender
            while (token != sender) {

                System.out.println(
                        "Token passed from Process "
                        + token +
                        " to Process "
                        + ((token + 1) % n));

                token = (token + 1) % n;
            }

            // Enter critical section
            System.out.println(
                    "\nProcess "
                    + sender +
                    " ENTERED Critical Section");

            System.out.println(
                    "Process "
                    + sender +
                    " EXITED Critical Section");

            // Pass token to next process
            token = (token + 1) % n;

            System.out.println(
                    "Token passed to Process "
                    + token);


            System.out.print(
                    "\nDo you want another request? (y/n): ");

            choice = sc.next().charAt(0);
        }

        sc.close();
    }
}