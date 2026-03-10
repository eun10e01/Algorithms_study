import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int len[] = new int[3];

        int max = 0;
        int idx = 0;
        
        for(int i = 0; i < 3; i++)
        {
            len[i] = Integer.parseInt(st.nextToken());

            if(max < len[i])
            {
                max = len[i];
                idx = i;
            }
        }

        int sum = 0;

        for(int i = 0; i < 3; i++)
        {
            if(i == idx)
            {
                continue;
            }
            else
            {
                sum += len[i];
            }
        }

        if(sum <= max)
        {
            max = sum - 1;
            System.out.println(sum + max);
        }
        else
        {
            System.out.println(sum + max);
        }
    }
}