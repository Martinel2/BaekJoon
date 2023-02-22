import java.io.*;
import java.util.*;

//27313 ȿ������ �ִϸ��̼� ����
public class Main {
	
	static long[] ani;
	static int N,K;
	static long M;
	static boolean ser(int anime) {
		int cnt = 0;
		long T = 0;
		//end == 1�϶�
		if(anime == 0 && ani[0] <= M)
			cnt = 1;
		for(int i = anime-1; i>=0; i-=K) {
			if(T + ani[i] <= M)
			{
				//K���� �ƴҶ�
				if(i+1 < K) {
					T += ani[i];
					cnt += i+1;
				}
				else {
					T += ani[i];
					cnt += K;
				}
			}
		}
		return cnt >= anime;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());//�ִϸ��̼� ����
		M = Long.parseLong(st.nextToken());//��밡���� �� �ð�
		K = Integer.parseInt(st.nextToken());//���ÿ� �����ִ� �ִϸ��̼� ����
		
		ani = new long[N];//�ִϸ��̼� �ð� ���� 
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++)
			ani[i] = Long.parseLong(st.nextToken());
		Arrays.sort(ani); // �������� ����
		
		int start = 0;
		int end = N;
		int ans = 0;
		if(M != 0) {	//�Ű����� Ž��
			while(start<=end) {
				if(end == 0)
					break;
				int mid = (start+end)/2;
				if(ser(mid)) {
					ans = mid;
					start = mid+1;
				}
				else
					end = mid-1;
			}
		}
		System.out.println(ans);
	}
}
