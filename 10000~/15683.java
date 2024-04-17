package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// ���ؿ¶������� 15683�� ���ù��� JavaǮ��
public class Main {
    // ����� ���庯��, �ּڰ��� �����ؾ��ϹǷ� 99999�� �ʱ�ȭ
    static int result = 99999;

    public static void main(String[] args) throws IOException {

        // �Է����� ���� ��ü
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // �繫�� ũ�� ���� �ޱ�
        String[] mapSize = br.readLine().split(" ");

        // �繫�� ���� ũ��
        int N = Integer.parseInt(mapSize[0]);
        // �繫�� ���� ũ��
        int M = Integer.parseInt(mapSize[1]);
        // �繫�� ������� �迭 ����
        int[][] map = new int[N][M];

        // �繫�ǿ� �ִ� cctv���� ����Ʈ
        List<CCTV> cctvList = new ArrayList<>();

        // �繫���� �����޾Ƽ� �迭 �ʱ�ȭ
        for (int i = 0; i < N; i++) {
            String[] mapInfo = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                int temp = Integer.parseInt(mapInfo[j]);
                map[i][j] = temp;
                // CCTV�� ���
                if (temp != 0 && temp != 6) {
                    // CCTV���� �����ϴ� ������ ǥ���� ���ڸ� �ٸ��� ������
                   int chkNum = Integer.parseInt("1" + String.valueOf(i) + String.valueOf(j));
                    // CCTV ���� �� ����Ʈ�� ����
                    cctvList.add(new CCTV(temp, i, j, chkNum));
                }
            }
        }

        // CCTV���� ���� üũ�� ������·� ����
        recursion(cctvList, 0, map);

