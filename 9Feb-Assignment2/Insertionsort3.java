class Trainee {
	int rollno;
	String name;
	float cppmarks;
	float fullstack;
	float java;

	Trainee(int rollno, String name, float cppmarks, float fullstack, float java) {
		this.rollno = rollno;
		this.name = name;
		this.cppmarks = cppmarks;
		this.fullstack = fullstack;
		this.java = java;
	}
}

public class Insertionsort3 {
	public static void main(String[] args) {

		Trainee[] t = {
			new Trainee(1, "Aman", 80, 75, 70),
			new Trainee(2, "Ravi", 80, 75, 85),
			new Trainee(3, "Neha", 85, 60, 90),
			new Trainee(4, "Sita", 80, 70, 60)
		};

		for (int i = 1; i < t.length; i++) {

			Trainee key = t[i];
			int j = i - 1;

			while (j >= 0) {

				if (t[j].cppmarks < key.cppmarks
						|| (t[j].cppmarks == key.cppmarks && t[j].fullstack < key.fullstack)
						|| (t[j].cppmarks == key.cppmarks && t[j].fullstack == key.fullstack
								&& t[j].java < key.java)) {

					t[j + 1] = t[j];
					j--;
				} else {
					break;
				}
			}

			t[j + 1] = key;
		}

		for (Trainee tr : t) {
			System.out.println(tr.rollno + " " + tr.name + " "
					+ tr.cppmarks + " " + tr.fullstack + " " + tr.java);
		}
	}
}
