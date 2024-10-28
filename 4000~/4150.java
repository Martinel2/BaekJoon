package solved;

import java.util.Scanner;
import java.math.BigInteger;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 정수 n 입력
        int n = sc.nextInt();
        
        // 입력된 정수에 해당하는 피보나치 수 계산
        BigInteger fibN = fibonacci(n);
        
        // 계산된 피보나치 수 출력
        System.out.println(fibN);
    }
    
    // 피보나치 수 계산하는 메서드
    private static BigInteger fibonacci(int n) {
        // n이 1 또는 2일 경우, 1을 반환
        if (n == 1 || n == 2) {
            return BigInteger.ONE;
        }
        
        // 피보나치 수 계산을 위한 BigInteger 변수 선언
        BigInteger a = BigInteger.ONE; // 첫 번째 항
        BigInteger b = BigInteger.ONE; // 두 번째 항
        BigInteger c = BigInteger.ZERO; // 세 번째 항
        
        // 세 번째 항부터 n번째 항까지 계산
        for (int i = 3; i <= n; i++) {
            c = a.add(b); // 현재 항은 이전 두 항의 합
            a = b; // 다음 반복에서 이전의 두 번째 항이 첫 번째 항이 되도록 업데이트
            b = c; // 다음 반복에서 현재 항이 두 번째 항이 되도록 업데이트
        }
        
        // n번째 피보나치 수 반환
        return c;
    }
}