        // ���
        System.out.println(result);
    }

    // CCTV Ŭ����
    static class CCTV {
        // CCTV ��ȣ
        int no;
        // CCTV�� ��ǥ ��
        int r;
        // CCTV�� ��ǥ ��
        int c;
        // CCTV���� ������ ���ù�ȣ
        // ������� CCTV�� ������ ���� # ������ �ɷ� ǥ���ϸ� �ߺ����� ���õǴ� ��ġ�� �ľ��� �� ����
        // �׷��Ƿ� �ش� CCTV�� ������ ���� ������ȣ�� üũ
        int chkNum;

        // CCTV�� ������ �� �� ������ �ʱ�ȭ
        public CCTV(int no, int r, int c, int chkNum) {
            this.no = no;
            this.r = r;
            this.c = c;
            this.chkNum = chkNum;
        }
    }

    /**
     * CCTV���� �����ϴ� ��� ����� ���� üũ �ϱ� ���� ��͸޼���
     * @param cctvList : �繫�ǿ� �ִ� CCTV����Ʈ
     * @param index : CCTV����Ʈ�� ����� �ε���
     * @param map : �繫���� ǥ���� 2���� �迭
     */
    static void recursion(List<CCTV> cctvList, int index, int[][] map) {
        // ��͸޼��� ���� �� CCTV ����Ʈ�� ������� �ε����� ���ٸ�
        // ��� CCTV�� ������ ������ �����̹Ƿ� �簢���� üũ
        if(index >= cctvList.size()){
            int tempResult = 0;
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    if (map[i][j] == 0) {
                        tempResult ++;
                    }
                }
            }
            // �������� ����� �� �߿��� �簢���밡 ���� ���� ������ ���� �� �޼��� ����
            result = Math.min(tempResult, result);
            return;
        }

        // CCTV����Ʈ���� CCTV��������
        CCTV cctv = cctvList.get(index);

        // CCTV�� �������� 4�������� ȸ�� �� �� �����Ƿ�
        // 4���� ��� ���ð����� ���� üũ �ؾ���
        // 0:��, 1:��, 2:��, 3:��
        for (int d = 0; d < 4; d++) {
            // CCTV ���ð����� �� üũ
            cctvChk(cctv.no, cctv.r, cctv.c ,d, map, cctv.chkNum);

            // ��͸޼��� ����
            // CCTV����Ʈ���� ���� CCTV�� ���� �� �ֵ��� �ε��� +1 ����
            recursion(cctvList, index+1, map);

            // CCTV �����ߴ� �� ����
            // 2���� �迭 1���� ��� ����ϱ� ���� ������ �� �ٽ� ��ĭ���� ����
            // �̶�, CCTV���� �ߺ����� ���ð����� ���� ���� ���̱� ������
            // CCTV�� �������ù�ȣ�� Ȯ���� �ؼ� �ߺ��� ���� ��ĭ���� �ٲ��� �ʵ��� ����
            cctvChk(cctv.no, cctv.r, cctv.c ,d, map, cctv.chkNum);
        }
    }

    /**
     * CCTV ���ù��� üũ �޼���
     * @param no : CCTV ��ȣ
     * @param r : CCTV�� �ִ� ��
     * @param c : CCTV�� �ִ� ��
     * @param d : CCTV�� �����ϴ� ����
     * @param map : �繫���� ������ ���� 2���� �迭
     * @param chk : CCTV�� ���� ���ù�ȣ
     */
    static void cctvChk(int no, int r, int c, int d, int[][] map, int chk) {
        // 1�� CCTV�� ���
        if (no == 1) {
            // ���� ������ �� üũ
            chk(r, c, d, chk, map);
        }
        // 2�� CCTV�� ���
        else if (no == 2) {
            // 2�� CCTV�� ��� ���� �Ǵ� ���η� ���ð� �����ϹǷ� 2������ ������ ��� ����
            int D1 = d;
            int D2 = d+2 == 4 ? 0 : d+2 == 5 ? 1 : d+2;

            // ���� �� ���� ������ �� üũ
            chk(r, c, D1, chk, map);
            chk(r, c, D2, chk, map);
        }
        // 3�� CCTV�� ���
        else if (no == 3) {
            // 3�� CCTV�� ��� ���̳� ���� ���·� ���ð� �����ϹǷ� 2������ ������ ��� ����
            int D1 = d;
            int D2 = d+1 == 4 ? 0 : d+1;

            // ���� �� ���� ������ �� üũ
            chk(r, c, D1, chk, map);
            chk(r, c, D2, chk, map);
        }
        // 4�� CCTV�� ���
        else if (no == 4) {
            // 4�� CCTV�� ��� ��,��,��,�� ���·� ���ð� �����ϹǷ� 3������ ������ ��� ����
            int D1 = d;
            int D2 = d-1 == -1 ? 3 : d-1;
            int D3 = d+1 == 4 ? 0 : d+1;

            // ���� �� ���� ������ �� üũ
            chk(r, c, D1, chk, map);
            chk(r, c, D2, chk, map);
            chk(r, c, D3, chk, map);
        }
        // 5�� CCTV�� ���
        else {
            // 5�� CCTV�� �������� ��� ���� �����ϹǷ� 4���� ��� üũ
            // ������ ���� ������ �ʴ� ������ ��� ������ �� üũ�� ���̱� �����Դϴ�.
            for (int i = 0; i < 4; i++) {
                // ���� �� ���� ������ �� üũ
                chk(r, c, i, chk, map);
            }
        }
    }

    /**
     * ����ī�޶� ���ð����� ��ġ ���ù�ȣ�� üũ�ϴ� �޼���
     * @param R : CCTV�� ��
     * @param C : CCTV�� ��
     * @param D : CCTV�� �����ϴ� ����
     * @param chkNum  : CCTV�� ���� ���ù�ȣ
     * @param map  : �繫���� ������ ���� 2���� �迭
     */
    static void chk(int R, int C, int D, int chkNum, int[][] map) {
        // �� �� �� ������ ��ǥ �̵��� ���� ����� �迭
        int[] moveR = {-1, 0, 1, 0};
        int[] moveC = {0, -1, 0, 1};

        // ���� ��ǥ�� ���� ���� ���
        while (map[R][C] != 6) {
            // �־��� �������� �̵��ϱ� ���� ��ǥ�� ���
            R = R + moveR[D];
            C = C + moveC[D];

            // ����� ��ǥ�� �迭�� ����� ���� �繫���� ��� �Ͱ� ����
            // ��, ���̻� ������ ���� �����Ƿ� �ݺ��� ����
            if (R < 0 || R >= map.length || C < 0 || C >= map[0].length) {
                break;
            }else {
                // ����� ��ǥ�� �� ������ ��� CCTV�� �������ù�ȣ�� �迭�� �� ����
                if (map[R][C] == 0) {
                    // �������ù�ȣ�� �迭�� ���� �ٲ� �� ���� �ش� CCTV�� �������̶�� ����
                    map[R][C] = chkNum;
                }

                // ������ �ٲ㰡�鼭 ���� ������ ���� üũ�ϰ� �����Ƿ� üũ�� �� ������ ���� ���
                // CCTV�� ���� �ߺ��ؼ� ���� ������ ���� ���� ���̱� ������
                // ������ ������ ���� �����ϱ� ���� �������ù�ȣ�� Ȯ���մϴ�.
                else if (map[R][C] == chkNum) {
                    map[R][C] = 0;
                }
            }
        }
    }
}