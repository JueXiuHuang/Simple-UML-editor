package panel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import menu.*;

public class Menu_bar extends JMenuBar{
    public Menu_bar(){
        System.out.println("Menu_bar created");

        file = new JMenu("file");
        edit = new JMenu("edit");
        group = new Group("Group");
        ungroup = new Ungroup("UnGroup");
        change_name = new ChangeName("change object name");
        edit.add(group);
        edit.add(ungroup);
        edit.add(change_name);
        add(file);
        add(edit);
    }

    protected JMenu file, edit;
    protected JMenuItem group, ungroup, change_name;
}