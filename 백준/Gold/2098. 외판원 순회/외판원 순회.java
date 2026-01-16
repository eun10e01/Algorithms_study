import java.io.*;
import java.util.StringTokenizer;

public class Main
{
	static int INF = 1000000 * 16 + 1;
	static int N;
	static int W[][];
	static int D[][];
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine().trim());
		W = new int[16][16];
		D = new int[16][1 << 16];
		
		for(int i = 0; i < N; i++)
		{
			st = new StringTokenizer(br.readLine().trim());
			
			for(int j = 0; j < N; j++)
			{
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(tsp(0, 1));
		
		br.close();
	}
	
	static int tsp(int c, int v)
	{
		if(v == (1 << N) - 1)
		{
			return W[c][0] == 0 ? INF : W[c][0];
		}
		
		if(D[c][v] != 0)
		{
			return D[c][v];
		}
		
		int min = INF;
		
		for(int i = 0; i < N; i++)
		{
			if((v & (1 << i)) == 0 && W[c][i] != 0)
			{
				min = Math.min(min, tsp(i, (v | (1 << i))) + W[c][i]);
			}
		}
		
		D[c][v] = min;
		
		return D[c][v];
	}
}