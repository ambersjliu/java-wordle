import java.util.Scanner;
public class Console{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        String word = "apple";
        boolean guessed = false;
        String[][] chars = new String[6][6];
        for(int i = 0; i<6; i++){
            for(int j = 0; j<6; j++){
                chars[i][j] = "";
            }
        }

        showBoard(chars);

        int rounds = 0;
        //printing the words each round
        while(guessed == false || rounds < 6){
            showBoard(chars);
            String guess = "sdfsdfsdf";
            while(guess.length()!=6){
                System.out.println("Enter your next guess: ");
                guess = sc.nextLine();
            }


        }

    }

    public static void showBoard(String[][] chars){
        for(int i = 0; i<6; i++){
            for(int j = 0; j<6; j++){
                if(chars[i][j].equals("")){
                    System.out.print("_");
                }else{
                    System.out.print(chars[i][j]);
                }
            }
            System.out.println();
        }
    }
}