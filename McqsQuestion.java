import java.util.Scanner;
import java.util.Arrays; // Added for array comparison

/*In this activity, we created a system (with an important question and answer choices)in which we ask a multiple choice quesion (MCQ),
 * and the user is given 3 choices to choose from.
 * The user inputs his/hers choice, and is immediately shown whether the answer was correct or false.
 */
public class McqsQuestion {
    private String question;
    private String[] answer;
    private String correctAnswer;

    /**
     * initializes the question, answer options, and the correct answer.
     * 
     * @param question      The question
     * @param answer        An array of the answer choices
     * @param correctAnswer The correct answer to the question
     */
    public McqsQuestion(String question, String[] answer, String correctAnswer) {
        this.answer = answer;
        this.question = question;
        this.correctAnswer = correctAnswer;
    }

    /* --------------------------- getters and setters -------------------------- */
    /**
     * Gets the value of the question
     * 
     * @return String of the question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Sets the question
     * 
     * @param question the new question
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * Gets an array of the answer options (strings)
     * 
     * @return string input for array of answers
     */
    public String[] getAnswer() {
        return answer;
    }

    /**
     * Sets the answer choices
     * 
     * @param answer the new answers
     */
    public void setAnswer(String[] answer) {
        this.answer = answer;
    }

    /**
     * Gets the value of the correct answer
     * 
     * @return string of the correct answer
     */
    public String getCorrectAnswer() {
        return correctAnswer;
    }

    /**
     * Sets the correct answer
     * 
     * @param correctAnswer the new correct answer
     */
    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    /* -------------------------------- toString -------------------------------- */
    /**
     * We wrote this to set up the area for the question followed by the multiple
     * choice answers on a new line.
     * This shows the user the question, choices, and asks for the answer.
     */
    @Override
    public String toString() {
        return question + "\n" + Arrays.toString(answer); // Fixed: Proper array printing
    }

    /* --------------------------------- equals --------------------------------- */

    /**
     * This compares if the user's input is equal to the correct answer, or in other
     * words, is correct.
     * Checks if the objects question is the same, answers are the same, and if the
     * correct answer remains the same; and then returns true if everything is the
     * same.
     * Or else it would return false
     */
    public boolean equals(Object obj) {
        if (obj instanceof McqsQuestion) {
            McqsQuestion other = (McqsQuestion) obj;
            boolean isQuestionSame = this.question.equals(other.getQuestion());
            boolean isAnswerSame = Arrays.equals(this.answer, other.getAnswer()); // Fixed: Proper array comparison
            boolean isCorrectAnswerSame = this.correctAnswer.equals(other.getCorrectAnswer()); // Fixed: String
                                                                                               // comparison
            return isQuestionSame && isAnswerSame && isCorrectAnswerSame;
        }
        return false;
    }

    /* ----------------------- creating the main function ----------------------- */
    /**
     * It displays the question, as well as the multiple choice options, and checks
     * the answer inputted by the user.
     * 
     * @param args question, answer choices, and String of the feedback (correct
     *             answer).
     */
    public static void main(String[] args) {
        String question = "What is the color of the sky?";
        String[] options = { "A) Light teal", "B) Majorelle blue", "C) Persian Blue" };
        String correctAns = "A";

        McqsQuestion mcq = new McqsQuestion(question, options, correctAns);

        Scanner scanner = new Scanner(System.in);
        System.out.print(mcq.getQuestion());
        System.out.println(Arrays.toString(mcq.getAnswer())); // Fixed: Proper array printing
        System.out.print("Write A, B, or C: ");
        String userAns = scanner.nextLine().toUpperCase();

        if (userAns.equals(mcq.getCorrectAnswer())) { // Fixed: Proper string comparison
            System.out.println("YIPPIEEEE You got it!!");
        } else {
            System.out.println("Nah, loser! The correct answer was " + mcq.getCorrectAnswer());
        }

        scanner.close();
    }
}
