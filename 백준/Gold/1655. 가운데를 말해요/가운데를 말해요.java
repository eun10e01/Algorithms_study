import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();

        for(int i = 0; i < N; i++)
        {
            int temp = Integer.parseInt(br.readLine());

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
            else if(left.size() > right.size())
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

            if(left.size() == right.size())
            {
                System.out.println(left.peek());
            }
            else if(left.size() > right.size())
            {
                System.out.println(left.peek());
            }
            else
            {
                System.out.println(right.peek());
            }
        }

        br.close();
    }
}