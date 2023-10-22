import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int curYear = Integer.parseInt(st.nextToken());
        int curMonth = Integer.parseInt(st.nextToken());
        int curDay = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int endYear = Integer.parseInt(st.nextToken());
        int endMonth = Integer.parseInt(st.nextToken());
        int endDay = Integer.parseInt(st.nextToken());

        // solve & output
        if (curYear + 1000 < endYear ||
                curYear + 1000 == endYear && (curMonth < endMonth || curMonth == endMonth && curDay <= endDay)) {
            System.out.print("gg");
        } else {
            int day = convertDateToInt(endYear, endMonth, endDay) - convertDateToInt(curYear, curMonth, curDay);
            System.out.printf("D-%d", day);
        }
    }

    private static int convertDateToInt(int year, int month, int day) {
        int[] daysOfMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int res = 0;

        for (int i = 1; i < year; ++i)
            res += (365 + checkLeapYear(i));
        for (int i = 1; i < month; ++i) {
            res += daysOfMonth[i];
            if (i == 2) res += checkLeapYear(year);
        }
        return res + day;
    }
    private static int checkLeapYear(int year) {
        return ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) ? 1 : 0;
    }
}
