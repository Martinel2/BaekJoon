import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


//1744 �� ����
/*���� �ִ밡 �ǰ� �ϴ¹�
 * ������ �ڿ��� ���� ���ϱ�
 * 1�� �������� ���ð�� ���ϴ°� �̵�
 * ����*����� ����ʱ�
 * ����*������ ����
 * ����*0�� ������ �� ���ٸ� ����
*/
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ans = 0;
		int N = Integer.parseInt(br.readLine());
		int[] seq = new int[N];
		for(int i = 0; i<N; i++) {
			seq[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(seq);
		int idx = N-1;
		while(idx >= 0 && seq[idx] > 0) {
			if(idx>0 && seq[idx] > 1 && seq[idx-1] > 1) {
				ans += seq[idx]*seq[idx-1];
				idx--;
			}
			else
				ans += seq[idx];
			idx--;
		}
		for(int i = 0; i<=idx; i++) {
			if(i<idx) {
				ans += seq[i]*seq[i+1];
				i++;
			}
			else if(i==idx && seq[idx] != 0)
				ans += seq[i];
		}
		System.out.println(ans);
	}
}
