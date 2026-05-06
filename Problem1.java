import java.util.HashSet;
import java.util.Scanner;

public class Problem1 {

    public static int maxCyclicSum(String s) {
        int n = s.length();
        // Duplicate string for cyclic handling
        String doubled = s + s;

        HashSet<Character> set = new HashSet<>();

        int left = 0;
        int currentSum = 0;
        int maxSum = 0;
        for (int right = 0; right < doubled.length(); right++) {
            char currentChar = doubled.charAt(right);
            // Remove characters until duplicate is removed
            while (set.contains(currentChar)) {
                char leftChar = doubled.charAt(left);
                set.remove(leftChar);
                currentSum -= (leftChar - 'a' + 1);
                left++;
            }
            
            // Add current character
            set.add(currentChar);
            currentSum += (currentChar - 'a' + 1);
            // Window size should not exceed original string length
            while ((right - left + 1) > n) {
                char leftChar = doubled.charAt(left);
                set.remove(leftChar);
                currentSum -= (leftChar - 'a' + 1);
                left++;
            }
            // Update maximum sum
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(maxCyclicSum(s));
        sc.close();
    }
}
