package solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        Combat[] combatArray = new Combat[n];
        for (int i = 0; i < combatArray.length; i++) {
            input = br.readLine().split(" ");
            combatArray[i] = new Combat(input[0], Long.parseLong(input[1]));
        }

        for (int i = 0; i < m; i++) {
            long combatScore = Long.parseLong(br.readLine());

            int start = 0;
            int end = n;
            // lowerBound
            while (start < end) {
                int mid = (start + end) / 2;

                if (combatScore > combatArray[mid].combatScore) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }

            bw.write(combatArray[start].style + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

class Combat {
    String style;
    long combatScore;

    public Combat(String style, long combatScore) {
        this.style = style;
        this.combatScore = combatScore;
    }
}