import java.util.Scanner;

public class Lab3 {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        Scanner in = new Scanner(System.in);
        boolean running = true;
        int choice;


        while(running){
            System.out.println("""
                    What would you like to do?
                    1. Add a question to the quiz
                    2. Remove a question from the quiz
                    3. Modify a question in the quiz
                    4. Take the quiz
                    5. Quit""");
            choice = in.nextInt();
            in.nextLine();
            switch(choice){
                case 1:
                    quiz.addQuestion();
                    break;
                case 2:
                    quiz.removeQuestion();
                    break;
                case 3:
                    quiz.editQuestion();
                    break;
                case 4:
                    int numRight = 0;
                    for(int i = 0; i < quiz.size(); i++){
                        quiz.printQuestion(i);
                        System.out.print("Answer: ");
                        if(quiz.checkAnswer(i,in.nextLine())){
                            System.out.println("Correct");
                            numRight++;
                        }
                        else{
                            System.out.println("Incorrect");
                        }
                    }
                    System.out.println("You got " + numRight + " out of " + quiz.size());
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid Input");
            }
        }
    }
}
