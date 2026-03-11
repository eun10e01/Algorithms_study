import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char chess[][] = new char[N][M];

        for(int i = 0; i < N; i++)
        {
            String temp = br.readLine();

            for(int j = 0; j < M; j++)
            {
                chess[i][j] = temp.charAt(j);
            }
        }
        
        int min = Integer.MAX_VALUE;

        for(int i = 0; i <= N - 8; i++)
        {
            for(int j = 0; j <= M - 8; j++)
            {
                int Bcnt = 0;
                int Wcnt = 0;

                for(int k = 0; k < 8; k++)
                {
                    for(int r = 0; r < 8; r++)
                    {
                        if((k + r) % 2 == 0)
                        {
                            if(chess[i+k][j+r] != 'B')
                            {
                                Bcnt++;
                            }
                            if(chess[i+k][j+r] != 'W')
                            {
                                Wcnt++;
                            }
                        }
                        else
                        {
                            if(chess[i+k][j+r] != 'W')
                            {
                                Bcnt++;
                            }
                            if(chess[i+k][j+r] != 'B')
                            {
                                Wcnt++;
                            }
                        }
                    }
                }

                min = Math.min(min, Math.min(Bcnt, Wcnt));
            }
        }
        
        System.out.println(min);
    }
}