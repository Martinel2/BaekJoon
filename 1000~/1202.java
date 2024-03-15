package solved;

import java.io.*;
import java.util.*;

public class Main{
	
	static class Jewel implements Comparable<Jewel>{
		int W;
		int V;
		
		Jewel(int W, int V){
			this.W=W;
			this.V=V;
		}
		
		@Override
		public int compareTo(Jewel o) {
			if(this.W == o.W) {
				return o.V - this.V;
			}
			else
				return this.W - o.W;
		}

	}
	
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		Jewel[] jw = new Jewel[n];
		int[] bag = new int[k];
		
		
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			jw[i] = new Jewel(w,v);
		}
		
		for(int i = 0; i<k; i++) {
			int w = Integer.parseInt(br.readLine());
			
			bag[i] = w;
		}
		
		Arrays.sort(jw);
		Arrays.sort(bag);
	
		//넣을 수 있는 무게 내에서 가장 가치가 높은 보석을 가방에 넣으면 최대값
		//가방을 오름차순으로 정렬하여 뒤에 나오는 가방도 앞의 보석을 넣을 수 있도록하기
		//가방에 넣을 수 있는 보석이 추려졌다면 그 보석들 중 가장 가치가 높은 보석을 넣으면 된다.
		int idx = 0;
		long ans = 0;
		for(int i = 0; i<k; i++) {
			while(idx < n && bag[i] >= jw[idx].W) {
				//System.out.println("weight: "+bag[i]+" jewel: "+jw[idx].V);
				pq.add(jw[idx++].V);
			}
			if(!pq.isEmpty()) {
				ans += pq.poll();
			}
		}
		
		System.out.println(ans);
	}
}