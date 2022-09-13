import java.io.*;


public class Main{
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    int[][] arr = new int[101][10];
    //자릿수가 1일때 모두 1.
    for(int i = 1; i <= 9; i++) arr[1][i] = 1;

    //자릿수가 2이상일때, 0은 1밖에 못쓰고, 9는 8밖에 못씀.
    for(int i = 2; i <= n; i++){
      arr[i][0] = arr[i-1][1];
      arr[i][9] = arr[i-1][8];
      for(int j = 1; j <= 8; j++) {
    	  //0~9까지의 합
        arr[i][j] = (arr[i-1][j+1] + arr[i-1][j-1]) % 1000000000;
      }
    }
    int answer = 0;

    for(int i = 0; i <= 9; i++) {
      answer = (answer + arr[n][i]) % 1000000000;
    }

    bw.write(String.valueOf(answer));
    bw.flush();
    bw.close();
  }
}