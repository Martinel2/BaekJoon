import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;

public class SpaceTravel {
    public static void main(String args[]) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder st = new StringBuilder();
        int t = Integer.parseInt(reader.readLine());
        String[] temp;
        int cnt = 0;
        for(int i = 0; i < t; i++){
            temp = reader.readLine().split(" ");
            int n = Integer.parseInt(temp[0]);
            int distance = Integer.parseInt(temp[1]);
            double[][] ships = new double[n][3];

            for(int j = 0; j < n; j++){
                temp = reader.readLine().split(" ");
                for(int k = 0; k < 3; k++){
                    ships[j][k] = Double.parseDouble(temp[k]);
                }
                if(ships[j][1] / ships[j][2] * ships[j][0] >= distance){
                    cnt++;
                }
            }
            st.append(cnt+"\n");
            cnt = 0;
        }
        System.out.println(st);
    }
}
