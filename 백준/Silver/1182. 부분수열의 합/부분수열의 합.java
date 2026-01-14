import java.util.Scanner;

public class Main
{
    static int N, S;
    static int nums[];
    static int count = 0;

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        S = sc.nextInt();

        nums = new int[N];

        for(int i = 0; i < N; i++)
        {
            nums[i] = sc.nextInt();
        }

        DFS(0, 0);

        if(S == 0)
        {
            count--;
        }

        System.out.println(count);

        sc.close();
    }

    static void DFS(int index, int sum)
    {
        if(index == N)
        {
            if(sum == S)
            {
                count++;
            }
            
            return;
        }

        DFS(index + 1, sum + nums[index]);
        DFS(index + 1, sum);
    }
}