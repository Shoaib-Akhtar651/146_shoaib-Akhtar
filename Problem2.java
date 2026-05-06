import java.util.*;

public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        int K = sc.nextInt();

        int rem = A[0] % K;
        for (int i = 1; i < N; i++) {
            if (A[i] % K != rem) {
                System.out.println(-1);
                return;
            }
        }


        Arrays.sort(A);

        int median = A[N / 2];

        long totalSteps = 0;
        for (int i = 0; i < N; i++) {
            totalSteps += Math.abs(A[i] - median) / K;
        }

        System.out.println(totalSteps);
    }
}
