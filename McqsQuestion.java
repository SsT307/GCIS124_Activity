import java.util.Scanner;

public class McqsQuestion {
    // small research on how others have done this task before
    // 3 memebrs, with the first as the question and then the user should enetr a b c, for the array,
    // and you decide if its right or wrong

    // you can decide if the correct answers will show up at the end or as sonn aasthey enter
    // method to compare 
    // you can ask to enter abc or 123 or the actual answer 
    // object of that mcq needs to run in the main

    private String question;
    private String[] answer;
    private String correctAnswer;

    public McqsQuestion(String question, String[] answer, String correctAnswer){
        this.answer = answer;
        this.question = question;
        this.correctAnswer = correctAnswer;
    }

    /* --------------------------- getters and setters -------------------------- */
    /**
     * 
     * @return
     */
    public String getQuestion() {
        return question; }

    /**
     * 
     * @param question
     */
    public void setQuestion(String question) {
        this.question = question; }

    /**
     * 
     * @return
     */
    public String[] getAnswer() {
        return answer; }

    /**
     * 
     * @param answer
     */
    public void setAnswer(String[] answer) {
        this.answer = answer; }

    /**
     * 
     * @return
     */
    public String getCorrectAnswer() {
        return correctAnswer; }

    /**
     * 
     * @param correctAnswer
     */
    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer; }

    /* -------------------------------- toString -------------------------------- */
    @Override
    public String toString(){
        return question + "\n" + answer;
    }
    /* --------------------------------- equals --------------------------------- */
    public boolean equals(Object obj){
        if(obj instanceof McqsQuestion) {
            McqsQuestion other = (McqsQuestion)obj;
            return this.question.equals(other.getQuestion()) && this.answer.equals(other.getAnswer()) && this.correctAnswer == other.getCorrectAnswer();
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
        System.out.println(mcq.getAnswer());
        System.out.print("Write A, B, or C: ");
        String userAns = scanner.nextLine().toUpperCase();
        

        if (userAns == mcq.getCorrectAnswer()){
            System.out.println("YIPPIEEEE You got it!!");
        } else {
            System.out.println("Nah, loser! The corect answer was "+ mcq.getCorrectAnswer());
        }

        scanner.close();
    }
    
}
