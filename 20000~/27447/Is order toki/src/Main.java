import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 손님 수
		int M = Integer.parseInt(st.nextToken());// 흙탕물이 되는 시간
		
		//토기를 만드는 데에 1초  커피 담는데에 1초  서빙하는데 1초
		int[] guest = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			guest[i] = Integer.parseInt(st.nextToken()); 
		}
		int togi = 0;
		int put = 0;
		int idx = 0;
		int time = 0;
		boolean f = true;
		while(idx < guest.length) {
			if(time > guest[idx]) {
				f = false;
				break;
			}
			if(guest[idx] == time) { // 서빙할 시간이면
				if(put > 0) { // 서빙할수있으면
					put--;
					idx++;
				}
				else { // 없으면
					f = false;
					break;
				}
			}
			else if(togi > 0) { //토기가 만들어져있을때
				//System.out.println("put "+put+" idx "+idx+" time+M "+(time+M) );
				if( (idx+put) < guest.length && guest[idx+put] <= time + M) { // 미리담아둬도 되면
					togi--;
					put++;
				}
				else
					togi++;
			}
			else
				togi++;
			//System.out.println("togi "+togi+" put "+put+" idx "+idx+" time "+time);
			time++;
		}
		if(f)
			System.out.println("success");
		else
			System.out.println("fail");
	}
}
/*
2 3
4 5
*/