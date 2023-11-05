import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int N = Integer.parseInt(br.readLine());
		String[] arr = new String[N];
		
		for(int i = 0; i<N; i++) {
			arr[i] = br.readLine();
		}
		
		int[] word = new int[N];
		
		int cnt = 1;
		for(int i = 1; i<N; i++) {
			boolean same = true;
			int ilen = arr[i].length();
			
			for(int j = 0; j<cnt; j++) {
				int index = word[j];
				int len = arr[index].length();
				if(ilen == len) {
					int idx = 0;
					for(int k = 0; k < len; k++) {
						if(arr[i].charAt(k) == arr[index].charAt(0)) {
							idx = k;
							break;
						}
					}
					for(int k = 0; k < len; k++) {
						if(arr[index].charAt(k) == arr[i].charAt(idx%ilen)) 
							idx++;
						else {
							same = false;
							break;
						}
						
						if(k == len-1)
							same = true;
					}
					if(same) 
						break;
				}
				else
					same = false;
			}
			if(!same) {
				word[cnt++] = i;
			}
		}
		
		System.out.println(cnt);
	}
}

/*
5
picture
turepic
icturep
word
ordw
 */
