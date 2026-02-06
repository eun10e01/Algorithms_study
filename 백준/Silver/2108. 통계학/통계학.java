import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import java.util.LinkedList;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        long sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        int nums[] = new int[N];

        Map<Integer, Integer> count = new HashMap<>();

        int max_frequence = 0;

        LinkedList<Integer> frequence = new LinkedList<>();
        
        for(int i = 0; i < N; i++)
        {
            int x = sc.nextInt();

            sum += x;

            if(x > max)
            {
                max = x;
            }

            if(x < min)
            {
                min = x;
            }

            nums[i] = x;
        }

        Arrays.sort(nums);

        for(int i = 0; i < N; i++)
        {
            if(count.containsKey(nums[i]))
            {
                count.put(nums[i], count.get(nums[i]) + 1);

                if(count.get(nums[i]) > max_frequence)
                {
                    max_frequence = count.get(nums[i]);
                }
            }
            else
            {
                count.put(nums[i], 1);

                if(count.get(nums[i]) > max_frequence)
                {
                    max_frequence = count.get(nums[i]);
                }
            }
        }

        for(int i = 0; i < N; i++)
        {
            if(count.get(nums[i]) == max_frequence && !frequence.contains(nums[i]))
            {
                frequence.add(nums[i]);
            }
        }

        System.out.println(Math.round((double)sum / N));
        System.out.println(nums[(N - 1) / 2]);

        if(frequence.size() == 1)
        {
            System.out.println(frequence.poll());
        }
        else if(frequence.size() >= 2)
        {
            frequence.poll();
            System.out.println(frequence.poll());
        }
        
        System.out.println(max - min);

        sc.close();
    }
}