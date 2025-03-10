package solved;

import java.util.*;
import java.io.*;

public class Main {
	
	static int[] degree;
	static ArrayList<Integer>[] arr;
	static int[] ans;
	static int n;
	
	/*
	static int find(int x) {
		if(union[x] == x) return x;
		else return union[x] = find(union[x]);
	}
	
	static void union(int x, int y) {
		int a = find(x);
		int b = find(y);
		
		union[b] = a;
	}
	*/
	
	static void topolSort() {
		Queue<Integer> q = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();
		for(int i=1; i<=n; i++) {
			if(degree[i] == 0) q.add(i);
		}
		
		int cnt = 1;
		for(int i=1; i<=n; i++) {
			if(q.isEmpty() && q2.isEmpty()) return;
			
			if(i % 2 != 0) {
				while(!q.isEmpty()) {
					int x = q.poll();
					ans[x] = cnt;
					for(int y : arr[x]) {
						degree[y]--;
						if(degree[y] == 0) q2.add(y);
					}
				}
			}
			else {
				while(!q2.isEmpty()) {
					int x = q2.poll();
					ans[x] = cnt;
					for(int y : arr[x]) {
						degree[y]--;
						if(degree[y] == 0) q.add(y);
					}
				}
			}
			cnt++;
		}
	}
	
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        //트리
        //1학기에 루트 
        //2학기에 그의 자식
        //3학기에 그의 자식의 자식
        
        st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        degree = new int[n+1];
        ans = new int[n+1];
        arr = new ArrayList[n+1];
        
        for(int i=1; i<=n; i++) {
        	arr[i] = new ArrayList<>();
        }
        
        for(int i=0; i<m; i++) {
        	st = new StringTokenizer(br.readLine());
        	int pre = Integer.parseInt(st.nextToken());
        	int su = Integer.parseInt(st.nextToken());
        	
        	arr[pre].add(su);
        	degree[su]++;
        	//union(pre,su);
        }
        
        topolSort();
        
        for(int i = 1; i<=n; i++) {
        	sb.append(ans[i] + " ");
        }
        
        System.out.println(sb);
    }
}