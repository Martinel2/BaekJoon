import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static char map[][][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);

		int N = sc.nextInt();
		int arr[] = new int[N];
		sc.nextLine();

		for (int i = 0; i < N; i++) {
			arr[i] = i;
		}

		map = new char[N][5][7];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 5; j++) {
				String line = sc.nextLine();
				for (int k = 0; k < 7; k++) {
					map[i][j][k] = line.charAt(k);
				}
			}
		}


		combi(0, 0, N, 2, arr);
		System.out.println(ans);

	}

	static int sel[] = new int[2];

	static void combi(int idx, int cnt, int N, int K, int[] arr) {
		if (idx == K) {
			check(sel);
			return;
		}

		if (cnt == N)
			return;

		sel[idx] = arr[cnt];
		combi(idx + 1, cnt + 1, N, K, arr);
		combi(idx, cnt + 1, N, K, arr);
	}

	static int max=Integer.MAX_VALUE;
	static String ans;
	
	static void check(int[] sel) {
		int cnt=0;
		Arrays.sort(sel);
		for (int j = 0; j < 5; j++) {
			for (int k = 0; k < 7; k++) {
				if(map[sel[0]][j][k]!=map[sel[1]][j][k]) {
					cnt++;
				}
			}
		}
		if(max>cnt) {
			StringBuilder sb = new StringBuilder();
			max=cnt;
			sb.append(sel[0]+1).append(" ").append(sel[1]+1);
			ans = sb.toString();
		}
	}

	private static String src = "3\r\n" + "..X....\r\n" + ".XXX...\r\n" + ".XX....\r\n" + ".....X.\r\n" + ".X...X.\r\n"
			+ "...X...\r\n" + "..XX...\r\n" + ".XX....\r\n" + ".XX..X.\r\n" + ".X...X.\r\n" + "XX.....\r\n"
			+ "X......\r\n" + "XX...XX\r\n" + "XXXX.XX\r\n" + "XXX..XX";
}