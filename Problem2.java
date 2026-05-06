import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        int K = sc.nextInt();

        // Step 1: Check remainder condition
        int rem = A[0] % K;
        for (int i = 1; i < N; i++) {
            if (A[i] % K != rem) {
                System.out.println(-1);
                return;
            }
        }

        // Step 2: Sort array
        Arrays.sort(A);

        // Step 3: Find median
        int median = A[N / 2];

        // Step 4: Calculate total operations
        long totalSteps = 0;
        for (int i = 0; i < N; i++) {
            totalSteps += Math.abs(A[i] - median) / K;
        }

        // Step 5: Print result
        System.out.println(totalSteps);
    }
}
