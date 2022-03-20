import java.util.Scanner;
public class Console{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        String word = "apple";
        boolean guessed = false;
        String[][] chars = new String[6][5];
        for(int i = 0; i<6; i++){
            for(int j = 0; j<5; j++){
                chars[i][j] = "";
            }
        }


        int rounds = 0;
        //printing the words each round
         while(guessed == false || rounds < 6){
            showBoard(chars);
            String guess = "";
            while(guess.length()!=5){
                System.out.println("Enter your next guess: ");
                guess = sc.nextLine();
            }

            String[] result = check(word, guess);

            for(int i =0; i<5; i++){
                chars[rounds][i] = result[i];
            }
            rounds++;

        } 


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
