import java.io.*;


//1213 �縰��Ҹ����
public class Main {
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] cntarr = new int[26];
		String s = br.readLine();
		int slen = s.length();
		for(int i = 0; i<slen; i++)
			cntarr[ s.charAt(i) - 'A' ]++;
		//Ȧ���� �ΰ��̻��̸� ���� �� ����
		int cnt = 0;
		int h=-1;
		for(int i = 0; i<26; i++){
			if(cntarr[i] % 2 != 0) {
				cnt++;
				h = i;
			}
			if(cnt>=2)
				break;
		}
		if(cnt>=2)
			System.out.println("I'm Sorry Hansoo");
		else{
			int divlen = 0;
			if(slen % 2 == 0)//��Ȯ�� ������ ������ Ȧ������ ���ĺ��� �־����
				divlen = slen/2;
			else
				divlen = slen/2+1;
			s = "";
			cnt = 0;
			for(int i = 0; i<26; i++){
				for(int j = 0; j < (int)(cntarr[i]/2); j++){
					s += (char)((int)'A' + i);
					//������ ������ Ȧ������ ���ĺ��� ����
					if(s.length() == divlen && h != -1){
						s += (char)((int)'A' + h);
						break;
					}
				}
				cnt += cntarr[i];
				if(s.length() == divlen) {
					break;
				}
				//Ȧ������ �������� 2�̻��̿��� ���������� ������ ���� ����
				if(cnt == slen) {
					s += (char)((int)'A' + h);
					break;
				}
			}
			//Ȧ������ �����Ҷ��� ������ ���ĺ��� �����ϰ� ������
			if(h != -1){
				for(int i = s.length()-2; i>=0; i--){
					s += s.charAt(i);
				}
			}
			//¦������ �������� �״�� ������
			else{
				for(int i = s.length()-1; i>=0; i--){
					s += s.charAt(i);
				}
			}
			System.out.println(s);
		}
	}
}