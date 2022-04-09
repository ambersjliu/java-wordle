import control.WordleControl;
public class Main {
    static WordleControl control;
    public static void main(String[] args){
        while(true){
            control = new WordleControl();
            control.initialize();
            System.out.println("mainLoop called");
            control.mainLoop();
        }
    }
}
