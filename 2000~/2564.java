package solved;

import java.util.*;

public class Main {
	static int k, n;
	static int[][] arr;
	static boolean[] robot;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		k = sc.nextInt();
		
		arr = new int[2][n];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0)
					arr[i][j] = sc.nextInt();
				else 
					arr[i][n - j - 1] = sc.nextInt();
			}
		}
		
		sc.close();
		
		int time = 1;  // 1단계부터 시작
		robot = new boolean[n];  // 로봇이 해당 좌표에 올라와 있는지 체크하는 배열
		while (true) {
			turnBelt();  // 1. 벨트가
			turnRobot();  // 각 칸위에 있는 로봇과 함께 한 칸 회전한다.

			for (int i = n - 1; i >= 0; i--) {  // 2. 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 이동
				if (robot[i]) {
					if (i == n - 1) {  // 내리는 위치라면 로봇을 내리고 해당 위치 false처리
						robot[i] = false;
					}
					else {
						if (robot[i + 1] || arr[0][i + 1] < 1)  // 옮기려는 칸에 (로봇이 있음 || 내구도가 1 미만)
							continue;  // 옮길 수 없으므로 가만히 있는다
						else {  // 옮길 수 있는 경우
							robot[i + 1] = true;  // 로봇을 다음 칸(true)으로 옮김
							robot[i] = false;  // 현재 칸은 로봇이 없으므로 false처리
							arr[0][i + 1] -= 1;  // 내구도는 1을 빼줌
						}
					}
				}
			}
			
			if (arr[0][0] != 0) {  // 올리는 칸에 내구도가 0이 아니라면
				robot[0] = true;  // 로봇을 올리고
				arr[0][0] -= 1;  // 내구도 -1
			}
			
			if (countZero() >= k) {  // 내구도가 0인 칸이 k개 이상일 경우 종료
				System.out.println(time);
				return;
			}
			
			time++;  // 모든 과정을 끝내면 time++
		}
	}
	
	static void turnBelt() {  // 컨베이어 벨트를 회전하는 함수
		int temp1 = arr[0][n - 1];
		int temp2 = arr[1][0];
		
		for (int i = n - 2; i >= 0; i--) {
			arr[0][i + 1] = arr[0][i];
		}
		arr[0][0] = temp2;
		
		for (int i = 0; i < n - 1; i++) {
			arr[1][i] = arr[1][i + 1];
		}
		arr[1][n - 1] = temp1;
	}
	
	static void turnRobot() {  // 로봇을 회전하는 함수
		for (int i = n - 2; i >= 0; i--) {
			robot[i + 1] = robot[i];
		}
		
		robot[0] = false;
	}
	
	static int countZero() {  // 내구도가 0인 칸을 세는 함수
		int count = 0;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 0)
					count++;
			}
		}
		
		return count;
	}
}