import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        boolean check = false;

        int i;

        for(i = N / 2; i <= 1000000; i++)
        {
            int sum = i;
            String temp = Integer.toString(i);
            
            for(int j = 0; j < temp.length(); j++)
            {
                sum += Integer.parseInt(Character.toString(temp.charAt(j)));
            }

            if(sum == N)
            {
                check = true;
                break;
            }
        }

        if(check)
        {
            System.out.println(i);
        }
        else
        {
            System.out.println(0);
        }
    }
}