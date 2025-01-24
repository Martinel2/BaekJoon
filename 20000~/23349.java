package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
    	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        HashMap<String, int[]> hm = new HashMap<>();
        ArrayList<String> al = new ArrayList<>();
        for(int i = 0; i<n; i++) {
        	st = new StringTokenizer(br.readLine());
        	String name = st.nextToken();
        	String place = st.nextToken();
        	
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	
        	if(al.contains(name)) continue;
        	else al.add(name);
        	
        	if(hm.containsKey(place)) { //이미 다른 사람이 방문한 경우
        		for(int j=start; j<end; j++) {
        			hm.get(place)[j]++; //해당 장소 시간 카운트 증가
        		}
        	}else { //방문하지 않은경우
        		//배열초기화
        		int[] time = new int[50001];
        		for(int j=start; j<end; j++) {
        			time[j]++;
        		}
        		//장소 저장
        		hm.put(place, time);
        	}	
        }
        
        String ans = "";
        int max = 0;
        int start = 0; int end = 0;
        for(Map.Entry<String, int[]> entry: hm.entrySet()) {
        	String key = entry.getKey();
        	int[] value = entry.getValue();
        	//int maxval = Arrays.stream(value).max().getAsInt();
        	int maxval = 0;
        	int s=0,e=0;
        	for(int j=1; j<=50000; j++) {
        		if(value[s] < value[j]) {
            		//System.out.println(key + " " + value[j]);
        			maxval = value[j];
        			s = j;
        		}
        		if(value[s] > value[j] && s >= e)
        			e = j;
        	}
        	
        	if(maxval > max) {
        		max = maxval;
        		ans = key;
        		start = s;
        		end = e;
        	}else if(maxval == max && key.compareTo(ans) < 0) {
        		ans = key;
        		start = s;
        		end = e;
        	}
        }
        
        System.out.println(ans + " " + start + " " + end);
        
    }
}
