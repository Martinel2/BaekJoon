import java.io.*;
import java.util.*;

public class Vertical {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] st = new String[5];
        int max = 0;
        for (int i = 0; i < 5; i++) {
            st[i] = reader.readLine();
            max = Math.max(max, st[i].length());//�ִ���� 
        }
        String ans = "";
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < 5; j++) {
                if (st[j].length() > i)//���ڿ��� ���̰� �� ���� ��ȯ����
                    ans += st[j].charAt(i);//**���� ��ȯ
            }
        }
        writer.write(ans + "\n");

        writer.flush();
        reader.close();
        writer.close();
    }
}

