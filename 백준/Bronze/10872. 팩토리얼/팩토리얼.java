import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        long N = sc.nextInt();
        
        long fac = 1;
        
        if(N == 0)
        {
            System.out.println(fac);
        }
        else
        {
            for(int i = 1; i <= N; i++)
            {
                fac *= i;
            }
            
            System.out.println(fac);
        }
        
        sc.close();
    }
}