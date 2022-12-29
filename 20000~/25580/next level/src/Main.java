import java.io.*;
import java.util.*;


//25580 next level
public class Main {
	//������ ���� ���� �������ְ� �������� dfs+a��� ����
	//ó�� ������ �ʱ�ȭ �Ҷ� ���ĺ������� ������ �̵����� �߰�
	public static int[][] map;//����
	public static boolean[][] visit;//�湮Ȯ��
	public static int[][] shape;//Ư���̵�
	public static boss[] dev;//����
	public static ArrayList<String> algo = new ArrayList<>();//�˰��ִ� �˰���
	public static int N;//����ũ��
	//�� �� �� ��
	public static int[] dx = {1,0,-1,0};  
	public static int[] dy = {0,1,0,-1};
	//���� ���� ��� �»� 
	public static int[] cx = {1,1,-1,-1};
	public static int[] cy = {1,-1,1,-1};
	
	public static class boss{
		int exist=0;
		String need="0";
		String learn="0";
		
		boss(int exist, String need, String learn){
			this.exist = exist;
			this.need = need;
			this.learn = learn;
		}
	}
	
	public static void init(int strx,int stry, int level) {
		for(int i = strx; i<strx+3; i++) {
			for(int j = stry; j<stry+3; j++) {
				if(map[i][j] < level){
					map[i][j] = level;
				}
			}
		}
	}
	// 1->2, 1->3 ���� ������ �Ұ�
	public static void Go_boss(int x, int y, char s) {
		switch(s) {
		case 'A':
			if(shape[x][y+1] == 0)
				shape[x][y+1] = 1;
			if(shape[x+1][y] == 0)
				shape[x+1][y] = 1;
			shape[x+1][y+1] =1;
			if(shape[x+1][y+2] == 0)
				shape[x+1][y+2] = 1;
			if(shape[x+2][y+1] == 0)
				shape[x+2][y+1] = 1;
			break;
		case 'B':
			shape[x+1][y] = 2;
			shape[x+1][y+1] = 2;
			shape[x+1][y+2] = 2;
			break;
		case 'C':
			shape[x][y+1] = 3;
			shape[x+1][y+1] = 3;
			shape[x+2][y+1] = 3;
			break;
		case 'D':
			shape[x][y] = 4;
			shape[x][y+2] = 4;
			shape[x+1][y+1] = 4;
			shape[x+2][y] = 4;
			shape[x+2][y+2] = 4;
			break;
		}
	}
	
	public static boolean flag = false; // ������ ��
	
	public static boolean check(int x, int y) {
		if( ((0<=x && x<=N*2) && (0<=y && y<=N*2)) && !visit[x][y])
			return true;
		else
			return false;
	}
	
