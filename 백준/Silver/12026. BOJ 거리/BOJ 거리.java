import java.util.*;
import java.io.*;

public class Main
{
    static int n;
    static int dp[];
    
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        
        dp = new int[n];
        
        String s = br.readLine();
        
        int e = 0;
        
        for(int i = 1; i < n; i++)
        {
            dp[i] = 1000001;
        }
        
        for(int i = 0; i < n - 1; i++)
        {
            if(s.charAt(i) == 'B')
            {
                for(int j = i; j < n; j++)
                {
                    if(s.charAt(j) == 'O')
                    {
                        e = dp[i] + (int)Math.pow((j - i), 2);
                        dp[j] = Math.min(dp[j], e);
                    }
                }
            }
            else if(s.charAt(i) == 'O')
            {
                for(int j = i; j < n; j++)
                {
                    if(s.charAt(j) == 'J')
                    {
                        e = dp[i] + (int)Math.pow((j - i), 2);
                        dp[j] = Math.min(dp[j], e);
                    }
                }
            }
            else if(s.charAt(i) == 'J')
            {
                for(int j = i; j < n; j++)
                {
                    if(s.charAt(j) == 'B')
                    {
                        e = dp[i] + (int)Math.pow((j - i), 2);
                        dp[j] = Math.min(dp[j], e);
                    }
                }
            }
        }
        
        if(dp[n - 1] == 1000001)
        {
            System.out.println(-1);
        }
        else
        {
            System.out.println(dp[n - 1]);
        }
	}
}