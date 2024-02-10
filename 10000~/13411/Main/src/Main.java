import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int i, n = Integer.parseInt(in.readLine());
		Robot r[] = new Robot[n];
		StringTokenizer st;
		for(i=0;i<n;i++){
			st = new StringTokenizer(in.readLine());
			r[i] = new Robot(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(r, new Comparator<Robot>(){
			public int compare(Robot r1, Robot r2) {
				double t1 = r1.getTime();
				double t2 = r2.getTime();
				if(t1==t2){
					int n1 = r1.getNum();
					int n2 = r2.getNum();
					return n1>n2?1:(n1<n2?-1:0);
				}
				return t1>t2?1:(t1<t2?-1:0);
			}
		});
		for(i=0;i<n;i++){
			out.write(String.valueOf(r[i].getNum()+1));
			out.newLine();
		}
		out.close();
		in.close();
	}
}
class Robot{
	private int num;
	private double time;
	public Robot(int num, int x, int y, int v) {
		this.num = num;
		this.time = Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2))/v;
	}
	public double getTime(){ return time; }
	public int getNum(){ return num; }
}
