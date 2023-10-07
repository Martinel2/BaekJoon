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
            arr[i][0] = Integer.parseInt(st.nextToken()); // ��ȣ�� ��ġ
            arr[i][1] = Integer.parseInt(st.nextToken()); // ������ ���ӽð�
            arr[i][2] = Integer.parseInt(st.nextToken()); // �ʷϺ� ���ӽð�
        }

        int current = 0; // ���� ��ġ
        int time = 0;

        while (true) {
            if (current == L) {
                break;
            }

            for (int i = 0; i < N; i++) {
                if (current == arr[i][0]) { // ������ġ�� ��ȣ���� �ִ� ���

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

    // ���� �ǳ� �� �ִ��� ������ �˷��ִ� �Լ�
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