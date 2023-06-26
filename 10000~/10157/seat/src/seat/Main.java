package seat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	// �������
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int c = Integer.parseInt(st.nextToken());
    	int r = Integer.parseInt(st.nextToken());
    	int[][] arr = new int[r + 2][c + 2];

    	for(int i = 0; i < (c + 2); i++) {
    		arr[0][i] = -1;
    		arr[r + 1][i] = -1;
    	}

    	for(int i = 0; i < (r + 2); i++) {
    		arr[i][0] = -1;
    		arr[i][c + 1] = -1;
    	}

    	int k = Integer.parseInt(br.readLine());

    	// �¼��� ������ �� ���� ���
    	if(k > c * r) {
    		System.out.println(0);
    		return;
    	}

    	int x = r; // ���� x ��ǥ
    	int y = 1; // ���� y ��ǥ
    	int value = 1; // �¼�
    	int dir = 0; // ���� (������� => 0123)

    	while(true) {
    		arr[x][y] = value;
    		// ����ȣ k ���� �¼� ��ġ ���
    		if(value == k) {
    			System.out.println(y + " " + (r - x + 1));
    			break;
    		}

    		// �̹� ä�����ְų� ���� ���������� ���� ��ȯ
    		if(arr[x + dx[dir]][y + dy[dir]] != 0) {
    			dir = (dir + 1) % 4;
    		}
    		x += dx[dir];
    		y += dy[dir];

    		value++;

    		// �¼� �ִ�
    		if(value > c * r) {
    			break;
    		}
    	}
    }
}