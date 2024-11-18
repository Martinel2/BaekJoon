package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int n = Integer.parseInt(st.nextToken());
	    int m = Integer.parseInt(st.nextToken());
	    int result = -1;
	    int[][] arr = new int[n][m];
	    
	    for (int i = 0; i < n; i++) {
            String s1 = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(s1.charAt(j)));
            }
        }
	    
	    //행과 열의 인덱스가 등차수열을 이뤄야 함. -> 한 방향으로 같은 크기만큼만 갈 수 있음
	    //증가하는 수를 브루스포스로 계산
	    for (int i = 0; i < n; ++i)
            for (int j = 0; j < m; ++j)
                for (int mi = -n; mi < n; ++mi)
                    for (int mj = -m; mj < m; ++mj) {
                        if (mi == 0 && mj == 0) { // 둘다 움직이지 않을 때
                            continue;
                        }

                        int t = 0;
                        int newI = i;
                        int newJ = j;
                        while (newI >= 0 && newI < n && newJ >= 0 && newJ < m) // 위치가 0>= && <범위를 설정해줍니다.
                        {
                            t = 10 * t + arr[newI][newJ]; // 기존에 담긴 숫자가 있다면 *10해주고 더해줍니다.
                            if (Math.abs(Math.sqrt(t) - (int) Math.sqrt(t)) < 1e-10) { // 완전 제곱수인지 판별합니다.
                                result = Math.max(result, t);
                            }
                            newI += mi;
                            newJ += mj;
                        }

                    }
        System.out.println(result);
	}
}