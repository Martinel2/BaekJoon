package solved;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine()); // Number of test cases

        for (int t = 0; t < T; t++) {
            // Read inputs for each test case
            int B = sc.nextInt();
            int X = sc.nextInt();
            int Y = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            // Print the result of nimSum
            System.out.println(nimSum(B, X, Y));
        }

        sc.close();
    }
    
    // Converts a number N from base 10 to base B.
    static List<Integer> change(int N, int B) {
        List<Integer> res = new ArrayList<>();
        while (N > 0) {
            res.add(N % B);
            N /= B;
        }
        return res;
    }

    // Calculates the Nim Sum of two numbers X and Y in base B.
    static int nimSum(int B, int X, int Y) {
        // Ensure X is always longer than or equal to Y for base B representation
        if (X < Y) {
            int temp = X;
            X = Y;
            Y = temp;
        }

        // Convert X and Y to base B
        List<Integer> XbaseB = change(X, B);
        List<Integer> YbaseB = change(Y, B);

        // Add each corresponding digit with modulo B
        for (int i = 0; i < YbaseB.size(); i++) {
            XbaseB.set(i, (XbaseB.get(i) + YbaseB.get(i)) % B);
        }

        // Convert the result back to base 10
        int result = 0, b = 1;
        for (int digit : XbaseB) {
            result += digit * b;
            b *= B;
        }

        return result;
    }
}
