import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//2628
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		int N = Integer.parseInt(br.readLine());
		
		int[] width = new int[N];
		int[] height = new int[N];
		for(int i = 0; i<N; i++)
		{
			st = new StringTokenizer(br.readLine());
			int sel = Integer.parseInt(st.nextToken());
			
			if(sel == 0) {
				height[i] = Integer.parseInt(st.nextToken());
			}
			else
				width[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(width);
		Arrays.sort(height);
		
		int curW = 0;
		int maxW = 0;
		
		int curH = 0;
		int maxH = 0;
		for(int val : width) {
			if(val != 0) {
				int wid = val - curW;
				if(wid > maxW)
					maxW = wid;
				curW = val;
			}
		}
		for(int val : height) {
			if(val != 0) {
				int hei = val - curH;
				if(hei > maxH)
					maxH = hei;
				curH = val;
			}
		}
		
		int wid = W - curW;
		int hei = H - curH;
		if(wid > maxW)
			maxW = wid;
		if(hei > maxH)
			maxH = hei;
		System.out.println(maxW * maxH);
	}
}
