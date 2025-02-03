package solved;

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        System.out.println(solution());
    }

    public static int solution(){
        Scanner scan = new Scanner(System.in);
        return solution(scan.next());
    }
    public static int solution(String input){
        int len = input.length();
        int count1 = countPattern(input, "KSA");
        int count2 = countPattern(input, "SAK");
        if(count2 == len) count2--;
        int count3 = countPattern(input, "AKS");
        if(count3 >= len-1) count3 = len-2;
        int max = Math.max(count1, Math.max(count2, count3));
        int answer = 2*(len-max);
        return answer;
    }
    public static int countPattern(String str, String pattern){
        int index = 0, count = 0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == pattern.charAt(index)){
                index++; count++;
                if(index == pattern.length()) index = 0;
            }
        }
        return count;
    }
}