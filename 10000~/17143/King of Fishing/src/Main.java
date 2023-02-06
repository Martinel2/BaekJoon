import java.io.*;
import java.util.*;


//17143 ���ÿ�
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
		//1.���� �ʱ�ȭ �� �迭 ����
		st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());//����
		C = Integer.parseInt(st.nextToken());//����
		M = Integer.parseInt(st.nextToken());//��� ��
		arr = new int[R][C];
		boolean[][] almove = new boolean[R][C];
		for(int i = 0; i<M; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken())-1;//����
			int c = Integer.parseInt(st.nextToken())-1;//����
			int s = Integer.parseInt(st.nextToken());//�ӷ� ���̻� ���������� �ݴ�������� �̵�
			int d = Integer.parseInt(st.nextToken());//���� 1:up 2:down 3:right 4:left
			int z = Integer.parseInt(st.nextToken());//ũ�� �������� ũ�� ������ ��ƸԱ�
			if (d <= 2) s %= (R - 1) * 2;
			else s %= (C - 1) * 2;
			arr[r][c] = z;
			hm.put(z, new shark(r,c,s,d));
		}
		//1.1�ʸ��� ��ĭ�� �̵�
		for(int i = 0; i<C; i++) {
			//2. �����ִ� ����� ���� ���� ����� ��� ���
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
			//3.��� �̵��ϱ�
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
				//���� �ڸ��� �θ����� �� ���� 
				if(almove[r][c]) {
					//System.out.println("bite");
					int z = arr[r][c];
					//�̵��� �Ϸ��� ����� ũ�� < ���� ������ ����� ũ��
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