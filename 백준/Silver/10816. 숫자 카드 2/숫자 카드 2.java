import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Map<Integer, Integer> cards = new HashMap<>();

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++)
        {
            int card = Integer.parseInt(st.nextToken());

            if(cards.containsKey(card))
            {
                cards.put(card, cards.get(card) + 1);
            }
            else
            {
                cards.put(card, 1);
            }
        }

        int M = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < M; i++)
        {
            int card = Integer.parseInt(st.nextToken());

            if(cards.get(card) == null)
            {
                sb.append(0 + " ");
            }
            else
            {
                sb.append(cards.get(card) + " ");
            }
        }

        System.out.println(sb);
    }
}