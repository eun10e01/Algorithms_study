import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++)
        {
            PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> right = new PriorityQueue<>();

            int M = Integer.parseInt(br.readLine());

            int M_count;

            if(M <= 10)
            {
                M_count = 1;
            }
            else
            {
                M_count = M / 10;

                if(M % 10 != 0)
                {
                    M_count++;
                }
            }
            
            LinkedList<Integer> ans = new LinkedList<>();

            int count = 0;

            for(int j = 0; j < M_count; j++)
            {
                st = new StringTokenizer(br.readLine());

                while(st.hasMoreTokens())
                {
                    int temp = Integer.parseInt(st.nextToken());

                    if(left.isEmpty())
                    {
                        left.add(temp);
                    }
                    else if(left.size() <= right.size())
                    {
                        if(right.peek() < temp)
                        {
                            left.add(right.poll());
                            right.add(temp);
                        }
                        else
                        {
                            left.add(temp);
                        }
                    }
                    else
                    {
                        if(left.peek() > temp)
                        {
                            right.add(left.poll());
                            left.add(temp);
                        }
                        else
                        {
                            right.add(temp);
                        }
                    }

                    count++;

                    if(count % 2 == 1)
                    {
                        ans.add(left.peek());
                    }
                }
            }

            System.out.println(ans.size());

            while(!ans.isEmpty())
            {
                for(int j = 0; j < 10; j++)
                {
                    System.out.print(ans.poll() + " ");

                    if(ans.isEmpty())
                    {
                        break;
                    }
                }

                System.out.println();
            }
        }

        br.close();
    }
}