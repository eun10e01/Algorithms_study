import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());

        if(n % 2 == 1)
        {
            System.out.println(n * (n / 2));
            System.out.println(2);
        }
        else
        {
            System.out.println((n * (n / 2 - 1)) + (n / 2));
            System.out.println(2);
        }
    }
}