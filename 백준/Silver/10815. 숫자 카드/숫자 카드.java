import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int cards[] = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++)
        {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cards);

        int M = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < M; i++)
        {
            int left = 0;
            int right = cards.length - 1;
            
            boolean check = false;

            int target = Integer.parseInt(st.nextToken());

            while(left <= right)
            {
                int mid = (left + right) / 2;
                
                if(cards[mid] == target)
                {
                    check = true;
                    break;
                }
                else if(cards[mid] < target)
                {
                    left = mid + 1;
                }
                else if(cards[mid] > target)
                {
                    right = mid - 1;
                }
            }

            if(check)
            {
                sb.append(1 + " ");
            }
            else
            {
                sb.append(0 + " ");
            }
        }

        System.out.println(sb);
    }
}