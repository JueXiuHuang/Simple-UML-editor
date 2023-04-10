package button;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class Button extends JToggleButton implements ActionListener{
    // constructor
    public Button(){
        super();
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent event){
        System.out.println("Button clicked!");
    }

    public void set_icon(String img_path){
        ImageIcon icon = new ImageIcon(this.getClass().getResource(img_path));
        icon.setImage(icon.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
        setIcon(icon);
        setBackground(Color.WHITE);
    }

    //private boolean inMode = false;
}