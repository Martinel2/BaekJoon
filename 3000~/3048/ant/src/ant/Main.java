package ant;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	private static int N1, N2, T;
	private static String s1;
	private static String s2;
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N1=sc.nextInt();
		N2=sc.nextInt();
		
		s1=sc.next();
		s2=sc.next();
		int lenS1=s1.length();
		int lenS2=s2.length();
		
		List<Integer> arr=new ArrayList<>();	// 첫번째 개미 그룹과 두번째 개미 그룹의 순서를 저장하는 리스트
		for(int i=0;i<N1;i++) arr.add(1);	// 첫번째 개미 그룹은 1을 저장(오른쪽으로 이동)
		for(int i=0;i<N2;i++) arr.add(0);	// 두번째 개미 그룹은 0을 저장(왼쪽으로 이동)
		String result="";
		T=sc.nextInt();
		if(T>=lenS1+lenS2) {	// 두 개미 그룹의 길이보다 T가 더 클 경우, 더 이상 점프할 경우가 없기 때문에 결과를 바로 출력
			for(int i=0;i<s2.length();i++) result+=s2.charAt(i);
			for(int i=s1.length()-1;i>=0;i--) result+=s1.charAt(i);
		} else {
			for(int i=0;i<T;i++) {
				for(int start=1;start<arr.size();start++) {
					if(arr.get(start-1)>arr.get(start)) {	// 다음 인덱스에 현재보다 작은 값이 저장되어 있는 경우, 반대방향으로 움직이는 개미가 있는 것이므로 점프를 한다.
						arr.set(start-1, 0);
						arr.set(start, 1);
						start++;
					}
				}
			}
			int idxS1=lenS1-1;
			int idxS2=0;
			for(int i=0;i<arr.size();i++) {
				if(arr.get(i)==1) {
					result+=s1.charAt(idxS1--);
				} else if(arr.get(i)==0) {
					result+=s2.charAt(idxS2++);
				}
			}
		}
		System.out.println(result);
	}
}
