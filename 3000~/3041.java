package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
    public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
        int answer = 0;

        for (int i = 0; i < 4; i++) {
            String input = br.readLine();

            for (int j = 0; j < 4; j++) {
                char current = input.charAt(j);

                if(current == '.') continue;

                int number = current - 'A';

                int x = number / 4;
                int y = number % 4;

                // 각 입력받은 정사각형의 위치와 원래의 위치 거리를 계산한다.
                answer += Math.abs(i - x) + Math.abs(j - y);
            }
        }

        System.out.println(answer);
		
    }
}
