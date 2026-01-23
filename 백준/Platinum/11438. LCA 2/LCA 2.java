import java.io.*;
import java.util.*;

public class Main
{
	static ArrayList<Integer> tree[];
	static int depth[];
	static int kmax;
	static int parent[][];
	static boolean visited[];
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		tree = new ArrayList[N + 1];
		
		for(int i = 1; i <= N; i++)
		{
			tree[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < N - 1; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			tree[s].add(e);
			tree[e].add(s);
		}
		
		depth = new int[N + 1];
		visited = new boolean[N + 1];
		
		int temp = 1;
		kmax = 0;
		
		while(temp <= N)
		{
			temp <<= 1;
			kmax++;
		}
		
		parent = new int[kmax + 1][N + 1];
		
		BFS(1);
		
		for(int i = 1; i <= kmax; i++)
		{
			for(int j = 1; j <= N; j++)
			{
				parent[i][j] = parent[i - 1][parent[i - 1][j]];
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < M; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int LCA = excuteLCA(a, b);
			
			System.out.println(LCA);
		}
	}
	
	static int excuteLCA(int a, int b)
	{
		if(depth[a] > depth[b])
		{
			int temp = a;
			a = b;
			b = temp;
		}
		
		for(int i = kmax; i >= 0; i--)
		{
			if(Math.pow(2, i) <= depth[b] - depth[a])
			{
				if(depth[a] <= depth[parent[i][b]])
				{
					b = parent[i][b];
				}
			}
		}
		
		for(int i = kmax; i >= 0; i--)
		{
			if(parent[i][a] != parent[i][b])
			{
				a = parent[i][a];
				b = parent[i][b];
			}
		}
		
		int LCA = a;
		
		if(a != b)
		{
			LCA = parent[0][LCA];
		}
		
		return LCA;
	}
	
	static void BFS(int node)
	{
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.add(node);
		visited[node] = true;
		
		int level = 1;
		int size = 1;
		int count = 0;
		
		while(!queue.isEmpty())
		{
			int now = queue.poll();
			
			for(int next : tree[now])
			{
				if(!visited[next])
				{
					visited[next] = true;
					queue.add(next);
					parent[0][next] = now;
					depth[next] = level;
				}
			}
			
			count++;
			
			if(count == size)
			{
				count = 0;
				size = queue.size();
				level++;
			}
		}
	}
}