import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++)
        {
            StringBuilder sb = new StringBuilder();
            
            int N = Integer.parseInt(br.readLine());

            int note1[] = new int[N];

            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++)
            {
                note1[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(note1);

            int M = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < M; j++)
            {
                int left = 0;
                int right = note1.length - 1;
                int target = Integer.parseInt(st.nextToken());
                boolean check = false;

                while(left <= right)
                {
                    int mid = (left + right) / 2;

                    if(note1[mid] == target)
                    {
                        check = true;
                        break;
                    }
                    else if(note1[mid] < target)
                    {
                        left = mid + 1;
                    }
                    else
                    {
                        right = mid - 1;
                    }
                }

                if(check)
                {
                    sb.append(1 + "\n");
                }
                else
                {
                    sb.append(0 + "\n");
                }
            }

            System.out.print(sb);
        }
    }
}