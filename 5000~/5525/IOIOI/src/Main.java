import java.io.*;


//5525 IOIOI
public class Main {
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String S = br.readLine();
		int num = 0;
		int cnt = 0;
		for(int i = 0; i<M; i++)
		{
			if(S.charAt(i) == 'I') {
				while(i+2 < M && S.charAt(i+1) == 'O' && S.charAt(i+2) == 'I') {
					num++;
					if(num == N)
					{
						num--;
						cnt++;
					}
					i += 2;
				}
				num = 0;
			}
		}
		System.out.println(cnt);
	}
}