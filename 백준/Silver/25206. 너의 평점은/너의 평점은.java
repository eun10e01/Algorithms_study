import java.io.*;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        double ans = 0.0;
        double count = 0.0;

        while(true)
        {
            String str;

            if((str = br.readLine()) != null)
            {
                st = new StringTokenizer(str);
                st.nextToken();
                
                double credit = Double.parseDouble(st.nextToken());
                String grade = st.nextToken();

                switch(grade.charAt(0))
                {
                    case 'A':
                        switch(grade.charAt(1))
                        {
                            case '+':
                                ans += (credit * 4.5);
                                count += credit;
                                break;
                            case '0':
                                ans += (credit * 4.0);
                                count += credit;
                                break;
                        }

                        break;
                    case 'B':
                        switch(grade.charAt(1))
                        {
                            case '+':
                                ans += (credit * 3.5);
                                count += credit;
                                break;
                            case '0':
                                ans += (credit * 3.0);
                                count += credit;
                                break;
                        }
                        
                        break;
                    case 'C':
                        switch(grade.charAt(1))
                        {
                            case '+':
                                ans += (credit * 2.5);
                                count += credit;
                                break;
                            case '0':
                                ans += (credit * 2.0);
                                count += credit;
                                break;
                        }
                        
                        break;
                    case 'D':
                        switch(grade.charAt(1))
                        {
                            case '+':
                                ans += (credit * 1.5);
                                count += credit;
                                break;
                            case '0':
                                ans += (credit * 1.0);
                                count += credit;
                                break;
                        }
                        
                        break;
                    case 'F':
                        count += credit;
                        break;
                    case 'P':
                        break;
                }
            }
            else
            {
                break;
            }
        }

        System.out.println(ans / count);

        br.close();
    }
}