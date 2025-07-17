package solved;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n and m
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        // Initialize the graph with size (n+1) x (m+1)
        int[][] graph = new int[n + 1][m + 1];

        // Fill entire graph with -1 initially
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                graph[i][j] = -1;
            }
        }

        // Read col values and set the first column
        int[] col = new int[n];
        for (int i = 0; i < n; i++) {
            col[i] = scanner.nextInt();
            graph[i + 1][0] = col[i];
        }

        // Read row values and set the first row
        int[] row = new int[m];
        for (int j = 0; j < m; j++) {
            row[j] = scanner.nextInt();
            graph[0][j + 1] = row[j];
        }

        // Fill the rest of the graph using XOR logic
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                graph[i][j] = graph[i][j - 1] ^ graph[i - 1][j];
            }
        }

        // Print the value at the bottom-right corner
        System.out.println(graph[n][m]);
    }
}
