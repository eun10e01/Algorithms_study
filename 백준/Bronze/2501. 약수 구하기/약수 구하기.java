import java.util.Scanner;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> nums = new ArrayList<>();

        int N = sc.nextInt();
        int K = sc.nextInt();

        for(int i = 1; i <= N; i++)
        {
            if(N % i == 0)
            {
                nums.add(i);
            }
        }

        if(nums.size() < K)
        {
            System.out.println(0);
        }
        else
        {
            int ans = nums.remove(K-1);
            
            System.out.println(ans);
        }

        sc.close();
    }
}