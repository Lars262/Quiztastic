package quiztastic.core;

/**
 * The Question Class.
 *
 * Should contain information about the questions
 */
public class Question {
    private final int score;
    private String category;
    private String question;
    private String answer;


    public Question(int score) {
        this.score = score;
        this.question = question;
        this.category = category;
        this.answer = answer;
    }

    public int getScore() {
        return score;
    }

    public String getQuestion() {
        return question;
    }

    public String getcategory() {return category;}

    public String getanswer() {return answer;}
}
