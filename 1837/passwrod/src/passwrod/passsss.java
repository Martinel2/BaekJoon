package passwrod;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class passsss {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BigInteger P = new BigInteger(st.nextToken());
		BigInteger K = new BigInteger(st.nextToken());
		//��� 1�� �������� ���� ����
		BigInteger i = new BigInteger("1");
		
		//��� �ݺ����� ���� �� ���⿡ ���ѷ���
		while(true) {
			//i�� K���� ũ�ų� �������� GOOD ��� �׸��� �ݺ��� ����
			if(i.compareTo(K) == 1 || i.compareTo(K) == 0) {
				System.out.println("GOOD");
				break;
			}
			//�ѹ� �ݺ� �ɶ����� i�� 1���Ѵ�.
			i = i.add(BigInteger.ONE);
			
			//P�� i�� ��������, i�� K���� ������ BAD�� i���� ���. �ݺ��� ����
			if(P.remainder(i).compareTo(BigInteger.ZERO) == 0 && i.compareTo(K) == -1) {
				System.out.println("BAD " + i);
				break;
			}
		}
		
	}

}