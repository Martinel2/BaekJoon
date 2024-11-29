import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // Loop through odd numbers from 1 to 2*N-1
        for (int i = 1; i <= 2 * N - 1; i += 2) {
            System.out.print(i + " ");
        }
    }
}
