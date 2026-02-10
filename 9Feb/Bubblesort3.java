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

public class MarksSorting {
	public static void main(String[] args) {

		Trainee[] t = { new Trainee(1, "Aman", 80, 75, 70), new Trainee(2, "Ravi", 80, 75, 85),
				new Trainee(3, "Neha", 85, 60, 90), new Trainee(4, "Sita", 80, 70, 60) };

		for (int i = 0; i < t.length - 1; i++) {
			for (int j = 0; j < t.length - i - 1; j++) {

				if (t[j].cppmarks < t[j + 1].cppmarks
						|| (t[j].cppmarks == t[j + 1].cppmarks && t[j].fullstack < t[j + 1].fullstack)
						|| (t[j].cppmarks == t[j + 1].cppmarks && t[j].fullstack == t[j + 1].fullstack
								&& t[j].java < t[j + 1].java)) {

					Trainee temp = t[j];
					t[j] = t[j + 1];
					t[j + 1] = temp;
				}
			}
		}

		for (Trainee tr : t) {
			System.out.println(tr.rollno + " " + tr.name + " " + tr.cppmarks + " " + tr.fullstack + " " + tr.java);
		}
	}
}