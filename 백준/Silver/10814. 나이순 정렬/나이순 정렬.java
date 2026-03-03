import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        LinkedList<String> members[] = new LinkedList[100001];

        for(int i = 1; i <= 100000; i++)
        {
            members[i] = new LinkedList<>();
        }

        for(int i = 0; i < N; i++)
        {
            st = new StringTokenizer(br.readLine());

            int age = Integer.parseInt(st.nextToken());

            members[age].add(st.nextToken());
        }

        for(int i = 1; i <= 100000; i++)
        {
            if(!members[i].isEmpty())
            {
                while(!members[i].isEmpty())
                {
                    System.out.println(i + " " + members[i].poll());
                }
            }
        }
    }
}