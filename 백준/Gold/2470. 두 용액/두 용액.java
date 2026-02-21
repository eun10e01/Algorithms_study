import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int solutions[] = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++)
        {
            solutions[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(solutions);

        int s = 0;
        int e = N - 1;

        int min = Integer.MAX_VALUE;
        int ans[] = new int[2];

        while(s < e)
        {
            int sum = solutions[s] + solutions[e];

            if(Math.abs(sum) < min)
            {
                min = Math.abs(sum);

                ans[0] = solutions[s];
                ans[1] = solutions[e];

                if(sum == 0)
                {
                    break;
                }
            }

            if(sum < 0)
            {
                s++;
            }
            else if(sum > 0)
            {
                e--;
            }
        }

        System.out.println(ans[0] + " " + ans[1]);
    }
}