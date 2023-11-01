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

        member = Integer.parseInt(st.nextToken()); //ȸ�� �� �� �޴´�.
        value = Integer.parseInt(st.nextToken()); // ġŲ�� ������ �޴´�.

        array = new int[member][value]; //3�� 5���� �������.
        check = new boolean[value]; // ������ ���� ����̱⿡ �ߺ����� �ʵ��� üũ �迭�� ����.

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
        //ġŲ�� ī���Ͱ� 3�� �Ǿ��� ��
        if(count == 3){

            int sum = 0;
            for(int i=0; i<member;i++){
                int chicken = 0;
                for(int j=0; j<value;j++){
                    if(check[j]) {
                       chicken  = Math.max(chicken,array[i][j]); // �� ���� ���� ū ���� ����
                    }
                }
               sum = sum + chicken; // �� ���� ���� ū ������ �����ϰ� sum�� ����.
            }
            max = Math.max(max,sum); // sum�� �ִ����� �� ����.
            return;
        }
        //������ �⺻���� ����
        // ����Լ��� ���鼭 [False,False,False,False,Fase]�� ������ True .. True�� �ٲ��ָ鼭
        //�ߺ����� �ʴ� ������ ã�� �� �ֵ��� �ϰ� �����ִ� ����
        for(int i=0; i<value;i++){
            if(check[i] == false){
                check[i] = true;
                dfs(count +1);
                check[i] = false;
            }
        }
    }
}