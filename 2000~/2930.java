package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static int getScore(char sang, char friend) {
        if(sang == friend) {
            return 1;
        }
        
        switch (sang) {
            case 'R':
                return friend == 'S' ? 2 : 0;
            case 'P':
                return friend == 'R' ? 2 : 0;
            case 'S':
                return friend == 'P' ? 2 : 0;
            default:
                return 0;
        }
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int round = Integer.parseInt(br.readLine());
        String sang = br.readLine();
        int friendsNumber = Integer.parseInt(br.readLine());
        String[] friendArr = new String[friendsNumber];

        for(int i = 0; i<friendsNumber; i++) {
            friendArr[i] = br.readLine();
        }

        int normalScore = 0;
        int bestScore = 0;

        for (int i = 0; i < round; i++) {
            int r = 0;
            int p = 0;
            int c = 0;

            for (int j = 0; j < friendsNumber; j++) {
                char friendChar = friendArr[j].charAt(i);
                normalScore += getScore(sang.charAt(i), friendChar);
                r += getScore('R', friendChar);
                p += getScore('P', friendChar);
                c += getScore('S', friendChar);
            }

            bestScore += Math.max(Math.max(r, p), c);
        }

        System.out.println(normalScore);
        System.out.println(bestScore);
	}
}