package solved;

import java.util.*;
import java.io.*;

public class Main {  
	
   static int R, C, T;
   static int[][] map;
   
   static int[] dx = {-1, 0, 1, 0};
   static int[] dy = {0, 1, 0, -1};
   
   static int[][] exMap;
  
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      R = Integer.parseInt(st.nextToken());
      C = Integer.parseInt(st.nextToken());
      T = Integer.parseInt(st.nextToken());
      
      map = new int[R][C];
      Cir[] cir = new Cir[2]; // [0]: 위 쪽 공기청정기, [1]: 아래 쪽 공기청정기
      int idx = 0;
      for(int i=0; i<R; i++) {
    	  st = new StringTokenizer(br.readLine(), " ");
    	  for(int j=0; j<C; j++) {
    		  map[i][j] = Integer.parseInt(st.nextToken());
    		  if(map[i][j] == -1) {
    			  cir[idx] = new Cir(i, j);
    			  idx++;
    		  }
    	  }
      }
      
      for(int i=1; i<=T; i++) {
    	  spreadDust(); // 먼지 퍼트리기
    	  circulating(cir[0], cir[1]); // 공기 순환
      }
      
      int ans = 0;
      for(int i=0; i<R; i++) {
    	  for(int j=0; j<C; j++) {
    		  ans += map[i][j];
    	  }
      }
      
      // 공기청정기 위치의 값은 -1 이므로 +2 해줌
      System.out.println(ans + 2);
   }   
   
   static void circulating(Cir up, Cir below) {
	   // 위 쪽 순환
	   int idx = 0;
	   int x = up.x;
	   int y = up.y;
	   while(true) {
		   int nx = x + dx[idx];
		   int ny = y + dy[idx];
		   
		   // 범위 벗어나면 idx 바꿔줌
		   if(nx < 0 || ny < 0 || nx > up.x || ny >= C) {
			   idx = (idx + 1) % 4;
			   continue;
		   }
		   
		   if(map[x][y] == -1) { // 순환 시작인 상황
			   
		   } else if(map[nx][ny] == -1) { // 순환 마지막 상황 -> 공기청정기에서 나가는 공기는 먼지 농도 0
			   map[x][y] = 0;
			   break;
		   } else { // 공기 순환
			   map[x][y] = map[nx][ny];
		   }
		   
		   x = nx;
		   y = ny;	   
	   }
	   
	   // 아래쪽 순환
	   idx = 3;
	   x = below.x;
	   y = below.y;
	   while(true) {
		   int nx = x + dx[idx];
		   int ny = y + dy[idx];
		   
		   // 범위 벗어나면 idx 바꿔줌
		   if(nx < below.x || ny < 0 || nx >= R || ny >= C) {
			   idx = idx - 1;
			   if(idx < 0) {
				   idx = 3;
			   }
			   continue;
		   }
		   
		   if(map[x][y] == -1) { // 순환 시작인 상황
			   
		   } else if(map[nx][ny] == -1) { // 순환 마지막 상황 -> 공기청정기에서 나가는 공기는 먼지 농도 0
			   map[x][y] = 0;
			   break;
		   } else { // 공기 순환
			   map[x][y] = map[nx][ny];
		   }
		   
		   x = nx;
		   y = ny;	   
	   }
	   
   }
   
   static void spreadDust() {
	   exMap = new int[R][C]; // 4방향으로 퍼진 새끼 먼지 농도 표시할 배열
	   
	   // 초기 상태인 부모 먼지 상태를 Queue에 넣음
	   Queue<Dust> que = new LinkedList<>(); 
	   for(int i=0; i<R; i++) {
		   for(int j=0; j<C; j++) {
			   if(map[i][j] != 0 && map[i][j] != -1) {
				   que.add(new Dust(i, j, map[i][j]));
			   }
		   }
	   }
	   
	   while(!que.isEmpty()) {
		   Dust dust = que.poll(); // 부모 먼지 객체
		   
		   int curX = dust.x;
		   int curY = dust.y;
		   int curVol = dust.vol;
		   
		   int cnt = 0;
		   int nVol = curVol / 5; // 새끼 먼지의 농도
		   for(int t=0; t<4; t++) {
			   int nx = curX + dx[t];
			   int ny = curY + dy[t];
			   
			   // 범위를 벗어났거나 공기청정기가 있는 위치는 먼지 퍼트리기 불가능
			   if(nx < 0 || ny < 0 || nx >= R || ny >= C || map[nx][ny] == -1) continue;
			   
			   cnt++; // 먼지가 퍼질 수 있는 방향의 갯수
			   // 배열에 새끼 먼지 농도를 중첩해줌
			   exMap[nx][ny] += nVol;
			     
		   }
		   // 부모 먼지의 농도 갱신
		   int nRootVol = curVol - (nVol * cnt);
		   map[curX][curY] = nRootVol;
		   
	   }
	   
	   // 갱신된 부모 먼지의 농도가 표시된 map배열에 새끼 먼지 농도를 더해줌
	   for(int i=0; i<R; i++) {
		   for(int j=0; j<C; j++) {
			   map[i][j] += exMap[i][j];
		   }
	   }
   
   }
   
   // 먼지의 위치, 농도
   static class Dust{
	   int x, y, vol;
	   
	   Dust(int x, int y, int vol){
		   this.x = x;
		   this.y = y;
		   this.vol = vol;
	   }
   }
   
   // 공기 청정기의 위치
   static class Cir{
	   int x, y;
	   
	   Cir(int x, int y){
		   this.x = x;
		   this.y = y;
	   }
   }
}