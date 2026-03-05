import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Map<Integer, Integer> x = new HashMap<>();
        Map<Integer, Integer> y = new HashMap<>();

        for(int i = 0; i < 3; i++)
        {
            st = new StringTokenizer(br.readLine());

            int tempx = Integer.parseInt(st.nextToken());
            int tempy = Integer.parseInt(st.nextToken());

            if(x.containsKey(tempx))
            {
                x.put(tempx, x.get(tempx) + 1);
            }
            else
            {
                x.put(tempx, 1);
            }

            if(y.containsKey(tempy))
            {
                y.put(tempy, y.get(tempy) + 1);
            }
            else
            {
                y.put(tempy, 1);
            }
        }

        int ansx = 0;
        int ansy = 0;

        for(int i : x.keySet())
        {
            if(x.get(i) % 2 != 0)
            {
                ansx = i;
                break;
            }
        }

        for(int i : y.keySet())
        {
            if(y.get(i) % 2 != 0)
            {
                ansy = i;
                break;
            }
        }

        System.out.println(ansx + " " + ansy);
    }
}