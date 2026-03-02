import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true)
        {
            int n = Integer.parseInt(br.readLine());

            if(n == -1)
            {
                break;
            }

            PriorityQueue<Integer> divisor = new PriorityQueue<>();

            for(int i = 1; i <= Math.sqrt(n); i++)
            {
                if(n % i == 0)
                {
                    if(i == 1)
                    {
                        divisor.add(i);
                    }
                    else
                    {
                        divisor.add(i);
                        divisor.add(n / i);
                    }
                }
            }

            int count = 0;
            PriorityQueue<Integer> temp = new PriorityQueue<>();

            int size = divisor.size();

            for(int i = 0; i < size; i++)
            {
                count += divisor.peek();
                temp.add(divisor.poll());
            }

            StringBuilder sb = new StringBuilder();

            if(count == n)
            {
                sb.append(n + " = ");

                for(int i = 0; i < size - 1; i++)
                {
                    sb.append(temp.poll() + " + ");
                }

                sb.append(temp.poll());

                System.out.println(sb);
            }
            else
            {
                System.out.println(n + " is NOT perfect.");
            }
        }
    }
}