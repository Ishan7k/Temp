import java.util.Scanner;

public class DAA1 {
    static int recSteps = 0;                    // counts recursive calls

    // Iterative: O(n) time, O(1) space
    static void fibIterative(int n) {
        int steps = 0;
        long a = 0, b = 1;
        steps++;                                // initialization

        System.out.print("Iterative Series: ");
        for (int i = 0; i < n; i++) {
            steps++;                            // loop check
            System.out.print(a + " ");
            long next = a + b;
            a = b;
            b = next;
            steps += 3;                         // 3 assignments
        }
        steps++;                                // final loop check (exit)
        System.out.println("\nIterative Step Count: " + steps);
    }

    // Recursive: O(2^n) time, O(n) space (call stack)
    static long fibRecursive(int n) {
        recSteps++;                             // count every call
        if (n <= 1) return n;                   // base case
        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value of n: ");
        int n = sc.nextInt();

        fibIterative(n);

        System.out.print("Recursive Series: ");
        for (int i = 0; i < n; i++) {
            System.out.print(fibRecursive(i) + " ");
        }
        System.out.println("\nRecursive Step Count (calls): " + recSteps);
        sc.close();
    }
}