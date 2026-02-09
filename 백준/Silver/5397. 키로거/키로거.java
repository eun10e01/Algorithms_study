import java.io.*;
import java.util.Stack;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++)
        {
            Stack<Character> left = new Stack<>();
            Stack<Character> right = new Stack<>();

            String text = br.readLine();

            for(int j = 0; j < text.length(); j++)
            {
                char temp = text.charAt(j);

                if(temp == '<')
                {
                    if(!left.empty())
                    {
                        right.push(left.pop());
                    }
                }
                else if(temp == '>')
                {  
                    if(!right.empty())
                    {
                        left.push(right.pop());
                    } 
                }
                else if(temp == '-')
                {
                    if(!left.empty())
                    {
                        left.pop();
                    }
                }
                else
                {
                    left.push(temp);
                }
            }

            StringBuilder sb = new StringBuilder();

            while(!left.empty())
            {
                right.push(left.pop());
            }

            while(!right.empty())
            {
                sb.append(right.pop());
            }

            System.out.println(sb.toString());
        }

        br.close();
    }
}