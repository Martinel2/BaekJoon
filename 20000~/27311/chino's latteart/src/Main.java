import java.io.*;
import java.util.*;

//27311 치노의 라떼아트
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
			//#로 감싸지는 최대의 사각형을 구함
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
			//그 사각형이 정사각형이면
			if(maxx-minx == maxy-miny) {
				//System.out.println("1clear");
				//.으로 이루어진 정사각형이 존재하는지 확인
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
				//.으로 이루어진 정사각형이  "구석에" 존재한다면
				if( (Mxx - Mnx == Mxy - Mny) && ((Mxx == minx || Mnx == minx) || (Mxx == maxx || Mnx == maxx)) 
						&& ((Mxy == miny || Mny == miny) || (Mxy == maxy || Mny == maxy))) {
						//그 사각형 안에 #이 있는지 확인
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