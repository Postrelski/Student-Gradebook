/* This is part of the starter code! 
 * You need to complete this class yourself!*/
package util;

public class Grade {
    private int score;
    private String letterGrade;

    public int getScore() {
        return score;
    }
    public String getLetterGrade() {
        return letterGrade;
    }

    public Grade(int score) {
        this.score = score;
        this.letterGrade = scoreConvert(score);
    }

    public String scoreConvert(int score){
        if(score >= 90.0){
            letterGrade = "A";
        } else if ( score >= 85.0 && score < 90.0) {
            letterGrade = "A-";
        } else if ( score >= 80.0 && score < 85.0) {
            letterGrade = "B+";
        } else if ( score >= 75.0 && score < 80.0) {
            letterGrade = "B";
        } else if ( score >= 70.0 && score < 75.0) {
            letterGrade = "B-";
        } else if (score >= 65.0 && score < 70.0){
            letterGrade = "C+";
        }else if (score >= 60.0 && score < 65.0){
            letterGrade = "C";
        }else if (score >= 50.0 && score < 60.0){
            letterGrade = "D";
        }else letterGrade = "F";
        return letterGrade;
    }
    // Resembles grading system in our Programming II
    // Returns a String & inputs an int
    // Converts int score to string depending on range of int
}