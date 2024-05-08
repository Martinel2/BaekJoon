package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static String RESULT = "KAKTUS";
    static char[][] map;
    static boolean[][] moveVisit;
    static int[] start;
    static ArrayList<int[]> roots;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        moveVisit = new boolean[R][C];
        roots = new ArrayList<>();

        for (int r = 0; r < R; r++) {
            String str = br.readLine();
            for (int c = 0; c < C; c++) {
                map[r][c] = str.charAt(c);
                if (map[r][c] == 'S') start = new int[]{r, c, 0};
                if (map[r][c] == '*') roots.add(new int[]{r, c});
            }
        }
        bfs();
        System.out.println(RESULT);
    }
    public static void bfs() {
        ArrayDeque<int[]> move = new ArrayDeque<>();
        move.add(start);
        moveVisit[start[0]][start[1]] = true;

        ArrayDeque<int[]> water = new ArrayDeque<>(roots);

        while (!move.isEmpty()) {
            //물 확산
            int waterSize = water.size();
            for(int w = 0; w < waterSize; w++) {
                int wr = water.peek()[0];
                int wc = water.poll()[1];

                for(int i = 0; i < 4; i++) {
                    int nwr = wr + dr[i];
                    int nwc = wc + dc[i];

                    if(outOfRange(nwc, nwr)) continue;
                    if(map[nwr][nwc] == 'X' || map[nwr][nwc] == 'D' || map[nwr][nwc] == '*') continue;

                    map[nwr][nwc] = '*';
                    water.add(new int[]{nwr, nwc});
                }
            }

            //고슴도치 이동
            int moveSize = move.size();
            for(int m = 0; m < moveSize; m++) {
                int mr = move.peek()[0];
                int mc = move.peek()[1];
                int mm = move.poll()[2];

                for(int i = 0; i < 4; i++) {
                    int nmr = mr + dr[i];
                    int nmc = mc + dc[i];

                    if(outOfRange(nmc, nmr)) continue;
                    if(map[nmr][nmc] == 'X' || map[nmr][nmc] == '*' || moveVisit[nmr][nmc]) continue;

                    if(map[nmr][nmc] == 'D') {
                        RESULT = String.valueOf(mm + 1);
                        return;
                    }

                    move.add(new int[]{nmr, nmc, mm + 1});
                    moveVisit[nmr][nmc] = true;
                }
            }
            //더이상 이동할 곳이 없으면 종료
            if(move.isEmpty()) return;
        }
    }

    public static boolean outOfRange(int c, int r) {
        return c < 0 || r < 0 || c >= C || r >= R;
    }
}