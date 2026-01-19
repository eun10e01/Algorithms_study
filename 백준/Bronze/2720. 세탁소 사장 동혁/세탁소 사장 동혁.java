import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        int Quarter = 25;
        int Dime = 10;
        int Nickel = 5;
        int Penny = 1;

        int ans[] = new int[4];

        for(int i = 0; i < T; i++)
        {
            int C = sc.nextInt();

            ans[0] = 0;
            ans[1] = 0;
            ans[2] = 0;
            ans[3] = 0;
            
            while(C >= Quarter)
            {
                C -= Quarter;
                ans[0]++;
            }

            while(C >= Dime)
            {
                C -= Dime;
                ans[1]++;
            }

            while(C >= Nickel)
            {
                C -= Nickel;
                ans[2]++;
            }

            while(C >= Penny)
            {
                C -= Penny;
                ans[3]++;
            }

            System.out.println(ans[0] + " " + ans[1] + " " + ans[2] + " " + ans[3]);
        }

        sc.close();
    }
}