	public static void dfs(int x,int y, int cnt, int aespa) {
		if(cnt > 18 || flag)
			return;
		if(x==N*2 && y==N*2) {
			flag = true;
			return;
		}
		else {
			//Ư�� �̵�
			if(shape[x][y] != 0) {
				//A����
				if(shape[x][y] == 1) {
					for(int i = 0; i<4; i++) {
						int nx = x + dx[i];
						int ny = y + dy[i];
						if(check(nx,ny) && (map[nx][ny] <= aespa)) {
							int sh = shape[nx][ny];
							//������ �ܷ̿� ������
							if(nx%2 ==0 || ny%2 == 0) {
								if(0 < sh  &&  sh < 4) {
									visit[nx][ny] = true;
									dfs(nx,ny,cnt+1,aespa);
									visit[nx][ny] = false;
								}
							}
							//
							//����
							else{
								if(sh != 1)
									continue;
								else { 
									int ix = (nx-1)/2, iy = (ny-1)/2;
									int idx = N*ix + iy;
									//������ ����
									if(dev[idx].exist == 0){
										visit[nx][ny] = true;
										dfs(nx,ny,cnt+1,aespa);
										visit[nx][ny] = false;
									}
									// ���� ����
									else { 
										//óġ������ �˰��� ����
										if(algo.contains(dev[idx].need) || "0".equals(dev[idx].need)) {
											String L = dev[idx].learn;
											if("0".equals(L)) {
												visit[nx][ny] = true;
												dfs(nx,ny,cnt+1,aespa+1);
												visit[nx][ny] = false;
											}
											//�˰��� ����
											else {
												algo.add(L);
												visit[nx][ny] = true;
												dfs(nx,ny,cnt+1,aespa+1);
												visit[nx][ny] = false;
												algo.remove(L);
											}
										}		
									}
								 }
							}
							//
						}
					}
				}
				// B����
				else if(shape[x][y] == 2) {
					int i = 1;
					while(i < 4) {
						int nx = x + dx[i];
						int ny = y + dy[i];
						if(check(nx,ny) && (map[nx][ny] <= aespa)) {
							int sh = shape[nx][ny];
							//������
							if(nx%2 == 0 || ny%2 == 0) {
								visit[nx][ny] = true;
								dfs(nx,ny,cnt+1,aespa);
								visit[nx][ny] = false;
							}
							//
							//����
							else{
								if(sh == 1 || sh == 2) {
									int ix = (nx-1)/2, iy = (ny-1)/2;
									int idx = N*ix + iy;
									//������ ����
									if(dev[idx].exist == 0){
										visit[nx][ny] = true;
										dfs(nx,ny,cnt+1,aespa);
										visit[nx][ny] = false;
									}
									// ���� ����
									else { 
										//óġ������ �˰��� ����
										if(algo.contains(dev[idx].need) || "0".equals(dev[idx].need)) {
											String L = dev[idx].learn;
											if("0".equals(L)) {
												visit[nx][ny] = true;
												dfs(nx,ny,cnt+1,aespa+1);
												visit[nx][ny] = false;
											}
											//�˰��� ����
											else {
												algo.add(L);
												visit[nx][ny] = true;
												dfs(nx,ny,cnt+1,aespa+1);
												visit[nx][ny] = false;
												algo.remove(L);
											}
										}		
									}
								}
							}
							//
						}
						i+=2;
					}
				}
				// C����
				else if(shape[x][y] == 3) {
					int i = 0;
					while(i<4) {
						int nx = x + dx[i];
						int ny = y + dy[i];
						if(check(nx,ny) && (map[nx][ny] <= aespa)) {
							int sh = shape[nx][ny];
							//������
							if(nx%2 ==0 || ny%2 == 0) {
								visit[nx][ny] = true;
								dfs(nx,ny,cnt+1,aespa);
								visit[nx][ny] = false;
							}
							//
							//����
							else {
								if(sh == 1 || sh == 3) { 
									int ix = (nx-1)/2, iy = (ny-1)/2;
									int idx = N*ix + iy;
									//������ ����
									if(dev[idx].exist == 0){
										visit[nx][ny] = true;
										dfs(nx,ny,cnt+1,aespa);
										visit[nx][ny] = false;
									}
									// ���� ����
									else { 
										//óġ������ �˰��� ����
										if(algo.contains(dev[idx].need) || "0".equals(dev[idx].need)) {
											String L = dev[idx].learn;
											if("0".equals(L)) {
												visit[nx][ny] = true;
												dfs(nx,ny,cnt+1,aespa+1);
												visit[nx][ny] = false;
											}
											//�˰��� ����
											else {
												algo.add(L);
												visit[nx][ny] = true;
												dfs(nx,ny,cnt+1,aespa+1);
												visit[nx][ny] = false;
												algo.remove(L);
											}
										}		
									}
								}
							}
							//
						}
						i+=2;
					}
				}
				// D����
				else if(shape[x][y] == 4){
					for(int i = 0; i<4; i++) {
						int nx = x + cx[i];
						int ny = y + cy[i];
						if(check(nx,ny) && (shape[nx][ny] == 4) && (map[nx][ny] <= aespa)) {
							//����������
							if(nx%2 == 0 || ny%2 == 0) {
								visit[nx][ny] = true;
								dfs(nx,ny,cnt+1,aespa);
								visit[nx][ny] = false;
							}
							//
							//����
							else {
								int ix = (nx-1)/2, iy = (ny-1)/2;
								int idx = N*ix + iy;
								//������ ����
								if(dev[idx].exist == 0){
									visit[nx][ny] = true;
									dfs(nx,ny,cnt+1,aespa);
									visit[nx][ny] = false;
								}
								// ���� ����
								else {
									//óġ������ �˰��� ����
									if(algo.contains(dev[idx].need) || "0".equals(dev[idx].need)) {
										String L = dev[idx].learn;
										if("0".equals(L)) {
											visit[nx][ny] = true;
											dfs(nx,ny,cnt+1,aespa+1);
											visit[nx][ny] = false;
										}
										//�˰��� ����
										else {
											algo.add(L);
											visit[nx][ny] = true;
											dfs(nx,ny,cnt+1,aespa+1);
											visit[nx][ny] = false;
											algo.remove(L);
										}
									}		
								}
							}	
						}
					}
				}
			}
			// �⺻���� �̵�
			if(x%2 ==0 || y%2 == 0) {
				for(int i = 0; i<4; i++) {
					if(flag)
						break;
					int nx = x + dx[i];
					int ny = y + dy[i];
					if(check(nx,ny) && (nx%2 == 0 || ny%2 == 0) && (map[nx][ny] <= aespa)) {
						visit[nx][ny] = true;
						dfs(nx,ny,cnt+1,aespa);
						visit[nx][ny] = false;
					}
				}
			}
		}
	}
	
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine()); // ������ ũ��
		int size = (N*2)+1;
		map = new int[size][size];
		visit = new boolean[size][size];
		shape = new int[size][size];
		for(int i = 0; i<N; i++) { // ������ ����
			String m = br.readLine();
			for(int j = 0; j<N; j++) {
				int strx = 2*i;
				int stry = 2*j;
				char s = m.charAt(j);
				Go_boss(strx,stry,s);
			}
		}
		
		for(int i = 0; i<N; i++)// ���� ����
		{
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j<N; j++){
				int strx = 2*i;
				int stry = 2*j;
				int level = Integer.parseInt(st.nextToken());
				init(strx,stry,level);
			}
		}
		dev = new boss[N*N];
		for(int i = 0; i<N; i++) { // ���� ����
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j<N; j++) {
				int idx = N*i + j;
				int exist = Integer.parseInt(st.nextToken());
				String need = st.nextToken();
				String learn = st.nextToken();
				dev[idx] = new boss(exist,need,learn);
			}
		}
		int a = Integer.parseInt(br.readLine()); //�˰��ִ� �˰��� ����
		if(a > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i<a; i++)
				algo.add(st.nextToken());
		}
		visit[0][0] = true;
		dfs(0,0,0,1);
		if(flag) {
			System.out.print("Dreams Come True");
		}
		else
			System.out.print("-1");
		
	}
}

/*
2
AB
AC
1 1
1 3
1 dfs greedy 1 greedy bfs
0 0 0 1 dijkstra dfs
1
dfs


4
ABAD
DDDD
BBBB
CCCC
1 1 2 1
1 1 2 1
3 3 3 3
1 1 1 4
0 0 0 1 dp greedy 0 0 0 0 0 0
0 0 0 1 dp sort 1 graph dfs 1 sort 0
0 0 0 1 greedy sort 0 0 0 1 sort dp
0 0 0 0 0 0 0 0 0 1 bfs graph
1
dp

System.out.println();
		for(int i = 0; i<N*2+1; i++) {
			for(int j = 0; j<N*2+1; j++){
				if(i == x && j == y)
					System.out.print("ME ");
				else if(visit[i][j])
					System.out.print(1+" ");
				else
					System.out.print(0+" ");
			}
			System.out.println();
		}
		for(String s : algo) {
			System.out.print(s+"  ");
		}
		System.out.println();

			
2
AB
AC
1 1
1 4
0 0 0 0 0 0
0 0 0 0 0 0
1
dfs		
			
*/
