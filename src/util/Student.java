/* This is part of the starter code! 
 * You need to complete this class yourself!*/
package util;

public class Student {
    private String firstName;
    private String lastName;
    private int pid;
    private Grade grade;
    // variables

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public int getPid() {
        return pid;
    }
    public Grade getGrade() {return grade;}

    public String getLetterGrade() {
        return grade.getLetterGrade();
    }
    /// these are GETTERS

    public void change(Grade grade){
        this.grade = grade;
    }

    public Student(String firstName, String lastName, int pid, Grade grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pid = pid;
        this.grade = grade;
    }
    // Constructor for Student class
    // Student ArrayList requires this input type & format
}
