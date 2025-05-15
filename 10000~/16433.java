package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int r=Integer.parseInt(st.nextToken())-1;
		int c=Integer.parseInt(st.nextToken())-1;
		char map[][]=new char[n][n];
		for(int y=0;y<n;y++) Arrays.fill(map[y], '.');
		map[r][c]='v';
		int dy[]= {-1,-1,1,1};
		int dx[]= {1,-1,1,-1};
		Queue<int[]> q=new LinkedList<int[]>();
		q.add(new int[] {r,c});
		while(!q.isEmpty()) {
			int[] p=q.poll();
			for(int i=0;i<4;i++) {
				int ny=p[0]+dy[i];
				int nx=p[1]+dx[i];
				if(ny>=0&&nx>=0&&ny<n&&nx<n&&map[ny][nx]=='.') {
					map[ny][nx]='v';
					q.add(new int[] {ny,nx});
				}
			}
		}
		for(int y=0;y<n;y++) {
			for(int x=0;x<n;x++) {
				System.out.print(map[y][x]);
			}
			System.out.println();
		}
	}
}