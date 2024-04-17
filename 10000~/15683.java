package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 백준온라인저지 15683번 감시문제 Java풀이
public class Main {
    // 결과값 저장변수, 최솟값을 저장해야하므로 99999로 초기화
    static int result = 99999;

    public static void main(String[] args) throws IOException {

        // 입력정보 받을 객체
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 사무실 크기 정보 받기
        String[] mapSize = br.readLine().split(" ");

        // 사무실 세로 크기
        int N = Integer.parseInt(mapSize[0]);
        // 사무실 가로 크기
        int M = Integer.parseInt(mapSize[1]);
        // 사무실 사이즈로 배열 생성
        int[][] map = new int[N][M];

        // 사무실에 있는 cctv저장 리스트
        List<CCTV> cctvList = new ArrayList<>();

        // 사무실을 정보받아서 배열 초기화
        for (int i = 0; i < N; i++) {
            String[] mapInfo = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                int temp = Integer.parseInt(mapInfo[j]);
                map[i][j] = temp;
                // CCTV인 경우
                if (temp != 0 && temp != 6) {
                    // CCTV별로 감시하는 영역을 표시할 숫자를 다르게 생성성
                   int chkNum = Integer.parseInt("1" + String.valueOf(i) + String.valueOf(j));
                    // CCTV 생성 후 리스트에 저장
                    cctvList.add(new CCTV(temp, i, j, chkNum));
                }
            }
        }

        // CCTV감시 범위 체크를 재귀형태로 구현
        recursion(cctvList, 0, map);

