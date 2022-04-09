import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Console{

    public static void main(String[] args){
        //initializing everything
        System.out.println("Hello world");
        //scanner for input
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        ArrayList<String> s = new ArrayList<>();

        //read in all 5 letter words from wordlist
        try {
            File wordFile = new File("wordlist.txt");
            Scanner scFile = new Scanner(wordFile);
            
            while (scFile.hasNextLine()) {
                s.add(scFile.nextLine());
            }
            scFile.close();

        } 
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        catch (Exception e) {
            System.out.println("File error");
        }

        
        String[][] chars = new String[6][5];
        clearChars(chars);

        //intro
        System.out.println("Welcome to Wordle!"+
                            "\nEnter 5 letter words to guess the selected one. A * preceding a character means it's in the right place, "+
                            "\na ? preceding a character means it's in the word but not in that position. Otherwise, the character is not in the word.");

        String answer = "";
        
        //keep playing loop
        do{
            //choose a different word every round
            int index = rand.nextInt(s.size());
            String word = s.get(index); 
 
            
            
            boolean guessed = false;
            int rounds = 0;
            //main gameplay loop (guessing words)
            do{

                String guess = "";
                while(guess.length()!=5 || !(s.contains(guess))){
                    System.out.println("Enter your next guess: ");
                    guess = sc.nextLine().toLowerCase();
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
            //if word guessed
            if(guessed==true){
                System.out.println("You guessed it in " + rounds + "/6 tries."); 
            }else{
                System.out.println("The word was :" + word);
                System.out.println("You couldn't guess the word. Better luck next time!");
            }

            //ask for replay
            System.out.println("Play again? Type 'EXIT' to leave.");
            answer = sc.nextLine();
            clearChars(chars);
            
        }while(answer!="EXIT");
        sc.close();


    }

    //prints the board out
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

    //checks how the entered word compares to the word to guess
    //Need to handle duplicate letters in a guess...
    public static String[] check(String word, String entered){
        String[] result = new String[5];
        HashMap<Character, Integer> seen =new HashMap<Character, Integer>();
        for (int i = 0; i<5; i++){
            seen.put(word.charAt(i), countChar(word, word.charAt(i)));
        }

        for(int i = 0; i < 5; i++){
            char current = entered.charAt(i);
            String cur = "" + current;
            String wordCur = "" + word.charAt(i);
            
            if(cur.equals(wordCur)){
                result[i] = "*"+cur;
                seen.replace(current, seen.get(current)-1);
            }else{

                result[i] = cur;

            }

        }

        for(int i = 0; i <5; i++){
            char current = entered.charAt(i);
            String cur = "" + current;
            String wordCur = "" + word.charAt(i);
            if(cur.equals(wordCur)){
                continue;
            }
            if (word.indexOf(cur) != -1 && seen.get(current) > 0) {
                result[i] = "?" + cur;
                seen.replace(current, seen.get(current) - 1);
            } else {
                result[i] = cur;
            }
        }


        return result;

    }

    //clears all letters in the word array
    public static void clearChars(String[][]chars){
        for(int i = 0; i<6; i++){
            for(int j = 0; j<5; j++){
                chars[i][j] = "";
            }
        }
    }

    public static int countChar(String str, char c){
        int count = 0;

        for(int i=0; i < str.length(); i++){
            if(str.charAt(i) == c){
                count++;
            }
        }

        return count;
    }

    



        
}
