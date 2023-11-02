import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		char[][] keyboard = {{'q','w','e','r','t','y','u','i','o','p'}, 
							 {'a','s','d','f','g','h','j','k','l','0'},
							 {'z','x','c','v','b','n','m','0','0','0'}};
		
		HashSet<Character> lhand = new HashSet<>();
		HashSet<Character> rhand = new HashSet<>();
		int ans = 0;
		
		char l,r;
		
		st = new StringTokenizer(br.readLine());
		
		l = st.nextToken().charAt(0);
		r = st.nextToken().charAt(0);
		
		int lx=0,ly=0;
		int rx=0,ry=0;
		
		for(int i = 0; i<3; i++) {
			for(int j = 0; j<10; j++) {
				if(i < 2 && j < 5) 
					lhand.add(keyboard[i][j]);
				else if(j<4) 
					lhand.add(keyboard[i][j]);
				else
					rhand.add(keyboard[i][j]);
				
				if(keyboard[i][j] == l) {
					lx = j;
					ly = i;
				}
				if(keyboard[i][j] == r) {
					rx = j;
					ry = i;
				}
			}
		}
		
		String word = br.readLine();
		ans = word.length(); // 누르는 시간 미리 더하기
		
		for(int i = 0; i<word.length(); i++) {
			char a = word.charAt(i);
			
			Loop :for(int j = 0; j<3; j++) {
				for(int k = 0; k<10; k++) {
					if(a == keyboard[j][k]) {
						if(lhand.contains(a)) {
							int dis = Math.abs(ly - j) + Math.abs(lx - k);
							ans += dis; //손가락 이동시간
							lx = k;
							ly = j;
							break Loop;
						}
						if(rhand.contains(a)) {
							int dis = Math.abs(ry - j) + Math.abs(rx - k);
							ans += dis; //손가락 이동시간
							rx = k;
							ry = j;
							break Loop;
						}
					}
				}
			}
		}
		
		System.out.println(ans);
	}
}
