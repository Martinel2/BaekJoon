package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static final int INF = 10_0000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        boolean[] chk = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            int idx = Integer.parseInt(br.readLine());
            chk[idx] = true;
        }
        //
        int dis = 2;
        int cnt = 1; // 가속만 했을 때 최대 점프 거리
        while (dis < N) {
            cnt++;
            dis += cnt;
        }
        int[][] dp = new int[N + 1][cnt + 1];
        for (int i = 0; i <= N; i++)
            Arrays.fill(dp[i], INF);
        dp[1][0] = 0;
        for (int i = 2; i <= N; i++) {
            if(chk[i]) continue;
            for (int j = 1; j <= cnt; j++) {
                if (i - j < 0) continue;
                dp[i][j] = Math.min(dp[i][j], dp[i - j][j - 1] + 1);
                dp[i][j] = Math.min(dp[i][j], dp[i - j][j] + 1);
                if (j < cnt) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - j][j + 1] + 1);
                }
            }
        }
        int ans = INF;
        for (int i = 1; i <= cnt; i++)
            ans = Math.min(ans, dp[N][i]);
        if (ans == INF)
            System.out.println(-1);
        else
            System.out.println(ans);
    }
}
