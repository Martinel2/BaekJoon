package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main{
	
	static int[] arr = new int[10005];
	static StringBuilder sb = new StringBuilder();
	
	// 전위 순회 = 왼 중 오
	// 후위 순회 = 왼 오 중
	// 이진 검색 트리는 왼쪽에 작은거 오른쪽에 큰거니 전위 순회중 큰 값이 나오면 우측서브트리가 되는 것
	static void post(int str, int end) {
		if(str>=end) return;
		
		int i;
		
		//기준노드보다 크면 우측서브트리이므로 정지하여 왼쪽 오른쪽을 나눔
		// 크지않다면 끝까지 가서 왼쪽 서브트리를 기준으로 후위순회 진행
		for(i = str+1; i<end; i++)
			if(arr[str]<arr[i]) break;
			
		
		post(str+1,i);
		post(i, end);
		sb.append(arr[str]).append('\n');
	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s;
		
		int idx = 0;
		while((s=br.readLine()) != null) {
			arr[idx++] = Integer.parseInt(s);
		}
		
		post(0,idx);
		
		System.out.println(sb);
	}
}