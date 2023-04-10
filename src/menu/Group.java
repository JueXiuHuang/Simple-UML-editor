package menu;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import object.*;
import panel.*;
import java.util.*;

public class Group extends JMenuItem implements ActionListener{
    public Group(String name){
        super(name);
        addActionListener(this);
        canvas = New_canvas.get_canvas();
    }

    private New_canvas canvas;
    private double group_id;

    @Override
    public void actionPerformed(ActionEvent e){
        System.out.println("Group clicked!");
        group_id = canvas.rand_gene.nextDouble();
        System.out.println(group_id);
        for(Object_base item : canvas.selected_item){
            item.add_group(group_id);
        }
    }
}