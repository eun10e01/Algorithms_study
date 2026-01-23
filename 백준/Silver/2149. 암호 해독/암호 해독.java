import java.io.*;
import java.util.Arrays;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String key = br.readLine();
        String text = br.readLine();

        int N = key.length();
        int M = text.length() / key.length();

        char matrix[][] = new char[M][N];
        int count = 0;

        for(int i = 0; i < N; i++)
        {
            String temp = text.substring(count, count + M);

            for(int j = 0; j < M; j++)
            {
                matrix[j][i] = temp.charAt(j);
            }

            count += M;
        }

        char temp[] = new char[N];
        String sequence[] = new String[N];

        for(int i = 0; i < N; i++)
        {
            temp[i] = key.charAt(i);
            sequence[i] = Integer.toString(i);
        }

        for(int i = 0; i < N; i++)
        {
            for(int j = i + 1; j < N; j++)
            {
                if((temp[i] > temp[j] || (temp[i] == temp[j] && Integer.parseInt(sequence[i]) > Integer.parseInt(sequence[j]))))
                {
                    char c = temp[i];
                    temp[i] = temp[j];
                    temp[j] = c;

                    String s = sequence[i];
                    sequence[i] = sequence[j];
                    sequence[j] = s;
                }
            }
        }

        for(int i = 0; i < M; i++)
        {
            for(int j = 0; j < N; j++)
            {
                System.out.print(matrix[i][Arrays.asList(sequence).indexOf(Integer.toString(j))]);
            }
        }

        br.close();
    }
}