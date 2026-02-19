import java.io.*;
import java.util.*;

public class Main
{   
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int len = Integer.parseInt(br.readLine());
        String S = br.readLine();

        char str[] = S.toCharArray();

        Deque<Integer> Ps = new ArrayDeque<>();
        Deque<Integer> Cs = new ArrayDeque<>();

        for(int i = 0; i < len; i++)
        {
            if(S.charAt(i) == 'P')
            {
                Ps.add(i);
            }
            else if(S.charAt(i) == 'C')
            {
                Cs.add(i);
            }
        }

        while(true)
        {
            if(Ps.isEmpty())
            {
                break;
            }

            if(Cs.isEmpty())
            {
                break;
            }

            int A = Ps.pollFirst();
            int B = Cs.pollFirst();

            char temp = str[A];
            str[A] = str[B];
            str[B] = temp;
        }

        for(char c : str)
        {
            System.out.print(c);
        }
    }
}