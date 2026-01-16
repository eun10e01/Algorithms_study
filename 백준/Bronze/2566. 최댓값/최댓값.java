import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int nums[][] = new int[9][9];
        int row = 0;
        int column = 0;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < 9; i++)
        {
            for(int j = 0; j < 9; j++)
            {
                nums[i][j] = sc.nextInt();

                if(nums[i][j] > max)
                {
                    max = nums[i][j];
                    row = i + 1;
                    column = j + 1;
                }
            }
        }

        System.out.println(max);
        System.out.print(row + " " + column);

        sc.close();
    }
}