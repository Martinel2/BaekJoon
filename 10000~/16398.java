package solved;

import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static int[] parent; // 집합 표시할 배열
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long answer = 0; // 문제 조건에 맞춰 long 타입 선언
		
		N = Integer.parseInt(br.readLine());
		
		// 정보 저장할 리스트
		List<Edge> edges = new ArrayList<>();
		// 입력받은 행렬의 정보를 저장
		for(int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			// 중복된 연결은 제외함
			for(int j = i + 1; j < N; j++) {
				int s = i;
				int e = j;
				int c = Integer.parseInt(input[j]);
				edges.add(new Edge(s, e, c));
			}
		}
		
		// 유지비용 기준으로 오름차순 정렬
		edges.sort(new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return Integer.compare(o1.cost, o2.cost);
			}
		});
		
		// 집합 표시할 배열 초기화
		parent = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		
		// 크루스칼 알고리즘 시작
		for(int i = 0; i < edges.size(); i++) {
			Edge edge = edges.get(i);
			
			if(!isSameParent(edge.start, edge.end)) {
				union(edge.start, edge.end);
				
				answer += edge.cost;
			}
		}
		
		System.out.println(answer);
	}
	
	static int find(int x) {
		if(parent[x] == x) {
			return x;
		}
		
		return parent[x] = find(parent[x]);
	}
	
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x < y) {
			parent[y] = x;
		} else if(x > y) {
			parent[x] = y;
		}
	}
	
	static boolean isSameParent(int x, int y) {
		int a = find(x);
		int b = find(y);
		
		if(a == b) {
			return true;
		}
		return false;
	}
	
	static class Edge {
		int start, end, cost;
		
		public Edge(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
	}

}