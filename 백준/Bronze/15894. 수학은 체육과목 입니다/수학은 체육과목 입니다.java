import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());

        long ans = n + (n * 2) + 1 + (n - 1);

        System.out.println(ans);
    }
}