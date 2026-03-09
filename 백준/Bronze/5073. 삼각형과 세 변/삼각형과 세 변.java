import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true)
        {
            st = new StringTokenizer(br.readLine());

            int temp = Integer.parseInt(st.nextToken());

            if(temp == 0)
            {
                break;
            }

            int len[] = new int[3];

            len[0] = temp;

            int max = temp;
            int idx = 0;

            for(int i = 1; i < 3; i++)
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

            if(max >= sum)
            {
                System.out.println("Invalid");
            }
            else
            {
                Set<Integer> cnt = new HashSet<>();

                for(int x : len)
                {
                    cnt.add(x);
                }

                if(cnt.size() == 1)
                {
                    System.out.println("Equilateral");
                }
                else if(cnt.size() == 2)
                {
                    System.out.println("Isosceles");
                }
                else
                {
                    System.out.println("Scalene");
                }
            }
        }
    }
}