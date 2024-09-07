package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class Main { 
    public static void solution(int n) {
        // 에라토스테네스의 체 - 소수 구하기
        int[] arr = new int[n + 1];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (arr[i] == 0) {
                list.add(i);
                for (int j = i; j <= n; j += i) {
                    arr[j]++;
                }
            }
        }

        for (int i = 0; i < list.size(); i++) {
            int tmp = list.get(i);
            HashSet<Integer> set = new HashSet<>();
            while (set.add(tmp)) {
                int ssum = 0;

                // 계속 나누기
                while (tmp > 0) {
                    int remainer = tmp % 10;
                    ssum += remainer * remainer;
                    tmp /= 10;
                }

                if (ssum == 1) {
                    System.out.println(list.get(i));
                } else {
                    tmp = ssum;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();
        solution(n);
    }
}
//출처:https://velog.io/@ljinho1001/%EB%B0%B1%EC%A4%80-%EC%9E%90%EB%B0%94-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-9421