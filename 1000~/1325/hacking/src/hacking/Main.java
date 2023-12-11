package hacking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] A; //��������Ʈ
	static boolean visited[]; //�湮 üũ
	static int[] result; //�湮 Ƚ�� üũ 
	
	public static void DFS(int s) {
        visited[s] = true;
        
        if(A[s].size() == 0)
			return;
        
        for(int e : A[s]) {
        	if(result[s] < A[s].size())
        		result[s]++;
        	if(!visited[e]) {
        		System.out.println("dfs: "+e);
        		DFS(e);
        	}
        	result[s] += result[e];
        }
        
    }
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int max = 0; //�湮 Ƚ�� �ִ�
		
		A = new ArrayList[N+1];
		result = new int[N+1];
		for(int i=1; i<=N; i++) {
			A[i] = new ArrayList<Integer>(); 
		}
		
		//�ŷ� ���� ����
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			A[b].add(a);
		}
		
		visited = new boolean[N+1];
		
		//��� ��� dfs, �湮 Ƚ�� ����
		for(int i=1; i<=N; i++) {
			if(A[i].size() == 0)
				continue;
			DFS(i);
		}
				
		//�湮 Ƚ�� �ִ� max�� ����
		for(int i=1; i<=N; i++) {
			max = Math.max(max, result[i]);
			System.out.println(i+": "+result[i]);
		}
				
		for(int i=1; i<=N; i++) {
			//max�� result[i]�� ���ٸ� ���� ���� �ŷڹ޴� ���
			if(result[i]==max)
				sb.append(i+" ");
		}			
		
		System.out.print(sb);
	}
}