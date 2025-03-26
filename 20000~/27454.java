package solved;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        bw.append(String.valueOf(multiply(1, n)));
        bw.flush();
        bw.close();
        br.close();
    }

    static BigInteger multiply(int start, int end) {

        BigInteger result = new BigInteger(String.valueOf(start));
        if (start < end) {
            int mid = (start + end) / 2;
            result = multiply(start, mid).multiply(multiply(mid + 1, end));
        }
        return result;
    }
}