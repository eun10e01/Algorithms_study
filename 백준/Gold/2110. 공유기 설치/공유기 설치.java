import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int x[] = new int[N];

        int max = 0;

        for(int i = 0; i < N; i++)
        {
            x[i] = Integer.parseInt(br.readLine());
            max = Math.max(x[i], max);
        }

        Arrays.sort(x);

        int left = 1;
        int right = max;
        int ans = 0;

        while(left <= right)
        {
            int mid = (left + right) / 2;

            int count = 1;
            int last_house = x[0];

            for(int i = 1; i < N; i++)
            {
                int now_house = x[i];

                if(now_house - last_house >= mid)
                {
                    count++;
                    last_house = now_house;
                }
            }

            if(count < C)
            {
                right = mid - 1;
            }
            else
            {
                left = mid + 1;
                ans = mid;
            }
        }

        System.out.println(ans);
    }
}