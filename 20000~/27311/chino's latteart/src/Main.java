import java.io.*;
import java.util.*;

//27311 ġ���� �󶼾�Ʈ
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t<T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			char[][] arr = new char[R][C];
			for(int i = 0; i<R; i++) {
				arr[i] = br.readLine().toCharArray();
			}
			//#�� �������� �ִ��� �簢���� ����
			int maxx=0,maxy=0;
			int minx=100, miny = 200;
			boolean flag = true;
			for(int i = 0; i<R; i++) {
				for(int j = 0; j<C; j++) {
					if(arr[i][j] == '#') {
						if(maxx < i)
							maxx = i;
						if(maxy < j)
							maxy = j;
						if(minx > i)
							minx = i;
						if(miny > j)
							miny = j;
					}
				}
			}
			//�� �簢���� ���簢���̸�
			if(maxx-minx == maxy-miny) {
				//System.out.println("1clear");
				//.���� �̷���� ���簢���� �����ϴ��� Ȯ��
				int Mxx = 0, Mxy = 0;
				int Mnx = 100, Mny = 200;
				for(int i = minx; i<=maxx; i++) {
					for(int j = miny; j <=maxy; j++) {
						if(arr[i][j] == '.') {
							if(Mxx < i)
								Mxx = i;
							if(Mxy < j)
								Mxy = j;
							if(Mnx > i)
								Mnx = i;
							if(Mny > j)
								Mny = j;
						}
					}
				}
				//.���� �̷���� ���簢����  "������" �����Ѵٸ�
				if( (Mxx - Mnx == Mxy - Mny) && ((Mxx == minx || Mnx == minx) || (Mxx == maxx || Mnx == maxx)) 
						&& ((Mxy == miny || Mny == miny) || (Mxy == maxy || Mny == maxy))) {
						//�� �簢�� �ȿ� #�� �ִ��� Ȯ��
					for(int i = Mnx; i<=Mxx; i++) {
						for(int j = Mny; j <=Mxy; j++) {
							if(arr[i][j] == '#') {
								flag = false;
								break;
							}
						}
					}
				}
				else
					flag = false;
			}
			else
				flag = false;
			if(flag)
				sb.append(1).append("\n");
			else
				sb.append(0).append("\n");
		}
		System.out.print(sb);
	}
}
/*
3
5 5
###..
###..
#####
#####
#####
10 10
...#.#....
..#.#.#...
..#.#.#...
..#####...
.#.....#..
.#.#.#.#..
.#..#..#..
.#.###.#..
.#.....#..
..#####...
4 8
........
.##.....
.#......
........
*/