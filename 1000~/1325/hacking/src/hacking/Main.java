package hacking;

import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer>[] A; //��������Ʈ
	static boolean visited[]; //�湮 üũ
	static int[] result; //�湮 Ƚ�� üũ 
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();
		
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
			A[a].add(b);
		}
		
		
		//��� ��� bfs, �湮 Ƚ�� ����
		for(int i=1; i<=N; i++) {
			visited = new boolean[N+1];
			bfs(i);
		}
		
		//�湮 Ƚ�� �ִ� max�� ����
		for(int i=1; i<=N; i++) {
			max = Math.max(max, result[i]);
		}
		
		for(int i=1; i<=N; i++) {
			//max�� result[i]�� ���ٸ� ���� ���� �ŷڹ޴� ���
			if(result[i]==max)
				System.out.print(i+" ");
		}
		
	}
	
	private static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		visited[start]=true;
		queue.add(start); //���۳�� ť�� ����
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			
			//now�� ����� ��� Ž��
			for(int n: A[now]) {
				//�湮�� �� ���ٸ�
				if(!visited[n]) {
					queue.add(n);
					visited[n]=true;
					//�湮Ƚ�� result����
					result[n]++;
				}
			}
		}
	}
}