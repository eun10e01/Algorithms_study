import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sleep = Integer.parseInt(br.readLine());
        int wake = Integer.parseInt(br.readLine());

        int total = 0;

        if(sleep >= 20)
        {
            total += (24 - sleep) + wake;
        }
        else if(sleep <= 3)
        {
            total += wake - sleep;
        }

        System.out.println(total);
    }
}