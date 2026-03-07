import java.io.*;
import java.util.*;

public class Main
{
    static PriorityQueue<Integer> nums = new PriorityQueue<>(Collections.reverseOrder());

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if(N == 1)
        {
            return;
        }
        else
        {
            if(isPrime(N))
            {
                System.out.println(N);
                return;
            }
            else
            {
                factor(N);

                while(!isPrime(nums.peek()))
                {
                    factor(nums.poll());
                }

                PriorityQueue<Integer> sort = new PriorityQueue<>();

                while(!nums.isEmpty())
                {
                    sort.add(nums.poll());
                }

                while(!sort.isEmpty())
                {
                    System.out.println(sort.poll());
                }
            }
        }
    }

    static boolean isPrime(int x)
    {
        if(x == 2)
        {
            return true;
        }

        for(int i = 2; i <= Math.sqrt(x); i++)
        {
            if(x % i == 0)
            {
                return false;
            }
        }

        return true;
    }

    static void factor(int x)
    {
        double size = Math.sqrt(x);

        for(int i = 2; i <= size; i++)
        {
            if(x % i == 0 && x != i)
            {
                nums.add(i);
                nums.add(x / i);
                
                return;
            }
        }
    }
}