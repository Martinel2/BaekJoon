import java.util.Scanner;

class Main {
    private static int n; // ������ ��
    private static int m; // ģ�������� ��
    private static int[] answerNum; // ���� ģ�� ��ȣ
    private static int[] minDistance; // ģ�� �ִ� ���
    private static int[][] distance; // �ּҺ��(�ִܰŸ�)
    private static int INF = 5001;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        distance = new int[n + 1][n + 1];

        //�ʱ�ȭ
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) distance[i][j] = 0;
                else distance[i][j] = INF;
            }
        }

        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            distance[start][end] = 1;
            distance[end][start] = 1;
        }

        //�÷��̵� ���� �˰���
        floyd();
        
        //���
        int[] answer = new int[n + 1];
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= n; j++) {
                sum += distance[i][j];
            }
            answer[i] = sum;
            if (sum < min) {
                min = sum;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (answer[i] == min) {
                System.out.println(i);
                return;
            }
        }
    }

    private static void floyd() {
        for (int k = 1; k <= n; k++) { //���İ��� �߰� ���� ���
            for (int i = 1; i <= n; i++) { //���� ���
                for (int j = 1; j <= n; j++) { //���� ���
                    distance[i][j] = Math.min(distance[i][k] + distance[k][j], distance[i][j]); //�ִܰ�� �ʱ�ȭ
                }
            }
        }
    }
}
