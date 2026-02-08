import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int H_centi = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> H = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < N; i++)
        {
            H.add(Integer.parseInt(br.readLine()));
        }

        int count = 0;

        for(int i = 0; i < T; i++)
        {
            int giant = H.poll();

            if(giant >= H_centi)
            {
                if(giant != 1)
                {
                    H.add(giant / 2);
                    count++;
                }
                else
                {
                    H.add(giant);
                    break;
                }
            }
            else
            {
                H.add(giant);
                break;
            }
        }

        if(H.peek() < H_centi)
        {
            System.out.println("YES");
            System.out.println(count);
        }
        else
        {
            System.out.println("NO");
            System.out.println(H.peek());
        }

        br.close();
    }
}