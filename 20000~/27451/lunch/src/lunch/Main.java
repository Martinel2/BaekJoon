package lunch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class location{
		
		int dis;
		String A;
		String B;
		String C;
		int a;
		int b;
		int c;
		
		location(int a, int b, int c, int dis){
			this.a = a;
			this.b = b;
			this.c = c;
			this.dis = dis;
		}
		/*
		int A;
		int B;
		int C;
		int dis = 0;
		
		location(int A, int B, int C, int dis){
			this.A = A;
			this.B = B;
			this.C = C;
			this.dis = dis;
		}
		*/
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N,M;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());//식당의 갯수
		M = Integer.parseInt(st.nextToken());//도로의 개수
		
		boolean[][][] visit = new boolean[N+1][N+1][N+1];
		int max = N*N*N;
		//처음위치
		int A;
		int B;
		int C;
		st  = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>[] map = new ArrayList[N+1]; // 그래프 저장
		for(int i = 1; i<=N; i++)
			map[i] = new ArrayList();
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			map[start].add(end);
			//System.out.println(start+" "+map[start].get(map[start].size()-1));
		}
		//bfs용 큐 생성
		Queue<location> Q = new LinkedList<>();
		location str = new location(A,B,C,0);
		str.A = Integer.toString(A)+" ";
		str.B = Integer.toString(B)+" ";
		str.C = Integer.toString(C)+" ";
		Q.add(str);
		visit[A][B][C] = true;
		
		boolean clear = false;
		//큐가 비거나 클리어하기전까지 루프
		while(!Q.isEmpty()) {
			location tmp = Q.poll();
			int dis = tmp.dis; //경로의 길이
			int curA = tmp.a, curB = tmp.b, curC = tmp.c; // 현재위치
			
			if(max < dis) { // 경로의 길이가 최대값초과
				Q.clear();
				break;
			}
			else {
				/*
				System.out.println(Q.size());
				System.out.print(tmp.A);
				System.out.println();
				System.out.print(tmp.B);
				System.out.println();
				System.out.print(tmp.C);
				System.out.println("\n");
				*/
				
				//경로 탐색
				if(map[curA].size() > 0 && map[curB].size() > 0 && map[curC].size() > 0) {
					
					for(int i : map[curA]) {
						for(int j : map[curB]) {
							for(int k : map[curC]) {
								//한번도 나오지않은 위치조합일시 큐에 추가
								if(!visit[i][j][k]) {
									visit[i][j][k] = true;
									if(i == j && j == k) { // i = j = k
										clear = true;
										sb.append(i).append(" ").append(dis+1).append("\n");
										sb.append(tmp.A).append(i).append("\n");
										sb.append(tmp.B).append(j).append("\n");
										sb.append(tmp.C).append(k);
										break;
									}
									else {
										location ad = new location(i,j,k,dis+1);
										ad.A = tmp.A+Integer.toString(i)+" ";
										ad.B = tmp.B+Integer.toString(j)+" ";
										ad.C = tmp.C+Integer.toString(k)+" ";
										Q.offer(ad);
									}
								}
								else continue;
							}
							if(clear)
								break;
						}
						if(clear)
							break;
					}	
				}
			}
			if(clear)
				break;
		}
		if(clear) {
			bw.write(sb.toString());
		}
		else 
			bw.write("-1");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
