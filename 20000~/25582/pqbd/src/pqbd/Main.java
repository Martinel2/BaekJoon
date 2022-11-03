package pqbd;

import java.io.*;
import java.util.*;


//25582 pqbd
public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] mirror = new char[130];
		char[] turn = new char[130];
		
		//�ſ� ��Ī/����Ī ä���
		mirror['b'] = 'd'; mirror['d'] = 'b'; mirror['i']='i'; mirror['m']='m'; 
		mirror['v']='v'; mirror['w']='w'; mirror['l']='l'; mirror['o']='o'; 
		mirror['x'] = 'x'; mirror['p'] = 'q'; mirror['q']='p'; mirror['.'] = '.';
		
		turn['l']='l'; turn['b']='q'; turn['d']='p'; turn['n']='u'; turn['o']='o';
		turn['p']='d'; turn['q']='b'; turn['s']='s'; turn['u']='n'; turn['x']='x';
		turn['z']='z'; turn['.']='.';
		//
		
		String s = br.readLine();
		s = "." + String.join(".", s.split("")) + ".";
		int n = s.length();
		// i��° ���ڸ� �߽����� �ϴ� ���� �� �Ӹ������ ������
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
                    && s.charAt(i - radius[i] - 1) == mirror[s.charAt(i + radius[i] + 1)] && mirror[s.charAt(i)] == s.charAt(i)) {
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
        rightIdx = 0; // ���� �Ӹ������ ���� �� �ε���
        centerIdx = 0; // ���� �Ӹ������ �߽� �ε���
        Arrays.fill(radius, 0);    
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
	    			&& s.charAt(i - radius[i] - 1) == turn[s.charAt(i + radius[i] + 1)] && turn[s.charAt(i)] == s.charAt(i)) {
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
	    if(max == 0)
	    	System.out.println("NOANSWER");
	    else
	    	System.out.println(max);
	}
}
