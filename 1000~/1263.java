package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{

	static class T implements Comparable<T>{
		int time;
		int suc;
		
		T(int time, int suc){
			this.time=time;
			this.suc=suc;
		}

		@Override
		public int compareTo(T o) {
			return this.suc - o.suc;
		}
	}
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int cha = Integer.MAX_VALUE;
        int total = 0;
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<T> pq = new PriorityQueue<>();
        for(int i = 0; i<n; i++) {
        	st = new StringTokenizer(br.readLine());
        	int time = Integer.parseInt(st.nextToken());
        	int suc = Integer.parseInt(st.nextToken());
        	
        	pq.add(new T(time,suc));
        }
        
        boolean not = false;
        while(!pq.isEmpty()) {
        	T now = pq.poll();
        	total += now.time;
        	if(total > now.suc) {
        		not = true;
        		break;
        	}
        	cha = Math.min(cha,now.suc-total);
        }
        if(not) cha = -1;
        System.out.println(cha);
    }
}