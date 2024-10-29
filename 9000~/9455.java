package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- != 0)
        {
            String[] s = br.readLine().split(" ");
            int m = Integer.parseInt(s[0]);
            int n = Integer.parseInt(s[1]);

            int count = 0;  // 0의 개수 (이동거리)
            int[][] box = new int[m][n];    // 박스

            // 배열에 입력 받기
            for (int i = 0; i < m; i++) {
                s = br.readLine().split(" ");
                for (int j = 0; j < n; j++)
                    box[i][j] = Integer.parseInt(s[j]);
            }

            // 이동거리 계산
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++)
                {
                    // 박스가 놓여있다면?
                    if (box[j][i] == 1)
                    {
                        // 현재위치 아래 칸부터 끝까지 0 개수 세기 (이동거리)
                        for (int k = j+1; k < m; k++) {
                            if (box[k][i] == 0)
                                count++;
                        }
                    }
                }
            }
            System.out.println(count);
        }
    }
}    