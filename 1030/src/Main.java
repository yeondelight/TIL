import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {
	
	class Student implements Comparable<Student> {
		String name;
		int day;
		int month;
		int year;
		
		public Student (String name, int day, int month, int year) {
			this.name = name;
			this.day = day;
			this.month = month;
			this.year = year;
		}
		
		@Override
		public int compareTo(Student s) {
			if (this.year == s.year) {
				if (this.month == s.month) {
					return this.day - s.day;
				} else {
					return this.month - s.month;
				}
			} else {
				return this.year - s.year;
			}
		}
	}
	
	public void sol_5635() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Vector<Student> v = new Vector<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int day = Integer.parseInt(st.nextToken());
			int month = Integer.parseInt(st.nextToken());
			int year = Integer.parseInt(st.nextToken());
			
			v.add(new Student(name, day, month, year));
		}
		
		Collections.sort(v);

		System.out.println(v.lastElement().name);
		System.out.println(v.firstElement().name);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().sol_5635();
	}
}
