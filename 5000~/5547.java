package solved;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] arr;
    static boolean[][] visited;
    static int x, y;
    static boolean check;
    static int ans, minus;

    // even : 홀수 odd : 짝수
    static final int[] evenDr = {-1, -1, 0, 0, 1, 1};
    static final int[] evenDc = {0, 1, -1, 1, 0, 1};
    static final int[] oddDr = {-1, -1, 0, 0, 1, 1};
    static final int[] oddDc = {-1, 0, 1, -1, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        arr = new int[x][y];
        ans = 0;
        minus = 0;
        visited = new boolean[x][y];
        for (int i = 0; i < x; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < y; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 가운데 껴있는 애들 다 1로 만들기
        makeNewArr();

        // 1인 친구들 세기, 기본 6개에서, 나와 마주한 친구들 만날 때 마다 -1 해주기
        visited = new boolean[x][y];
        checkAside();
        System.out.println(ans-minus);
    }
    
    
    private static void checkAside(){
        Queue<Node> q = new LinkedList<>();
        for (int r = 0; r < x; r++) {
            for (int c = 0; c < y; c++) {
                if(!visited[r][c] && arr[r][c] ==1){
                    // loc가 0이면 홀수 1이면 짝수
                    visited[r][c] = true;
                    ans +=6;
                    q.offer(new Node(r,c,r%2));
                    while (!q.isEmpty()) {
                        Node poll = q.poll();
                        if (poll.loc == 0) {
                            checkAside(evenDr, evenDc, poll.r, poll.c, q);
                        } else {
                            checkAside(oddDr, oddDc, poll.r, poll.c, q);
                        }
                    }
                }
            }
        }
    }
    private static void checkAside(int[] dr, int[] dc, int r, int c, Queue<Node> q) {
        for (int i = 0; i < 6; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr < 0 || nc < 0 || nr >= x || nc >= y || arr[nr][nc]==0) {
                continue;
            }
            if (!visited[nr][nc]) {
                visited[nr][nc] = true;
                ans+=6;
                minus+=1;
                q.offer(new Node(nr, nc, nr % 2));
            }else{
                minus+=1;
            }
        }
    }


    private static void checkSixdir(int[] dr, int[] dc, int r, int c, Queue<Node> checkSurround, Queue<Node> ChangeSurround) {
        for (int i = 0; i < 6; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr < 0 || nc < 0 || nr >= x || nc >= y) {
                check = false;
                continue;
            }
            if (!visited[nr][nc] && arr[nr][nc] == 0) {
                visited[nr][nc] = true;
                checkSurround.offer(new Node(nr, nc, nr % 2));
                ChangeSurround.offer(new Node(nr, nc, nr % 2));
            }
        }
    }


    private static void makeNewArr() {
        Queue<Node> checkSurround = new LinkedList<>();
        // 1로 바꿀 값 넣기
        Queue<Node> ChangeSurround = new LinkedList<>();
        for (int r = 0; r < x; r++) {
            for (int c = 0; c < y; c++) {
                // 아직 방문하지 않았고, 0인 값을 q에 넣는다.
                if (!visited[r][c] && arr[r][c] == 0) {
                    visited[r][c] = true;
                    check = true;
                    // loc가 0이면 홀수, loc가 1이면 짝수
                    checkSurround.offer(new Node(r, c, r % 2));
                    ChangeSurround.offer(new Node(r, c, r % 2));
                    while (!checkSurround.isEmpty()) {
                        Node poll = checkSurround.poll();
                        if (poll.loc == 0) {
                            checkSixdir(evenDr, evenDc, poll.r, poll.c, checkSurround, ChangeSurround);
                        } else {
                            checkSixdir(oddDr, oddDc, poll.r, poll.c, checkSurround, ChangeSurround);
                        }
                    }
                    if (check) {
                        while (!ChangeSurround.isEmpty()) {
                            Node poll = ChangeSurround.poll();
                            arr[poll.r][poll.c] = 1;
                        }
                    } else {
                        ChangeSurround.clear();
                    }

                }
            }
        }
    }

    private static void DFS(int r, int c) {

    }

    private static class Node {
        int r;
        int c;
        int loc;

        public Node(int r, int c, int loc) {
            this.r = r;
            this.c = c;
            this.loc = loc;
        }
    }
}