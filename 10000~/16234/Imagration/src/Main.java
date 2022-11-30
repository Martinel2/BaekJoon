import java.util.*;
import java.io.*;

//16234 인구 이동
public class Main {

	static class mat {
		int x;
		int y;
		mat(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int dx[] = {0,1,0,-1};
		int dy[] = {1,0,-1,0};
		int[][] arr = new int[N][N];
		Stack<mat> stack = new Stack<>();
		Queue<mat> q = new LinkedList<>();
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		int cnt = 0;
		while(true)
		{
			boolean[][] visit = new boolean[N][N];
			int[] S = new int[N*N];
			int[] In = new int[N*N];
			int idx = 0;
			boolean flag = false;
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					if(!visit[i][j]) {
						q.add(new mat(i,j));
						stack.add(new mat(i,j));
						visit[i][j] = true;
					}
					else
						continue;
					int total = 0;
					int c = 0;
					while(!q.isEmpty()) {
						mat m = q.poll();
						int num1 = arr[m.x][m.y];
						total += num1;
						c++;
						for(int k = 0; k<4; k++) {
							int nx = dx[k]+m.x;
							int ny = dy[k]+m.y;
							if( (0<= nx && nx < N) && (0<= ny && ny < N) && !visit[nx][ny]) {
								int sum = Math.abs(num1-arr[nx][ny]);
								if(L<=sum && sum<=R) {
									q.add(new mat(nx,ny));
									stack.add(new mat(nx,ny));
									visit[nx][ny] = true;
									flag = true;
								}
							}
						}
					}
					S[idx] = total;
					In[idx] = c;
					idx++;
					stack.add(new mat(-1,-1));//여기까지 한 연합
				}
			}
			if(!flag)
				break;
			else {
				cnt++;
				stack.pop();
				for(int k = idx-1; k>=0; k--) {
					mat m = stack.pop();
					int change = S[k]/In[k];
					while(m.x != -1 && m.y != -1) {
						arr[m.x][m.y] = change;
						if(!stack.isEmpty())
							m =stack.pop();
						else
							break;
					}
				}
			}
		}
		System.out.println(cnt);
	}
}