package menu;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import object.*;
import panel.*;
import java.lang.*;

public class Ungroup extends JMenuItem implements ActionListener{
    public Ungroup(String name){
        super(name);
        addActionListener(this);
        canvas = New_canvas.get_canvas();
    }

    private New_canvas canvas;

    @Override
    public void actionPerformed(ActionEvent e){
        System.out.println("ungroup clicked!");

        for(Object_base item : canvas.selected_item){
            item.remove_group();
        }
    }
}