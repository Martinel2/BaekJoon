package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<Integer> numbers = new ArrayList<>();
    static int first=1;
    static int second=1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        // 두 번째 답 찾기
        st = new StringTokenizer(br.readLine());
        //N 앞에 몇개 있냐 = Math(2,second) 값이다.
        int count = 0;
        boolean isNPassed = false; 
        for(int i=0; i<N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if(!isNPassed && temp != N) {
                count++;
            }

            if(temp == N) {
                isNPassed = true;
            }

            numbers.add(temp);
        }


        while(count != Math.pow(2, second)) {
            second++;
        }

        // 첫 번째 형태로 복원하기
        for(int i=0; i<=second; i++) {
            // 앞에서 뽑을 갯수
            int removeNum = (int)Math.pow(2, i);

            // 삽입할 index => 왜냐면 2^n에서 뒤에 2^(n-1)개 앞으로 보내는 거라서
            int insertIndex = -1;
            if(i == second) { // 마지막은 그냥 맨 끝으로 보내는 거임
                insertIndex = N;
            } else {
                insertIndex = (int)Math.pow(2,i+1);
            }

            for(int j=0; j<removeNum; j++) {
                int temp = numbers.remove(0);
                numbers.add(insertIndex-1, temp); //insertIndex-1은 하나 앞에서 뺐으니까 index도 하나 제거해주는 것
            }
        }

        //System.out.println(numbers);
        // first
        // 1 앞에 몇 개 있냐가 Math.pow(2, first);

        count = 0;
        for(int i=0; i<N; i++) {
            if(numbers.get(i) == 1) {
                break;
            }
            count++;
        }

        while(count != Math.pow(2, first)) {
            first++;
        }

        System.out.println(first+" "+second);
    }
 }