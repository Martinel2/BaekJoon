package persia;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class persia {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//���ѷ���
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			// 0 0 0 0 �Է½� ���ѷ��� ����
			if(a == 0 && b == 0 && c == 0 && d == 0) break;
			
			//�ּҳ��� �ִ볪�� ���� ���� �ְ� ���
			System.out.println((c - b) + " " + (d - a));
		}
	}
}
