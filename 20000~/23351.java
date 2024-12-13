package solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int day = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i<n; i++) {
        	pq.add(k);
        }
        
        while(pq.peek() > day) {
        	for(int i = 0; i<a; i++) {
        		int num = pq.poll()+b;
        		pq.add(num);
        		//System.out.println(num);
        	}
        	day++;
        }
        bw.write(String.valueOf(day));
        bw.flush();
    }
}