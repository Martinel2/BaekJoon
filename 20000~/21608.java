package solved;

import java.io.*;
import java.util.*;

public class Main {

    static BufferedWriter bw;
    static BufferedReader br;
    static int N;
    static int seats [][];
    static int likeCounts [][];
    static int emptyCounts [][];
    static List<Integer>[] students;
    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        seats = new int[N+1][N+1];
        likeCounts =new int[N+1][N+1];
        emptyCounts = new int[N+1][N+1];

        students = new ArrayList[N*N+1];
        // 초기화
        for(int i=0; i<students.length; i++)
            students[i] = new ArrayList<>();

        for(int i=0; i< N*N; i++){
            int maxLike = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int me = Integer.parseInt(st.nextToken());
            // 좋아하는 학생 4명 정보 담기
            for(int j=0; j<4; j++){
                students[me].add(Integer.parseInt(st.nextToken()));
            }
            // 현재 학생 좌석 배치 시작
            for(int r=1; r<=N; r++){
                for(int c=1; c<=N; c++){
                    // 이미 배정된 좌석이면 패스
                    if(seats[r][c] != 0)
                        continue;

                    //1. 좋아하는 학생의 수가 많은 곳
                    likeCounts[r][c] = getLikeCount(me, r, c);
                    maxLike = Math.max(maxLike, likeCounts[r][c]);

                    //2. 비어있는 인접 칸 몇개 인지
                    emptyCounts[r][c] = getEmpty(r, c);
                }
            }

            int [] point = new int[2];
            int maxEmpty = -1;
            for(int r=1; r<=N; r++) {
                for (int c = 1; c <= N; c++) {
                    if(seats[r][c] != 0)
                        continue;
                    // 3. 행, 열 번호가 가장 작은 곳에 배치
                    if(likeCounts[r][c] == maxLike){
                        // 인접 칸 중 가장 많이 비어있는 칸을 찾음
                        if(maxEmpty < emptyCounts[r][c]){
                            point[0] = r;
                            point[1] =c;
                            maxEmpty = emptyCounts[r][c];
                        }
                    }
                }
            }
            seats[point[0]][point[1]] = me;
        }

        // 4. 만족도 조사
        int ans = 0;
        for(int r=1; r<=N; r++) {
            for (int c = 1; c <= N; c++) {
                int likeCount = getLikeCount(seats[r][c], r, c);
                switch (likeCount){
                    case 1:
                        ans += 1;
                        break;
                    case 2:
                        ans += 10;
                        break;
                    case 3:
                        ans += 100;
                        break;
                    case 4:
                        ans += 1000;
                        break;
                }
            }
        }

        bw.write(ans+"\n");
        bw.flush();

        bw.close();
        br.close();

    }

    // (r,c)에 앉을 시 비어있는 인접한 칸이 몇개인지 리턴
    public static int getEmpty(int r, int c){
        int dr [] = {0, 1, 0, -1};
        int dc [] = {1,0,-1,0};
        int count = 0;
        for(int i=0; i<4; i++){
            int newR = r + dr[i];
            int newC = c + dc[i];

            if(isRange(newR,newC) && seats[newR][newC] == 0)
                count++;
        }
        return count;
    }
    // (r,c)에 앉을 시 인접한 칸에 좋아하는 학생이 몇명인지 리턴
    public static int getLikeCount(int me, int r, int c){
        int dr [] = {0, 1, 0, -1};
        int dc [] = {1, 0,-1, 0};
        int count = 0;
        for(int i=0; i<4; i++){
            int newR = r + dr[i];
            int newC = c + dc[i];

            if(isRange(newR,newC) && students[me].contains(seats[newR][newC]))
                count++;
        }
        return count;
    }

    // 유효 범위인지 체크
    public static boolean isRange(int r, int c){
        if(r>0 && r<=N && c>0 && c<=N)
            return true;
        return false;
    }
}