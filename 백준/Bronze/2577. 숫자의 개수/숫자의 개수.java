import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        String result = Integer.toString(A * B * C);

        int cnt[] = new int[10];

        for(int i = 0; i < 10; i++)
        {
            cnt[i] = 0;
        }

        for(int i = 0; i < result.length(); i++)
        {
            char temp = result.charAt(i);

            switch (temp)
            {
                case '0':
                    cnt[0]++;
                    break;
                case '1':
                    cnt[1]++;
                    break;
                case '2':
                    cnt[2]++;
                    break;
                case '3':
                    cnt[3]++;
                    break;
                case '4':
                    cnt[4]++;
                    break;
                case '5':
                    cnt[5]++;
                    break;
                case '6':
                    cnt[6]++;
                    break;
                case '7':
                    cnt[7]++;
                    break;
                case '8':
                    cnt[8]++;
                    break;
                case '9':
                    cnt[9]++;
                    break;
            }
        }

        for(int i = 0; i < 10; i++)
        {
            System.out.println(cnt[i]);
        }
    }
}