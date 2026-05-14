#include <mpi.h>
#include <iostream>

using namespace std;

int main(int argc, char* argv[]) {

    // Initialize MPI
    MPI_Init(&argc, &argv);

    int rank, size;

    // Get process rank
    MPI_Comm_rank(MPI_COMM_WORLD, &rank);

    // Get total processes
    MPI_Comm_size(MPI_COMM_WORLD, &size);

    int array[4] = {10, 20, 30, 40};

    int elementsPerProcess = 4 / size;

    int start = rank * elementsPerProcess;
    int end = start + elementsPerProcess;

    int localSum = 0;

    // Calculate partial sum
    for (int i = start; i < end; i++) {
        localSum += array[i];
    }

    // Display intermediate result
    cout << "Process "
         << rank
         << " partial sum = "
         << localSum
         << endl;

    int globalSum = 0;

    // Reduce all partial sums
    MPI_Reduce(
        &localSum,
        &globalSum,
        1,
        MPI_INT,
        MPI_SUM,
        0,
        MPI_COMM_WORLD
    );

    // Root process displays final sum
    if (rank == 0) {
        cout << "Final Sum = "
             << globalSum
             << endl;
    }

    // Finalize MPI
    MPI_Finalize();

    return 0;
}