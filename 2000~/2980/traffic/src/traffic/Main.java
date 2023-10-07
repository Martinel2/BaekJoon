package traffic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); // 신호등 위치
            arr[i][1] = Integer.parseInt(st.nextToken()); // 빨간불 지속시간
            arr[i][2] = Integer.parseInt(st.nextToken()); // 초록불 지속시간
        }

        int current = 0; // 현재 위치
        int time = 0;

        while (true) {
            if (current == L) {
                break;
            }

            for (int i = 0; i < N; i++) {
                if (current == arr[i][0]) { // 현재위치에 신호등이 있는 경우

                    if (check(time, arr[i][1], arr[i][2]) == 0) {
                        break;
                    } else if (check(time, arr[i][1], arr[i][2]) != 0) {
                        time += check(time, arr[i][1], arr[i][2]);
                        break;
                    }
                }
            }

            current++;
            time++;
        }

        System.out.println(time);
    }

    // 지금 건널 수 있는지 없는지 알려주는 함수
    public static int check(int time, int R, int G) {
        if (time > (R + G)) {
            time = time % (R + G);
        }

        if (time <= R) {
            return R - time;
        } else if (time > R) {
            return 0;
        }

        return 0;
    }

}