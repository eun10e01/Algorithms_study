import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        long nums[] = new long[5];
        long ans = 0;
        
        for(int i = 0; i < 5; i++)
        {
            nums[i] = sc.nextLong();
            ans += (nums[i] * nums[i]);
        }
        
        System.out.println(ans % 10);
        
        sc.close();
    }
}