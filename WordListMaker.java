import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class WordListMaker {
    public static void main(String[] args) throws FileNotFoundException {
        File words = new File("words.txt");
        Scanner reader = new Scanner(words);
        PrintWriter pw4 = new PrintWriter("words4.txt");
        PrintWriter pw5 = new PrintWriter("words5.txt");
        PrintWriter pw6 = new PrintWriter("words6.txt");
        PrintWriter pw7 = new PrintWriter("words7.txt");
        PrintWriter pw8 = new PrintWriter("words8.txt");
        PrintWriter pw9 = new PrintWriter("words9.txt");

        int pw4count = 0;
        int pw5count = 0;
        int pw6count = 0;
        int pw7count = 0;
        int pw8count = 0;
        int pw9count = 0;

        while (reader.hasNext()) {
            String word = reader.nextLine();
            switch (word.length()) {
                case 4:
                    pw4.write(word + "\n");
                    pw4count++;
                    break;
                case 5:
                    pw5.write(word + "\n");
                    pw5count++;
                    break;
                case 6:
                    pw6.write(word + "\n");
                    pw6count++;
                    break;
                case 7:
                    pw7.write(word + "\n");
                    pw7count++;
                    break;
                case 8:
                    pw8.write(word + "\n");
                    pw8count++;
                    break;
                case 9:
                    pw9.write(word + "\n");
                    pw9count++;
                    break;
            }
        }

        pw4.close();
        pw5.close();
        pw6.close();
        pw7.close();
        pw8.close();
        pw9.close();

        System.out.println("4 letter words: " + pw4count);
        System.out.println("5 letter words: " + pw5count);
        System.out.println("6 letter words: " + pw6count);
        System.out.println("7 letter words: " + pw7count);
        System.out.println("8 letter words: " + pw8count);
        System.out.println("9 letter words: " + pw9count);

    }
}
