import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        char chess[][] = new char[8][8];
        int count = 0;

        for(int i = 0; i < 8; i++)
        {
            String temp = sc.next();

            for(int j = 0; j < 8; j++)
            {
                chess[i][j] = temp.charAt(j);
            }
        }

        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                if(i % 2 == 0)
                {
                    if(j % 2 == 0 && chess[i][j] == 'F')
                    {
                        count++;
                    }
                }
                else
                {
                    if(j % 2 == 1 && chess[i][j] == 'F')
                    {
                        count++;
                    }
                }
            }
        }

        System.out.println(count);

        sc.close();
    }
}