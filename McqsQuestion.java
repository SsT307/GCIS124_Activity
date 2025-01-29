import java.util.Scanner;
import java.util.Arrays;

/*
*           *           *           *           *           *           *           *           *
* Students: Shaikha Alhajri, Noora Almidfa, Adeeb Harb
* Activity 1: In this assignment, we were given the task to create a system in which we give a
* user some question and have them answer that question from a given array of 3 multiple choice
* answers. Once the user inputs his/her answer, the system immediatly reveals whether the answer
* was right or wrong, and if it was wrong, it would also reveal the right answer.
* We were also asked to create a UML for this project before starting, which is uploaded along with
* this file.
*           *           *           *           *           *           *           *           *
*/

public class McqsQuestion {
    /* 
     * First we had to initialize the memebers of our class which includes a String for the question,
     * an array of strings for the answers, and a String that contains the right answer.
     */
    private String question;
    private String[] answer;
    private String correctAnswer;

    /**
     * initializes the question, answer options, and the correct answer.
     * @param question      The question that the user has to answer
     * @param answer        An array of the multiple answer choices
     * @param correctAnswer The correct answer to the question
     */
    public McqsQuestion(String question, String[] answer, String correctAnswer) {
        this.answer = answer;
        this.question = question;
        this.correctAnswer = correctAnswer;
    }

    
    /* --------------------------- getters and setters -------------------------- */
    /* We created a set of mutators and accessors because our members are private and
     * cannot be accessed without them.
     */
    
    /**
     * Gets the value of the question
     * @return String of the question
     */
    public String getQuestion() { return question; }

    /**
     * Sets the question
     * @param question the new question
     */
    public void setQuestion(String question) { this.question = question; }

    /**
     * Gets an array of the answer options (strings)
     * 
     * @return string input for array of answers
     */
    public String[] getAnswer() { return answer; }

    /**
     * Sets the answer choices
     * @param answer the new answers
     */
    public void setAnswer(String[] answer) { this.answer = answer; }

    /**
     * Gets the value of the correct answer
     * @return string of the correct answer
     */
    public String getCorrectAnswer() { return correctAnswer; }

    /**
     * Sets the correct answer
     * @param correctAnswer the new correct answer
     */
    public void setCorrectAnswer(String correctAnswer) { this.correctAnswer = correctAnswer; }


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
     * First it checks the instances of the two objects.
     * Then checks if the objects' questions, answers, and answers match, if so
     * then it returns true, or else it would return false.
     */
    public boolean equals(Object obj) {
        if (obj instanceof McqsQuestion) {
            McqsQuestion other = (McqsQuestion)obj;
            return this.question.equals(other.getQuestion()) && Arrays.equals(this.answer, other.getAnswer()) && this.correctAnswer.equals(other.getCorrectAnswer());
        }
        return false;
    }

    /* ----------------------- creating the main function ----------------------- */
    /**
     * It displays the question, as well as the multiple choice options, and checks
     * the answer given by the user.
     * @param args
     */
    public static void main(String[] args) {
        /* 
         * We created the question, multiple choice answers, and set the correct answer.
         * Which we then used to create the object of "mcq".
         */
        String question = "What is the color of the sky?";
        String[] options = { "A) Persian Blue", "B) Majorelle blue", "C) Light teal" };
        String correctAns = "C";
        McqsQuestion mcq = new McqsQuestion(question, options, correctAns);

        /* 
         * We are scanning for an input from the user.
         * The system first prints out the question and then the multiple choices.
         * Then it asks the user to input their answer.
         * P.S Arrays.toString converts the content into something readable, without
         * it, the system was not able to compare the answer given and the actual answer.
         */
        Scanner scanner = new Scanner(System.in);
        System.out.print(mcq.getQuestion());
        System.out.println(Arrays.toString(mcq.getAnswer())); 
        System.out.print("Write A, B, or C: ");

        /*
         * The system first saves the String input given by the user into a variable, userAns,
         * then checks if the input from the user and the actual answer are equal using the
         * method equals.
         */
        String userAns = scanner.nextLine().toUpperCase();
        if (userAns == "A" || userAns == "B" || userAns == "C") {
            if (userAns.equals(mcq.getCorrectAnswer())) { // Fixed: Proper string comparison
                System.out.println("YIPPIEEEE You got it!!");
            } else {
                System.out.println("Nah, loser! The correct answer was " + mcq.getCorrectAnswer());
            }
            } else {
                System.out.println("Invalid input. Please enter A, B, or C");
        }

        scanner.close();
    }
}
