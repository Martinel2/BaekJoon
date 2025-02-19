package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;
 
public class Main {		

    private static int calc(char ch) {
        if (ch == 'C') {
            return 12;
        } else if (ch == 'H') {
            return 1;
        } else {
            return 16;
        }
    } // End of calc()
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st;
		
		char[] chArr = br.readLine().toCharArray();
		int ans = 0;
		
		int N = chArr.length;
        int i = 0;
        ArrayDeque<Integer> que = new ArrayDeque<>();

        while (i < N) {
            char ch = chArr[i];

            if (ch == '(') {
                que.addLast(-1);
                i++;
            } else if (ch == ')') {
                int value = 0;
                while (!que.isEmpty() && que.getLast() != -1) {
                    value += que.removeLast();
                }

                while (!que.isEmpty() && que.getLast() == -1) {
                    que.removeLast();
                }

                i++;
                if (i < N && Character.isDigit(chArr[i])) {
                    value *= Character.getNumericValue(chArr[i]);
                }

                que.addLast(value);
            } else if (ch == 'C' || ch == 'H' || ch == 'O') {
                int value = calc(ch);

                i++;
                if (i < N && Character.isDigit(chArr[i])) {
                    value *= Character.getNumericValue(chArr[i]);
                }
                que.addLast(value);
            } else {
                i++;
            }
        }

        for (int num : que) {
            ans += num;
        }
        System.out.println(ans);
	}	
}