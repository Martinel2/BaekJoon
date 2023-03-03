import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // �մ� ��
		int M = Integer.parseInt(st.nextToken());// �������� �Ǵ� �ð�
		
		//��⸦ ����� ���� 1��  Ŀ�� ��µ��� 1��  �����ϴµ� 1��
		int[] guest = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			guest[i] = Integer.parseInt(st.nextToken()); 
		}
		int togi = 0;
		int put = 0;
		int idx = 0;
		int time = 0;
		boolean f = true;
		while(idx < guest.length) {
			if(time > guest[idx]) {
				f = false;
				break;
			}
			if(guest[idx] == time) { // ������ �ð��̸�
				if(put > 0) { // �����Ҽ�������
					put--;
					idx++;
				}
				else { // ������
					f = false;
					break;
				}
			}
			else if(togi > 0) { //��Ⱑ �������������
				//System.out.println("put "+put+" idx "+idx+" time+M "+(time+M) );
				if( (idx+put) < guest.length && guest[idx+put] <= time + M) { // �̸���Ƶֵ� �Ǹ�
					togi--;
					put++;
				}
				else
					togi++;
			}
			else
				togi++;
			//System.out.println("togi "+togi+" put "+put+" idx "+idx+" time "+time);
			time++;
		}
		if(f)
			System.out.println("success");
		else
			System.out.println("fail");
	}
}
/*
2 3
4 5
*/