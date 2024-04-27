package solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int N;
    static int[] arr;
    static boolean[] visited;
    static boolean[] cycle;
    static Queue<Integer> result = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        visited = new boolean[N + 1];
        cycle = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= N; i++) {

            if(!visited[i]) {
                Queue<Integer> q = new LinkedList<>();

                q.add(i);

                int number = arr[i];

                while(!visited[number]) {
                    q.add(number);
                    visited[number] = true;
                    number = arr[number];
                }

                if (q.contains(number)) {
                    while(q.peek() != number) {
                        q.poll();
                    }

                    while (!q.isEmpty()) {
                        cycle[q.poll()] = true;
                    }

                }
             }
        }

        for (int i = 1; i <= N; i++) {
            if(cycle[i]){
                result.offer(i);
            }
        }

        System.out.println(result.size());

        while (!result.isEmpty()) {
            System.out.println(result.poll());
        }
    }
}