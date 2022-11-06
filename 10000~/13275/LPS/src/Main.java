import java.io.*;


//14444,13275 가장 긴 팰린드롬 부분 문자열
public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		s = "." + String.join(".", s.split("")) + "."; //짝수길이를 홀수길이로 바꾸어줌
		int n = s.length();
		
		int[] radius = new int[n];
        int max = 0;
        int rightIdx = 0; // 최장 팰린드롬의 우측 끝 인덱스
        int centerIdx = 0; // 최장 팰린드롬의 중심 인덱스

        for (int i = 0; i < n; i++) {
            // (1) 팰린드롬 탐색 범위를 최대한 줄여보자 (DP)
            if (i <= rightIdx) { // i <= r 이면 (= 현재 위치의 글자가 최장 팰린드롬의 범위에 속하면)
                // radius[i] (= 현재 글자를 중심으로 하는 최장 팰린드롬의 반지름 길이는)
                //   1-1. 최장 팰린드롬 중심 p 기준의 대칭점 2*p-i 의 반지름의 길이 또는
                //   1-2. r - i (= 최장 팰린드롬의 우측 끝인 r 과 현위치의 거리차이) 중 짧은 것
                radius[i] = Math.min(radius[2 * centerIdx - i], rightIdx - i);
            }
            // (2) 현 위치에서 양옆으로 뻗어가며 팰린드롬을 반지름 측정
            while (0 <= i - radius[i] - 1 && i + radius[i] + 1 < n
                    && s.charAt(i - radius[i] - 1) == s.charAt(i + radius[i] + 1)) {
            	radius[i]++;
            }
            if(max < radius[i])
            	max = radius[i];
            // (3) 기존보다 더 긴 팰린드롬이 발견됐다면 rightIdx, centerIdx 값 갱신
            if (rightIdx < i + radius[i]) {
                rightIdx = i + radius[i]; // 최장 팰린드롬 끝점 갱신
                centerIdx = i; // 최장 팰린드롬 중심 갱신
            }
        }
        System.out.println(max);
	}
}