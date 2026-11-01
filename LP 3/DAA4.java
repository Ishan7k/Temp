import java.util.Scanner;

public class DAA4 {
    static int[] board = new int[8]; // Stores column position for each row

    // Check if placing at (row, col) conflicts with any previously placed queen
    static boolean isSafe(int row, int col) {
        for (int i = 0; i < row; i++) {
            // Same column OR on the same diagonal
            if (board[i] == col || Math.abs(board[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }

    static boolean solve(int row, int fixedRow) {
        if (row == 8) return true; // All 8 rows filled successfully

        // Skip the row where the user placed the first queen
        if (row == fixedRow) return solve(row + 1, fixedRow);

        for (int col = 0; col < 8; col++) {
            if (isSafe(row, col)) {
                board[row] = col;                      // 1. Place Queen
                if (solve(row + 1, fixedRow)) return true; // 2. Recurse next row
                // 3. Backtrack (gets replaced in the next loop turn)
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter row & col for 1st Queen (e.g. 0 0): ");
        int r = sc.nextInt(), c = sc.nextInt();
        board[r] = c; // Place 1st Queen

        solve(0, r);

        System.out.println("\nFinal Board:");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i] == j ? "Q " : ". ");
            }
            System.out.println();
        }
        sc.close();
    }
}