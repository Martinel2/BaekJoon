package chicken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int member;
    static int value;
    static  int[][] array;
    static boolean[] check;
    static int max;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        member = Integer.parseInt(st.nextToken()); //회원 수 를 받는다.
        value = Integer.parseInt(st.nextToken()); // 치킨의 종류를 받는다.

        array = new int[member][value]; //3행 5열을 만들어줌.
        check = new boolean[value]; // 순열의 접근 방법이기에 중복되지 않도록 체크 배열을 만듬.

        for(int i=0; i<member;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<value;j++){
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

                dfs(0);
        System.out.println(max);
    }
    public static void dfs(int count){
        //치킨의 카운터가 3이 되었을 때
        if(count == 3){

            int sum = 0;
            for(int i=0; i<member;i++){
                int chicken = 0;
                for(int j=0; j<value;j++){
                    if(check[j]) {
                       chicken  = Math.max(chicken,array[i][j]); // 행 마다 가장 큰 값을 저장
                    }
                }
               sum = sum + chicken; // 행 마다 가장 큰 값들을 저장하고 sum에 담음.
            }
            max = Math.max(max,sum); // sum의 최대합이 곧 답임.
            return;
        }
        //순열의 기본적인 구조
        // 재귀함수로 들어가면서 [False,False,False,False,Fase]인 값들을 True .. True로 바꿔주면서
        //중복되지 않는 값들을 찾을 수 있도록 하게 도와주는 로직
        for(int i=0; i<value;i++){
            if(check[i] == false){
                check[i] = true;
                dfs(count +1);
                check[i] = false;
            }
        }
    }
}