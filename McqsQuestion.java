import java.util.Scanner;
import java.util.Arrays; // Added for array comparison

public class McqsQuestion {
    // small research on how others have done this task before
    // 3 memebrs, with the first as the question and then the user should enetr a b c, for the array,
    // and you decide if its right or wrong

    // you can decide if the correct answers will show up at the end or as sonn aasthey enter
    // method to compare 
    // you can ask to enter abc or 123 or the actual answer 
    // object of that mcq needs to run in the main

    private String question;
    private String[] answer;
    private String correctAnswer;

    public McqsQuestion(String question, String[] answer, String correctAnswer){
        this.answer = answer;
        this.question = question;
        this.correctAnswer = correctAnswer;
    }

    /* --------------------------- getters and setters -------------------------- */
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getAnswer() {
        return answer;
    }

    public void setAnswer(String[] answer) {
        this.answer = answer;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    /* -------------------------------- toString -------------------------------- */
    @Override
    public String toString(){
        return question + "\n" + Arrays.toString(answer); // Fixed: Proper array printing
    }

    /* --------------------------------- equals --------------------------------- */
    public boolean equals(Object obj){
        if(obj instanceof McqsQuestion) {
            McqsQuestion other = (McqsQuestion)obj;
            boolean isQuestionSame = this.question.equals(other.getQuestion());
            boolean isAnswerSame = Arrays.equals(this.answer, other.getAnswer()); // Fixed: Proper array comparison
            boolean isCorrectAnswerSame = this.correctAnswer.equals(other.getCorrectAnswer()); // Fixed: String comparison
            return isQuestionSame && isAnswerSame && isCorrectAnswerSame;
        }
        return false;
    }

    /* ----------------------- creating the main function ----------------------- */
    public static void main(String[] args)
    {        
        String question = "What is the color of the sky?";
        String[] options = {"A) Light teal","B) Majorelle blue","C) Persian Blue"};
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
