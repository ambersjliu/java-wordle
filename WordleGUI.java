import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordleGUI extends JFrame implements ActionListener {

    JPanel guessesPanel; // panel for guessed letters
    JLabel[][] guessesPanelLetters; // 2d array for the guessed letters interface
    JPanel keyboardPanel;
    JButton[] keyboardRow1; // qwertyuiop
    JButton[] keyboardRow2; // asdfghjkl
    JButton[] keyboardRow3; // zxcvbnm


    public WordleGUI(int wordSize) {
        guessesPanel = new JPanel();
        guessesPanelLetters = new JLabel[wordSize + 1][wordSize];
        for (int r = 0; r < wordSize + 1; r++) {
            for (int c = 0; c < wordSize; c++) {
                guessesPanelLetters[r][c] = new JLabel();
                guessesPanel.add(guessesPanelLetters[r][c]);
                // guessPanelLetters[r][c].setIcon(icon);
            }
        }
        guessesPanel.setLayout(new GridLayout(wordSize + 1, wordSize));
        add(guessesPanel);

        keyboardPanel = new JPanel();
        String [] keyboardCharacters = {"Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "A", "S", "D", "F", "G", "H",
                "J", "K", "L", "Z", "X", "C", "V", "B", "N", "M"};
        keyboardRow1 = new JButton[10];
        keyboardRow2 = new JButton[9];
        keyboardRow3 = new JButton[7];
        for (int i = 0; i < 26; i++) {
            if (i < 10) {
                keyboardRow1[i].setText(keyboardCharacters[i]);
            } else if (i < 19) {
                keyboardRow2[i].setText(keyboardCharacters[i]);
            } else {
                keyboardRow3[i].setText(keyboardCharacters[i]);
            }
        }


    }

    public static void main(String[] args) {

    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
