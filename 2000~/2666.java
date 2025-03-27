package solved;

import java.io.*;
import java.util.*;
import static java.lang.Integer.parseInt;

public class Main{
    static int n, m;
    static int[] arr;
    static int[][][] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int left = parseInt(st.nextToken()); // 왼쪽에 있는 포인터
        int right = parseInt(st.nextToken()); // 오른쪽에 있는 포인터
        
        m = parseInt(br.readLine());
        // dp[m][n][n] => m번째 움직어야 하는 방을 움직일 때, left와 right의 움직임 최소 값
        dp = new int[m][n + 1][n + 1]; // m은 이동 해야하는 개수, n + 1 : left 이동, n + 1: right 이동
        arr = new int[m]; // 움직어야 하는 방 저장
        for (int i = 0; i < m; i++) arr[i] = parseInt(br.readLine());
        
        for (int i = 0; i < m; i++) {
            for (int j = 1; j <= n; j++) // (n은 1부터)
                Arrays.fill(dp[i][j], -1); // 초기 값은 -1로 초기화
        }
        
        System.out.println(dfs(0, left, right));
    }
    
    static int dfs(int idx, int left, int right) {
        if (idx == m) return 0; // 움직여야 하는 모든 움직임을 마친 경우
        
        if (dp[idx][left][right] == -1) { // 아직 dp가 업데이트 되지 않았음
            dp[idx][left][right] = Math.min(
                Math.abs(left - arr[idx]) + dfs(idx + 1, arr[idx], right), // left가 움직인 값 + 재귀로 다음 항, left가 움직여진 위치, right
                Math.abs(right - arr[idx]) + dfs(idx + 1, left, arr[idx])
            );
        }
        return dp[idx][left][right];
    }
}