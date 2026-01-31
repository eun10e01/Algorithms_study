import java.util.LinkedList;
import java.util.ListIterator;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String text = br.readLine();

        LinkedList<Character> edit = new LinkedList<>();

        for(int i = 0; i < text.length(); i++)
        {
            edit.add(text.charAt(i));
        }

        int M = Integer.parseInt(br.readLine());

        ListIterator<Character> iter = edit.listIterator();

        while(iter.hasNext())
        {
            iter.next();
        }

        for(int i = 0; i < M; i++)
        {
            String command = br.readLine();

            switch(command.charAt(0))
            {
                case 'L':
                    if(iter.hasPrevious())
                    {
                        iter.previous();
                    }
                    break;
                case 'D':
                    if(iter.hasNext())
                    {
                        iter.next();
                    }
                    break;
                case 'B':
                    if(iter.hasPrevious())
                    {
                        iter.previous();
                        iter.remove();
                    }
                    break;
                case 'P':
                    char temp = command.charAt(2);
                    iter.add(temp);
                    break;
            }
        }
        
        for(char c : edit)
        {
            bw.write(c);
        }

        br.close();
        bw.flush();
        bw.close();
    }
}