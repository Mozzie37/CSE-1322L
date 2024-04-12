
public class Lab1 {
    public static void main(String[] args){
        char array[][] = make_forward();
        char array2[][] = make_mirror(array);


        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                System.out.print(array2[i][j]);
            }
            System.out.println();
        }
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length * 2; j++){
                if(j < array[i].length){
                    System.out.print(array[i][j]);
                }
                else{
                    System.out.print(array2[i][j - array[i].length]);
                }
            }
            System.out.println();
        }
    }

    public static char[][] make_forward(){
        char[][] pixel = new char[4][13];
        pixel[0][0]=' ';
        pixel[0][1]=' ';
        pixel[0][2]='_';
        pixel[0][3]='_';
        pixel[0][4]='_';
        pixel[0][5]='_';
        pixel[0][6]='_';
        pixel[0][7]='_';
        pixel[0][8]=' ';
        pixel[0][9]=' ';
        pixel[0][10]=' ';
        pixel[0][11]=' ';
        pixel[0][12]=' ';
        pixel[1][0]=' ';
        pixel[1][1]='/';
        pixel[1][2]='|';
        pixel[1][3]='_';
        pixel[1][4]='|';
        pixel[1][5]='|';
        pixel[1][6]='_';
        pixel[1][7]='\\';
        pixel[1][8]='\'';
        pixel[1][9]='.';
        pixel[1][10]='_';
        pixel[1][11]='_';
        pixel[1][12]=' ';
        pixel[2][0]='(';
        pixel[2][1]=' ';
        pixel[2][2]=' ';
        pixel[2][3]=' ';
        pixel[2][4]='_';
        pixel[2][5]=' ';
        pixel[2][6]=' ';
        pixel[2][7]=' ';
        pixel[2][8]=' ';
        pixel[2][9]='_';
        pixel[2][10]=' ';
        pixel[2][11]='_';
        pixel[2][12]='\\';
        pixel[3][0]='=';
        pixel[3][1]='\'';
        pixel[3][2]='-';
        pixel[3][3]='(';
        pixel[3][4]='_';
        pixel[3][5]=')';
        pixel[3][6]='-';
        pixel[3][7]='-';
        pixel[3][8]='(';
        pixel[3][9]='_';
        pixel[3][10]=')';
        pixel[3][11]='-';
        pixel[3][12]='\'';
        return pixel;
    }
    public static char[][] make_mirror(char[][] input){
        char[][] output = new char[input.length][input[0].length];

        for(int i = 0; i < input.length; i++){ //row
            for(int j = 0; j < input[i].length; j++){ //col
                if(inLookupTable(input[i][input[i].length - 1 - j])){
                    output[i][j] = mirror_char(input[i][input[i].length - 1 - j]);

                }
                else{
                    output[i][j] = input[i][input[i].length - 1 - j];
                }
            }
        }



        return output;
    }
    public static boolean inLookupTable(char input){
        switch(input){
            case '(', ')', '\\', '/':
                return true;
            default:
                return false;
        }
    }
    public static char mirror_char(char input){
        if(input == '('){
            return ')';
        }
        else if(input == ')'){
            return '(';
        }
        else if(input == '\\'){
            return '/';
        }
        else if(input == '/'){
            return '\\';
        }
        else{
            return input;
        }
    }
}
