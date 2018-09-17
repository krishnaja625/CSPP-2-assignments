import java.util.Scanner;
/**
 * Class for question.
 */
class Question {
    /**
     * { var_description }.
     */
    private String questiontext;
    /**
     * { var_description }.
     */
    private String[] choices;
    /**
     * { var_description }.
     */
    private int correctAnswer;
    /**
     * { var_description }.
     */
    private int maxMarks;
    /**
     * { var_description }.
     */
    private int penalty;
    /**
     * { var_description }.
     */
    private String response;
    /**
     * Constructs the object.
     */
    Question() {

    }
    /**
     * Constructs the object.
     *
     * @param      question1       The question 1
     * @param      choices1        The choices 1
     * @param      correctAnswer1  The correct answer 1
     * @param      maxMarks1       The maximum marks 1
     * @param      penalty1        The penalty 1
     */
    Question(final String question1, final String[] choices1,
        final int correctAnswer1, final int maxMarks1, final int penalty1) {
        questiontext = question1;
        choices = choices1;
        correctAnswer = correctAnswer1;
        maxMarks = maxMarks1;
        penalty = penalty1;
        response = "";

    }
    /**
     * { function_description }.
     *
     * @param      choice  The choice
     *
     * @return     { description_of_the_return_value }
     */
    public boolean evaluateResponse(final String choice) {
        if (getCorrectAnswer().equals(choice)) {
            return true;
        }
        return false;
    }
    /**
     * Gets the correct answer.
     *
     * @return     The correct answer.
     */
    public String getCorrectAnswer() {
        return this.choices[this.correctAnswer - 1];
    }
    /**
     * Gets the question text.
     *
     * @return     The question text.
     */
    public String getQuestionText() {
        return this.questiontext;
    }
    /**
     * Gets the choice.
     *
     * @return     The choice.
     */
    public String[] getChoice() {
        return choices;
    }
    /**
     * Gets the maximum marks.
     *
     * @return     The maximum marks.
     */
    public int getMaxMarks() {
        return maxMarks;
    }
    /**
     * Gets the penalty.
     *
     * @return     The penalty.
     */
    public int getPenalty() {
        return penalty;
    }
    /**
     * Sets the response.
     *
     * @param      answer  The answer
     */
    public void setResponse(final String answer) {
        this.response = answer;

    }
    /**
     * Gets the response.
     *
     * @return     The response.
     */
    public String getResponse() {
        return this.response;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String s = getQuestionText() + "(" + getMaxMarks() + ")" + "\n";
        for (int i = 0; i < choices.length - 1; i++) {
            s += choices[i] + "\t";
        }
        s += choices[choices.length - 1] + "\n";
        return s;
    }
}
/**
 * Class for quiz.
 */
class Quiz {
    /**
     * { var_description }.
     */
    private final int onehundred = 100;
    /**
     * { var_description }.
     */
    private Question[] questions;
    /**
     * { var_description }.
     */
    private int size;
    private String[] responses;
    private int sizeres;
    /**
     * Constructs the object.
     */
    Quiz() {
        questions = new Question[onehundred];
        size = 0;
    }
    /**
     * Adds a question.
     *
     * @param      q     The question
     */
    public void addQuestion(final Question q) {
        questions[size++] = q;

    }
    /**
     * Gets the question.
     *
     * @param      index  The index
     *
     * @return     The question.
     */
    public Question getQuestion(final int index) {
        return questions[index];
    }

    /**
     * Shows the report.
     *
     * @return     { description_of_the_return_value }
     */
    public String showReport() {
        String s = "";
        int total = 0;
        if (size != 0) {
        for(int i = 0; i < size; i++) {
            s += getQuestion(i).getQuestionText() + "\n";
            String[] list = getQuestion(i).getResponse().split(" ");

            if(getQuestion(i).evaluateResponse(list[1])) {
                s += " Correct Answer! - Marks Awarded: "+ getQuestion(i).getMaxMarks() + "\n";
                total += getQuestion(i).getMaxMarks();
            }
            else {
                s += " Wrong Answer! - Penalty: "+ getQuestion(i).getPenalty() + "\n";
                total += getQuestion(i).getPenalty();
            }
        }
        s += "Total Score: "+ total;
    }
        return s;
    }
    }

