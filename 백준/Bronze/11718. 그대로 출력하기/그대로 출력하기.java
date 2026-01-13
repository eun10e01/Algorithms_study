import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] sentences = new String[100];

        for(int i = 0; i < 100; i++)
        {
            if((sentences[i] = br.readLine()) != null)
            {
                System.out.println(sentences[i]);
            }
            else
            {
                break;
            }
        }
    }
}