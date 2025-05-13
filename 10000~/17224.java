package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;


class Quiz {
    int easy;
    int dif;

    public Quiz(int easy, int dif) {
        this.easy = easy;
        this.dif = dif;
    }

}

public class Main {


    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken()); // 역량
        int K = Integer.parseInt(st.nextToken()); // 최대 문제 풀이

        ArrayList<Quiz> arrayList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arrayList.add(new Quiz(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(arrayList, new Comparator<Quiz>() {
            @Override
            public int compare(Quiz o1, Quiz o2) {
                if (o1.dif == o2.dif) {
                    return o1.easy - o2.easy;
                } else
                    return o1.dif - o2.dif;
            }
        });

        int result = 0;
        for (int i = 0; i < N; i++) {
            Quiz temp = arrayList.get(i);

            if (K > 0) {
                if (temp.dif <= L) {
                    result += 140;
                    K--;
                } else if (temp.easy <= L) {
                    result += 100;
                    K--;
                }
            } else
                break;
        }
        System.out.println(result);

    }
}