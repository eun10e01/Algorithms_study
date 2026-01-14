import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        
        int ans[][] = new int[N][M];
        
        for(int i = 0; i < N; i++)
        {
            for(int j = 0; j < M; j++)
            {
                ans[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < N; i++)
        {
            for(int j = 0; j < M; j++)
            {
                ans[i][j] += sc.nextInt();
            }
        }

        for(int i = 0; i < N; i++)
        {
            for(int j = 0; j < M; j++)
            {
                System.out.print(ans[i][j] + " ");
            }
            
            System.out.println();
        }
        
        sc.close();
    }
}