import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.Collections;
import java.util.LinkedList;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        Queue<Integer> papers = new LinkedList<>();
        PriorityQueue<Integer> importance = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < T; i++)
        {
            int count = 0;

            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            int ans_importance = 0;

            for(int j = 0; j < N; j++)
            {
                int temp = Integer.parseInt(st.nextToken());

                if(j == M)
                {
                    papers.add(0);
                    importance.add(temp);
                    ans_importance = temp;
                }
                else
                {
                    papers.add(temp);
                    importance.add(temp);
                }
            }

            while(!papers.isEmpty())
            {
                int now = papers.poll();

                if(now == 0)
                {
                    if(ans_importance == importance.peek())
                    {
                        count++;
                        papers.clear();
                        importance.clear();
                        break;
                    }
                    else
                    {
                        papers.add(now);
                    }
                }
                else
                {
                    if(now == importance.peek())
                    {
                        count++;
                        importance.poll();
                    }
                    else
                    {
                        papers.add(now);
                    }
                }
            }

            System.out.println(count);
        }
    }
}