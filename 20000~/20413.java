package solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new Main().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        char[] grade = new char[count];
        String[] input = br.readLine().split(" ");
        int silver = Integer.parseInt(input[0]);
        int gold = Integer.parseInt(input[1]);
        int platinum = Integer.parseInt(input[2]);
        int diamond = Integer.parseInt(input[3]);

        String str = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            grade[i] = str.charAt(i);
        }

        int result = 0;
        int current = 0;
        for (int i = 0; i < grade.length; i++) {
            if (grade[i] == 'B') {
                current = (silver - 1) - current;
            } else if (grade[i] == 'S') {
                current = (gold - 1) - current;
            } else if (grade[i] == 'G') {
                current = (platinum - 1) - current;
            } else if (grade[i] == 'P') {
                current = (diamond - 1) - current;
            } else if (grade[i] == 'D') {
                current = diamond;
            }

            result += current;
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}