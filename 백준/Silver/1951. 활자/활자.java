import java.util.Scanner;

public class Main
{   
    static int count[] = new int[10];
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        long N = sc.nextLong();    

        long ans = 0;
        int len = 1;
        long start = 1;

        while(start <= N)
        {
            long end = Math.min(N, start * 10 - 1);
            long count = end - start + 1;

            ans = (ans + (count % 1234567) * len) % 1234567;

            start *= 10;
            len++;
        }

        System.out.println(ans);

        sc.close();
    }
}