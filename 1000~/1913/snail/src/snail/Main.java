package snail;
import java.util.*;
 
public class Main {
    static int arr[][];
    static int N = 0, M = 0;
    static StringBuilder sb = new StringBuilder();
 
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
 
        arr = new int[N][N];
        int dir = 1, row = -1, col = 0;
        int x = 0, y = 0;
        int n = N * N;
        int origin_n = N;
 
        while (N > 0) {
            for (int i = 0; i < N; i++) {
                row += dir;
                arr[row][col] = n;
                if (chk_num(row, col)) {
                    x = row + 1;
                    y = col + 1;
                }
                n--;
            }
            N--;
 
            for (int j = 0; j < N; j++) {
                col += dir;
                arr[row][col] = n;
                if (chk_num(row, col)) {
                    x = row + 1;
                    y = col + 1;
                }
                n--;
            }
            dir *= -1;
 
        }
 
        for (int i = 0; i < origin_n; i++) {
            for (int j = 0; j < origin_n; j++) {
                sb.append(arr[i][j] + " ");
            }
            sb.append("\n");
        }
        sb.append(x + " " + y);
        System.out.print(sb);
        sc.close();
    }
 
    private static boolean chk_num(int x, int y) {
        if (arr[x][y] == M) {
            return true;
        }
        return false;
    }
}
