import java.util.Arrays;
import java.util.Scanner;
 
public class Main {
 
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int K = sc.nextInt();
            int[] arr = new int[K + 1];
            int[] sum = new int[K + 1];
            int[][] dp = new int[502][502];
            int[][] kk = new int[502][502]; // Knuth ����ȭ�� ���� ���� ��ȭ�� ���¸� �����ֱ� ����.
 
            for (int i = 1; i <= K; i++) {
                arr[i] = sc.nextInt();
                sum[i] = sum[i - 1] + arr[i];
            }
 
            for (int i = 1; i <= K; i++) {
                dp[i - 1][i] = 0;
                kk[i - 1][i] = i;
            }
 
            // DP ����ȭ ��� �� �ϳ��� Knuth Optimization�� ����� �ڵ� O(N^2)
            for (int d = 2; d <= K; d++) {
                for (int i = 0; i + d <= K; i++) {
                    int j = i + d;
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = kk[i][j - 1]; k <= kk[i + 1][j]; k++) {
                        int v = dp[i][k] + dp[k][j] + (sum[j] - sum[i]);
                        if (dp[i][j] > v) {
                            dp[i][j] = v;
                            kk[i][j] = k;
                        }
                    }
                }
            }
            sb.append(dp[0][K]).append("\n");
 
            // DP ����ȭ���� �׳� DP�� Ǭ �ڵ�. O(N^3)
            // j���� i������ �ּ� ���. (j < k < i)
//            for (int i = 2; i <= K; i++) {
//                for (int j = i - 1; j > 0; j--) {
//                    dp[j][i] = Integer.MAX_VALUE;
//                    for (int k = j; k <= i; k++) {
//                        dp[j][i] = Math.min(dp[j][i], dp[j][k] + dp[k + 1][i]);
//                    }
//                    dp[j][i] += sum[i] - sum[j - 1]; // �������� ��ü ���� �� �� �����ش�.
//                }
//            }
//            sb.append(dp[1][K]).append("\n");
 
        }
 
        System.out.println(sb.toString());
    }
}