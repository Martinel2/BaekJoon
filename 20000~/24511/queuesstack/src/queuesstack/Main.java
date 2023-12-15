package queuesstack;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =
                new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        Deque<Integer> deque = new ArrayDeque<>();

        // arr[i][0] = 0�̸� ť, 1�̸� ����
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // ���ÿ� ���ؼ� �Ű澵 �ʿ䰡 �����Ƿ� ť �ڷᱸ���� �͸� ����
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (arr[i] == 0)
                deque.addLast(num);
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            deque.addFirst(Integer.parseInt(st.nextToken()));
            bw.write(deque.pollLast()+" ");
        }
        bw.flush();
    }
}