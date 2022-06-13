import java.io.*;
import java.util.*;


public class set {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	boolean[] sett = new boolean[21];
        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i<M; i++)
        {
        	StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
        	String str = tk.nextToken();
        	if(str.equals("add"))
        	{
        		int x = Integer.parseInt(tk.nextToken());
        		if(!sett[x]) {
        			sett[x]=true;
        		}
        	}
        	else if(str.equals("remove"))
        	{
        		int x = Integer.parseInt(tk.nextToken());
        		if(sett[x])
        			sett[x] = false;
        	}
        	else if(str.equals("check"))
        	{
        		int x = Integer.parseInt(tk.nextToken());
        		if(sett[x] == true)
        		{
        			bw.write(1 + "\n");
        		}
        		else if(!sett[x])
        			bw.write(0 + "\n");
        	}
        	else if(str.equals("toggle"))
        	{
        		int x = Integer.parseInt(tk.nextToken());
        		sett[x] = !sett[x]; 
        	}
        	else if(str.equals("all"))
        	{
        		Arrays.fill(sett, true);
        	}
        	else
        	{
        		Arrays.fill(sett, false);
        	}
        	
        }
        bw.close();
	}
}
