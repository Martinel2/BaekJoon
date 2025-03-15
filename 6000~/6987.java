package solved;

import java.util.*;
import java.io.*;

public class Main {
	
	static final int MAX = 6;
	static int[][] matches;
	static boolean end = false;
	
	static void bt(int[][] worldCup, int matchCount, int size) {
		if(end) {
			return;
		}
		
		// 모든 게임을 수행할 수 있다면 이 월드컵은 가능하다.
		if(matchCount == size) {
			end = true;
			return;
		}
		
		int myTeam = matches[matchCount][0];
		int enemyTeam = matches[matchCount][1];
		
		// 승 -> 패
		if(worldCup[0][myTeam] > 0 && worldCup[2][enemyTeam] > 0) {
			worldCup[0][myTeam]--;
			worldCup[2][enemyTeam]--;
			
			bt(worldCup, matchCount + 1, size);
			
			worldCup[0][myTeam]++;
			worldCup[2][enemyTeam]++;
		}
		// 무 -> 무
		if(worldCup[1][myTeam] > 0 && worldCup[1][enemyTeam] > 0) {
			worldCup[1][myTeam]--;
			worldCup[1][enemyTeam]--;
			
			bt(worldCup, matchCount + 1, size);
			
			worldCup[1][myTeam]++;
			worldCup[1][enemyTeam]++;
		}
		// 패 -> 승
		if(worldCup[2][myTeam] > 0 && worldCup[0][enemyTeam] > 0) {
			worldCup[2][myTeam]--;
			worldCup[0][enemyTeam]--;
			
			bt(worldCup, matchCount + 1, size);
			
			worldCup[2][myTeam]++;
			worldCup[0][enemyTeam]++;
		}
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int tc=4;
    	int size = 0;
        for(int t=1; t<MAX; t++) {
        	size += t;
        }
        
        matches = new int[size][2];
        int index = 0;
        for(int i = 0; i<MAX-1; i++) {
        	// 모든 팀의 경기 조합 수
        	// 0 1
        	// 0 2
        	// ...
        	// 4 5
        	for(int j=i+1; j<MAX; j++) {
        		matches[index][0] = i;
        		matches[index][1] = j;
        		index++;
        	}
        }
        
        while(tc-->0) {
        	st = new StringTokenizer(br.readLine());
        	int[][] worldcup = new int[3][MAX];
        	boolean can = true;
        	
        	for(int i=0; i<MAX; i++) {
        		int w = Integer.parseInt(st.nextToken());
        		int d = Integer.parseInt(st.nextToken());
        		int l = Integer.parseInt(st.nextToken());
        		
        		worldcup[0][i] = w;
        		worldcup[1][i] = d;
        		worldcup[2][i] = l;
        		
        		if(w+d+l !=5) {
        			can = false;
        			break;
        		}
        	}
        	
        	if(can) {
        		bt(worldcup,0,size);
        		if(end) {
        			sb.append(1);
        		}else sb.append(0);
        	}else sb.append(0);
        	
        	sb.append(" ");
        	end = false;
        }
        System.out.print(sb);
    }
}