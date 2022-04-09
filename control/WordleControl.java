package control;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import model.GuessResult;
import view.WordleGUI;


public class WordleControl {

    Scanner sc = new Scanner(System.in);
    Random rand = new Random();
    ArrayList<String> words = new ArrayList<>();
    ArrayList<String> descs = new ArrayList<>();
    int index;
    String word;
    String desc;
    WordleGUI game;
    int totalRows;


    public void initialize(){
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        words = new ArrayList<>();
        descs = new ArrayList<>();

        //read in all 5 letter words from wordlist
        try {
            File wordFile = new File("wordlist.txt");
            Scanner scFile = new Scanner(wordFile);
            
            while (scFile.hasNextLine()) {
                words.add(scFile.nextLine());
            }
            scFile.close();

        } 
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        catch (Exception e) {
            System.out.println("File error");
        }

        try {
            File wordFile = new File("worddesc.txt");
            Scanner scFile = new Scanner(wordFile);
            
            while (scFile.hasNextLine()) {
                descs.add(scFile.nextLine());
            }
            scFile.close();

        } 
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        catch (Exception e) {
            System.out.println("File error");
        }

        index = rand.nextInt(words.size());
        word = words.get(index);
        desc = descs.get(index);
        totalRows = word.length()+1;
        game = new WordleGUI(word.length());

    }

    public void mainLoop(){
        int guessCount=0;
        boolean guessed = false;

        while (!guessed && guessCount < totalRows){
            String guessedWord = game.getGuessedWord();
            GuessResult result = checkWord(word, guessedWord);
            game.refresh(result, guessCount);
            guessed=result.isAllGuessed();
            guessCount++;            
        }

        if(guessed)
            game.congratulate(desc);
            //use jconfirmpane
        else
            game.sorry(desc);

    }
    
    GuessResult checkWord(String word, String guessedWord){
        GuessResult result = new GuessResult(word.length());

        // logic here
        return result;
    }
    
    /*void guessWords(){
        
    }


    */


/*  public void startGame() {

		while (true) { // loop that brings game back to initial state after game over
			initialize(); // reset vals to 0
			
			while (!currentGameOver) { // while no one has won
				guessWords();
			}
		}
	} */

}
