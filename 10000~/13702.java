package solved;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N];
        int max = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            max = Math.max(max, arr[i]);
        }

        long low = 1, high = max;

        while (low <= high) {
            long mid = (low + high) / 2;
            int cnt = 0;

            for(int i = 0; i < N; i++) {
                cnt += arr[i] / mid;
            }
            // 부을 양이 mid일 때, 모두에게 막걸리를 줄 수 있으면
            // 더 많이 부워도 k명에게 주고 남는지
            if (cnt >= K) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        System.out.println(high);
    }
}