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
		
		int time = 1;  // 1�ܰ���� ����
		robot = new boolean[n];  // �κ��� �ش� ��ǥ�� �ö�� �ִ��� üũ�ϴ� �迭
		while (true) {
			turnBelt();  // 1. ��Ʈ��
			turnRobot();  // �� ĭ���� �ִ� �κ��� �Բ� �� ĭ ȸ���Ѵ�.

			for (int i = n - 1; i >= 0; i--) {  // 2. ���� ���� ��Ʈ�� �ö� �κ�����, ��Ʈ�� ȸ���ϴ� �������� �̵�
				if (robot[i]) {
					if (i == n - 1) {  // ������ ��ġ��� �κ��� ������ �ش� ��ġ falseó��
						robot[i] = false;
					}
					else {
						if (robot[i + 1] || arr[0][i + 1] < 1)  // �ű���� ĭ�� (�κ��� ���� || �������� 1 �̸�)
							continue;  // �ű� �� �����Ƿ� ������ �ִ´�
						else {  // �ű� �� �ִ� ���
							robot[i + 1] = true;  // �κ��� ���� ĭ(true)���� �ű�
							robot[i] = false;  // ���� ĭ�� �κ��� �����Ƿ� falseó��
							arr[0][i + 1] -= 1;  // �������� 1�� ����
						}
					}
				}
			}
			
			if (arr[0][0] != 0) {  // �ø��� ĭ�� �������� 0�� �ƴ϶��
				robot[0] = true;  // �κ��� �ø���
				arr[0][0] -= 1;  // ������ -1
			}
			
			if (countZero() >= k) {  // �������� 0�� ĭ�� k�� �̻��� ��� ����
				System.out.println(time);
				return;
			}
			
			time++;  // ��� ������ ������ time++
		}
	}
	
	static void turnBelt() {  // �����̾� ��Ʈ�� ȸ���ϴ� �Լ�
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
	
	static void turnRobot() {  // �κ��� ȸ���ϴ� �Լ�
		for (int i = n - 2; i >= 0; i--) {
			robot[i + 1] = robot[i];
		}
		
		robot[0] = false;
	}
	
	static int countZero() {  // �������� 0�� ĭ�� ���� �Լ�
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