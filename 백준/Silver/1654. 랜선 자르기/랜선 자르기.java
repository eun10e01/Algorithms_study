import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        long lan[] = new long[K];
        long max = Long.MIN_VALUE;

        for(int i = 0; i < K; i++)
        {
            lan[i] = Long.parseLong(br.readLine());
            max = Math.max(lan[i], max);
        }

        long left = 1;
        long right = max;
        long ans = 0;

        while(left <= right)
        {
            long mid = (left + right) / 2;
            long total = 0;

            for(int i = 0; i < K; i++)
            {
                total += (lan[i] / mid);
            }

            if(total >= N)
            {
                ans = mid;
                left = mid + 1;
            }
            else
            {
                right = mid - 1;
            }
        }

        System.out.println(ans);
    }
}