/**
 * Solution class for code-eval.
 */
public final class Solution {
     /**
     * Constructs the object.
     */
    private Solution() {
        // leave this blank
    }
    private static boolean flag = true;
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
         // instantiate this Quiz
        Quiz q = new Quiz();
         // code to read the test cases input file
        Scanner s = new Scanner(System.in);
        // check if there is one more line to process
        while (s.hasNext()) {
            // read the line
            String line = s.nextLine();
             // split the line using space
            String[] tokens = line.split(" ");
              // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
                case "LOAD_QUESTIONS":
                System.out.println("|----------------|");
                System.out.println("| Load Questions |");
                System.out.println("|----------------|");
                loadQuestions(s, q, Integer.parseInt(tokens[1]));
                break;
                case "START_QUIZ":
                System.out.println("|------------|");
                System.out.println("| Start Quiz |");
                System.out.println("|------------|");
                startQuiz(s, q, Integer.parseInt(tokens[1]));
                break;
                case "SCORE_REPORT":
                System.out.println("|--------------|");
                System.out.println("| Score Report |");
                System.out.println("|--------------|");
                displayScore(q);
                break;
                default:
                break;
            }
        }
    }
    /**
     * Loads questions.
     *
     * @param      scan       The scan
     * @param      quiz       The quiz
     * @param      q          The question count
     *
     */
    public static void loadQuestions(final Scanner scan,
        final Quiz quiz, final int q) {
        // write your code here to read the questions from the console
        // tokenize the question line and create the question object
        // add the question objects to the quiz class
        final int z = 4;
        final int y = 3;
        final int w = 10;
        final int five = 5;
        String[] choices = new String[w];
        String[] data = new String[q];
        if (q < 1) {
            System.out.println("Quiz does not have questions");
            flag = false;
            return;
        }
        for (int i = 0; i < q; i++) {
            String s = scan.nextLine();
            data = s.split(":");
            if (data.length != five || data[0].equals("")) {
                System.out.println("Error! Malformed question");
                flag = false;
                return;
            }
            String[] choice = data[1].split(",");
            if (choice.length < 2) {
                System.out.println(data[0] + " "
                + "does not have enough answer choices");
                flag = false;
                return;
            }
            if (Integer.parseInt(data[2]) < 1
                    || Integer.parseInt(data[2]) > choice.length) {
                System.out.println("Error! Correct answer choice number"
                    + " " + "is out of range for" + " " + data[0]);
                flag = false;
                return;
            }
            if (Integer.parseInt(data[y]) <= 0) {
                System.out.println("Invalid max marks for" + " " + data[0]);
                flag = false;
                return;
            }
            if (Integer.parseInt(data[z]) > 0) {
                System.out.println("Invalid penalty for" + " " + data[0]);
                flag = false;
                return;
            }
            quiz.addQuestion(new Question(data[0], choice,
            Integer.parseInt(data[2]), Integer.parseInt(data[y]),
            Integer.parseInt(data[z])));
        }
        System.out.println(q + " " + "are added to the quiz");
    }
    /**
     * Starts a quiz.
     *
     * @param      scan  The scan
     * @param      quiz  The quiz
     * @param      q     The answer count
     */
    public static void startQuiz(final Scanner scan,
        final Quiz quiz, final int q) {
        // write your code here to display the quiz questions on the console.
        // read the user responses from the console using scanner object.
        // store the user respone in the question object
        /*quiz.displayQuiz();*/

        if (!flag) {
            return;
        }
        for (int i = 0; i < q; i++) {
            Question ques = quiz.getQuestion(i);
            System.out.println(ques);
            String line = scan.nextLine();
            ques.setResponse(line);
        }
    }
    /**
     * Displays the score report.
     *
     * @param      quiz     The quiz object
     */
    public static void displayScore(final Quiz quiz) {
        // write your code here to display the score report using quiz object.
        System.out.println(quiz.showReport());
        
    }
}
