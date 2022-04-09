
package view;
import model.GuessResult;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class WordleGUI extends JFrame implements KeyListener, ActionListener {

    JPanel guessesPanel; // panel for guessed letters
    JLabel[][] guessesPanelLetters; // 2d array for the guessed letters interface
    JPanel keyboardPanel1;
    JPanel keyboardPanel2;
    JPanel keyboardPanel3;
    JButton[] keyboardRow1; // qwertyuiop
    JButton[] keyboardRow2; // asdfghjkl
    JButton[] keyboardRow3; // (enter)zxcvbnm(delete)
    JTextField typing;
    char[][] letterBoard;
    int[] cursor;
    int wordSize;
    String guess, guessedWord=null;

    public WordleGUI(int wordSize) {
        this.wordSize = wordSize;
        guessesPanel = new JPanel();
        guessesPanelLetters = new JLabel[wordSize + 1][wordSize];
        letterBoard = new char[wordSize + 1][wordSize];
        cursor = new int[]{0, 0};
        for (int r = 0; r < wordSize + 1; r++) {
            for (int c = 0; c < wordSize; c++) {
                guessesPanelLetters[r][c] = new JLabel("", SwingConstants.CENTER);
                guessesPanelLetters[r][c].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
                guessesPanel.add(guessesPanelLetters[r][c]);
                guessesPanel.setBackground(new Color(18, 18, 19));
                guessesPanel.setOpaque(true);
                guessesPanelLetters[r][c].setBackground(new Color(129, 131, 132));
                guessesPanelLetters[r][c].setOpaque(true);
                guessesPanelLetters[r][c].setForeground(Color.white);
                guessesPanelLetters[r][c].setFont(new Font("Clear Sans", Font.BOLD, 18 - wordSize));
            }
        }
        guessesPanel.setLayout(new GridLayout(wordSize + 1, wordSize));

        keyboardPanel1 = new JPanel();
        keyboardPanel2 = new JPanel();
        keyboardPanel3 = new JPanel();
        String[] keyboardCharacters = {"Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "A", "S", "D", "F", "G", "H",
                "J", "K", "L", "ENTER", "Z", "X", "C", "V", "B", "N", "M", "DLT"};
        keyboardRow1 = new JButton[10];
        keyboardRow2 = new JButton[9];
        keyboardRow3 = new JButton[9];
        for (int i = 0; i < 28; i++) {
            if (i < 10) {
                keyboardRow1[i] = new JButton();
                keyboardRow1[i].setText(keyboardCharacters[i]);
                keyboardPanel1.add(keyboardRow1[i]);
                keyboardRow1[i].setBorder(BorderFactory.createLineBorder(new Color(18, 18, 19), 2));
                keyboardRow1[i].setBackground(new Color(129, 131, 132));
                keyboardRow1[i].setOpaque(true);
                keyboardRow1[i].setForeground(Color.white);
                keyboardRow1[i].setFont(new Font("Clear Sans", Font.BOLD, 13));
                keyboardRow1[i].addActionListener(this);
            } else if (i < 19) {
                keyboardRow2[i - 10] = new JButton();
                keyboardRow2[i - 10].setText(keyboardCharacters[i]);
                keyboardPanel2.add(keyboardRow2[i - 10]);
                keyboardRow2[i - 10].setBorder(BorderFactory.createLineBorder(new Color(18, 18, 19), 2));
                keyboardRow2[i - 10].setBackground(new Color(129, 131, 132));
                keyboardRow2[i - 10].setOpaque(true);
                keyboardRow2[i - 10].setForeground(Color.white);
                keyboardRow2[i - 10].setFont(new Font("Clear Sans", Font.BOLD, 13));
                keyboardRow2[i - 10].addActionListener(this);
            } else {
                keyboardRow3[i - 19] = new JButton();
                keyboardRow3[i - 19].setText(keyboardCharacters[i]);
                keyboardPanel3.add(keyboardRow3[i - 19]);
                keyboardRow3[i - 19].setBorder(BorderFactory.createLineBorder(new Color(18, 18, 19), 2));
                keyboardRow3[i - 19].setBackground(new Color(129, 131, 132));
                keyboardRow3[i - 19].setOpaque(true);
                keyboardRow3[i - 19].setForeground(Color.white);
                keyboardRow3[i - 19].setFont(new Font("Clear Sans", Font.BOLD, 13));
                if (i == 19) {
                    keyboardRow3[i - 19].setFont(new Font("Clear Sans", Font.BOLD, 11));
                }
                keyboardRow3[i - 19].addActionListener(this);
            }
        }
        keyboardPanel1.setLayout(new GridLayout(1, 10));
        keyboardPanel2.setLayout(new GridLayout(1, 9));
        keyboardPanel3.setLayout(new GridLayout(1, 9));
        typing = new JTextField();
        typing.setText(" ");
        typing.addKeyListener(this);

        add(guessesPanel);
        add(keyboardPanel1);
        add(keyboardPanel2);
        add(keyboardPanel3);
        add(typing);

        guessesPanel.setSize(50 * wordSize, 300);
        guessesPanel.setLocation((9 - wordSize) * 25, 50);
        keyboardPanel1.setLocation(37, 400);
        keyboardPanel1.setSize(375, 50);
        keyboardPanel1.setBackground(new Color(18, 18, 19));
        keyboardPanel2.setLocation(55, 450);
        keyboardPanel2.setSize(340, 50);
        keyboardPanel2.setBackground(new Color(18, 18, 19));
        keyboardPanel3.setLocation(37, 500);
        keyboardPanel3.setSize(375, 50);
        keyboardPanel3.setBackground(new Color(18, 18, 19));
        typing.setLocation(0, 0);
        typing.setSize(465, 600);
//        typing.setBackground(new Color(18, 18, 19));
        typing.setOpaque(false);
        typing.setBorder(BorderFactory.createEmptyBorder());
        typing.setForeground(new Color(18, 18, 19));
        typing.setBackground(new Color(18, 18, 19));


        setLayout(new BorderLayout());
        setTitle("Wordle");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(465, 600);
        getContentPane().setBackground(new Color(18, 18, 19));
        setVisible(true);
    }

    public void refresh(GuessResult individualResult, int guessCount) {
        for (int i = 0; i < this.wordSize; i++) {
            guessesPanelLetters[guessCount][i].setText(Character.toString(letterBoard[guessCount][i]));
            Color bkg = new Color(58, 58, 60);
            switch (individualResult.getIndividualResult().get(i)) {
                case 1:
                    bkg = new Color(181, 159, 59);
                    break;
                case 2:
                    bkg = new Color(83, 141, 78);
                    break;
            }
            guessesPanelLetters[guessCount][i].setBackground(bkg);
            guessesPanelLetters[guessCount][i].setOpaque(true);
        }
    }

    public void updateBoard() {
        for (int i = 0; i < this.wordSize; i++) {
            guessesPanelLetters[cursor[0]][i].setText(Character.toString(letterBoard[cursor[0]][i]));
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        typing.setText("");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 8) { //backspace
            if (cursor[1] != 0) {
                letterBoard[cursor[0]][cursor[1] - 1] = ' ';
                cursor[1]--;
            }
        } else if (e.getKeyCode() == 10) { //enter
            if (cursor[1] == this.wordSize) { //the row is filled
                guess = "";
                for (char c : letterBoard[cursor[0]]) {
                    guess += c; //fill guess string with letters in current row
                }
                guessedWord=guess;
            } else {
                System.out.println("invalid guess"); //row not filled
            }
        } else if (e.getKeyCode() >= 65 && e.getKeyCode() <= 90) { //any other letter char
            if (cursor[1] != this.wordSize) { //row not filled yet
                letterBoard[cursor[0]][cursor[1]] = Character.toTitleCase((char) e.getKeyCode());
                cursor[1]++;
            } else {
                System.out.println("full characters");
            }
        } else {
            System.out.println("invalid character"); //character can be typed
        }
        updateBoard(); //set text inside buttons
        typing.setText(" ");
    }

    void sleep(long milliSec){
        try {
            Thread.sleep(milliSec);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public String getGuessedWord() {
        while (guessedWord==null)
            sleep(100);
        String result = guessedWord;
        guessedWord=null;
        return result;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        typing.setText(" ");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!e.getActionCommand().equals("DLT") && !e.getActionCommand().equals("ENTER")) {
            if (cursor[1] != this.wordSize) {
                letterBoard[cursor[0]][cursor[1]] = Character.toTitleCase(e.getActionCommand().charAt(0));
                cursor[1]++;
            } else {
                System.out.println("full characters");
            }
        } else if (e.getActionCommand().equals("DLT")) {
            if (cursor[1] != 0) {
                letterBoard[cursor[0]][cursor[1] - 1] = ' ';
                cursor[1]--;
                System.out.println("char deleted");
            }
        } else {
            if (cursor[1] == this.wordSize) {
                guess = "";
                for (char c : letterBoard[cursor[0]]) {
                    guess += c;
                }
                System.out.println("guess updated to " + guess);
            } else {
                System.out.println("invalid guess");
            }
        }
        updateBoard();
    }
}
//gaming