import java.io.*;
import java.util.*;


//13460 ����Ż�� 2
public class Main {
	//���� ��ǥ Ŭ����
	static class ball{
		private int x;
		private int y;
		private int cnt = 0;
		ball(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
		ball(int cnt,int x,int y)
		{
			this.cnt = cnt;
			this.x = x;
			this.y = y;
		}
	}
	//�ִܰ�� ã��
	static int Bfs() {
		while(!red.isEmpty())
		{
			r = red.poll();
			b = blue.poll();
			board[r.x][r.y] = 'R';
			board[b.x][b.y] = 'B';
			
			if(r.cnt < 10)//10�ʰ��� -1 ����
			{
				ball rollr = new ball(r.cnt, r.x, r.y);
				ball rollb = new ball(b.cnt, b.x, b.y);
				
				//���� ����̱�
				if(r.x < b.x) {
					int cnt = rolling(rollr,-1,0,rollb);
					if(cnt !=0)
						return cnt;
				}
				else
				{
					int cnt = rolling(rollb,-1,0,rollr);
					if(cnt !=0)
						return cnt;
				}
				rollr = new ball(r.cnt, r.x, r.y);
				rollb = new ball(b.cnt, b.x, b.y);
				//�Ʒ��� ����̱�
				if(r.x > b.x) {
					int cnt = rolling(rollr,1,0,rollb);
					if(cnt !=0)
						return cnt;
				}
				else
				{
					int cnt = rolling(rollb,1,0,rollr);
					if(cnt !=0)
						return cnt;
				}
				rollr = new ball(r.cnt, r.x, r.y);
				rollb = new ball(b.cnt, b.x, b.y);
				//�������� ����̱�
				if(r.y < b.y) {
					int cnt = rolling(rollr,0,-1,rollb);
					if(cnt !=0)
						return cnt;
				}
				else
				{
					int cnt = rolling(rollb,0,-1,rollr);
					if(cnt !=0)
						return cnt;
				}
				rollr = new ball(r.cnt, r.x, r.y);
				rollb = new ball(b.cnt, b.x, b.y);
				//���������� ����̱�
				if(r.y > b.y) {
					int cnt = rolling(rollr,0,1,rollb);
					if(cnt !=0)
						return cnt;
				}
				else
				{
					int cnt = rolling(rollb,0,1,rollr);
					if(cnt !=0)
						return cnt;
				}
				board[r.x][r.y] = '.';
				board[b.x][b.y] = '.';
				
			}
			else
				return -1;
				
		}
		return -1;
		
	}
	
	//������ ���� ��Ȳ�� ����
	static int rolling(ball roll1, int x, int y, ball roll2)
	{
		boolean wir = false;
		String s = "";
		int rx,ry,bx,by;
		if(roll1.x == r.x && roll1.y == r.y) 
			wir = true;
		else
			wir = false;
		if(wir)//1�� red
		{
			roll1 = move(roll1, x,y);
			rx = roll1.x;
			ry = roll1.y;
			if(board[rx][ry] != 'O')
			{
				board[r.x][r.y] = '.';
				board[rx][ry] = 'R';
			}
			else
				board[r.x][r.y] = '.';
			
			roll2 = move(roll2, x,y);

			bx = roll2.x;
			by = roll2.y;
		
			if(board[bx][by] == 'O') {
				if(board[rx][ry] != 'O') {
					board[rx][ry] = '.';
					board[r.x][r.y] = 'R';
					return 0;
				}
				else {
					board[r.x][r.y] = 'R';
					return 0;
				}
			}
			//�������� ���ۿ� ������
			else if(board[rx][ry] == 'O')
				return roll1.cnt;
			else
			{
				board[rx][ry] = '.';
				board[r.x][r.y] = 'R';
				s += Integer.toString(rx);
				s += Integer.toString(ry);
				s += Integer.toString(bx);
				s += Integer.toString(by);

				//�� ���� �� ��ġ�������� ������
				if(!visit.contains(s))
				{
					visit.add(s);
					red.offer(roll1);
					blue.add(roll2);
					roll1 = new ball(r.cnt, r.x, r.y);
					roll2 = new ball(b.cnt, b.x, b.y);
				}
			}
		}
		else // 2�� red
		{
			roll1 = move(roll1, x,y);
			bx = roll1.x;
			by = roll1.y;
			if(board[bx][by] != 'O')
			{
				board[b.x][b.y] = '.';
				board[bx][by] = 'B';
			}
			else
				return 0;
			
			roll2 = move(roll2, x,y);
			board[bx][by] = '.';
			board[b.x][b.y] = 'B';

			rx = roll2.x;
			ry = roll2.y;
			//�������� ���ۿ� ������
			if(board[rx][ry] == 'O')
				return roll2.cnt;
			else
			{
				s += Integer.toString(rx);
				s += Integer.toString(ry);
				s += Integer.toString(bx);
				s += Integer.toString(by);
			
				//�� ���� �� ��ġ�������� ������
				if(!visit.contains(s))
				{
					visit.add(s);
					red.offer(roll2);
					blue.offer(roll1);
				}
			}
		}
		
		return 0;
	}
	
	//��￩�� �����̴� �Լ�
		static ball move(ball roll, int movex, int movey)
		{
			while(board[roll.x + movex][roll.y + movey] == '.')//���� ���������� ������
			{
					roll.x += movex;
					roll.y += movey;
			}
			if(board[roll.x + movex][roll.y + movey] == 'O')
			{
				roll.x += movex;
				roll.y += movey;
			}
			roll.cnt++;
			return roll;
		}

	static Queue<ball> red = new LinkedList<>();
	static Queue<ball> blue = new LinkedList<>();
	static HashSet<String> visit = new HashSet<>();
	static char[][] board;
	static ball r,b;
	static int N,M;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		String s = "";
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N][M];
		//�迭 �ʱ�ȭ
		for(int i = 0; i<N; i++)
		{
			board[i] = br.readLine().toCharArray();
			//����, ���� ��ġ ����
			for(int j = 0; j<M; j++)
			{
				if(board[i][j] == 'R') {
					red.offer(new ball(i,j));
					s += Integer.toString(i);
					s += Integer.toString(j);
					board[i][j] = '.';
				}
				else if(board[i][j] == 'B') {
					blue.offer(new ball(i,j));
					s += Integer.toString(i);
					s += Integer.toString(j);
					board[i][j] = '.';
				}
			}
		}
		visit.add(s);
		System.out.print(Bfs());
	}
}