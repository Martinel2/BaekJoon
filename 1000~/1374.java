package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class L{
        int str;
        int end;
        int idx;

        L(int idx, int str, int end) {
            this.idx = idx;
            this.str = str;
            this.end = end;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<L> pq = new PriorityQueue<>((a, b) -> {
            if (a.str == b.str) return a.end - b.end;
            return a.str - b.str;
        });

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int str = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            pq.add(new L(idx, str, end));
        }

        PriorityQueue<Integer> room = new PriorityQueue<>();
        room.add(pq.poll().end);
        int ans = 1;

        while (!pq.isEmpty()) {
            if (room.peek() <= pq.peek().str) room.poll();
            else ans++;
            room.add(pq.poll().end);
        }

        System.out.println(ans);
    }
}
