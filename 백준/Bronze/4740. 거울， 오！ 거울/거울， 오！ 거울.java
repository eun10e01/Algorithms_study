import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true)
        {
            char temp[] = br.readLine().toCharArray();

            if(temp[0] == '*' && temp[1] == '*' && temp[2] == '*')
            {
                break;
            }

            for(int i = temp.length - 1; i >= 0; i--)
            {
                System.out.print(temp[i]);
            }

            System.out.println();
        }
    }
}