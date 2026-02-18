import java.io.*;
import java.util.*;

public class Main
{   
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> nums = new LinkedList<>();
        LinkedList<Integer> one = new LinkedList<>();
        LinkedList<Integer> zero = new LinkedList<>();

        boolean isOdd = false;

        int ans = 0;
        StringBuilder sb = new StringBuilder();

        if(N % 2 == 1)
        {
            isOdd = true;
        }
        else
        {
            isOdd = false;
        }

        if(N == 2)
        {
            sb.append(2 + " " + 1);

            ans = 1;
        }
        else if(N == 3)
        {
            sb.append(2 + " " + 1 + "\n");
            sb.append(3 + " " + 1 + "\n");

            ans = 2;
        }

        if(isOdd && N != 3)
        {
            for(int i = 1; i <= N; i++)
            {
                nums.add(i);
            }

            for(int i = 0; i < (N - 1) / 2; i++)
            {
                int A = nums.poll();
                int B = nums.poll();

                one.add(B - A);

                sb.append(B + " " + A + "\n");
            }

            int size_one = one.size();

            if(size_one % 2 == 1)
            {
                for(int i = 0; i < (size_one - 1) / 2; i++)
                {
                    int A = one.poll();
                    int B = one.poll();

                    zero.add(B - A);

                    sb.append(B + " " + A + "\n");
                }

                while(zero.size() > 1)
                {
                    int A = zero.poll();
                    int B = zero.poll();

                    zero.add(B - A);

                    sb.append(B + " " + A + "\n");
                }

                sb.append(1 + " " + 0 + "\n");

                sb.append(N + " " + 1 + "\n");

                ans = N - 1;
            }
            else
            {
                for(int i = 0; i < size_one / 2; i++)
                {
                    int A = one.poll();
                    int B = one.poll();

                    zero.add(B - A);

                    sb.append(B + " " + A + "\n");
                }

                while(zero.size() > 1)
                {
                    int A = zero.poll();
                    int B = zero.poll();

                    zero.add(B - A);

                    sb.append(B + " " + A + "\n");
                }

                sb.append(N + " " + 0 + "\n");

                ans = N;
            }
        }
        else if(!isOdd && N != 2)
        {
            one.add(1);

            for(int i = 2; i <= N; i++)
            {
                nums.add(i);
            }

            for(int i = 0; i < (N - 2) / 2; i++)
            {
                int A = nums.poll();
                int B = nums.poll();

                one.add(B - A);

                sb.append(B + " " + A + "\n");
            }

            int size_one = one.size();

            if(size_one % 2 == 1)
            {
                for(int i = 0; i < (size_one - 1) / 2; i++)
                {
                    int A = one.poll();
                    int B = one.poll();

                    zero.add(B - A);

                    sb.append(B + " " + A + "\n");
                }

                while(zero.size() > 1)
                {
                    int A = zero.poll();
                    int B = zero.poll();

                    zero.add(B - A);

                    sb.append(B + " " + A + "\n");
                }

                sb.append(1 + " " + 0 + "\n");

                sb.append(N + " " + 1 + "\n");

                ans = N - 1;
            }
            else
            {
                for(int i = 0; i < size_one / 2; i++)
                {
                    int A = one.poll();
                    int B = one.poll();

                    zero.add(B - A);

                    sb.append(B + " " + A + "\n");
                }

                while(zero.size() > 1)
                {
                    int A = zero.poll();
                    int B = zero.poll();

                    zero.add(B - A);

                    sb.append(B + " " + A + "\n");
                }

                sb.append(N + " " + 0 + "\n");

                ans = N;
            }
        }

        System.out.println(ans);
        System.out.println(sb);
    }
}