/* This is part of the starter code! 
 * You need to complete this class yourself!*/
package util;
import java.util.*;

public class Gradebook {

    private final ArrayList <Student> listOfStudents;

	public Gradebook (ArrayList <Student> listOfStudents) {
		this.listOfStudents = listOfStudents;
	}
	// constructor that imports ArrayList of type Student

	public double calculateAvg() {
	double sum = 0;
	for(Student s: listOfStudents)
	    sum += s.getGrade().getScore();
	return sum / listOfStudents.size();
    }
	//calculates average of students using enhanced for loop
	// adds all scores of students in ArrayList & divides by sum

    public float calculateMedian() {
	int i = 0, n = listOfStudents.size();
	int[] scores = new int[n];
	for(Student s: listOfStudents)
	    scores[i++] = s.getGrade().getScore();
	Arrays.sort(scores);
	if (n % 2 == 0)
	    return (scores[n / 2] + scores[n / 2 - 1]) / 2.0f;
	else
	    return scores[n / 2];
    }
	// calculates median of students in ArrayList
	// if even, finds average of middle two index in ArrayList

    public void printAllStudents() {
	for(Student s: listOfStudents)
		System.out.printf("%s\t%s\t%d\t%d\n", s.getFirstName(),
				s.getLastName(), s.getPid(), s.getGrade().getScore());
    }
	//prints all student info with tabs

	public double minScore() {
		double minScore = 100;
		for(Student s: listOfStudents)
			if(s.getGrade().getScore() < minScore){
				minScore = s.getGrade().getScore();
			}
		return minScore;
	}
	// finds min score by looping ArrayList and updating min number variable if lower than max value

	public double maxScore() {
		double maxScore = 0;
		for(Student s: listOfStudents)
			if(s.getGrade().getScore() > maxScore){
				maxScore = s.getGrade().getScore();
			}
		return maxScore;
	}
	// finds max score by looping ArrayList and updating max number if higher than min value

	public String maxLetter() {

		Grade g = new Grade((int) maxScore());
		return g.getLetterGrade();
	}
	// find max letter by creating Grade object and input maxScore()
	// macScore() is passed through scoreConvert function which generates letter grade

	public String minLetter() {

		Grade g = new Grade((int) minScore());
		return g.getLetterGrade();

	}
	// same concept as max letter except input is minScore() function.
	// lowest score is passed through score convert and Letter Grade Getter is called.

	public String letter(String pid) {

//		System.out.println(pid);
		for (Student s: listOfStudents){
			if(s.getPid() == Integer.parseInt(pid))
				return s.getLetterGrade();
		}

		return "Student Not Found";
	}
	// scanner takes input from user, if PID matches a PID in the ArrayList,
	// program then returns letter grade of student with matching PID
	// however, if PID does not match a PID in the ArrayList, program prints "student not found"

	public String name(String pid) {
		for (Student s: listOfStudents){
			if(s.getPid() == Integer.parseInt(pid))
				return s.getFirstName() + " " + s.getLastName();
		}
		return "Student Not Found";
	}
	// user enters pid, if pid matches pid in ArrayList, then student first and last name is printed
	// however, if PID does not match a PID in the ArrayList, program prints "student not found"

	public void change(String pid, int score) {
		if (0 <= score && score <= 100){
			for (Student s: listOfStudents){
				if(s.getPid() == Integer.parseInt(pid)){
					Grade g = new Grade(score);
					s.change(g);
				}
			}
		}
	}
	// this function changes grade of student
	// takes two inputs -- String pid & int score
	// if score is within 0 - 100, run loop
	// then if PID matches a PID in ArrayList, then score = score user entered
	// creates Grade object with input score
	// then calls change() function in student glass - which takes input type Grade and updates info in Student ArrayList


	public String averageLetter(){

		Grade g = new Grade((int) calculateAvg());
		return g.getLetterGrade();
	}
	// finds average letter by creating Grade Object with input calculateAvg() function
	// Letter Grade getter then returns average in letter grade form.

	public String medianLetter(){

		Grade g = new Grade((int) calculateMedian());
		return g.getLetterGrade();

	}
	// finds median letter by creating Grade Object with input calculateMedian() function
	// Letter Grade getter then returns median in letter grade form.

	public void tabLetters() {
		for(Student s: listOfStudents)
			System.out.printf("%s\t%s\t%d\t%s\n", s.getFirstName(),
					s.getLastName(), s.getPid(), s.getLetterGrade());
	}
	//prints all students inside ArrayList with letter grades
}
