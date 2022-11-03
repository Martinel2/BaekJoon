package pqbd;

import java.io.*;
import java.util.*;


//25582 pqbd
public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] mirror = new char[130];
		char[] turn = new char[130];
		
		//거울 대칭/점대칭 채우기
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
		// i번째 문자를 중심으로 하는 가장 긴 팰린드롬의 반지름
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
                    && s.charAt(i - radius[i] - 1) == mirror[s.charAt(i + radius[i] + 1)] && mirror[s.charAt(i)] == s.charAt(i)) {
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
        rightIdx = 0; // 최장 팰린드롬의 우측 끝 인덱스
        centerIdx = 0; // 최장 팰린드롬의 중심 인덱스
        Arrays.fill(radius, 0);    
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
	    			&& s.charAt(i - radius[i] - 1) == turn[s.charAt(i + radius[i] + 1)] && turn[s.charAt(i)] == s.charAt(i)) {
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
	    if(max == 0)
	    	System.out.println("NOANSWER");
	    else
	    	System.out.println(max);
	}
}
