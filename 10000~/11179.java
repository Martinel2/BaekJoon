package solved;

import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    bw.write(String.valueOf(binaryToDecimal(toBinary(N))));

    bw.flush();
    br.close();
    bw.close();
  }

  static String toBinary(int n) {
    StringBuffer result = new StringBuffer();

    do {
      result.append(n % 2);
      n /= 2;
    } while (n > 0);

    return result.reverse().toString();
  }

  static int binaryToDecimal(String binary) {
    int result = 0;

    for (int i = 0; i < binary.length(); i++) {
      result += (binary.charAt(i) - '0') * Math.pow(2, i);
    }

    return result;
  }
}