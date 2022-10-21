import java.io.*;
import java.util.*;


//5347 LCM
public class Main {
	//�ּҰ���� = �ִ����� * (a*b)/(�ִ�����)
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int A = a;
			int B = b;
			if(a<b) {
				int temp = a;
				a = b;
				b = temp;
			}
			while(b >= 1)
			{
				int r = a%b;
				a = b;
				b = r;
			}
			sb.append((A*B)/a).append("\n");
		}
		System.out.print(sb);
	}
}