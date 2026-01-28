import java.util.Scanner;
import java.util.Arrays;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int solution[] = new int[N];
        
        for(int i = 0; i < N; i++)
        {
            solution[i] = sc.nextInt();
        }

        Arrays.sort(solution);

        int start = 0;
        int end = 0;
        long count = 0;

        while(start < N)
        {
            while(end < N && solution[end] * 0.9 <= solution[start])
            {
                end++;
            }

            count += end - start - 1;
            start++;
        }

        System.out.println(count);

        sc.close();
    }
}