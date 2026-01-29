import java.util.Scanner;
import java.util.LinkedList;

public class Main
{
    static boolean friends, almost;

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int target[] = new int[M];

        for(int i = 0; i < M; i++)
        {
            target[i] = sc.nextInt();
        }

        LinkedList<Integer> nums = new LinkedList<>();

        for(int i = 1; i <= N; i++)
        {
            nums.add(i);
        }

        int count = 0;

        for(int i = 0; i < M; i++)
        {
            while(true)
            {
                int temp = nums.poll();

                if(temp == target[i])
                {
                    break;
                }
                else
                {
                    int index = nums.indexOf(target[i]);

                    if(index < nums.size() / 2)
                    {
                        nums.add(temp);
                        count++;
                    }
                    else
                    {
                        nums.addFirst(temp);
                        nums.addFirst(nums.removeLast());
                        count++;
                    }
                }
            }
        }

        System.out.println(count);

        sc.close();
    }
}