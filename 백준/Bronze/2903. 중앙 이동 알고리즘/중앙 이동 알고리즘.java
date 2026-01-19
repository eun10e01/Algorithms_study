import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Long ans = 2L;

        for(int i = 0; i < N; i++)
        {
            Long temp = ans - 1;

            ans += temp;
        }

        System.out.println(ans * ans);

        sc.close();
    }
}