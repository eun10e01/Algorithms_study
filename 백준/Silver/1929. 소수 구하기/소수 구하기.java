import java.io.*;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        for(int i = M; i <= N; i++)
        {
            boolean check = isPrime(i);

            if(check == true)
            {
                System.out.println(i);
            }
        }

        br.close();
    }

    static boolean isPrime(int x)
    {
        boolean prime = true;

        if(x == 1)
        {
            prime = false;
        }
        else if(x == 2)
        {   
            prime = true;
        }
        else
        {
            for(int i = 2; i <= Math.sqrt(x); i++)
            {
                if(x % i == 0)
                {
                    prime = false;
                    break;
                }
            }
        }

        return prime;
    }
}