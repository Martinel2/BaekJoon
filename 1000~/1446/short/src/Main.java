import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//1446
class ShortCut implements Comparable<ShortCut> {
	int start;
	int end;
	int distance;
	
	ShortCut(int start, int end, int distance) {
		this.start = start;
		this.end = end;
		this.distance = distance;
	}

	@Override
	public int compareTo(ShortCut o) {
		if(this.start < o.start) {
			return -1;
		}
		return 1;
	}
}


public class Main {
	static int n, d;
	static int[] movedDistance;	// 최단 으로 운전한 거리  
	static ShortCut[] shortCuts;
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		movedDistance = new int[d + 1];
		shortCuts = new ShortCut[n];
		
		// 초기화
		Arrays.fill(movedDistance, Integer.MAX_VALUE);
		
		// 지름길 입력받기 
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			
			shortCuts[i] = new ShortCut(start, end, dist);
		}
		
		// 시작점 기준 오름차순 정렬 
		Arrays.sort(shortCuts);
		
		int nowDistance = 0;
		int nowIndex = 0;
		movedDistance[0] = 0;
		
		while(nowDistance < d) {
			while(nowIndex < n) {
				if(shortCuts[nowIndex].start != nowDistance) {
					break;
				}
				
				// 지름길 이동 
				if(shortCuts[nowIndex].end <= d) {
					int goShortCutDistance = movedDistance[nowDistance] + shortCuts[nowIndex].distance;
					if(goShortCutDistance < movedDistance[shortCuts[nowIndex].end]) {
						movedDistance[shortCuts[nowIndex].end] = goShortCutDistance;
					}
				}
			
				nowIndex++;
			}
			
			// 한 칸 이동 
			if(movedDistance[nowDistance] + 1 < movedDistance[nowDistance + 1]) {
				movedDistance[nowDistance + 1] = movedDistance[nowDistance] + 1;
			}
			
			nowDistance++;
		}
		
		System.out.println(movedDistance[d]);
	}
}