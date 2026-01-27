import java.util.Scanner;
import java.util.Arrays;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int nums[] = new int[n];

        for(int i = 0; i < n; i++)
        {
            nums[i] = sc.nextInt();
        }

        int x = sc.nextInt();

        Arrays.sort(nums);

        int start = 0;
        int end = nums.length - 1;
        int count = 0;

        while(start < end)
        {
            int sum = nums[start] + nums[end];

            if(sum == x)
            {
                count++;
                start++;
                end--;
            }
            else if(sum < x)
            {
                start++;
            }
            else
            {
                end--;
            }
        }

        System.out.println(count);

        sc.close();
    }
}