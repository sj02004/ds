import mpi.*;

public class MPI {
    public static void main(String[] args) throws Exception {

        // Initialize MPI
        MPI.Init(args);

        // Rank of current process
        int rank = MPI.COMM_WORLD.Rank();

        // Total number of processes
        int size = MPI.COMM_WORLD.Size();

        int[] array = {10, 20, 30, 40};

        int elementsPerProcess = array.length / size;

        int start = rank * elementsPerProcess;
        int end = start + elementsPerProcess;

        int localSum = 0;

        // Calculate partial sum
        for (int i = start; i < end; i++) {
            localSum += array[i];
        }

        // Display intermediate sum
        System.out.println(
                "Process " + rank +
                " calculated partial sum = " + localSum);

        int[] globalSum = new int[1];

        // Reduce all partial sums into final sum
        MPI.COMM_WORLD.Reduce(
                new int[]{localSum}, 0,
                globalSum, 0,
                1,
                MPI.INT,
                MPI.SUM,
                0);

        // Display final result on root process
        if (rank == 0) {
            System.out.println("Final Sum = " + globalSum[0]);
        }

        // Finalize MPI
        MPI.Finalize();
    }
}
