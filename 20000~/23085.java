package solved;

import java.util.*;

public class Main {
    static int[] visited = new int[3001];
    static int n, m;
    static String s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        s = scanner.next();

        int head = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'H') {
                head++;
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { head, 0 });
        visited[head] = 1;

        while (!queue.isEmpty()) {
            int[] front = queue.poll();
            int h = front[0];
            int cnt = front[1];
            int t = n - h;

            if (t == n) {
                System.out.println(cnt);
                return;
            }

            // 'H'인 동전을 뒤집을 개수
            for (int i = 1; i <= m; i++) {
                if (i <= h && m - i <= t) {
                    int newHead = h - 2 * i + m;
                    if (newHead >= 0 && newHead <= 3000 && visited[newHead] == 0) {
                        visited[newHead] = 1;
                        queue.add(new int[] { newHead, cnt + 1 });
                    }
                }
            }
        }

        System.out.println(-1);
    }
}
