import java.io.*;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.HashMap;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++)
        {
            int n = Integer.parseInt(br.readLine());

            Map<String, Integer> clothes = new HashMap<>();

            if(n == 0)
            {
                System.out.println(0);
                continue;
            }

            for(int j = 0; j < n; j++)
            {
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String temp = st.nextToken();

                if(clothes.containsKey(temp))
                {
                    clothes.put(temp, clothes.get(temp) + 1);
                }
                else
                {
                    clothes.put(temp, 1);
                }
            }

            int ans = 1;

            for(int val : clothes.values())
            {
                ans *= (val + 1);
            }

            System.out.println(ans - 1);
        }

        br.close();
    }
}