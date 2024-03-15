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
	
		//���� �� �ִ� ���� ������ ���� ��ġ�� ���� ������ ���濡 ������ �ִ밪
		//������ ������������ �����Ͽ� �ڿ� ������ ���浵 ���� ������ ���� �� �ֵ����ϱ�
		//���濡 ���� �� �ִ� ������ �߷����ٸ� �� ������ �� ���� ��ġ�� ���� ������ ������ �ȴ�.
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