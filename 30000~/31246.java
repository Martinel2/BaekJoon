package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> hm = new HashMap<>();

        int baseCnt = 0;
        int maxDiff = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int diff = b - a;
            if (diff <= 0) {
                baseCnt++;
            } else {
                hm.put(diff, hm.getOrDefault(diff, 0) + 1);
                maxDiff = Math.max(maxDiff, diff);
            }
        }

        int left = 0;
        int right = maxDiff;  // 안전하게 넉넉하게 잡기
        int answer = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            int cnt = baseCnt;
            for (int key : hm.keySet()) {
                if (key <= mid) {
                    cnt += hm.get(key);
                }
            }

            if (cnt >= k) {
                answer = mid;
                right = mid - 1; // 더 작은 x 찾기
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }
}
