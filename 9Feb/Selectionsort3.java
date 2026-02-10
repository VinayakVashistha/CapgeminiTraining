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

public class Selectionsort3 {
	public static void main(String[] args) {

		Trainee[] t = {
			new Trainee(1, "Aman", 80, 75, 70),
			new Trainee(2, "Ravi", 80, 75, 85),
			new Trainee(3, "Neha", 85, 60, 90),
			new Trainee(4, "Sita", 80, 70, 60)
		};

		for (int i = 0; i < t.length - 1; i++) {

			int maxIndex = i;

			for (int j = i + 1; j < t.length; j++) {

				if (t[maxIndex].cppmarks < t[j].cppmarks
						|| (t[maxIndex].cppmarks == t[j].cppmarks
								&& t[maxIndex].fullstack < t[j].fullstack)
						|| (t[maxIndex].cppmarks == t[j].cppmarks
								&& t[maxIndex].fullstack == t[j].fullstack
								&& t[maxIndex].java < t[j].java)) {

					maxIndex = j;
				}
			}

			if (maxIndex != i) {
				Trainee temp = t[i];
				t[i] = t[maxIndex];
				t[maxIndex] = temp;
			}
		}

		for (Trainee tr : t) {
			System.out.println(tr.rollno + " " + tr.name + " "
					+ tr.cppmarks + " " + tr.fullstack + " " + tr.java);
		}
	}
}
