import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> nums = new Stack<>();

        for(int i = 0; i < N; i++)
        {
            st = new StringTokenizer(br.readLine());

            String command = st.nextToken();

            switch (command)
            {
                case "push":
                    nums.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if(!nums.isEmpty())
                    {
                        System.out.println(nums.pop());
                    }
                    else
                    {
                        System.out.println(-1);
                    }
                    break;
                case "size":
                    System.out.println(nums.size());
                    break;
                case "empty":
                    if(nums.isEmpty())
                    {
                        System.out.println(1);
                    }
                    else
                    {
                        System.out.println(0);
                    }
                    break;
                case "top":
                    if(!nums.isEmpty())
                    {
                        System.out.println(nums.peek());
                    }
                    else
                    {
                        System.out.println(-1);
                    }
                    break;
            }
        }
    }
}