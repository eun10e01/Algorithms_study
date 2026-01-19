import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        Long N = sc.nextLong();

        Long check = 1L;
        Long count = 1L;

        while(check < N)
        {
            check += (count * 6);
            count++;
        }

        System.out.println(count);

        sc.close();
    }
}