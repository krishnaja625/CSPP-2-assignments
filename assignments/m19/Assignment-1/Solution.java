import java.util.Scanner;

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
     * @param      s              The scanner object for user input
     * @param      quiz           The quiz object
     * @param      questionCount  The question count
     */
    public static void loadQuestions(final Scanner s, final Quiz quiz, final int questionCount) {
        // write your code here to read the questions from the console
        // tokenize the question line and create the question object
        // add the question objects to the quiz class
        int k = 0;
        Quiz[] questionObject = new Quiz[questionCount];
        for (int i = 0; i < questionCount; i++) {
        	String[] data = s.nextLine().split(":");
        	String[] choices = data[1].split(",");
        	/*quiz = new Quiz(data[0], Integer.parseInt(data[2]), Integer.parseInt(data[3]),
                    Integer.parseInt(data[4]), questionCount);
        	questionObject[i] = quiz;*/

        for (int j = 0; j <= data.length; j++) {
        	if (data[j].equals("")) {
        		
        		k = 1;
        		break;
        	}
        }
    }
            if (questionCount == 0){
        	System.out.println("Quiz does not have questions");
        }
    else if (k != 1){
    	System.out.println(questionCount + " are added to the quiz");
    	
        	
        } else {
        	System.out.println("Error! Malformed question");
        	
        }
    }

    /**
     * Starts a quiz.
     *
     * @param      s            The scanner object for user input
     * @param      quiz         The quiz object
     * @param      answerCount  The answer count
     */
    public static void startQuiz(final Scanner s, final Quiz quiz, final int answerCount) {
        // write your code here to display the quiz questions
        // read the user responses from the console
        // store the user respones in the quiz object
    }

    /**
     * Displays the score report
     *
     * @param      quiz     The quiz object
     */
    public static void displayScore(final Quiz quiz) {
        // write your code here to display the score report
/*        for(int i =0; i < quiz.questionCount(); i++) {
        	System.out.println(quiz.questionObject[i].questionText());


        }*/
        
/*        question text 1
 Correct Answer! - Marks Awarded: 1
question text 2
 Correct Answer! - Marks Awarded: 2
question text 3
 Correct Answer! - Marks Awarded: 3
question text 4
 Correct Answer! - Marks Awarded: 4
Total Score: 10*/
    }
}
class Quiz {
        	private int correctChoice;
        	private int marksAwarded;
        	private int penalty;
        	private String questionText;
        	private int questionCount;
    /**
     * Constructs the object.
     *
     * @param      movieName        The movie name
     * @param      showDateandTime  The show dateand time
     * @param      seats            The seats
     */
    Quiz() {

    }
/*    public Quiz(String questionText, int corectChoice, int marksAwarded, int penalty, int questionCount) {
        this.corectChoice = corectChoice;
        this.marksAwarded = marksAwarded;
        this.penalty = penalty;
        this.questionText = questionText;
        this.questionCount = questionCount;
    }
    public String questionText() {
    	return questionText;
    }*/
}