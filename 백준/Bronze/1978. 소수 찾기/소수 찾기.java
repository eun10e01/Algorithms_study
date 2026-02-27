import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        int count = 0;

        for(int i = 0; i < N; i++)
        {
            if(isPrime(Integer.parseInt(st.nextToken())))
            {
                count++;
            }
        }

        System.out.println(count);
    }

    static boolean isPrime(int x)
    {
        if(x == 1)
        {
            return false;
        }

        for(int i = 2; i <= x; i++)
        {
            if(x % i == 0 && x != i)
            {
                return false;
            }
        }

        return true;
    }
}