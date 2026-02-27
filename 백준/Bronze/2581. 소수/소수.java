import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());

        int min = Integer.MAX_VALUE;
        int sum = 0;

        for(int i = A; i <= B; i++)
        {
            if(isPrime(i))
            {
                sum += i;
                min = Math.min(i, min);
            }
        }

        if(sum == 0)
        {
            System.out.println(-1);
        }
        else
        {
            System.out.println(sum);
            System.out.println(min);
        }
    }

    static boolean isPrime(int x)
    {
        if(x == 1)
        {
            return false;
        }

        for(int i = 2; i <= Math.sqrt(x) + 1; i++)
        {
            if(x % i == 0 && x != i)
            {
                return false;
            }
        }

        return true;
    }
}