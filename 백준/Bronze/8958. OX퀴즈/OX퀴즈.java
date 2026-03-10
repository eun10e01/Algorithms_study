import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++)
        {
            String ans = br.readLine();
            int score = 0;
            int cnt = 0;

            for(int j = 0; j < ans.length(); j++)
            {
                char temp = ans.charAt(j);

                switch (temp)
                {
                    case 'O':
                        cnt++;
                        score += cnt;
                        break;
                    case 'X':
                        cnt = 0;
                        break;
                }
            }

            System.out.println(score);
        }
    }
}