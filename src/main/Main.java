/* This is part of the starter code! 
 * You need to complete this class yourself!*/
package main;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import util.*;

public class Main {

    public static void main(String[] args) {

        Gradebook myGradebook; // creates Gradebook object
        ArrayList <Student> myStudents = new ArrayList<>(); //creates ArrayList of type Student called myStudents
        Scanner scan = new Scanner(System.in);  // Create a Scanner object called scan - takes input from terminal

        System.out.println(
                """
                        Welcome to my grade book!
                        Please enter the information of the first student using the following format: “FirstName LastName PID(8digits) grade(int)”.
                        Press Enter when you are done.""");

        //----------------------------------------------------------------------------------------------
        // input section
        //----------------------------------------------------------------------------------------------

        while (true) {
            // while loop runs infinitely until break trigger or until user enters "DONE"

            String [] studentsInfo = scan.nextLine().split(" ");
            // stores scanner in a String array called studentsInfo
            // .split() separates elements by space character

            if (studentsInfo[0].equals("DONE")) {
                myGradebook = new Gradebook(myStudents);
                // once user enters "DONE", Student ArrayList is added to Gradebook
                break;
            } else {

                if ( (!validFirstName(studentsInfo[0]) || (!validLastName(studentsInfo[1]))
                    || (!validPID(studentsInfo[2])) ||  (!validScore(Integer.parseInt(studentsInfo[3])) ))){
                    System.out.println("Try again");
                    // if input does not meet all conditions, program prints "try again"

                } else {
                    Student student = new Student(studentsInfo[0], studentsInfo[1], Integer.parseInt(studentsInfo[2]),
                            new Grade(Integer.parseInt(studentsInfo[3])));
                    // if all input conditions met, program creates Student object & adds to Student ArrayList
                    // studentInfo is String array, however Student class constructor requires following format --
                    // String, String, int, Grade

                    myStudents.add(student);
                    System.out.println("'"+studentsInfo[0] + " " + studentsInfo[1] + "'" + " is added to the grade book. Enter 'DONE' after adding all students.");
                    //add object to ArrayList
                }
            }
        }//end while

        //-------------------------------------------------------------------------------------------------
        //command loop section
        //--------------------------------------------------------------------------------------------------

        System.out.println("""
                Welcome to Command Loop. Please enter a command.
                Here are your options: min score, min letter, max score, max letter,
                letter, name, change, average score, average letter,
                median score, median letter, tab scores, tab letters, or quit.
                ...Remember, we are using the grading scale found in the Programming II syllabus :)""");
        while (true) {
            //while loop will run infinitely until break trigger

            String commandLine = scan.nextLine();
            // Scanner object is stored in String commandLine
            // .nextLine() reads input including space between words
            // .next() can read input only till the space

            Scanner scan2 = new Scanner(System.in);
            // this will be used for the input commands
            // this way I do not see 'invalid command' when typing the inputs


            if (Objects.equals(commandLine, "quit")){
                break;
                //this command will stop the code
            } else {
                // all of these commands run functions in Gradebook class

                if (commandLine.equals("min score")){
                    System.out.println(myGradebook.minScore());
                }
                else if (commandLine.equals("min letter")){
                    System.out.println(myGradebook.minLetter());
                }
                else if (commandLine.equals("max score")){
                    System.out.println(myGradebook.maxScore());
                }
                else if (commandLine.equals("max letter")){
                    System.out.println(myGradebook.maxLetter());
                }
                else if (commandLine.equals("letter")){
                    System.out.println("Enter a PID: ");
                    String pid = scan2.next();
                    System.out.println(myGradebook.letter(pid));
                }
                else if (commandLine.equals("name")){
                    System.out.println("Enter a PID: ");
                    String pid = scan2.next();
                    System.out.println(myGradebook.name(pid));
                }
                else if (commandLine.equals("change")){
                    System.out.println("Enter a PID: ");
                    String pid = scan2.next();
                    System.out.println("Enter a new score grade: ");
                    String score = scan2.next();
                    myGradebook.change(pid, Integer.parseInt(score));
                    System.out.println("New grade: "+ score);
                    //scanners are storing the data entered by user in String variables 'score' & 'pid'
                    //then variables are inputted in Gradebook Change method
                }
                else if (commandLine.equals("average score")){
                    System.out.println(myGradebook.calculateAvg());
                }
                else if (commandLine.equals("average letter")){
                    System.out.println(myGradebook.averageLetter());
                }
                else if (commandLine.equals("median score")){
                    System.out.println(myGradebook.calculateMedian());
                }
                else if (commandLine.equals("median letter")){
                    System.out.println(myGradebook.medianLetter());
                }
                else if (commandLine.equals("tab scores")){
                    myGradebook.printAllStudents();
                }
                else if (commandLine.equals("tab letters")){
                    myGradebook.tabLetters();
                }
                else if (commandLine.equals("quit")){
                    break;
                }
                else {
                    System.out.println("invalid command");
                }

            }// end else

        }// end while

    }// end main

    //---------------------------------------------------------------------------------------------------
    // input conditions
    //----------------------------------------------------------------------------------------------------

    public static boolean validFirstName(String name) {
        return Character.isUpperCase(name.charAt(0)) && name.matches("[a-zA-Z]+");
    }
    // firstname is true if first letter is uppercase & an alphabetical letter

    public static boolean validLastName(String name){
       int counterPeriod = 0;
           for(int x = 0; x < name.length(); x++){
               if(name.charAt(x) == '.'){
                   counterPeriod++;
               }
       }
        return Character.isUpperCase(name.charAt(0)) && name.matches("[a-zA-Z].+")
                && counterPeriod<=1;
    }
    // lastname is true if first letter is uppercase & an alphabetical letter  & contains one "." or less

    public static boolean validPID(String pid){
        return Integer.parseInt(pid) < 10000000 && Integer.parseInt(pid) >= 1000000 ;
    }
    // String PID is converted to Integer. If integer is between 10000000 & 1000000
    // return true
    // creates sevenDigit number with NO leading zeros

    public static boolean validScore(int score){
        return 0 <= score && score <= 100;
    }
    //score is true if value is between 0 and 100 (inclusive)

}// end class

