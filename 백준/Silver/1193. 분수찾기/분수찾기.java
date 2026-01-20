import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int X = sc.nextInt();
        int count = 1;

        while(X > count)
        {
            X -= count;
            count++;
        }
        
        int numerator = 0;
        int denominator = 0;

        if(count % 2 == 0)
        {
            numerator = 1;
            denominator = count;

            for(int i = 1; i < X; i++)
            {
                numerator++;
                denominator--;
            }
        }
        else
        {
            numerator = count;
            denominator = 1;

            for(int i = 1; i < X; i++)
            {
                numerator--;
                denominator++;
            }
        }

        System.out.println(numerator + "/" + denominator);

        sc.close();
    }
}