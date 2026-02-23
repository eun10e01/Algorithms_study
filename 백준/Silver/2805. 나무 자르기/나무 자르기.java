import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        long trees[] = new long[N];
        long max = Long.MIN_VALUE;

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++)
        {
            trees[i] = Long.parseLong(st.nextToken());
            max = Math.max(trees[i], max);
        }

        long left = 1;
        long right = max;
        long ans = 0;

        while(left <= right)
        {
            long mid = (left + right) / 2;
            long total = 0;

            for(int i = 0; i < N; i++)
            {
                long temp = trees[i] - mid;

                if(temp > 0)
                {
                    total += temp;
                }
            }

            if(total >= M)
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