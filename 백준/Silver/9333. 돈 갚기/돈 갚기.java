import java.io.*;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++)
        {
            st = new StringTokenizer(br.readLine());

            long R = Math.round(Double.parseDouble(st.nextToken()) * 100);
            long B = Math.round(Double.parseDouble(st.nextToken()) * 100);
            long M = Math.round(Double.parseDouble(st.nextToken()) * 100);

            int month = 0;
            boolean check = true;

            while(B > 0)
            {
                long Interest = (B * R + 5000) / 10000;

                B += Interest;
                month++;
                B -= M;

                if(month > 1200)
                {
                    check = false;
                    break;
                }
            }
            
            if(check)
            {
                System.out.println(month);
            }
            else
            {
                System.out.println("impossible");
            }
        }

        br.close();
    }
}