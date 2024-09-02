package solved;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        N = Math.abs(N);
        M = Math.abs(M);
        
        if (N == 0 && M == 0) {
            System.out.println(0);
        } else if (GCD(N, M) == 1) {
            System.out.println(1);
        } else {
            System.out.println(2);
        }
    }

    // GCD 함수 (최대 공약수 구하기)
    public static int GCD(int a, int b) {
        if (b == 0) return a;
        return GCD(b, a % b);
    }
}
