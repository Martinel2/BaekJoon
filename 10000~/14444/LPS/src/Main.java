import java.io.*;


//14444,13275 ���� �� �Ӹ���� �κ� ���ڿ�
public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		s = "." + String.join(".", s.split("")) + "."; //¦�����̸� Ȧ�����̷� �ٲپ���
		int n = s.length();
		
		int[] radius = new int[n];
        int max = 0;
        int rightIdx = 0; // ���� �Ӹ������ ���� �� �ε���
        int centerIdx = 0; // ���� �Ӹ������ �߽� �ε���

        for (int i = 0; i < n; i++) {
            // (1) �Ӹ���� Ž�� ������ �ִ��� �ٿ����� (DP)
            if (i <= rightIdx) { // i <= r �̸� (= ���� ��ġ�� ���ڰ� ���� �Ӹ������ ������ ���ϸ�)
                // radius[i] (= ���� ���ڸ� �߽����� �ϴ� ���� �Ӹ������ ������ ���̴�)
                //   1-1. ���� �Ӹ���� �߽� p ������ ��Ī�� 2*p-i �� �������� ���� �Ǵ�
                //   1-2. r - i (= ���� �Ӹ������ ���� ���� r �� ����ġ�� �Ÿ�����) �� ª�� ��
                radius[i] = Math.min(radius[2 * centerIdx - i], rightIdx - i);
            }
            // (2) �� ��ġ���� �翷���� ����� �Ӹ������ ������ ����
            while (0 <= i - radius[i] - 1 && i + radius[i] + 1 < n
                    && s.charAt(i - radius[i] - 1) == s.charAt(i + radius[i] + 1)) {
            	radius[i]++;
            }
            if(max < radius[i])
            	max = radius[i];
            // (3) �������� �� �� �Ӹ������ �߰ߵƴٸ� rightIdx, centerIdx �� ����
            if (rightIdx < i + radius[i]) {
                rightIdx = i + radius[i]; // ���� �Ӹ���� ���� ����
                centerIdx = i; // ���� �Ӹ���� �߽� ����
            }
        }
        System.out.println(max);
	}
}