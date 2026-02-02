import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> nums = new PriorityQueue<>();

        for(int i = 0; i < N; i++)
        {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++)
            {
                if(nums.size() != N)
                {
                    nums.add(Integer.parseInt(st.nextToken()));
                }
                else
                {
                    int A = Integer.parseInt(st.nextToken());
                    int B = nums.poll();

                    if(A > B)
                    {
                        nums.add(A);
                    }
                    else
                    {
                        nums.add(B);
                    }
                }
            }
        }

        System.out.println(nums.poll());
    }
}