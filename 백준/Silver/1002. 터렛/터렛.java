import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int i = 0; i < T; i++)
        {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int r1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int r2 = sc.nextInt();

            double powd = ((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1));

            if(powd == 0 && r1 == r2)
            {
                System.out.println(-1);
            }
            else if((r1 - r2) * (r1 - r2) < powd && powd < (r1 + r2) * (r1 + r2))
            {
                System.out.println(2);
            }
            else if(powd == (r1 + r2) * (r1 + r2) || powd == (r1 - r2) * (r1 - r2))
            {
                System.out.println(1);
            }
            else if(powd > (r1 + r2) * (r1 + r2) || powd < (r1 - r2) * (r1 - r2))
            {
                System.out.println(0);
            }
        }

        sc.close();
    }
}