package solved;

import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();		
    st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int Q = Integer.parseInt(st.nextToken());
    
    long[] person = new long[N + 2];
    long sum = 0;
    long max = 0;
    for (int q = 0; q < Q; q++) {
        st = new StringTokenizer(br.readLine());
        int order = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        if (order == 1) {
            person[y] += x;
            if (y != N + 1) {
                sum += x;
                max = Math.max(max, person[y]);
            }
        } else {
            long jung = person[N + 1] + x;
            long tmp = (sum + y) / N;
            if ((sum + y) % N != 0) {
                tmp += 1;
            }
            if (jung <= max) {
                sb.append("NO").append("\n");
            } else if (jung <= tmp) {
                sb.append("NO").append("\n");
            } else {
                sb.append("YES").append("\n");
            }
        }
    }
    System.out.print(sb);
  }
}