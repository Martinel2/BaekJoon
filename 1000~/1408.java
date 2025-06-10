package solved;

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 현재 시간과 임무 시작 시간 입력 받기
        String currentTimeStr = sc.next();
        String missionStartTimeStr = sc.next();
        
        // 남은 시간 계산 함수 호출
        String remainingTime = calculateRemainingTime(currentTimeStr, missionStartTimeStr);
        
        // 남은 시간 출력
        System.out.println(remainingTime);
    }
    
    // 남은 시간 계산하는 함수
    public static String calculateRemainingTime(String currentTimeStr, String missionStartTimeStr) {
        // 문자열 시간을 초로 변환
        int currentTimeInSeconds = convertStringToSeconds(currentTimeStr);
        int missionStartTimeInSeconds = convertStringToSeconds(missionStartTimeStr);
        
        // 남은 시간 계산
        int remainingSeconds;
        if (currentTimeInSeconds <= missionStartTimeInSeconds) {
            remainingSeconds = missionStartTimeInSeconds - currentTimeInSeconds;
        } else {
            remainingSeconds = 24 * 3600 - (currentTimeInSeconds - missionStartTimeInSeconds);
        }
        
        // 시, 분, 초로 변환하여 형식에 맞게 반환
        int remainingHours = remainingSeconds / 3600;
        remainingSeconds %= 3600;
        int remainingMinutes = remainingSeconds / 60;
        int remainingSecs = remainingSeconds % 60;
        
        return String.format("%02d:%02d:%02d", remainingHours, remainingMinutes, remainingSecs);
    }
    
    // 문자열 시간을 초로 변환하는 함수
    public static int convertStringToSeconds(String timeStr) {
        String[] timeParts = timeStr.split(":");
        
        int hours = Integer.parseInt(timeParts[0]);
        int minutes = Integer.parseInt(timeParts[1]);
        int seconds = Integer.parseInt(timeParts[2]);
        
        return hours * 3600 + minutes * 60 + seconds;
    }
    
}