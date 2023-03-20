import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


//1744 수 묶기
/*수가 최대가 되게 하는법
 * 정렬후 뒤에서 부터 곱하기
 * 1이 연속으로 나올경우 더하는게 이득
 * 음수*양수는 묶기않기
 * 음수*음수는 묶기
 * 음수*0도 음수가 더 없다면 묶기
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
