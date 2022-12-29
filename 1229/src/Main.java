import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	class Country implements Comparable{
		int idx;
		int gold;
		int silver;
		int bronze;
		
		public Country(int idx, int gold, int silver, int bronze) {
			this.idx = idx;
			this.gold = gold;
			this.silver = silver;
			this.bronze = bronze;
		}
		
		@Override
		public int hashCode() {
			return this.idx + this.gold + this.silver + this.bronze;
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) {
				return true;
			}
			if (o instanceof Country) {
				Country cmp = (Country) o;
				return this.idx == cmp.idx && this.gold == cmp.gold && this.silver == cmp.silver && this.bronze == cmp.bronze;
			}
			return false;
		}
		
		@Override
		public int compareTo(Object o) {
			Country c = (Country) o;
			if (this.gold == c.gold) {
				if (this.silver == c.silver) {
					if (this.bronze == c.bronze) {
						return 0;
					} else {
						return c.bronze - this.bronze;
					}
				} else {
					return c.silver - this.silver;
				}
			} else {
				return c.gold - this.gold;
			}
		}
		
		@Override
		public String toString() {
			return this.idx + " : ( " + this.gold + ", " + this.silver + ", " + this.bronze + " )"; 
		}
	}
	
	public void sol_8979() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Country[] c = new Country[N];
		Country cmp = new Country(0, 0, 0, 0);
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			int gold = Integer.parseInt(st.nextToken());
			int silver = Integer.parseInt(st.nextToken());
			int bronze = Integer.parseInt(st.nextToken());
			c[i] = new Country(idx, gold, silver, bronze);
			
			if (idx == K) {
				cmp = c[i];
			}
		}
		Arrays.sort(c);
		
		int ans = 1;
		for (Country con : c) {
			if (con.compareTo(cmp) < 0) {
				ans++;
			}
			if (con == cmp) {
				break;
			}
		}
		
		System.out.println(ans);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_8979();
	}

}
