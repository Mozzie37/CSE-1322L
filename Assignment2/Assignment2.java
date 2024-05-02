import java.util.Scanner;

public class Assignment2 {
    public static void main(String[] args) {
        English english = new English();
        Scanner in = new Scanner(System.in);

        int letters, choice;
        String lettersOfChoice;

        System.out.println("How many letters are in the word");
        letters = in.nextInt();

        System.out.println("Do you want to look for letters or a pattern?\n1. Letters\n2. Pattern");
        choice = in.nextInt();
        in.nextLine();
        System.out.println("What letters are in the word? ");
        lettersOfChoice = in.nextLine();

        System.out.println("It might be any of these...");

        switch(choice){
            case 1:
                guessWordWithLetters(english, letters, lettersOfChoice);
                break;
            case 2:
                guessWordWithPattern(english, letters, lettersOfChoice);
                break;
            default:
                System.out.println("IDK bro...");
        }





    }

    static boolean wordContainsLetter(String word, char letter){
        char[] letterArray = word.toCharArray();
        for(int i = 0; i < letterArray.length; i++){
            if(letterArray[i] == letter){
                return true;
            }
        }
        return false;
    }

    static boolean wordContainsString(String word, String phrase){
        return word.contains(phrase);
    }

    static void guessWordWithLetters(English english, int length, String letters){
        boolean containsLetter;
        char[] letterArray = letters.toCharArray();
        for(int i = 0; i < english.words.size(); i++){
            containsLetter = true;
            if(english.words.get(i).length() == length){ //if the possible word is the same length check if the letter is in it, otherwise skip
                for(int j = 0; j < letterArray.length; j++){
                    if(!wordContainsLetter(english.words.get(i),letterArray[j])){
                        containsLetter = false;
                    }
                }
                if(containsLetter ){
                    System.out.println(english.words.get(i));
                }
            }

        }
    }

    static void guessWordWithPattern(English english, int length, String pattern){
        boolean containsPattern;
        for(int i = 0; i < english.words.size(); i++){
            containsPattern = false;
            if(english.words.get(i).length() == length && wordContainsString(english.words.get(i), pattern)){
                System.out.println(english.words.get(i));
            }
        }

    }
}
