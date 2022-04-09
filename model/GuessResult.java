package model;

import java.util.ArrayList;

public class GuessResult {
    boolean allGuessed;
    // 0: wrong, 1: in word 2: right at position
    ArrayList<Integer> individualResult;
    
  

    public boolean isAllGuessed() {
        return allGuessed;
    }



    public void setAllGuessed(boolean allGuessed) {
        this.allGuessed = allGuessed;
    }



    public ArrayList<Integer> getIndividualResult() {
        return individualResult;
    }



    public void setIndividualResult(ArrayList<Integer> individualResult) {
        this.individualResult = individualResult;
    }



    public GuessResult(int wordLength){
        allGuessed = false;
        individualResult = new ArrayList<>(wordLength);
        for (int i=0; i< wordLength;i++){
            individualResult.set(i, 0);
        }
    }
}
