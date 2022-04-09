package view;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameWindow {
    private JFrame frm;

    private void initialize(){
        setFrm(new JFrame());
    }
    public JFrame getFrm(){
        return frm;
    }
    public void setFrm(JFrame frm){
        this.frm = frm;
    }
    
}
