public class Question {
    private String question;
    private String answer;
    private int difficulty;

    //setters
    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    //getters
    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public int getDifficulty() {
        return difficulty;
    }
}
