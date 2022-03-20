import java.util.Scanner;
public class Console{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        String word = "apple";
        
        String[][] chars = new String[6][5];
        for(int i = 0; i<6; i++){
            for(int j = 0; j<5; j++){
                chars[i][j] = "";
            }
        }

        System.out.println("Welcome to Wordle!"+
                            "\nEnter 5 letter words to guess the selected one. A * preceding a character means it's in the right place, "+
                            "\na ? preceding a character means it's in the word but not in that position. Otherwise, the character is not in the word.");

        String answer = "";
        
        do{
            boolean guessed = false;
            int rounds = 0;
            //printing the words each round
            do{

                String guess = "";
                while(guess.length()!=5){
                    System.out.println("Enter your next guess: ");
                    guess = sc.nextLine();
                }
                

                String[] result = check(word, guess);

                for(int i =0; i<5; i++){
                    chars[rounds][i] = result[i];
                }
                showBoard(chars);
                rounds++;
                if(word.equals(guess)){
                    guessed=true;
                }

            }while(guessed == false && rounds < 6);

            if(guessed==true){
                System.out.println("You guessed it in " + rounds + "/6 tries."); 
            }else{
                System.out.println("You couldn't guess the word. Better luck next time!");
            }
            System.out.println("Play again? Type 'EXIT' to leave.");
            answer = sc.nextLine();
        }while(answer!="EXIT");


    }

    public static void showBoard(String[][] chars){
        for(int i = 0; i<6; i++){
            for(int j = 0; j<5; j++){
                if(chars[i][j].equals("")){
                    System.out.print("_ ");
                }else{
                    System.out.print(chars[i][j]+" ");
                }
            }
            System.out.println();
        }
    }

    public static String[] check(String word, String entered){
        String[] result = new String[5];
        for(int i = 0; i < 5; i++){
            String cur = "" + entered.charAt(i);
            String wordCur = "" + word.charAt(i);
            if(cur.equals(wordCur)){
                result[i] = "*"+cur;
            }else{
                if(word.indexOf(cur)!=-1){
                    result[i] = "?"+cur;
                }else{
                    result[i] = cur;
                }

            }

        }

        return result;

    }
        
}
