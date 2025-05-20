package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] price = new int[3]; // 주차요금 저장할 배열

        for(int i = 0; i < 3; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        int[] time = new int[101]; // 주어지는 시간 1~100
        int max = Integer.MIN_VALUE;

        int from = 0; // 주차장 도착 시간
        int to = 0; // 주차장 떠난 시간

        for(int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            max = Math.max(Math.max(max, from), to); // 떠난 시간 최댓값 구하기
            for(int j = from; j < to; j++) {
                time[j]++;
            }
        }

        int result = 0;

        // 1부터 떠난 시간까지 시간마다 몇대의 차량이 주차되어있었는지 확인
        for(int i = 1; i <= max; i++) {
            if(time[i] > 0) {
                switch(time[i]) {
                    case 1:
                        result += price[0];
                        break;

                    case 2:
                        result += 2 * price[1];
                        break;

                    case 3:
                        result += 3 * price[2];
                        break;
                }
            }
        }
        System.out.println(result);
    }
}