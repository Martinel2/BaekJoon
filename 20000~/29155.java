package solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        // 입력
        int n = Integer.parseInt(br.readLine());
        int[] p = new int[6];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= 5; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }

     // 각 난이도별로 문제를 푸는 데 걸린 시간 저장
        ArrayList<Integer>[] t = new ArrayList[6];
        for (int i = 1; i <= 5; i++) {
            t[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            t[x].add(y);
        }

        // 난이도별 오름차순 정렬
        for (int i = 1; i <= 5; i++) {
            Collections.sort(t[i]);
        }

        // 결과 변수
        int ans = 0;
        int cnt = 0;

        // 문제 풀이 로직
        for (int i = 1; i <= 5; i++) {
            cnt++;
            for (int j = 0; j < p[i]; j++) {
                if (j == 0) { // 현재 난이도의 첫 번째 문제인 경우
                    ans += t[i].get(j); // 문제를 푸는 데 걸리는 시간 추가
                    if (cnt != 1) { // 난이도가 1이 아닌 경우
                        ans += 60; // 휴식시간 60분 추가
                    }
                } else { // 첫 번째 문제가 아닌 경우
                    ans += 2 * t[i].get(j) - t[i].get(j - 1); // 다음 문제를 푸는 데 걸리는 시간 + 휴식시간 추가
                }
            }
        }

        // 결과 출력
        System.out.println(ans);
    }
}