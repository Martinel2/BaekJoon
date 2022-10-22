import java.io.*;
import java.util.*;


//2635 수 이어가기
//an-2 - an-1 = an an<0, 종료
public class Main {
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> res = new ArrayList<>();
		int cnt = 0;
		int N = Integer.parseInt(br.readLine());
		for(int i = N; i>=N/2; i--)
		{
			ArrayList<Integer> list = new ArrayList<>();
			list.add(N);
			
			int temp = N;
			int temp2 = i;
			
			while(true) {
				if(temp<0) break;
				int temp3 = temp;
				if(temp2 >= 0) list.add(temp2);
				temp = temp2;
				temp2 = temp3-temp;
			}
			if(cnt<list.size()) {
				cnt = list.size();
				res = list;
			}
		}
		System.out.println(cnt);
		for(int val : res)
			System.out.print(val + " ");
	}
}