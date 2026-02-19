import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int array[] = new int[N];

        int max = 0;
        long sum = 0;

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++)
        {
            array[i] = Integer.parseInt(st.nextToken());
            sum += array[i];
            max = Math.max(max, array[i]);
        }

        int M = Integer.parseInt(br.readLine());

        if(sum <= M)
        {
            System.out.println(max);
            return;
        }

        int left = 0;
        int right = max;
        int ans = 0;

        while(left <= right)
        {
            int mid = (left + right) / 2;

            long total = 0;

            for(int i = 0; i < N; i++)
            {
                total += Math.min(array[i], mid);
            }

            if(total <= M)
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