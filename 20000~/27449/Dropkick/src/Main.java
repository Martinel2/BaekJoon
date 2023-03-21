import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//27449 한별이 드롭킥!
public class Main {
	
	static class up implements Comparable<up>{
		int x;
		long p;
		
		up(int x, long p){
			this.p = p;
			this.x = x;
		}
		
		@Override
		public int compareTo(up o) {
			return this.x - o.x;
		}
	}
	
	static class han{
		long dis=0;
		long H = 0;
		int left = 0;
		int right = 0;
		long cnt = 0;
		han(long dis, int left, int right, long H, long cnt){
			this.dis = dis;
			this.left = left;
			this.right = right;
			this.H = H;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N;
		long jump;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		jump = Long.parseLong(st.nextToken());
		
		ArrayList<up> L = new ArrayList<>();
		ArrayList<up> R = new ArrayList<>();
		L.add(new up(0,0));//집
		R.add(new up(0,0));//집
		int left = 0;
		int right = 1;
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			long p = Long.parseLong(st.nextToken());
			if(x < 0) {
				L.add(new up(x,p));
			}
			else {
				R.add(new up(x,p));
			}		
		}
		Collections.sort(L,Collections.reverseOrder());//내림차순
		Collections.sort(R);//오름차순
		long ans = 0;//정답
		int Ls = L.size();
		int Rs = R.size();
		Queue<han> Q = new LinkedList<>();
		long[][][]visit = new long[2][Ls][Rs];//현재높이 저장
		Q.add(new han(0,0,0,jump,jump));//집에서부터 시작
		
		while(!Q.isEmpty()) {
			han tmp = Q.poll();
			int i = tmp.left;//왼쪽으로 이동
			int j = tmp.right;//오른쪽으로 이동
			long x = tmp.dis;//현재위치
			long cnt = tmp.cnt;
			long H = tmp.H;
			if(x==0 || (x < 0 && visit[left][i][j]==tmp.H) || (x > 0 && visit[right][i][j]==tmp.H)) {
				if(cnt > ans) {//최대값이라면
					ans = cnt;
				}
				//현재위치에서 왼쪽으로 이동가능하며, 현재높이가 최대라면 이동
				if(i+1<Ls) {
					up Ltmp = L.get(i+1);
					long s = -((long)Ltmp.x - x);//i or j ~ i+1까지의 거리
					if(H > s) {
						if(visit[left][i+1][j] < (H-s)+Ltmp.p) {
							visit[left][i+1][j] = (H-s)+Ltmp.p;
							Q.add(new han((long)Ltmp.x, i+1, j, (H-s)+Ltmp.p, cnt+Ltmp.p));
						}
					}
					
				}
				//현재위치에서 오른쪽으로 이동가능하며, 현재높이가 최대라면 이동
				if(j+1 < Rs) {
					up Rtmp = R.get(j+1);
					long s = (long)Rtmp.x - x;//i or j ~ j+1까지의 거리
					if(H > s) {
						if(visit[right][i][j+1] < (H-s)+Rtmp.p) {
							visit[right][i][j+1] = (H-s)+Rtmp.p;
							Q.add(new han((long)Rtmp.x, i, j+1, (H-s)+Rtmp.p, cnt+Rtmp.p));
						}
					}
				}
			}
		}
		System.out.println(ans);
	}
}
/*
2 3
2 5
-4 7



5 2
1 5
3 7
10 2
9 5
-1 1000000000

*/