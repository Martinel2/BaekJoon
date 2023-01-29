import java.io.*;

//17478 ����Լ��� ������?
public class Main {
	static StringBuilder sb = new StringBuilder();
	
	static void recur(int now, int end) {
		if(now == 0) {
			sb.append("��� �� ��ǻ�Ͱ��а� �л��� ������ �������� ã�ư� ������.\n");
		}
		if(now < end) {
			for(int j = 0; j<now; j++) {
				sb.append("____");
			}
			sb.append("\"����Լ��� ������?\"\n");
			
			for(int j = 0; j<now; j++) {
				sb.append("____");
			}
			sb.append("\"�� ����. �������� �� �� ����⿡ �̼��� ��� ������ ����� ������ �־���.\n");
			
			for(int j = 0; j<now; j++) {
				sb.append("____");
			}
			sb.append("���� ������� ��� �� ���ο��� ������ ������ �߰�, ��� �����Ӱ� ����� �־���.\n");
			
			for(int j = 0; j<now; j++) {
				sb.append("____");
			}
			sb.append("���� ���� ��κ� �ǾҴٰ� �ϳ�. �׷��� ��� ��, �� ���ο��� �� ���� ã�ƿͼ� ������.\"\n");
			
			recur(now+1, end);
		}
		else {
			for(int j = 0; j<now; j++) {
				sb.append("____");
			}
			sb.append("\"����Լ��� ������?\"\n");
			for(int j = 0; j<now; j++) {
				sb.append("____");
			}
			sb.append("\"����Լ��� �ڱ� �ڽ��� ȣ���ϴ� �Լ����\"\n");
		}
		for(int j = 0; j<now; j++) {
			sb.append("____");
		}
		sb.append("��� �亯�Ͽ���.\n");
	}
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int N = Integer.parseInt(br.readLine());
		recur(0,N);
		System.out.print(sb);
	
	}
}