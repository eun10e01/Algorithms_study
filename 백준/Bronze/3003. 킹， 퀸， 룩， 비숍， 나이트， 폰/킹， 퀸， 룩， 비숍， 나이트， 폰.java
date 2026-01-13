import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int chess[] = new int[6];
        
        for(int i = 0; i < 6; i++)
        {
            chess[i] = sc.nextInt();
        }
        
        if(chess[0] != 1)
        {
            if(chess[0] > 1)
            {
                chess[0] = -Math.abs(chess[0] - 1);
            }
            else
            {
                chess[0] = Math.abs(chess[0] - 1);
            }
        }
        else
        {
            chess[0] = 0;
        }
        
        if(chess[1] != 1)
        {
            if(chess[1] > 1)
            {
                chess[1] = -Math.abs(chess[1] - 1);
            }
            else
            {
                chess[1] = Math.abs(chess[1] - 1);
            }
        }
        else
        {
            chess[1] = 0;
        }
        
        if(chess[2] != 2)
        {
            if(chess[2] > 2)
            {
                chess[2] = -Math.abs(chess[2] - 2);
            }
            else
            {
                chess[2] = Math.abs(chess[2] - 2);
            }
        }
        else
        {
            chess[2] = 0;
        }
        
        if(chess[3] != 2)
        {
            if(chess[3] > 2)
            {
                chess[3] = -Math.abs(chess[3] - 2);
            }
            else
            {
                chess[3] = Math.abs(chess[3] - 2);
            }
        }
        else
        {
            chess[3] = 0;
        }
        
        if(chess[4] != 2)
        {
            if(chess[4] > 2)
            {
                chess[4] = -Math.abs(chess[4] - 2);
            }
            else
            {
                chess[4] = Math.abs(chess[4] - 2);
            }
        }
        else
        {
            chess[4] = 0;
        }
        
        if(chess[5] != 8)
        {
            if(chess[5] > 8)
            {
                chess[5] = -Math.abs(chess[5] - 8);
            }
            else
            {
                chess[5] = Math.abs(chess[5] - 8);
            }
        }
        else
        {
            chess[5] = 0;
        }
        
        for(int i = 0; i < 6; i++)
        {
            System.out.print(chess[i] + " ");
        }
        
        sc.close();
    }
}