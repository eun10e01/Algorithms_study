import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int F = sc.nextInt();

        N /= 100;
        N *= 100;

        int ans = 0;
        
        while (N % F != 0)
        {
            N++;
            ans++;
        }

        if (ans < 10)
        {
            System.out.print("0" + ans);
        }
        else
        {
            System.out.print(ans);
        }

        sc.close();
    }
}