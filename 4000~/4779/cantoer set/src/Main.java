import java.io.*;


public class Main {

    public static char[] list=new char[531441];

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        String input="";

        while((input=br.readLine())!=null){
            int num=Integer.parseInt(input);

            int new_num= (int) Math.pow(3,num);

            for(int i=0;i<new_num;i++)
                list[i]=' ';

            make(0, new_num-1,new_num);

            for(int i=0;i<new_num;i++)
                bw.write(list[i]);

            bw.newLine();
            bw.flush();
        }
        bw.close();


    }

    public static void make(int first,int last,int range){
        if(range==1)
            list[first]='-';
        else{
            int temp_range=range/3;

            make(first,first+temp_range-1,temp_range);
            make(last-temp_range+1,last,temp_range);
        }
    }



}