        // 출력
        System.out.println(result);
    }

    // CCTV 클래스
    static class CCTV {
        // CCTV 번호
        int no;
        // CCTV의 좌표 행
        int r;
        // CCTV의 좌표 열
        int c;
        // CCTV마다 고유한 감시번호
        // 예를들어 CCTV가 감시한 곳을 # 과같은 걸로 표시하면 중복으로 감시되는 위치를 파악할 수 없음
        // 그러므로 해당 CCTV가 감시한 곳은 고유번호로 체크
        int chkNum;

        // CCTV를 생성할 때 각 변수들 초기화
        public CCTV(int no, int r, int c, int chkNum) {
            this.no = no;
            this.r = r;
            this.c = c;
            this.chkNum = chkNum;
        }
    }

    /**
     * CCTV들이 감시하는 모든 경우의 수를 체크 하기 위한 재귀메서드
     * @param cctvList : 사무실에 있는 CCTV리스트
     * @param index : CCTV리스트에 사용할 인덱스
     * @param map : 사무실을 표현한 2차원 배열
     */
    static void recursion(List<CCTV> cctvList, int index, int[][] map) {
        // 재귀메서드 진행 중 CCTV 리스트의 사이즈랑 인덱스가 같다면
        // 모든 CCTV의 방향이 정해진 상태이므로 사각지대 체크
        if(index >= cctvList.size()){
            int tempResult = 0;
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    if (map[i][j] == 0) {
                        tempResult ++;
                    }
                }
            }
            // 여러가지 경우의 수 중에서 사각지대가 가장 적은 값으로 저장 후 메서드 종료
            result = Math.min(tempResult, result);
            return;
        }

        // CCTV리스트에서 CCTV가져오기
        CCTV cctv = cctvList.get(index);

        // CCTV는 동서남북 4방향으로 회전 할 수 있으므로
        // 4방향 모두 감시가능한 곳을 체크 해야함
        // 0:북, 1:서, 2:남, 3:동
        for (int d = 0; d < 4; d++) {
            // CCTV 감시가능한 곳 체크
            cctvChk(cctv.no, cctv.r, cctv.c ,d, map, cctv.chkNum);

            // 재귀메서드 실행
            // CCTV리스트에서 다음 CCTV를 꺼낼 수 있도록 인덱스 +1 증가
            recursion(cctvList, index+1, map);

            // CCTV 감시했던 곳 해제
            // 2차원 배열 1개로 계속 사용하기 위해 감시한 곳 다시 빈칸으로 변경
            // 이때, CCTV끼리 중복으로 감시가능한 곳이 있을 것이기 때문에
            // CCTV별 고유감시번호로 확인을 해서 중복난 곳을 빈칸으로 바꾸지 않도록 구현
            cctvChk(cctv.no, cctv.r, cctv.c ,d, map, cctv.chkNum);
        }
    }

    /**
     * CCTV 감시범위 체크 메서드
     * @param no : CCTV 번호
     * @param r : CCTV가 있는 행
     * @param c : CCTV가 있는 열
     * @param d : CCTV가 감시하는 방향
     * @param map : 사무실의 정보를 가진 2차원 배열
     * @param chk : CCTV별 고유 감시번호
     */
    static void cctvChk(int no, int r, int c, int d, int[][] map, int chk) {
        // 1번 CCTV인 경우
        if (no == 1) {
            // 감시 가능한 곳 체크
            chk(r, c, d, chk, map);
        }
        // 2번 CCTV인 경우
        else if (no == 2) {
            // 2번 CCTV의 경우 세로 또는 가로로 감시가 가능하므로 2가지의 방향을 모두 구함
            int D1 = d;
            int D2 = d+2 == 4 ? 0 : d+2 == 5 ? 1 : d+2;

            // 방향 별 감시 가능한 곳 체크
            chk(r, c, D1, chk, map);
            chk(r, c, D2, chk, map);
        }
        // 3번 CCTV인 경우
        else if (no == 3) {
            // 3번 CCTV의 경우 ㄱ이나 ㄴ자 형태로 감시가 가능하므로 2가지의 방향을 모두 구함
            int D1 = d;
            int D2 = d+1 == 4 ? 0 : d+1;

            // 방향 별 감시 가능한 곳 체크
            chk(r, c, D1, chk, map);
            chk(r, c, D2, chk, map);
        }
        // 4번 CCTV인 경우
        else if (no == 4) {
            // 4번 CCTV의 경우 ㅗ,ㅏ,ㅓ,ㅜ 형태로 감시가 가능하므로 3가지의 방향을 모두 구함
            int D1 = d;
            int D2 = d-1 == -1 ? 3 : d-1;
            int D3 = d+1 == 4 ? 0 : d+1;

            // 방향 별 감시 가능한 곳 체크
            chk(r, c, D1, chk, map);
            chk(r, c, D2, chk, map);
            chk(r, c, D3, chk, map);
        }
        // 5번 CCTV인 경우
        else {
            // 5번 CCTV는 동서남북 모두 감시 가능하므로 4방향 모두 체크
            // 방향을 따로 구하지 않는 이유는 모든 방향을 다 체크할 것이기 때문입니다.
            for (int i = 0; i < 4; i++) {
                // 방향 별 감시 가능한 곳 체크
                chk(r, c, i, chk, map);
            }
        }
    }

    /**
     * 감시카메라가 감시가능한 위치 감시번호로 체크하는 메서드
     * @param R : CCTV의 행
     * @param C : CCTV의 열
     * @param D : CCTV가 감시하는 방향
     * @param chkNum  : CCTV별 고유 감시번호
     * @param map  : 사무실의 정보를 가진 2차원 배열
     */
    static void chk(int R, int C, int D, int chkNum, int[][] map) {
        // 북 서 남 동으로 좌표 이동을 위해 사용할 배열
        int[] moveR = {-1, 0, 1, 0};
        int[] moveC = {0, -1, 0, 1};

        // 현재 좌표에 벽이 없는 경우
        while (map[R][C] != 6) {
            // 주어진 방향으로 이동하기 위해 좌표를 계산
            R = R + moveR[D];
            C = C + moveC[D];

            // 계산한 좌표가 배열을 벗어나는 경우는 사무실을 벗어난 것과 같음
            // 즉, 더이상 감시할 곳이 없으므로 반복문 종료
            if (R < 0 || R >= map.length || C < 0 || C >= map[0].length) {
                break;
            }else {
                // 계산한 좌표가 빈 공간인 경우 CCTV별 고유감시번호로 배열의 값 변경
                if (map[R][C] == 0) {
                    // 고유감시번호로 배열의 값을 바꾼 건 현재 해당 CCTV가 감시중이라는 뜻임
                    map[R][C] = chkNum;
                }

                // 방향을 바꿔가면서 감시 가능한 곳을 체크하고 있으므로 체크한 곳 해제를 위해 사용
                // CCTV가 서로 중복해서 감시 가능한 곳이 있을 것이기 떄문에
                // 본인이 감시한 곳만 해제하기 위해 고유감시번호로 확인합니다.
                else if (map[R][C] == chkNum) {
                    map[R][C] = 0;
                }
            }
        }
    }
}