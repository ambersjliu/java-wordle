package view;
import model.Constants;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameWindow {
    private JFrame frm;

    private void initialize(){
        setFrm(new JFrame());
        getFrm().setTitle("Hackyordle");
        getFrm().setResizable(false);
        getFrm().setBounds(200, 200, 640, 1000);
		getFrm().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrm().setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
		getFrm().getContentPane().setLayout(new BorderLayout(0, 0));

        getFrm().getContentPane().setBackground(Constants.bgColor);
    }
    public JFrame getFrm(){
        return frm;
    }
    public void setFrm(JFrame frm){
        this.frm = frm;
    }
    
}
