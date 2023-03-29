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
		N = Integer.parseInt(st.nextToken());//�Ĵ��� ����
		M = Integer.parseInt(st.nextToken());//������ ����
		
		boolean[][][] visit = new boolean[N+1][N+1][N+1];
		int max = N*N*N;
		//ó����ġ
		int A;
		int B;
		int C;
		st  = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>[] map = new ArrayList[N+1]; // �׷��� ����
		for(int i = 1; i<=N; i++)
			map[i] = new ArrayList();
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			map[start].add(end);
			//System.out.println(start+" "+map[start].get(map[start].size()-1));
		}
		//bfs�� ť ����
		Queue<location> Q = new LinkedList<>();
		location str = new location(A,B,C,0);
		str.A = Integer.toString(A)+" ";
		str.B = Integer.toString(B)+" ";
		str.C = Integer.toString(C)+" ";
		Q.add(str);
		visit[A][B][C] = true;
		
		boolean clear = false;
		//ť�� ��ų� Ŭ�����ϱ������� ����
		while(!Q.isEmpty()) {
			location tmp = Q.poll();
			int dis = tmp.dis; //����� ����
			int curA = tmp.a, curB = tmp.b, curC = tmp.c; // ������ġ
			
			if(max < dis) { // ����� ���̰� �ִ밪�ʰ�
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
				
				//��� Ž��
				if(map[curA].size() > 0 && map[curB].size() > 0 && map[curC].size() > 0) {
					
					for(int i : map[curA]) {
						for(int j : map[curB]) {
							for(int k : map[curC]) {
								//�ѹ��� ���������� ��ġ�����Ͻ� ť�� �߰�
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
