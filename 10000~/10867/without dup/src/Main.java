import java.io.*;
import java.util.*;


//10867 중복빼고 정렬하기
public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet<Integer> wd = new HashSet<>();
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i<N; i++)
			wd.add(Integer.parseInt(st.nextToken()));
		Object[] arr = wd.toArray();
		
		Arrays.sort(arr);
		for(int i = 0; i<arr.length; i++)
			sb.append(arr[i] + " ");
		System.out.print(sb);
			
		
		
	}
}