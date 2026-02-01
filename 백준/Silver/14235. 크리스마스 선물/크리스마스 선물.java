import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> gift = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < n; i++)
        {
            st = new StringTokenizer(br.readLine());

            int temp = Integer.parseInt(st.nextToken());

            if(temp == 0)
            {
                if(!gift.isEmpty())
                {
                    System.out.println(gift.poll());
                }
                else
                {
                    System.out.println(-1);
                }
            }
            else
            {
                while(st.hasMoreTokens())
                {
                    gift.add(Integer.parseInt(st.nextToken()));
                }
            }
        }

        br.close();
    }
}