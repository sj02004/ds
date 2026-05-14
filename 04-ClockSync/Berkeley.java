import java.util.Scanner;

public class Berkeley {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n;

        // Number of slave clocks
        System.out.print("Enter number of slave clocks: ");
        n = sc.nextInt();

        int[] clocks = new int[n + 1];

        // Master clock
        System.out.print("Enter master clock time: ");
        clocks[0] = sc.nextInt();

        // Slave clocks
        for (int i = 1; i <= n; i++) {
            System.out.print("Enter slave clock " + i + " time: ");
            clocks[i] = sc.nextInt();
        }

        int sum = 0;

        // Calculate total time
        for (int i = 0; i <= n; i++) {
            sum += clocks[i];
        }

        // Average time
        int average = sum / (n + 1);

        System.out.println("\nAverage Time = " + average);

        // Synchronize clocks
        System.out.println("\nSynchronized Clock Times:");

        for (int i = 0; i <= n; i++) {

            int adjustment = average - clocks[i];

            System.out.println(
                    "Clock " + i +
                    " adjusted by " +
                    adjustment +
                    " units -> New Time = " +
                    average);
        }

        sc.close();
    }
}