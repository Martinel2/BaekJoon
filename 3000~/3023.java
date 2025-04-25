import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 마술사 이민혁
// 구현 문제
public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        // 배열 입력
        char[][] arr = new char[r][c];

        for (int i = 0; i < r; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        // 결과 배열
        char[][] resultArr = new char[r * 2][c * 2];

        // 좌우, 상하 대칭
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                // 좌우 대칭
                resultArr[i][j] = arr[i][j];
                resultArr[i][c * 2 - j - 1] = arr[i][j]; // 열 역순
                // 상하 대칭
                resultArr[r * 2 - i - 1][j] = arr[i][j];
                resultArr[r * 2 - i - 1][c * 2 - j - 1] = arr[i][j]; // 행 역순
            }
        }

        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken()) - 1;
        int b = Integer.parseInt(st.nextToken()) - 1;

        // 에러 표시
        resultArr[a][b] = resultArr[a][b] == '.' ? '#' : '.';

        StringBuilder answer = new StringBuilder(Arrays.deepToString(resultArr)
                .replace("[", "").replace(",", "").replace(" ", "").replace("]", "\n"));
        System.out.println(answer);
	}
}
