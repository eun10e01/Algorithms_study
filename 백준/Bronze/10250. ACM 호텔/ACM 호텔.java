import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        
        for(int i = 0; i < T; i++)
        {
            int H = sc.nextInt();
            int W = sc.nextInt();
            int N = sc.nextInt();

            int Y, X;

            if(N % H == 0)
            {
                Y = H;
                X = N / H;
            }
            else
            {
                Y = N % H;
                X = (N / H) + 1;
            }

            System.out.println(Y * 100 + X);
        }

        sc.close();
    }
}