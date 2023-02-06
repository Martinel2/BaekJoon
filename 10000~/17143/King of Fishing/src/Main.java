import java.io.*;
import java.util.*;


//17143 낚시왕
public class Main {
	
	
	static class shark{
		private int r,c;
		private int s,d;
		
		shark(int r, int c, int s, int d)
		{
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
		}
		
	}
	
	static int revdir(int dir) {
		if(dir == 1)
			return 2;
		else if(dir == 2)
			return 1;
		else if(dir == 3)
			return 4;
		else
			return 3;
	}
	
	public static void main(String[] args)throws IOException{
		int R,C,M;
		int[] dx = {0,-1,1,0,0};
		int[] dy = {0,0,0,1,-1};
 		HashMap<Integer, shark> hm = new HashMap<>();
 		int[][] arr;
 		int cnt = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		//1.변수 초기화 및 배열 생성
		st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());//세로
		C = Integer.parseInt(st.nextToken());//가로
		M = Integer.parseInt(st.nextToken());//상어 수
		arr = new int[R][C];
		boolean[][] almove = new boolean[R][C];
		for(int i = 0; i<M; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken())-1;//세로
			int c = Integer.parseInt(st.nextToken())-1;//가로
			int s = Integer.parseInt(st.nextToken());//속력 더이상 갈수없으면 반대방향으로 이동
			int d = Integer.parseInt(st.nextToken());//방향 1:up 2:down 3:right 4:left
			int z = Integer.parseInt(st.nextToken());//크기 만났을때 크면 작은놈 잡아먹기
			if (d <= 2) s %= (R - 1) * 2;
			else s %= (C - 1) * 2;
			arr[r][c] = z;
			hm.put(z, new shark(r,c,s,d));
		}
		//1.1초마다 한칸씩 이동
		for(int i = 0; i<C; i++) {
			//2. 열에있는 상어중 가장 땅과 가까운 상어 잡기
			for(int j = 0; j<R; j++)
			{
				int z = arr[j][i];
				if(z != 0){
					//System.out.println("get  "+z);
					cnt += z;
					hm.remove(z);
					break;
				}
			}
			//3.상어 이동하기
			//System.out.println(hm.size());
			for(int k = 0; k<R; k++)
				Arrays.fill(almove[k], false);
			Queue<Integer> q = new LinkedList<>();
			for(Integer size : hm.keySet()) {
				q.add(size);
			}
			while(!q.isEmpty()) {
				int size = q.poll();
				shark cur = hm.get(size);
				int r = cur.r;
				int c = cur.c;
				int s = cur.s;
				int dir = cur.d;
				if(size == arr[r][c])
					arr[r][c] = 0;
				for(int m = 0; m < s; m++) {
					r += dx[dir];
					c += dy[dir];
					if(0 > r || r > R-1 ||  0 > c || c > C-1) {
						dir = revdir(dir);
						r += dx[dir]*2;
						c += dy[dir]*2;
					}
						
				}
				hm.replace(size, new shark(r,c,s,dir));
				//같은 자리에 두마리의 상어가 존재 
				if(almove[r][c]) {
					//System.out.println("bite");
					int z = arr[r][c];
					//이동을 완료한 상어의 크기 < 지금 움직인 상어의 크기
					if(z < size) {
						hm.remove(z);
						arr[r][c] = size;
					}
					else {
						hm.remove(size);
					}
				}
				else{
					almove[r][c] = true;
					arr[r][c] = size;
				}
			}
			//System.out.println("after   "+hm.size());
		}
		System.out.println(cnt);
	}
}

/*
4 5 4
4 1 3 3 8
1 3 5 2 9
2 4 8 4 1
4 5 0 1 4
*/