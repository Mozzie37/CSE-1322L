import java.util.ArrayList;
import java.util.Scanner;

public class Quiz {
    ArrayList<Question> quiz = new ArrayList<Question>();
    Scanner in = new Scanner(System.in);

    void addQuestion(){
        int difficulty;
        Question question = new Question();
        System.out.println("What is the question?");
        question.setQuestion(in.nextLine());
        System.out.println("What is the answer?");
        question.setAnswer(in.nextLine());
        do{
            System.out.println("What is the difficulty? (1-3)");
            difficulty = in.nextInt();
            in.nextLine();
            if(difficulty > 0 && difficulty < 4){
                question.setDifficulty(difficulty);
                break;
            }
            System.out.println("That is not a valid input!");
        }while(true);
        quiz.add(question);
    }
    void removeQuestion(){
        int choice;
        printQuestions();
        do {
            System.out.println("Which question would you like to remove?");
            choice = in.nextInt();
            if(choice >= 0 && choice < quiz.size()){
                quiz.remove(choice);
                break;
            }
            System.out.println("That is not a valid index.");
        }while(true);
    }
    void editQuestion(){
        printQuestions();
        int questionNum;
        Question question = new Question();
        do{
            System.out.println("Which question do you want to edit?");
            questionNum = in.nextInt();
            in.nextLine();
            if(questionNum >= 0 && questionNum < quiz.size()){
                break;
            }
            System.out.print("That is not a valid index.");
        }while(true);
        System.out.println("What is the new Question?");
        question.setQuestion(in.nextLine());
        System.out.println("What is the new Answer?");
        question.setAnswer(in.nextLine());
        System.out.println("What is the new difficulty?");
        question.setDifficulty(in.nextInt());
        in.nextLine();
        quiz.set(questionNum, question);

    }
    int size(){
        return quiz.size();
    }
    void printQuestion(int index){
        System.out.println(quiz.get(index).getQuestion());
    }
    boolean checkAnswer(int index, String input){
        return input.equals(quiz.get(index).getAnswer());
    }
    private void printQuestions(){
        for (int i = 0; i < quiz.size(); i++){
            System.out.println(i + ") " + quiz.get(i).getQuestion());
        }
    }
}
