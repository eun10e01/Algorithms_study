import java.util.Scanner;

public class test
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        long hurt = sc.nextLong();
        long count = sc.nextLong();

        long ans = 0;

        if(count == 0)
        {
            ans = hurt - 1;
        }
        else
        {
            if(hurt == 1 || hurt == 5)
            {
                ans += (8 * count);
                ans += (hurt - 1);
            }
            else if(hurt == 2)
            {
                ans += (count / 2) * 8;
                ans += (count % 2) * 6 + 1;
            }
            else if(hurt == 3)
            {
                ans += (count / 2) * 8;
                ans += (count % 2) * 4 + 2;
            }
            else if(hurt == 4)
            {
                ans += (count / 2) * 8;
                ans += (count % 2) * 2 + 3;
            }
        }

        System.out.println(ans);

        sc.close();
    }
}
