import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		//����ִ� ������ ���� ���� �� ����
		int count = 0;
		//���� ����ϱ� ���� �Է°��� �迭�� ����
		String[] arr = new String[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = br.readLine();
			//���ڿ��� X(���)�� ���� ���θ� Ȯ��. false�� ���ٴ� ��
			if(arr[i].contains("X") == false) {
				count++;
			}
		}
		
		//max ������ count ���� �� count �ʱ�ȭ
		int max = count;
		count = 0;
		
		//���� �� ������ ����ϱ� ���� �ݺ���
		for(int i = 0; i < M; i++) {
			//count�ϳ��� �񱳱��� �ϱ� �����ϱ⿡ ���� ��Ȱ�� �ϳ� �� ����
			int counts = 0;
			for(int j = 0; j < N; j++) {
				if(arr[j].charAt(i) == '.') {
					counts++;
				}
			}
			//���� .�� �ִ��� �Ǻ��ϴ� ���ǹ�
			if(counts == N) count++;
		}
		//��� �� �� ū ���� ����
		max = Math.max(max, count);
		
		System.out.println(max);
	}

}