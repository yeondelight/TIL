import java.io.*;
import java.util.*;

public class Main {

	class Meeting implements Comparable<Meeting>{
		int startTime;
		int endTime;
		public Meeting(int startTime, int endTime) {
			this.startTime = startTime;
			this.endTime = endTime;
		}
		
		@Override
		public int compareTo(Meeting m) {
			if (endTime > m.endTime)		return 1;
			else if (endTime < m.endTime)	return -1;
			else {
				if (startTime > m.startTime)		return 1;
				else if (startTime < m.startTime)	return -1;
				else								return 0;
			}
		}
	}
	
	public void sol_1931() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		List<Meeting> meets = new ArrayList<Meeting>();
		List<Integer> meeted = new ArrayList<Integer>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int startTime = Integer.parseInt(st.nextToken());
			int endTime = Integer.parseInt(st.nextToken());
			meets.add(new Meeting(startTime, endTime));
		}
		Collections.sort(meets);
		
		int count = 1;
		int endTime = meets.get(0).endTime;
		for(int i = 1; i < N; i++) {
			Meeting m = meets.get(i);
			if (m.startTime >= endTime) {
				count++;
				endTime = m.endTime;
			}
		}
		
		System.out.println(count);
	}
	
	public void sol_1026() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// scan
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		List<Integer> B = new ArrayList<Integer>();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)	A[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)	B.add(Integer.parseInt(st.nextToken()));
		
		Arrays.sort(A);
		Collections.sort(B);
		Collections.reverse(B);
		
		// cal
		int S = 0;
		for(int i = 0 ; i < N; i++)	S += A[i] * B.get(i);
		
		// print
		System.out.println(S);
	}

	public boolean binarySearch(String str, List<String> arr) {
		int middle;
		int low = 0, high = arr.size() - 1;
		while(low <= high) {
			middle = (low + high) / 2;
			int compare = arr.get(middle).compareTo(str);
			if (compare == 0)		return true;
			else if (compare > 0)	high = middle - 1;
			else					low = middle + 1;
		}
		return false;
	}
	
	public void sol_1764() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// scan
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<String> listen = new ArrayList<String>();
		List<String> seen = new ArrayList<String>();
		for(int i = 0; i < N; i++)	listen.add(br.readLine());
		for(int i = 0; i < M; i++)	seen.add(br.readLine());
		
		// sort
		Collections.sort(listen);
		Collections.sort(seen);
		
		// binary search
		List<String> res = new ArrayList<String>();
		if (N < M) {
			for(int i = 0; i < M; i++) {
				if (binarySearch(seen.get(i), listen))	res.add(seen.get(i));
			}
		} else {
			for(int i = 0; i < N; i++) {
				if (binarySearch(listen.get(i), seen))	res.add(listen.get(i));
			}
		}
		
		sb.append(res.size()).append('\n');
		for(int i = 0; i < res.size(); i++)
			sb.append(res.get(i)).append('\n');
		
		// print
		System.out.println(sb);
	}
	
	public void sol_2271() throws Exception{
		// scan
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		List<Integer> ropes = new ArrayList<Integer>();
		for(int i = 0; i < N; i++)
			ropes.add(Integer.parseInt(br.readLine()));
		
		// sort
		Collections.sort(ropes);
		Collections.reverse(ropes);
		
		// cal
		int max = 0;
		for(int i = 0; i < N; i++) {
			int weight = ropes.get(i) * (i + 1);
			if (weight > max)	max = weight;
		}
		
		System.out.println(max);
	}

	public void sol_18870() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		// scan
		int N = Integer.parseInt(br.readLine());
		int[] X = new int[N];
	
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			X[i] = num;
		}
		
		// sort
		int[] XCopy = Arrays.stream(X).distinct().toArray();
		Arrays.sort(XCopy);
		
		Map<Integer, Integer> compressed = new HashMap<Integer, Integer>();
		for(int i = 0; i < XCopy.length; i++) {
			compressed.put(XCopy[i], i);
		}
		
		// get index
		for(int i = 0; i < N; i++) {
			sb.append(compressed.get(X[i])).append(' ');
		}
		
		// print
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception{
		new Main().sol_18870();
	}

}
