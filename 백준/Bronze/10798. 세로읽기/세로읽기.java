import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char words[][] = new char[5][15];

        for(int i = 0; i < 5; i++)
        {
            String str = br.readLine();
            int max = str.length();

            for(int j = 0; j < max; j++)
            {
                words[i][j] = str.charAt(j);
            }
            
            for(int j = max; j < 15; j++)
            {
                words[i][j] = '!';
            }
        }

        for(int i = 0; i < 15; i++)
        {
            for(int j = 0; j < 5; j++)
            {
                if(words[j][i] != '!')
                {
                    System.out.print(words[j][i]);
                }
            }
        }

        br.close();
    }
}